import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AppTest {
    @Test
    public void normaliseYieldsCorrectResult() throws FileNotFoundException {
        List<Double> normalized = App.normalize(IntStream.range(1,11).mapToDouble(x -> x).boxed().collect(Collectors.toList()));
        List<Double> expected = Arrays.asList(
                -1.5666989036012806,
                -1.2185435916898848,
                -0.8703882797784892,
                -0.5222329678670935,
                -0.17407765595569785,
                0.17407765595569785,
                0.5222329678670935,
                0.8703882797784892,
                1.2185435916898848,
                1.5666989036012806
        );
        
        assertEquals(expected, normalized);
    }

    @Test
    public void normaliseEmptyYieldsCorrectResult() throws FileNotFoundException {
        List<Double> normalized = App.normalize(new ArrayList<>());
        List<Double> expected = new ArrayList<>();

        assertEquals(expected, normalized);
    }

    @Test
    public void readDataYieldsRightValues() throws IOException {
        File file = new File("data");
        List<Double> data = IntStream.range(1,10).mapToDouble(x -> x).boxed().collect(Collectors.toList());
        List<Double> res = App.readData(file);

        assertEquals(data, res);
    }
}
