package fr.formation.todolist.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class Task {

    private final int idendifier;

    private String description;

    private Status status;

    private final LocalDateTime creationDate = LocalDateTime.now();

    public Task(int idendifier, String description) {
	this.idendifier = idendifier;
	this.description = description;
    }

    public void toNextStatus() {
	status = status.next();
    }

    public int getIdendifier() {
	return idendifier;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (!(obj instanceof Task)) {
	    return false;
	}
	Task other = (Task) obj;
	return idendifier == other.idendifier;
    }

    @Override
    public int hashCode() {
	return Objects.hash(idendifier);
    }

    @Override
    public String toString() {
	return "{idendifier=" + idendifier + ", description=" + description
		+ ", status=" + status + ", creationDate=" + creationDate + "}";
    }
}
