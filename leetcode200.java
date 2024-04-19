//dfs solution
class Solution {
    public int numIslands(char[][] grid) {
        int ans=0;
        int n=grid.length,m=grid[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    ans++;
                    dfs(grid,i,j,n,m);
                }
            }
        }
        return ans;
    }
    void dfs(char arr[][],int i,int j,int n,int m){
        if(i<0 || i>=n || j<0 || j>=m || arr[i][j]=='0' ){
            return;
        }
        arr[i][j]='0';
        dfs(arr,i+1,j,n,m);
        dfs(arr,i,j+1,n,m);
        dfs(arr,i-1,j,n,m);
        dfs(arr,i,j-1,n,m);
    }
}
//********************************************************* */

//bfs solution
class Solution {
    int x[]={0,1,-1,0};
    int y[]={1,0,0,-1};
    void bfs(char arr[][],int i1,int j1){
        Queue<ArrayList<Integer>> q=new LinkedList<>();
        ArrayList<Integer> a=new ArrayList<>();
        a.add(i1);
        a.add(j1);
        q.add(a);
        while(!q.isEmpty()){
            ArrayList<Integer> rt=q.poll();

            for(int b=0;b<4;b++){
                int i=rt.get(0)+x[b];
                int j=rt.get(1)+y[b];
                if(i>=0 && i<arr.length && j>=0 && j<arr[0].length && arr[i][j]=='1'){
                    arr[i][j]='*';
                    ArrayList<Integer> r=new ArrayList<>();
                    r.add(i);
                    r.add(j);
                    q.add(r);
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    bfs(grid,i,j);
                }

            }
        }
        return count;
    }
}