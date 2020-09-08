import java.util.ArrayList;
class isGraphConnected{

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

    public static void isGraphConnected(ArrayList<ArrayList<Edge>> graph, int src, ArrayList<Integer> comp, boolean[] visited){

        comp.add(src);
        visited[src] = true;
        for(Edge e: graph.get(src)){
            if(visited[e.nbr] == false){
                isGraphConnected(graph, e.nbr, comp, visited);
            }
        }
    }

    public static void main(String[] args){
        int vtces = 7;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i=0; i<vtces; i++){
            graph.add(new ArrayList<Edge>());
        }

        graph.get(0).add(new Edge(0,1,10));

        graph.get(1).add(new Edge(1,0,10));

        graph.get(2).add(new Edge(2,3,10));

        graph.get(3).add(new Edge(3,2,10));

        graph.get(4).add(new Edge(4,5,10));
        graph.get(4).add(new Edge(4,6,10));

        graph.get(5).add(new Edge(5,4,10));
        graph.get(5).add(new Edge(5,6,10));

        graph.get(6).add(new Edge(6,4,10));
        graph.get(6).add(new Edge(6,5,10));

        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        boolean[] visited = new boolean[vtces];
        for(int v=0; v<vtces; v++){
            if(visited[v] == false){
                ArrayList<Integer> comp = new ArrayList<>();
                isGraphConnected(graph, v, comp, visited);
                comps.add(comp);
            }
        }
        if(comps.size() == 1){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}