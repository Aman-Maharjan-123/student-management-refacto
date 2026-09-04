public class Demo {
    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();
        // choice 2 -> calculate average; but englishScore field is blank/missing input
        String[] badData = {"Bishal Rai", "S002", "65", "70", ""};
        sm.doEverything(badData, 2);
    }
}
