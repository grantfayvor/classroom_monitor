public class Lecturer {

    private String name;

    Lecturer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void enter(Classroom classroom) {
        classroom.setLecturer(this);
    }

    public void startLecture(Classroom classroom) throws Exception {
        boolean canStart = true;
        for (Student student : classroom.getStudents()) {
            if (student.isReady == false) {
                canStart = false;
                break;
            }
        }
        if (canStart == true) {
            classroom.isRunning = true;
//            classroom.start();
        } else {
            throw new Exception("Lecturer cannot start the lecture until all participants are settled.");
        }
    }

    public void leave(Classroom classroom) {
        classroom.interrupt();
        classroom.isRunning = false;
        classroom.setLecturer(null);
    }
}
