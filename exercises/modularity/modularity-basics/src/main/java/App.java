import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        compute();
    }

    public static List<Double> readData(File file) throws FileNotFoundException{
        // Read data
        Scanner scanner = new Scanner(file);
        
        List<Double> numbers = new ArrayList<>();
        while (scanner.hasNextDouble()) {
            numbers.add(scanner.nextDouble());
        }
        scanner.close();

        return numbers;
    }

    public static List<Double> normalize(List<Double> numbers){
        //Compute data
        List<Double> normalized = new ArrayList<>();
        
        double mean = numbers.stream().mapToDouble(d -> d).average().orElse(0.0);
        double sumSquare = numbers.stream().mapToDouble(d -> d).map(d -> Math.pow(d-mean,2)).sum();
        double std = Math.sqrt(sumSquare / numbers.size());
        return numbers.stream().mapToDouble(d -> d).map(d -> (d-mean)/std).boxed().collect(Collectors.toList());
    }

    public static void writeResult(String filename, List<Double> normalized){
        // Write result
        try {
            FileWriter fw = new FileWriter(filename);
            for (double n : normalized) {
                fw.write(Double.toString(n));
                fw.write("\n");
            }
            fw.close();
        } catch (Exception e) {
            System.err.println("Error writing output file");
        }
    }

    public static List<Double> compute() throws FileNotFoundException {
        List<Double> numbers = readData(new File("data"));
        List<Double> normalized = normalize(numbers);
        System.out.println(normalized);

        writeResult("output", normalized);
        System.out.println("Wrote output file.");

        return normalized;
    }
}
