import java.io.*;
import java.util.*;

public class CapitalsGame {
    public static void main(String[] args) {
        Map<String, String> countries = new HashMap<>();
        try (Scanner sc = new Scanner(new File("countries.txt"))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split("\\s+");
                    String country = parts[0];
                    String capital = parts[1];
                    countries.put(country, capital);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file countries.txt was not found");
            return;
        }

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String userName = input.nextLine();

        int score = 0;
        List<String> countryList = new ArrayList<>(countries.keySet());
        Collections.shuffle(countryList);

        for (int i = 0; i < 10; i++) {
            String randomCountry = countryList.get(i);
            String correctCapital = countries.get(randomCountry);

            System.out.print("What is the capital of " + randomCountry + "? ");
            String answer = input.nextLine().trim();

            if (answer.equalsIgnoreCase(correctCapital)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The capital is " + correctCapital);
            }
        }

        System.out.println("\n" + userName + ", your score is: " + score);

        try (PrintWriter pw = new PrintWriter(new FileWriter("classificacio.txt", true))) {
            pw.println(userName + " " + score);
        } catch (IOException e) {
            System.out.println("Error writing to classificacio.txt");
        }
    }
}