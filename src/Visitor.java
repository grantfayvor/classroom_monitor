public class Visitor extends Thread {

    private String name;
    public boolean isReady = false;

    Visitor(String name) {
        this.name = name;
    }

    public void enter(Classroom classroom) throws Exception {
        if (classroom.getLecturer() == null) {
            classroom.addVisitor(this);
        } else {
            throw new Exception("Cannot add student to an ongoing lecture.");
        }
    }

    public void sitDown(Classroom classroom) throws Exception {
        isReady = true;
        classroom.join();
    }

    public void leave(Classroom classroom) throws Exception {
        classroom.getStudents().remove(this);
        this.start();
    }
}
