// reverse euler -> DFS iteratively
// DFS via recursion -> call stack -> less storage -> stack overflow for large data;
// DFS iteratively -> using object of stack class in heap -> address stored in call stack -> processing happens in heap 
import java.util.Stack;
import java.util.ArrayList;
class iterativeDepthFirstSearch{

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

    public static class Pair{
        int v;
        String psf;

        Pair(int v, String psf){
            this.v = v;
            this.psf = psf;
        }
    }

    public static void iterativeDepthFirstSearch(ArrayList<ArrayList<Edge>> graph, int src, int dest, boolean[] visited){
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(src, src+""));

        while(st.size()>0){
            Pair rm = st.pop();

            if(visited[rm.v] == true){
                continue;
            }
            visited[rm.v] = true;

            if(rm.v == dest){
                System.out.println(rm.v + " @ " + rm.psf);
            }
            
            for(Edge e: graph.get(rm.v)){
                if(visited[e.nbr] == false){
                    st.push(new Pair(e.nbr, rm.psf + e.nbr));
                }
            }
        }
    }

    public static void main(String[] args){
        int vtces = 7;
        int src =0;
        int dest = 6;

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i=0; i<vtces; i++){
            graph.add(new ArrayList<Edge>());
        }

        graph.get(0).add(new Edge(0, 1, 10));
        graph.get(0).add(new Edge(0, 3, 40));

        graph.get(1).add(new Edge(1, 0, 10));
        graph.get(1).add(new Edge(1, 2, 10));

        graph.get(2).add(new Edge(2, 1, 10));
        graph.get(2).add(new Edge(2, 3, 10));

        graph.get(3).add(new Edge(3, 0, 40));
        graph.get(3).add(new Edge(3, 2, 10));
        graph.get(3).add(new Edge(3, 4, 2));

        graph.get(4).add(new Edge(4, 3, 2));
        graph.get(4).add(new Edge(4, 5, 3));
        graph.get(4).add(new Edge(4, 6, 3));

        graph.get(5).add(new Edge(5, 4, 3));
        graph.get(5).add(new Edge(5, 6, 3));

        graph.get(6).add(new Edge(6, 4, 8));
        graph.get(6).add(new Edge(6, 5, 3));

        boolean[] visited = new boolean[vtces];
        iterativeDepthFirstSearch(graph, src, dest, visited);
    }
}