package ch.epfl.sweng.defensive.neutral.returned.value;

import java.util.Optional;
import java.util.Scanner;

import ch.epfl.sweng.defensive.neutral.returned.value.goolge.Goolge;
import ch.epfl.sweng.defensive.neutral.returned.value.model.Result;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a search phrase:");
        String line = scanner.nextLine().trim();
        if (!line.isEmpty()) {
            String[] keywords = line.split(" ");
            Optional<Result> result = Goolge.search(keywords);
            while (result.isPresent()) {
                System.out.println(result);
                System.out.println("...");
                scanner.nextLine();
                result = result.get().next();
            }
            System.out.println();
        }
    }
}