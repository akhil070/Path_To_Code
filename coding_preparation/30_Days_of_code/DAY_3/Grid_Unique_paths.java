public class Grid_Unique_paths {
    public int Approach1(int row,int col){
        // The time complexiy is O(M*N) and sapce is O(M*N)
        // This is a classical DP question
        int grid[][] = new int[row][col];
        for(int i=0;i<col;i++)
            grid[0][i] = 1;
        for(int i=0;i<row;i++)
            grid[i][0] = 1;
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                grid[i][j] = grid[i-1][j]+grid[i][j-1];
            }
        }
        return grid[row-1][col-1];
    }
    public int Approach2(int row,int col){
        // This is memoizaton top down version recursion
        // similar to fibonnaci takes O(2^n) time 
        if(row==1 || col==1)
            return 1;
        else  
            return Approach2(row-1,col) + Approach2(row, col-1);
    }
    public int Approach3(int row,int col){
        // The time complexity is O(n) 
        double value = 1;
        for(int i=1;i<=col-1;i++){
            value *= ((double)(row+i-1) / (double) i);
        }
        return (int)Math.round(value);
    }
    public int uniquePaths(int row,int col){
        // return Approach1(row,col);
        // return Approach2(row,col);
        return Approach3(row,col);
    }
    public static void main(String[] args) {
        Grid_Unique_paths GP = new Grid_Unique_paths();
        // For the sample senario considering a generic 3*3 grid
        int row = 3 , col = 3;
        int paths = GP.uniquePaths(row,col);
        System.out.println("The uniqe paths in "+row+"*"+col+"is: "+paths);
    }
}