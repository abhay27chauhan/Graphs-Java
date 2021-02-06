import java.util.List;
import java.util.ArrayList;
class printAllPaths2{
    static List<List<Integer>> res;
    public static void solution(int[][] graph, boolean[] visited, int src, int dest, List<Integer> list){
        if(src == dest){
            res.add(new ArrayList<>(list));
            return;
        }
        
        visited[src] = true;
        for(int val: graph[src]){
            if(!visited[val]){
                list.add(val);
                solution(graph, visited, val, dest, list);
                list.remove(list.size() -1);
            }
        }
        visited[src] = false;
    }
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        List<Integer> list = new ArrayList<>();
        list.add(0);
        solution(graph, visited, 0, graph.length-1, list);
        return res;
    }

    public static void main(String[] args){
        int[][] graph = {{1,2},{3},{3},{}};
        System.out.println(allPathsSourceTarget(graph));
    }
}
