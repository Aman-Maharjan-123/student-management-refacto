import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class StudentManagement {
    public void doEverything(String[] data, int choice) {
        // Array format: [name, id, mathScore, scienceScore, englishScore]
        if (choice == 1) {
            // Add student
            System.out.println("Adding student: " + data[0] + " with ID: " + data[1]);
            String s = data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4];
            try {
                FileWriter fw = new FileWriter("students.txt", true);
                fw.write(s + "\n");
                fw.close();
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } else if (choice == 2) {
            // Calculate average and print details
            int m = Integer.parseInt(data[2]);
            int s = Integer.parseInt(data[3]);
            int e = Integer.parseInt(data[4]);
            int avg = (m + s + e) / 3;
            System.out.println("Student: " + data[0] + ", ID: " + data[1] + ", Avg Score: " + avg);
            if (avg >= 90) {
                System.out.println("Grade: A");
            } else if (avg >= 80) {
                System.out.println("Grade: B");
            } else if (avg >= 70) {
                System.out.println("Grade: C");
            } else {
                System.out.println("Grade: F");
            }
        } else if (choice == 3) {
            // Read all students
            try {
                FileReader fr = new FileReader("students.txt");
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    System.out.println("Name: " + parts[0] + ", ID: " + parts[1] + ", Scores: " + parts[2] + "," + parts[3] + "," + parts[4]);
                }
                br.close();
                fr.close();
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } else {
            System.out.println("Invalid choice!");
        }
    }
}
