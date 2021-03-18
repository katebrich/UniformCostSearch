package uniformedCostSearch;

public class UcsTest {

	public static void main(String[] args) {
		Problem<String> problem = new GraphProblem();

		Node<String> goal = Ucs.search(problem);
		//find first step on the path to the goal
		while(goal.parent != null) {
			goal = goal.parent;		
		}


	}

}
