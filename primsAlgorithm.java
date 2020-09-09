import java.util.ArrayList;
import java.util.PriorityQueue;
class primsAlgorithm{

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

    private static class Pair implements Comparable<Pair>{
        int v;
        int av;
        int wt;

        Pair(int v, int av, int wt){
            this.v = v;
            this.av = av;
            this.wt = wt;
        }

        public int compareTo(Pair o){
            return this.wt - o.wt;
        }
    }

    public static void primsAlgorithm(ArrayList<ArrayList<Edge>> graph, int src, boolean[] visited){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, -1, 0));

        while(pq.size() >0){
            Pair rm = pq.remove();

            if(visited[rm.v] == true){
                continue;
            }
            visited[rm.v] = true;

            if(rm.av != -1){
                System.out.println(rm.v + " - " + rm.av + " @ " + rm.wt);
            }

            for(Edge e: graph.get(rm.v)){
                if(visited[e.nbr] == false){
                    pq.add(new Pair(e.nbr, rm.v, e.wt));
                }
            }
        }
    }

    public static void main(String[] args){
        int vtces = 7;
        int src = 0;

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
        primsAlgorithm(graph, src, visited);
    }
}