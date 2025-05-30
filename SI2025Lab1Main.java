import java.util.*;

enum Priority {
    LOW, MEDIUM, HIGH
}

class Task {
    private String name;
    private boolean isCompleted;
    private Priority priority;
    private String category;

    public Task(String name, Priority priority, String category) {
        this.name = name;
        this.priority = priority;
        this.category = category;
        this.isCompleted = false;
    }

    public void complete() {
        this.isCompleted = true;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name + " [" + category + "] - Priority: " + priority + (isCompleted ? " [Completed]" : " [Pending]");
    }
}

class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String name, Priority priority, String category) {
        tasks.add(new Task(name, priority, category));
    }

    public void printTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    // MISSING FEATURES:

    // 1. Remove a task by name
    public void removeTask(String name) {
        // TODO: Implement removal logic
        tasks.removeIf(task -> task.getName().equals(name));

    }

    // 2. Find all completed tasks
    public List<Task> getCompletedTasks() {
        return tasks.stream().filter(Task::isCompleted).collect(Collectors.toList());
        return new ArrayList<>();
    }

    // 3. List tasks sorted by name
    public void sortTasksByName() {
        // TODO: Implement sorting logic
        tasks.sort(Comparator.comparing(Task::getName));
    }

    // 4. Sort tasks by priority
    public void sortTasksByPriority() {
        // TODO: Implement sorting by priority logic
        tasks.sort(Comparator.comparing(Task::getPriority).reversed());
    }

    // 5. Filter tasks by category
    public List<Task> filterByCategory(String category) {
        // TODO: Implement filtering logic
        return tasks.stream()
                .filter(task -> task.getCategory().equals(category))
                .collect(Collectors.toList());
        return new ArrayList<>();
    }

    // 6. Find the highest-priority unfinished task
    public List<Task> getMostUrgentTasks() {
        // TODO: Implement logic to find most urgent tasks
        List<Task> unfinished = tasks.stream()
                .filter(task -> !task.isCompleted())
                .collect(Collectors.toList());
        if (unfinished.isEmpty()) return new ArrayList<>();

        Priority maxPriority = unfinished.stream()
                .map(Task::getPriority)
                .max(Comparator.naturalOrder())
                .orElse(Priority.LOW);
        return unfinished.stream()
                .filter(task -> task.getPriority() == maxPriority)
                .collect(Collectors.toList());
        return new ArrayList<>();
    }

    // 7. Count tasks per category
    public Map<String, Integer> countTasksPerCategory() {
        // TODO: Implement counting logic
        Map<String, Integer> counts = new HashMap<>();
        for (Task task : tasks) {
            counts.put(task.getCategory(), counts.getOrDefault(task.getCategory(), 0) + 1);
        }
        return counts;
        return new HashMap<>();
    }

    // 8. Mark a task as completed by name
    public void markTaskCompleted(String name) {
        // TODO: Implement completion logic
        tasks.stream()
                .filter(task -> task.getName().equals(name))
                .forEach(Task::complete);
    }

    // 9. Mark all tasks in a category as completed
    public void markCategoryCompleted(String category) {
        // TODO: Implement bulk completion logic
        tasks.stream()
                .filter(task -> task.getCategory().equals(category))
                .forEach(Task::complete);
    }
}

public class SI2025Lab1Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.addTask("Write report", Priority.HIGH, "Work");
        manager.addTask("Submit assignment", Priority.MEDIUM, "School");
        manager.addTask("Buy groceries", Priority.LOW, "Personal");

        // MISSING: Calls to the new methods that will be implemented
        manager.removeTask("Buy groceries");
        manager.markTaskCompleted("Submit assignment");
        manager.markCategoryCompleted("Personal");
        manager.sortTasksByPriority();
        System.out.println("Completed Tasks: " + manager.getCompletedTasks());
        System.out.println("Tasks in Work: " + manager.filterByCategory("Work"));
        System.out.println("Most Urgent Tasks: " + manager.getMostUrgentTasks());
        System.out.println("Tasks per Category: " + manager.countTasksPerCategory());

        manager.printTasks();
    }
}
