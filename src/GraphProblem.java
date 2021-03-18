package uniformedCostSearch;

import java.util.*;

public class GraphProblem implements Problem<String> {

	@Override
	public String initialState() {
		return "b";
	}

	@Override
	public List<Integer> actions(String state) {
		switch (state) {
		case "p":
			return Arrays.asList(1,2);
		case "b":
			return Arrays.asList(1,2,4);
		case "v":
			return Arrays.asList(1,2,3,4);
		case "bu":
			return Arrays.asList(1,3,2,4);
		case "l":
			return Arrays.asList(1,2,4);
		case "z":
			return Arrays.asList(1,2);

		default:
			return null;
		}
	}

	@Override
	public String result(String state, int action) {
		switch (state) {
		case "p":
			if (action == 1)
				return "v";
			if (action == 2)
				return "b";
		case "b":
			if (action == 1)
				return "bu";
			if (action == 2)
				return "p";
			if (action == 4)
				return "v";
		case "v":
			if (action == 1)
				return "l";
			if (action == 2)
				return "bu";
			if (action == 3)
				return "p";
			if (action == 4)
				return "b";
		case "bu":
			if (action == 1)
				return "z";
			if (action == 2)
				return "v";
			if (action == 3)
				return "b";
			if (action == 4)
				return "l";
		case "l":
			if (action == 1)
				return "v";
			if (action == 2)
				return "z";
			if (action == 4)
				return "bu";
		case "z":
			if (action == 1)
				return "bu";
			if (action == 2)
				return "l";

		default:
			return null;
		}
	}

	@Override
	public boolean isGoal(String state) {
		return (state == "l");
	}

	@Override
	public int cost(String state, int action) {
		switch (state) {
		case "p":
			if (action == 1)
				return 4;
			if (action == 2)
				return 3;
		case "b":
			if (action == 1)
				return 2;
			if (action == 2)
				return 3;
			if (action == 4)
				return 1;
		case "v":
			if (action == 1)
				return 4;
			if (action == 2)
				return 3;
			if (action == 3)
				return 4;
			if (action == 4)
				return 1;
		case "bu":
			if (action == 1)
				return 3;
			if (action == 2)
				return 3;
			if (action == 3)
				return 2;
			if (action == 4)
				return 4;
		case "l":
			if (action == 1)
				return 4;
			if (action == 2)
				return 2;
			if (action == 4)
				return 4;
		case "z":
			if (action == 1)
				return 3;
			if (action == 2)
				return 2;

		default:
			return 10000;
		}
	}

}
