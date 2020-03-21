import java.util.concurrent.TimeUnit;

public class Assignment {

    public static void main (String[] args) {
        Classroom classroom1 = new Classroom("W201", 60);
        Classroom classroom2 = new Classroom("W202", 60);
        Classroom classroom3 = new Classroom("JS101", 30);
        Classroom classroom4 = new Classroom("W101", 20);

        Lecturer lecturer1 = new Lecturer("Osama");
        Lecturer lecturer2 = new Lecturer("Barry");
        Lecturer lecturer3 = new Lecturer("Faheem");
        Lecturer lecturer4 = new Lecturer("Alex");
        Lecturer lecturer5 = new Lecturer("Aqeel");
        Lecturer lecturer6 = new Lecturer("Waseem");

        Monitor monitor = new Monitor();
        monitor.addClassroom(classroom1);
        monitor.addClassroom(classroom2);
        monitor.addClassroom(classroom3);
        monitor.addClassroom(classroom4);

        try {

            for (int i = 0; i < 10; i++) {
                Student student = new Student(Long.toHexString((long) (Math.random() * 10)));
                student.enter(classroom1);
                student.sitDown(classroom1);
            }

            Visitor visitor1 = new Visitor("Vincent");
            visitor1.enter(classroom1);
            visitor1.sitDown(classroom1);

            lecturer1.enter(classroom1);
            lecturer1.startLecture(classroom1);

            for (int i = 0; i < 13; i++) {
                Student student = new Student(Long.toHexString((long) (Math.random() * 10)));
                student.enter(classroom2);
                student.sitDown(classroom2);
            }

            Visitor visitor2 = new Visitor("Vincent");
            visitor2.enter(classroom2);
            visitor2.sitDown(classroom2);

            Visitor visitor3 = new Visitor("Vincent");
            visitor3.enter(classroom2);
            visitor3.sitDown(classroom2);

            lecturer2.enter(classroom2);
            lecturer2.startLecture(classroom2);

            for (int i = 0; i < 5; i++) {
                Student student = new Student(Long.toHexString((long) (Math.random() * 10)));
                student.enter(classroom3);
                student.sitDown(classroom3);
            }

            lecturer3.enter(classroom3);
            lecturer3.startLecture(classroom3);

            for (int i = 0; i < 16; i++) {
                Student student = new Student(Long.toHexString((long) (Math.random() * 10)));
                student.enter(classroom4);
                student.sitDown(classroom4);
            }

            Visitor visitor4 = new Visitor("Vincent");
            visitor4.enter(classroom4);
            visitor4.sitDown(classroom4);

            Visitor visitor5 = new Visitor("Vincent");
            visitor5.enter(classroom4);
            visitor5.sitDown(classroom4);

            Visitor visitor6 = new Visitor("Vincent");
            visitor6.enter(classroom4);
            visitor6.sitDown(classroom4);

            monitor.start();

            TimeUnit.MILLISECONDS.sleep(2000);

            lecturer1.leave(classroom1);
            lecturer2.leave(classroom2);

            classroom1.getStudents().get(1).leave(classroom1);

            lecturer4.enter(classroom2);
            lecturer5.enter(classroom1);

            TimeUnit.MILLISECONDS.sleep(2000);

            lecturer4.startLecture(classroom2);
            lecturer5.startLecture(classroom1);

            TimeUnit.MILLISECONDS.sleep(2000);

            lecturer6.enter(classroom4);
            lecturer6.startLecture(classroom4);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
