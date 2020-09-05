import java.util.ArrayList;
class perfectFriends{

    private static class Edge{
        int src;
        int nbr;

        Edge(int src, int nbr){
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static void getConnectedComps(ArrayList<ArrayList<Edge>> graph, int src, ArrayList<Integer> comp, boolean[] visited){

        comp.add(src);
        visited[src] = true;
        for(Edge e: graph.get(src)){
            if(visited[e.nbr] == false){
                getConnectedComps(graph, e.nbr, comp, visited);
            }
        }
    }

    public static void main(String[] args){
        int vtces = 7;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i=0; i<vtces; i++){
            graph.add(new ArrayList<Edge>());
        }

        graph.get(0).add(new Edge(0,1));
        graph.get(2).add(new Edge(2,3));
        graph.get(4).add(new Edge(4,5));
        graph.get(4).add(new Edge(4,6));
        graph.get(5).add(new Edge(5,6));

        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        boolean[] visited = new boolean[vtces];

        for(int v=0; v<vtces; v++){
            if(visited[v] == false){
                ArrayList<Integer> comp = new ArrayList<>();
                getConnectedComps(graph, v, comp, visited);
                comps.add(comp);
            }
        }

        int pairs = 0;
        for(int i=0; i<comps.size()-1; i++){
            for(int j=i+1; j<comps.size(); j++){
                pairs += comps.get(i).size()*comps.get(j).size();
            }
        }
        System.out.println(pairs);

    }
}