package duke.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.List;

/**
 * Represents task type of deadline.
 */
public class Deadline extends Task {
    private final String taskType;
    private final LocalDateTime taskDeadline;
    DateTimeFormatter dateTimeFormatter1 =
            DateTimeFormatter.ofPattern("MMM dd yyyy HHmm a");

    public Deadline(int taskNumber, boolean taskStatus, String task, LocalDateTime taskDeadline, int totalNumOfTasks) {
        super(taskNumber, taskStatus, task, totalNumOfTasks);
        this.taskType = "[D]";
        this.taskDeadline = taskDeadline;
    }

    /**
     * Prints that task is marked as done when task is done.
     */
    @Override
    public void markAsDone() {
        System.out.println("\t____________________________________________________________"
                + "\n\t Nice! I've marked this task as done:\n"
                + "\t  " + this.taskType + "[X]" + " " + super.task
                + " (by: " + this.taskDeadline.format(dateTimeFormatter1) + ")"
                + "\n\t____________________________________________________________");
    }

    /**
     * Prints that task is marked as not done when task is unmarked.
     */
    @Override
    public void unmarkAsUndone() {
        System.out.println("\t____________________________________________________________"
                + "\n\t OK, I've marked this task as not done yet:\n"
                + "\t  " + this.taskType + "[ ]" + " " + super.task
                + " (by: " + this.taskDeadline.format(dateTimeFormatter1) + ")"
                + "\n\t____________________________________________________________");
    }

    /**
     * Prints task information when added to task list.
     */
    public void printDeadlineTask() {
        System.out.println("\t____________________________________________________________"
                + "\n\t Got it. I've added this task:"
                + "\n\t   [D]" + super.getTaskStatus() + " " + super.task
                + "(by: " + this.taskDeadline.format(dateTimeFormatter1) + ")"
                + "\n\t Now you have " + super.totalNumOfTasks + " tasks in the list."
                + "\n\t____________________________________________________________");
    }

    /**
     * Prints that task is deleted.
     */
    @Override
    public void printDelete(List<Task> allTasks) {
        int newTotalNumOfTasks = allTasks.size() - 1;
        System.out.println("\t____________________________________________________________"
                + "\n\t Noted. I've removed this task:" + "\n\t   " + this.taskType
                + super.getTaskStatus() + " " + super.task + " (by: "
                + this.taskDeadline.format(dateTimeFormatter1) + ")"
                + "\n\t Now you have " + newTotalNumOfTasks + " tasks in the list."
                + "\n\t____________________________________________________________");
    }

    /**
     * Returns that this is a deadline task type.
     */
    @Override
    public String getTaskType() {
        return this.taskType;
    }

    /**
     * Get task deadline.
     */
    @Override
    public LocalDateTime getDeadline() {
        return this.taskDeadline;
    }

    /**
     * Get date of task deadline.
     */
    @Override
    public LocalDate getDate() {
        return this.taskDeadline.toLocalDate();
    }
}
