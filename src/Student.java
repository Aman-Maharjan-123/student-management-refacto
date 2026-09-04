/**
 * Represents a single student record.
 * Encapsulates the raw data that was previously passed around as a
 * loosely-typed String[] array, giving compile-time type safety and
 * a single, testable place to validate student data.
 */
public class Student {

    private final String name;
    private final String id;
    private final int mathScore;
    private final int scienceScore;
    private final int englishScore;

    public Student(String name, String id, int mathScore, int scienceScore, int englishScore) {
        this.name = name;
        this.id = id;
        this.mathScore = mathScore;
        this.scienceScore = scienceScore;
        this.englishScore = englishScore;
    }

    /**
     * Parses a Student from the CSV line format used for persistence
     * (name,id,mathScore,scienceScore,englishScore).
     * Centralising parsing here means the format only needs to change
     * in one place, and invalid rows fail fast with a clear message.
     */
    public static Student fromCsv(String csvLine) {
        String[] parts = csvLine.split(",");
        if (parts.length != 5) {
            throw new IllegalArgumentException("Malformed student record: " + csvLine);
        }
        return new Student(
                parts[0].trim(),
                parts[1].trim(),
                Integer.parseInt(parts[2].trim()),
                Integer.parseInt(parts[3].trim()),
                Integer.parseInt(parts[4].trim())
        );
    }

    public String toCsv() {
        return name + "," + id + "," + mathScore + "," + scienceScore + "," + englishScore;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getMathScore() {
        return mathScore;
    }

    public int getScienceScore() {
        return scienceScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }
}
