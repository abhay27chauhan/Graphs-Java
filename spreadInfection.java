// application of BFS
// 1 unit of time to spread to immediate neighbour 
import java.util.ArrayDeque;
import java.util.ArrayList;
class spreadInfection{

    public static class Edge{
        int src;
        int nbr;

        Edge(int src, int nbr){
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static class Pair{
        int v;
        int time;

        Pair(int v, int time){
            this.v = v;
            this.time = time;
        }
    }

    public static void spreadInfection(ArrayList<ArrayList<Edge>> graph, int src, int time, int[] visited){
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, 1));
        int count =0;
        while(q.size()>0){
            Pair rm = q.removeFirst();

            if(visited[rm.v] > 0){
                continue;
            }
            visited[rm.v] = rm.time;
            if(rm.time > time){
                break;
            }
            count++;

            for(Edge e: graph.get(rm.v)){
                if(visited[e.nbr] == 0){
                    q.add(new Pair(e.nbr, rm.time+1));
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args){
        int vtces = 7;
        int src = 0;

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i=0; i<vtces; i++){
            graph.add(new ArrayList<Edge>());
        }

        graph.get(0).add(new Edge(0, 1));
        graph.get(0).add(new Edge(0, 3));

        graph.get(1).add(new Edge(1, 0));
        graph.get(1).add(new Edge(1, 2));

        graph.get(2).add(new Edge(2, 1));
        graph.get(2).add(new Edge(2, 3));

        graph.get(3).add(new Edge(3, 0));
        graph.get(3).add(new Edge(3, 2));
        graph.get(3).add(new Edge(3, 4));

        graph.get(4).add(new Edge(4, 3));
        graph.get(4).add(new Edge(4, 5));
        graph.get(4).add(new Edge(4, 6));

        graph.get(5).add(new Edge(5, 4));
        graph.get(5).add(new Edge(5, 6));

        graph.get(6).add(new Edge(6, 4));
        graph.get(6).add(new Edge(6, 5));

        int[] visited = new int[vtces];
        spreadInfection(graph, src, 3, visited);
    }
}