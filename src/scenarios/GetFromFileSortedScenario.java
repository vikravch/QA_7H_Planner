package scenarios;

import business_logic.Planner;

public class GetFromFileSortedScenario {

	public static void main(String[] args) {
		Planner planner = new Planner();
		planner.restoreFromFile("src/backup.txt");
		//planner.printAllTasks();
		planner.sortByUrgency();
		planner.printAllTasks();
	}
}