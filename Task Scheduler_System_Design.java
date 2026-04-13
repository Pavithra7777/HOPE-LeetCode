import java.util.*;
import java.time.*;
class Task {
    private int id;
    private String title;
    private boolean isCompleted;
    private LocalDateTime deadline;

    public Task(int id, String title, LocalDateTime deadline) {
        this.id = id;
        this.title = title;
        this.deadline = deadline;
        this.isCompleted = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void markCompleted() {
        isCompleted = true;
    }

    public void displayTask() {
        System.out.println("ID: " + id +
                " | Title: " + title +
                " | Deadline: " + deadline +
                " | Completed: " + isCompleted);
    }
}
class TaskManager {
    private Map<Integer, Task> taskMap = new HashMap<>();
    public void addTask(Task task) {
        taskMap.put(task.getId(), task);
    }
    public void removeTask(int id) {
        if (taskMap.containsKey(id)) {
            taskMap.remove(id);
            System.out.println("Task removed.");
        } else {
            System.out.println("Task not found.");
        }
    }
    public void markCompleted(int id) {
        Task t = taskMap.get(id);
        if (t != null) {
            t.markCompleted();
            System.out.println("Task marked completed.");
        } else {
            System.out.println("Task not found.");
        }
    }
    public void displayAll() {
        for (Task t : taskMap.values()) {
            t.displayTask();
        }
    }
    public void displayPending() {
        for (Task t : taskMap.values()) {
            if (!t.isCompleted()) {
                t.displayTask();
            }
        }
    }
    public void displayCompleted() {
        for (Task t : taskMap.values()) {
            if (t.isCompleted()) {
                t.displayTask();
            }
        }
    }
    public void checkDeadlines() {
        LocalDateTime now = LocalDateTime.now();

        for (Task t : taskMap.values()) {

            if (!t.isCompleted() && t.getDeadline().isBefore(now)) {
                System.out.println("❌ OVERDUE: " + t.getTitle());
            }

            else if (!t.isCompleted() &&
                    t.getDeadline().isBefore(now.plusHours(1))) {
                System.out.println("⚠️ DUE SOON: " + t.getTitle());
            }
        }
    }
    public void sortByDeadline() {
        List<Task> list = new ArrayList<>(taskMap.values());

        Collections.sort(list, new Comparator<Task>() {
            public int compare(Task t1, Task t2) {
                return t1.getDeadline().compareTo(t2.getDeadline());
            }
        });

        System.out.println("\n--- Sorted by Deadline ---");
        for (Task t : list) {
            t.displayTask();
        }
    }
}
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {
            System.out.println("\n===== TASK SCHEDULER =====");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Mark Completed");
            System.out.println("4. Show All Tasks");
            System.out.println("5. Show Pending Tasks");
            System.out.println("6. Show Completed Tasks");
            System.out.println("7. Check Deadlines");
            System.out.println("8. Sort by Deadline");
            System.out.println("9. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Deadline (yyyy-MM-ddTHH:mm): ");
                    String dl = sc.nextLine();
                    LocalDateTime deadline = LocalDateTime.parse(dl);

                    manager.addTask(new Task(id, title, deadline));
                    break;

                case 2:
                    System.out.print("Enter ID to remove: ");
                    int rid = sc.nextInt();
                    manager.removeTask(rid);
                    break;

                case 3:
                    System.out.print("Enter ID to mark completed: ");
                    int cid = sc.nextInt();
                    manager.markCompleted(cid);
                    break;

                case 4:
                    manager.displayAll();
                    break;

                case 5:
                    manager.displayPending();
                    break;

                case 6:
                    manager.displayCompleted();
                    break;

                case 7:
                    manager.checkDeadlines();
                    break;

                case 8:
                    manager.sortByDeadline();
                    break;

                case 9:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
