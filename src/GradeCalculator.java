/**
 * Responsible only for computing a student's average score and
 * corresponding letter grade. Isolating this logic makes the grade
 * boundaries easy to find, change, and unit test independently of
 * file I/O or console output.
 */
public class GradeCalculator {

    private static final int GRADE_A_THRESHOLD = 90;
    private static final int GRADE_B_THRESHOLD = 80;
    private static final int GRADE_C_THRESHOLD = 70;

    public double calculateAverage(Student student) {
        return (student.getMathScore() + student.getScienceScore() + student.getEnglishScore()) / 3.0;
    }

    public String calculateGrade(double average) {
        if (average >= GRADE_A_THRESHOLD) {
            return "A";
        } else if (average >= GRADE_B_THRESHOLD) {
            return "B";
        } else if (average >= GRADE_C_THRESHOLD) {
            return "C";
        } else {
            return "F";
        }
    }
}
