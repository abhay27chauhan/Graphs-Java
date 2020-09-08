//application of BFS
import java.util.ArrayDeque;
import java.util.ArrayList;
class isGraphCyclic{

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

    public static boolean isGraphCyclic(ArrayList<ArrayList<Edge>> graph, int src, boolean[] visited){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(src);

        while(q.size()>0){
            int v = q.removeFirst();

            if(visited[v] == true){
                return true;
            }
            visited[v] = true;

            for(Edge e: graph.get(v)){
                if(visited[e.nbr] == false){
                    q.add(e.nbr);
                }
            }
        } return false;
    }

    public static void main(String[] args){
        int vtces = 7;
        int src =0;

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
        for(int v=0; v<vtces; v++){
            if(visited[v] == false){
                boolean isCyclic = isGraphCyclic(graph, v, visited);
                if(isCyclic){
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println(false);
    }
}