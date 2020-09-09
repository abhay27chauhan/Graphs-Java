// A permutation of vertices such that for all the edges uv (u-->v), must appear before v in the topological sort
// DFS
import java.util.ArrayList;
import java.util.Stack;
class topologicalSort{

    public static class Edge{
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void topologicalSort(ArrayList<ArrayList<Edge>> graph, int src, boolean[] visited, Stack<Integer> st){

        visited[src] = true;
        for(Edge e: graph.get(src)){
            if(visited[e.nbr] == false){
                topologicalSort(graph, e.nbr, visited, st);
            }
        }
        st.push(src);
    }

    public static void main(String[] args){
        int vtces = 7;

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i=0; i<vtces; i++){
            graph.add(new ArrayList<Edge>());
        }

        graph.get(0).add(new Edge(0, 1, 10));
        graph.get(0).add(new Edge(0, 3, 40));

        graph.get(1).add(new Edge(1, 2, 10));

        graph.get(2).add(new Edge(2, 3, 10));

        graph.get(4).add(new Edge(4, 3, 2));
        graph.get(4).add(new Edge(4, 5, 3));
        graph.get(4).add(new Edge(4, 6, 3));

        graph.get(5).add(new Edge(5, 6, 3));


        boolean[] visited = new boolean[vtces];
        Stack<Integer> st = new Stack<>();
        for(int v=0; v<vtces; v++){
            if(visited[v] == false){
                topologicalSort(graph, v, visited, st);
            }
        }
        while(st.size()>0){
            System.out.println(st.pop());
        }
    }
}