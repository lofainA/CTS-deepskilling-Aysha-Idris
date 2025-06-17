public class TestMVC {
    public static void main(String[] args) {
        StudentController sc = new StudentController(new Student(), new StudentView());
        sc.setStudentID(101);
        sc.setStudentName("Abdul Rahman");
        sc.setStudentGrade('A');
        sc.updateView();
    }
}
