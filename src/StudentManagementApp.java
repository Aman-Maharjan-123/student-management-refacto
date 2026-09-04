/**
 * Demonstrates the refactored Student Management design.
 * Compare this to the original single doEverything(data, choice) call -
 * intent is now clear from the method names alone, with no magic
 * numbers for "choice".
 */
public class StudentManagementApp {

    public static void main(String[] args) {
        StudentRepository repository = new StudentRepository("students.txt");
        GradeCalculator gradeCalculator = new GradeCalculator();
        StudentService studentService = new StudentService(repository, gradeCalculator);

        Student alice = new Student("Alice Sharma", "S001", 92, 88, 95);
        Student bishal = new Student("Bishal Rai", "S002", 65, 70, 60);

        try {
            studentService.addStudent(alice);
            studentService.addStudent(bishal);

            System.out.println();
            studentService.printStudentReport(alice);
            studentService.printStudentReport(bishal);

            System.out.println();
            System.out.println("All stored students:");
            studentService.printAllStudents();

        } catch (StudentRepositoryException e) {
            System.err.println("A problem occurred while managing student records: " + e.getMessage());
        }
    }
}
