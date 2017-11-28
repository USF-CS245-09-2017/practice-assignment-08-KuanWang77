import java.util.ArrayList;
import java.util.Stack;

public class GraphAdjMatrix implements Graph{
	int vertices;
	int[][] graph;
	
	public GraphAdjMatrix(int vertices) {
		this.vertices = vertices;
		graph = new int[vertices][vertices];
	}

	public void addEdge(int src, int tar) {
		graph[src][tar] = 1;
	}
	
	public void topologicalSort() {
		Stack<Integer> stack = new Stack<Integer>();
		
		boolean visited[] = new boolean[vertices];
		
		for (int i = 0; i < vertices; i ++) {
			visited[i] = false;
		}
		
		for (int j = 0; j < vertices; j++) {
			if (visited[j] == false) {
				topologicalSort(j, stack, visited);
			}
		}
		
		while (stack.empty() == false) {
			System.out.print(stack.pop() + " | ");
		}
		System.out.println();
	}
	
	public void topologicalSort(int v, Stack<Integer> stack, boolean visited[]) {
		visited[v] = true;
		Integer edge;
		int arr[] = neighbors(v);
		
		for (int i = 0; i < arr.length; i++) {
			edge = arr[i];
			if (!visited[edge]) {
				topologicalSort(edge, stack, visited);
			}
		}
		
		stack.push(new Integer(v));
	}
	
	
	public int[] neighbors(int vertex) {
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for (int i = 0; i < graph[vertex].length; i++) {
			if (graph[vertex][i] == 1) {
				al.add(i);
			}
		}
		
		int[] arr = new int[al.size()];
		
		for (int j = 0; j < al.size();j++) {
			arr[j] = al.get(j);
		}
		return arr;
		
	}

}
