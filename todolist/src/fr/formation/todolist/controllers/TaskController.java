package fr.formation.todolist.controllers;

import java.util.concurrent.atomic.AtomicInteger;

import fr.formation.todolist.entities.Task;
import fr.formation.todolist.stores.TaskStore;

public class TaskController {

    private final static AtomicInteger KEYS = new AtomicInteger();

    private final static TaskStore STORE = TaskStore.getInstance();

    public TaskController() {
	// Empty constructor
    }

    public void create(String description) {
	int idendifier = KEYS.incrementAndGet();
	Task task = new Task(idendifier, description);
	STORE.save(task);
    }

    public void changeStatus(int identifier) {
	Task task = STORE.findById(identifier);
	task.toNextStatus();
    }
}
