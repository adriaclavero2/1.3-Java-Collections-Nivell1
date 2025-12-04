import java.io.*;
import java.util.*;

public class CapitalsGame {
    public static void main(String[] args) {
        Map<String, String> countries = new HashMap<>();

        try (InputStream in = CapitalsGame.class.getResourceAsStream("/countries.txt");
             Scanner sc = new Scanner(in)) {

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split("\\s+");
                    if (parts.length >= 2) {
                        String country = parts[0];
                        String capital = parts[1];
                        countries.put(country, capital);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading countries.txt from resources");
            return;
        }

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String userName = input.nextLine();

        int score = 0;
        List<String> countryList = new ArrayList<>(countries.keySet());
        Collections.shuffle(countryList);

        for (int i = 0; i < 10 && i < countryList.size(); i++) {
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

        try {
            File file = new File("resources/classificacio.txt");
            file.getParentFile().mkdirs(); // crea carpeta si no existeix
            try (PrintWriter pw = new PrintWriter(new FileWriter(file, true))) {
                pw.println(userName + " " + score);
            }
        } catch (IOException e) {
            System.out.println("Error writing to classificacio.txt");
        }
    }
}