import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles all persistence for Student records.
 * This is the ONLY class that knows students are stored as CSV lines
 * in a text file. If the storage mechanism ever changes (e.g. to a
 * database), only this class needs to change.
 *
 * try-with-resources guarantees the file streams are always closed,
 * even if an exception occurs mid-read/write - the original code
 * closed streams manually, so a thrown exception would leak them.
 */
public class StudentRepository {

    private final String filePath;

    public StudentRepository(String filePath) {
        this.filePath = filePath;
    }

    public void save(Student student) throws StudentRepositoryException {
        try (FileWriter fw = new FileWriter(filePath, true)) {
            fw.write(student.toCsv() + System.lineSeparator());
        } catch (IOException e) {
            throw new StudentRepositoryException("Failed to save student " + student.getId(), e);
        }
    }

    public List<Student> findAll() throws StudentRepositoryException {
        List<Student> students = new ArrayList<>();

        if (!Files.exists(Path.of(filePath))) {
            return students; // No records yet - not an error.
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.isBlank()) {
                    students.add(Student.fromCsv(line));
                }
            }
        } catch (IOException e) {
            throw new StudentRepositoryException("Failed to read students from " + filePath, e);
        }

        return students;
    }
}
