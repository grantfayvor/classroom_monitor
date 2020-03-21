import java.util.ArrayList;
import java.util.List;

public class Classroom extends Thread {

    private List<Student> students = new ArrayList<>();
    private List<Visitor> visitors = new ArrayList<>();
    private String className;
    private int capacity;
    private Lecturer lecturer;
    public boolean isRunning = false;

    Classroom(String className, int capacity) {
        this.className = className;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void addStudent(Student student) throws Exception {
        if (this.capacity == students.size()) throw new Exception("Cannot add student to a filled classroom");
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addVisitor(Visitor visitor) throws Exception {
        if (5 == visitors.size()) throw new Exception("Cannot add visitor to a filled classroom");
        visitors.add(visitor);
    }

    public List<Visitor> getVisitors() {
        return visitors;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    @Override
    public void run() {
        while (isRunning) {
            System.out.format("%s%32s%32b%32d%32d", this.getClassName(), this.getLecturer().getName(), this.isRunning,
                    this.getStudents().size(), this.getVisitors().size());
            System.out.println();
        }
    }

    @Override
    public String toString() {
        if (this.getLecturer() == null || !this.isRunning) {
            return String.format("%s%40b", this.getClassName(), this.isRunning);
        }

        return String.format("%s%40s%40b%40d%40d", this.getClassName(), this.getLecturer().getName(), this.isRunning,
                this.getStudents().size(), this.getVisitors().size());
    }
}
