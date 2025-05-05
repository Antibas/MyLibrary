package mylib.util.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import mylib.util.graph.Edge;
import mylib.util.graph.Graph;
import mylib.util.graph.Vertex;

public final class Search {
	public static <S, A> List<A> depthFirstSearch(Problem<S, A> problem){
		List<Successor<S, A>> actionSuccessors = new ArrayList<>();
		if(problem.isGoalState(problem.getStartState())) {
			List<A> actions = new ArrayList<>();
			actions.add(problem.getFinalAction());
			return actions;
		}
		
		Stack<Successor<S,A>> stack = new Stack<>();
		stack.addAll(problem.getSuccessors(problem.getStartState()));
		
		Set<S> exploredStates = new HashSet<>();
		exploredStates.add(problem.getStartState());
		
		while(!stack.isEmpty()) {
			Successor<S,A> currentSucc = stack.pop(); 
			
			exploredStates.add(currentSucc.getState());
			
			actionSuccessors.add(currentSucc);
			
			if(problem.isGoalState(currentSucc.getState())) {
				return problem.backtrackSuccessors(actionSuccessors);
			}
			
			List<Successor<S,A>> expSuccs = new ArrayList<>();
			for(Successor<S,A> successor: problem.getSuccessors(problem.getStartState())) {
				if(!exploredStates.contains(successor.getState()) && !stack.contains(successor)) {
					expSuccs.add(successor);
				}
			}
			stack.addAll(stack.size(), expSuccs);
		}
		return null;
	}
	public static <S, A> List<A> breadthFirstSearch(Problem<S, A> problem){
		List<Successor<S, A>> actionSuccessors = new ArrayList<>();
		if(problem.isGoalState(problem.getStartState())) {
			List<A> actions = new ArrayList<>();
			actions.add(problem.getFinalAction());
			return actions;
		}
		
		Queue<Successor<S,A>> queue = new LinkedList<>();
		queue.addAll(problem.getSuccessors(problem.getStartState()));
		
		return null;
	}
	public static <S, A> List<A> AStarSearch(Problem<S, A> problem, Heuristic<S, A> heuristic){
		return null;
	}
	
	public static <S, A> List<A> AStarSearch(Problem<S, A> problem){
		return Search.AStarSearch(problem, x -> 0d);
	}
	
	

}
