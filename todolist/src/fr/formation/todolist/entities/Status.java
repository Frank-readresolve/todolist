package fr.formation.todolist.entities;

import java.util.HashMap;
import java.util.Map;

public enum Status {

    TODO(0), IN_PROGRESS(1), DONE(2);

    private final static Map<Integer, Status> CACHE = new HashMap<>();
    static {
	for (Status status : values()) {
	    CACHE.put(status.order, status);
	}
    }

    private final int order;

    private Status(int order) {
	this.order = order;
    }

    public Status next() {
	return get(order + 1);
    }

    private static Status get(int key) {
	return CACHE.get(key);
    }
}
