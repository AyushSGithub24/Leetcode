class Solution {
    public int islandPerimeter(int[][] grid) {
        int ans=0;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    int c=4;
                    if((i+1)<n && grid[i+1][j]==1) c--;
                    if((i-1)>=0 && grid[i-1][j]==1) c--;
                    if((j+1)<m  && grid[i][j+1]==1) c--;
                    if((j-1)>=0 && grid[i][j-1]==1) c--;
                    ans+=c;
                }
            }
        }
        return ans;
    }
}