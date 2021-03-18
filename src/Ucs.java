package uniformedCostSearch;
import java.awt.print.Printable;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

// uniform-cost search
// returns null if no goal was found
public class Ucs {
	
	public static <S> Node<S> search(Problem<S> prob) {
		PriorityQueue<Node<S>> frontier = new PriorityQueue<Node<S>>();
		Set<S> expanded = new HashSet<S>();
		
		//put initial node into frontier
		S initialState = prob.initialState();
		//System.out.println("Initial state is " + initialState.toString()); //debug
		Node<S> node  = new Node<S>(initialState, null, 0, 0);
		frontier.add(node);
		
		while (!frontier.isEmpty()) {
			Node<S> curNode = frontier.poll(); //get node with highest priority
			//System.out.println(curNode.state.toString() + " taken from frontier"); //debug
			if (expanded.contains(curNode.state)) {//this state has been already expanded with smaller cost
				//System.out.println("Already expanded" + curNode.state.toString()); //debug
				continue;
			}
			if (prob.isGoal(curNode.state)) {
				//System.out.println("Returning goal " + curNode.state.toString()); //debug
				return curNode;
			}
			else {
				//System.out.println("Expanding " + curNode.state.toString()); //debug
				frontier.addAll(expand(curNode, prob));
				expanded.add(curNode.state);
			}		
		}
		
		return null; //no goal was found
	  }
	  
	private static <S> Set<Node<S>> expand(Node<S> curNode, Problem<S> problem) {
		  Set<Node<S>> successors = new HashSet<Node<S>>();
		  //System.out.println("Coordinates of current node:"); //debug
		  //problem.printCoordinates((Integer)curNode.state); //debug
		  List<Integer> actions = problem.actions(curNode.state);
		  //System.out.println("Possible actions: " + actions.toString()); //debug
		  for (Integer action : actions) {
			  //System.out.println("    Action: " + action.toString()); //debug
			  S result = problem.result(curNode.state, action);
			  if (result == null) {  
				  //System.out.println("    Result is null, this action cannot be taken."); //debug
				  break;
			  }
			  // problem.printCoordinates((Integer)result); //debug
			  //System.out.println("    Result is " + result.toString()); //debug
			  int cost = problem.cost(curNode.state, action) + curNode.pathCost;
			  //System.out.println("    Cost is " + cost); //debug
			  Node<S> newNode = new Node<S>(result, curNode, action, cost);
			  successors.add(newNode);
			  //System.out.println("    New node added to frontier: " + newNode.state.toString()); //debug
		  }
		  return successors;
	}
} 
