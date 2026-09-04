import java.util.List;

/**
 * The single entry point for student-related operations.
 * Replaces the original doEverything(data, choice) method with three
 * clearly-named methods, one per responsibility. Each method delegates
 * to the class that owns that concern (repository for storage,
 * calculator for grading) rather than doing everything itself.
 */
public class StudentService {

    private final StudentRepository repository;
    private final GradeCalculator gradeCalculator;

    public StudentService(StudentRepository repository, GradeCalculator gradeCalculator) {
        this.repository = repository;
        this.gradeCalculator = gradeCalculator;
    }

    public void addStudent(Student student) throws StudentRepositoryException {
        repository.save(student);
        System.out.println("Added student: " + student.getName() + " (ID: " + student.getId() + ")");
    }

    public void printStudentReport(Student student) {
        double average = gradeCalculator.calculateAverage(student);
        String grade = gradeCalculator.calculateGrade(average);
        System.out.printf("Student: %s, ID: %s, Avg Score: %.2f, Grade: %s%n",
                student.getName(), student.getId(), average, grade);
    }

    public void printAllStudents() throws StudentRepositoryException {
        List<Student> students = repository.findAll();
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        for (Student student : students) {
            System.out.println("Name: " + student.getName()
                    + ", ID: " + student.getId()
                    + ", Scores: " + student.getMathScore() + "," + student.getScienceScore() + "," + student.getEnglishScore());
        }
    }
}
