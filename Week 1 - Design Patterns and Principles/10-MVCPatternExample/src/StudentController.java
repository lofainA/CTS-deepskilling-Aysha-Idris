public class StudentController {
    Student model;
    StudentView view;

    StudentController(Student student, StudentView studentView) {
        this.model = student;
        this.view = studentView;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public void setStudentID(int id) {
        model.setId(id);
    }

    public void setStudentGrade(char grade) {
        model.setGrade(grade);
    }

    public void updateView() {
        view.displayStudentDetails(model.getId(), model.getName(), model.getGrade());
    }

}
