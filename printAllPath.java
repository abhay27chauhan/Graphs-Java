import java.util.ArrayList;
class printAllPath{

    private static class Edge{
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void printAllPath(ArrayList<ArrayList<Edge>> graph, int src, int dest, String psf, boolean[] visited){
        if(src == dest){
            System.out.println(psf);
            return;
        }

        visited[src] = true;
        for(Edge e: graph.get(src)){
            if(visited[e.nbr]== false){
                printAllPath(graph, e.nbr, dest, psf + e.nbr, visited);
            }
        }
        visited[src] = false;
    }

    public static void main(String[] args){
        int vtces = 7;
        int edges = 8;
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
        String psf = "0";
        printAllPath(graph, src, dest, psf, visited);
    }
}