//if hamiltonian cycle -> print with "*"
//if hamiltonian path -> print with "."
import java.util.ArrayList;
import java.util.HashSet;
class hamiltonianPathsNCycles{

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

    public static void hamiltonianPathsNCycles(ArrayList<ArrayList<Edge>> graph, int osrc, int src, String psf, HashSet<Integer> visited){
        if(visited.size() == graph.size()-1){
            System.out.print(psf + " ");
            
            boolean closingEdgeFound = false;
            for(Edge e: graph.get(src)){
                if(e.nbr == osrc){
                   closingEdgeFound = true;
                   break;
                }
            }

            if(closingEdgeFound){
                System.out.println("*");
            }else{
                System.out.println(".");
            }
            return;
        }

        visited.add(src);
        for(Edge e: graph.get(src)){
            if(visited.contains(e.nbr) == false){
                hamiltonianPathsNCycles(graph, osrc, e.nbr, psf + e.nbr, visited);
            }
        }
        visited.remove(src);
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
        graph.get(2).add(new Edge(2, 5, 10));

        graph.get(3).add(new Edge(3, 0, 10));
        graph.get(3).add(new Edge(3, 2, 10));
        graph.get(3).add(new Edge(3, 4, 10));

        graph.get(4).add(new Edge(4, 3, 10));
        graph.get(4).add(new Edge(4, 5, 10));
        graph.get(4).add(new Edge(4, 6, 10));

        graph.get(5).add(new Edge(5, 2, 10));
        graph.get(5).add(new Edge(5, 4, 10));
        graph.get(5).add(new Edge(5, 6, 10));

        graph.get(6).add(new Edge(6, 4, 10));
        graph.get(6).add(new Edge(6, 5, 10));

        HashSet<Integer> visited = new HashSet<>();
        hamiltonianPathsNCycles(graph, src, src, src+"", visited);
    }
}