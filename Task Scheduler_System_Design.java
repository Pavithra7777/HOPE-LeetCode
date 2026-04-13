import java.util.*;
class Task {
    private int id;
    private String task;
    private boolean isCompleted;
    public Task(int id, String task) {
        this.id = id;
        this.task = task;
        this.isCompleted = false;
    }
    public int getId() {
        return id;
    }
    public String getTask() {
        return task;
    }
    public boolean isCompleted() {
        return isCompleted;
    }
    public void markCompleted() {
        isCompleted = true;
    }
    public void display() {
        System.out.println("Id: " + id +
                ", Task: " + task +
                ", Completed: " + isCompleted);
    }
}
class TaskManager {
    private Map<Integer, Task> taskMap = new HashMap<>();

    public void addTask(Task task) {
        taskMap.put(task.getId(), task);
    }
    public void removeTask(int id) {
        try {
            if (taskMap.containsKey(id)) {
                taskMap.remove(id);
                System.out.println("Task removed.");
            } else {
                System.out.println("Task not found.");
            }
        } catch (Exception e) {
            System.out.println("Error while removing task.");
        }
    }
    public void markCompleted(int id) {
        try {
            Task t = taskMap.get(id);
            if (t != null) {
                t.markCompleted();
                System.out.println("Task marked completed.");
            } else {
                System.out.println("Task not found.");
            }
        } catch (Exception e) {
            System.out.println("Error while marking task.");
        }
    }
    public void displayAll() {
        for (Task t : taskMap.values()) {
            t.display();
        }
    }
    public void displayPending() {
        for (Task t : taskMap.values()) {
            if (!t.isCompleted()) {
                t.display();
            }
        }
    }
    public void displayCompleted() {
        for (Task t : taskMap.values()) {
            if (t.isCompleted()) {
                t.display();
            }
        }
    }
    public void sortByName() {
        List<Task> list = new ArrayList<>(taskMap.values());
        Collections.sort(list, new Comparator<Task>() {
            public int compare(Task t1, Task t2) {
                return t1.getTask().compareTo(t2.getTask());
            }
        })
        System.out.println("---- Sorted Tasks ----");
        for (Task t : list) {
            t.display();
        }
    }
}
public class Assignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        while (true) {
            try {
                System.out.println("\n===== TASK SCHEDULER =====");
                System.out.println("1. Add Task");
                System.out.println("2. Remove Task");
                System.out.println("3. Mark Completed");
                System.out.println("4. Show All Tasks");
                System.out.println("5. Show Pending Tasks");
                System.out.println("6. Show Completed Tasks");
                System.out.println("7. Sort by Name");
                System.out.println("8. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        try {
                            System.out.print("Enter ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter Task: ");
                            String task = sc.nextLine();

                            manager.addTask(new Task(id, task));
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input!");
                            sc.nextLine();
                        }
                        break;
                    case 2:
                        try {
                            System.out.print("Enter ID to remove: ");
                            int rid = sc.nextInt();
                            manager.removeTask(rid);
                        } catch (Exception e) {
                            System.out.println("Invalid input!");
                            sc.nextLine();
                        }
                        break;
                    case 3:
                        try {
                            System.out.print("Enter ID to mark completed: ");
                            int cid = sc.nextInt();
                            manager.markCompleted(cid);
                        } catch (Exception e) {
                            System.out.println("Invalid input!");
                            sc.nextLine();
                        }
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
                        manager.sortByName();
                        break;
                    case 8:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Something went wrong!");
                sc.nextLine();
            }
        }
    }
}
