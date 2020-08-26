package scenarios;
import business_logic.Planner;

public class InputFromConsoleTestScenario {

	public static void main(String[] args) {
		Planner planner = new Planner();
		planner.readTaskFromConsole();
		planner.printAllTasks();
	}

}
