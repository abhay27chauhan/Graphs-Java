import java.util.PriorityQueue;
import java.util.ArrayList;
class multisolver{

    public static class Edge{
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr= nbr;
            this.wt = wt;
        }
    }

    public static class Pair implements Comparable<Pair>{
        int wt;
        String psf;

        Pair(int wt, String psf){
            this.wt = wt;
            this.psf = psf;
        }

        public int compareTo(Pair o){
            return this.wt - o.wt;
        }
    }

    static String spath;
    static Integer spathwt = Integer.MAX_VALUE;
    static String lpath;
    static Integer lpathwt = Integer.MIN_VALUE;
    static String cpath;
    static Integer cpathwt = Integer.MAX_VALUE;
    static String fpath;
    static Integer fpathwt = Integer.MIN_VALUE;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();
    public static void multisolver(ArrayList<ArrayList<Edge>> graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf){
        if(src == dest){
            if(wsf < spathwt){
                spathwt = wsf;
                spath = psf;
            }

            if(wsf > lpathwt){
                lpathwt = wsf;
                lpath = psf;
            }

            if(wsf > criteria && wsf < cpathwt){
                cpathwt = wsf;
                cpath = psf;
            }

            if(wsf < criteria && wsf > fpathwt){
                fpathwt = wsf;
                fpath = psf;
            }

            while(pq.size() != k){
                pq.add(new Pair(wsf, psf));
            }

            if(wsf > pq.peek().wt){
                pq.remove();
                pq.add(new Pair(wsf, psf));
            }

            return;
        }

        visited[src] = true;
        for(Edge e: graph.get(src)){
            if(!visited[e.nbr]){
                multisolver(graph, e.nbr, dest, visited, criteria, k, psf +" "+ e.nbr, wsf + e.wt);
            }
        }
        visited[src] = false;

    }

    public static void main(String[] args){
        int vtces = 7;
        int edges = 8;
        int src =0;
        int dest = 6;
        int criteria = 40;
        int k = 4;

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
        graph.get(4).add(new Edge(4, 6, 8));

        graph.get(5).add(new Edge(5, 4, 3));
        graph.get(5).add(new Edge(5, 6, 3));

        graph.get(6).add(new Edge(6, 4, 8));
        graph.get(6).add(new Edge(6, 5, 3));

        boolean[] visited = new boolean[vtces];
        multisolver(graph, src, dest, visited, criteria, k, src + "", 0);
        String kpath = pq.remove().psf;
        System.out.println(spath);
        System.out.println(lpath);
        System.out.println(cpath);
        System.out.println(fpath);
        System.out.println(kpath);
    }
}
