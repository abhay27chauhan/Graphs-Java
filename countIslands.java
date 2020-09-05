// application of get connected graphs
class countIslands{

    public static void countIslands(int[][] arr, int i, int j, boolean[][] visited){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j] == 1 || visited[i][j] == true){
            return;
        }

        visited[i][j] = true;
        countIslands(arr, i-1, j, visited);
        countIslands(arr, i, j+1, visited);
        countIslands(arr, i+1, j, visited);
        countIslands(arr, i, j-1, visited);
    }

    public static void main(String[] args){
        int[][] arr = {{0,0,1,1,1,1,1,1}, 
                       {0,0,1,1,1,1,1,1},
                       {1,1,1,1,1,1,1,0},
                       {1,1,0,0,0,1,1,0},
                       {1,1,1,1,0,1,1,0},
                       {1,1,1,1,0,1,1,0},
                       {1,1,1,1,1,1,1,0},
                       {1,1,1,1,1,1,1,0}
                    };
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int count = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(visited[i][j] == false && arr[i][j] == 0){
                    countIslands(arr,i,j,visited);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}