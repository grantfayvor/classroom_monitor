public class Student extends Thread {

    private String name;
    public boolean isReady = false;

    Student(String name) {
        this.name = name;
    }

    public void enter(Classroom classroom) throws Exception {
        if (classroom.getLecturer() == null) {
            classroom.addStudent(this);
        } else {
            throw new Exception("Cannot add student to an ongoing lecture.");
        }
    }

    public void sitDown(Classroom classroom) throws Exception {
        isReady = true;
        classroom.join();
    }

    public void leave(Classroom classroom) throws Exception {
        if (classroom.getLecturer() == null) {
            classroom.getStudents().remove(this);
        }
        this.start();
    }
}
