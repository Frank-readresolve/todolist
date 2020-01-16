package fr.formation.todolist.stores;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import fr.formation.todolist.entities.Task;

/**
 * A store implemented as a singleton.
 */
public class TaskStore {

    private final static TaskStore INSTANCE = new TaskStore();

    private final Set<Task> data = new HashSet<>();

    /* An index-like to retrieve tasks faster by id */
    private final Map<Integer, Task> index = new HashMap<>();

    private TaskStore() {
	// Private
    }

    /**
     * Returns the single instance of this {@code store}.
     *
     * @return the single instance of this {@code store}
     */
    public static TaskStore getInstance() {
	return INSTANCE;
    }

    /**
     * Stores the given {@code task}.
     *
     * @param task the {@code task} to store
     * @throws NullPointerException if given argument is {@code null}
     */
    public void save(Task task) {
	Objects.requireNonNull(task); // Defensive programming
	if (data.add(task)) {
	    index.put(task.getIdendifier(), task);
	}
    }

    /**
     * Finds and returns a stored {@code task} with given {@code identifier} if
     * present.
     *
     * @param identifier the identifier of the {@code task} to find
     * @return the {@code task} with given {@code ientifer}; or {@code null} if
     *         not present
     */
    public Task findById(int identifier) {
	return index.get(identifier);
    }
}
