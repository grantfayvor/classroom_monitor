import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Monitor extends Thread {

    private List<Classroom> classrooms = new ArrayList<>();

    public void addClassroom(Classroom classroom) {
        classrooms.add(classroom);
    }

    @Override
    public void run() {
        System.out.println("=========================================================================================================================================================================================");
        System.out.format("%s%40s%40s%40s%40s", "Classroom", "Lecturer", "InSession", "Students", "Visitors");
        System.out.println();
        System.out.println("==========================================================================================================================================================================================");

        while (true) {
            classrooms.forEach(classroom -> {
                System.out.println(classroom);
            });

            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                if (Thread.interrupted()) {
                    return;
                }
            }

            if (Thread.interrupted()) {
                return;
            }
        }

    }
}
