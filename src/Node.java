package uniformedCostSearch;

public class Node<S> implements Comparable<Node<S>> {
	public S state;
	public Node<S> parent;  // parent node, or null if this is the start node
	public int action;  // the action we took to get here from the parent
	public int pathCost;
	
	public Node(S state, Node<S> parent, int action, int pathCost) {
		this.state = state;
		this.parent = parent;
		this.action = action;
		this.pathCost = pathCost;
	}

	@Override
	public int compareTo(Node<S> node2) {
		if (this.pathCost > node2.pathCost)
			return 1;
		else if (this.pathCost < node2.pathCost)
			return -1;
		else
			return 0;
	}
}
