import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
class isBiparite{

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

    private static class Pair{
        int v;
        int level;

        Pair(int v, int level){
            this.v = v;
            this.level = level;
        }
    }

    public static boolean isBiparite(ArrayList<ArrayList<Edge>> graph, int src, int[] visited){
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, 0));

        while(q.size() >0){
            Pair rm  = q.remove();

            if(visited[rm.v] != -1){
                if(rm.level != visited[rm.v]){
                    return false;
                }
            }else{
                visited[rm.v] = rm.level;
            }

            for(Edge e: graph.get(rm.v)){
                if(visited[e.nbr] == -1){
                    q.add(new Pair(e.nbr, rm.level + 1));
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        int vtces = 7;
        int src = 2;

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

        graph.get(4).add(new Edge(4, 5, 3));
        graph.get(4).add(new Edge(4, 6, 3));

        graph.get(5).add(new Edge(5, 4, 3));
        graph.get(5).add(new Edge(5, 6, 3));

        graph.get(6).add(new Edge(6, 4, 8));
        graph.get(6).add(new Edge(6, 5, 3));

        int[] visited = new int[vtces];
        Arrays.fill(visited, -1);

        for(int v=0; v<vtces; v++){
            if(visited[v] == -1){
                boolean isGraphBiparite = isBiparite(graph, v, visited);
                if(isGraphBiparite == false){
                    System.out.println(false);
                    return;
                }
            }
        }

        System.out.println(true);
    }
}
