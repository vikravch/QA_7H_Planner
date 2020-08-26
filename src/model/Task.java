package model;
import java.util.Random;

public abstract class Task implements Comparable<Task> {
	
	public static final int STATUS_DONE = 1;
	public static final int STATUS_IN_PROGRESS = 2;
	public static final int STATUS_TODO = 3;
	public static final int STATUS_PAUSED = 4;
	
	private int id; // 0 .. max_int
	private String deadline = "No deadline"; 
	private int status = STATUS_TODO;
	
	private String description;
	private int urgency;
	private int importance;
	
	private static Random rand = new Random();
	
	public Task(String description, 
			int urgency, int importance) {
		super();
		this.description = description;
		//setDescription(description);
		this.urgency = urgency;
		this.importance = importance;

		id = rand.nextInt(Integer.MAX_VALUE);
	}

	public int getId() {
		return id;
	}

	public String getDeadline() {
		return deadline;
	}

	public int getStatus() {
		return status;
	}

	public String getDescription() {
		return description;
	}

	public int getUrgency() {
		return urgency;
	}

	public int getImportance() {
		return importance;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", deadline=" + deadline + ", status=" + status + ", description=" + description
				+ ", urgency=" + urgency + ", importance=" + importance + "]";
	}
	
	public static Task fromCSV(String taskStr) {
		String[] dataArr = taskStr.split(";"); 
		Task task = new SimpleTask(
				dataArr[3],
				Integer.parseInt(dataArr[4]),
				Integer.parseInt(dataArr[5]));
		task.id = Integer.parseInt(dataArr[0]);
		task.deadline = dataArr[1];
		task.status = Integer.parseInt(dataArr[2]);
		return task;
	}
	//  0    1       2        3         4         5
	// id;deadline;status;description;urgency;importance\n
	public String toCSV() {
		return id+";"+deadline+";"+status+";"+
				description+";"+urgency+";"+importance+"\n";
	}
	
	public int compareTo(Task other) {
		return - Integer.compare(this.urgency, other.urgency);
	}
}
