package business_logic;
import java.util.Collections;
import java.util.LinkedList;

import model.SimpleTask;
import model.Task;

public class Planner {
	
	private LinkedList<Task> tasks = 
			new LinkedList<>();
	
	public int addSimpleTask(String description,
			int urgency, int importance) {
		// POJO (Plain old java object), model, data class
		Task newTask = new SimpleTask(description, 
				urgency,
				importance);
		tasks.add(newTask);
		return newTask.getId();
	}
	
	public void printAllTasks() {
		for(Task currTask:tasks) {
			System.out.println(currTask);
		}
	}

	public void readTaskFromConsole() {
		ConsoleReader cr = new ConsoleReader();
		addSimpleTask(
				cr.getSafetyString("Input description: "),
				cr.getInt("Input urgency: "),
				cr.getInt("Input importance: "));
	}

	public void restoreFromFile(String fileName) {
		String textFromFile = 
				FileHelper.readFromFile(fileName);
		String[] tasksStrArr = textFromFile.split("\n");
		for(String taskStr:tasksStrArr) {
			if(!taskStr.equals("")) {
				Task newTask = Task.fromCSV(taskStr);
				tasks.add(newTask);
				//System.out.println("Task str - "+taskStr);				
			}
		}
	}

	public void saveToBackup(String fileName) {
		String content = "";
		for(Task task:tasks) {
			content = content+task.toCSV();
		}
		FileHelper.printToFile(fileName, false, content);
	}

	public void sortByUrgency() {
		Collections.sort(tasks);
	}
}
