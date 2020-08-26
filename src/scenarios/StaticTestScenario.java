package scenarios;
import business_logic.Planner;

public class StaticTestScenario {

	public static void main(String[] args) {
		Planner planner = new Planner();
		int newId = planner.addSimpleTask("Sleep for 8 hours", 4, 9);
		planner.addSimpleTask("Talk with friend", 2, 3);
		planner.addSimpleTask("Go to work", 8, 8);
		planner.addSimpleTask("Learn Java", 3, 7);
		planner.printAllTasks();
	}

}