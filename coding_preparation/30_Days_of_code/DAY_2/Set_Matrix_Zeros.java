import java.util.Arrays;
import java.util.HashSet;

class Set_Matrix_Zeros{
    //  Problem link
    // https://leetcode.com/problems/set-matrix-zeroes/
    
    public void Approach1(int[][] matrix,int row,int col){

        // The time complexity is O(M*N) and space complexity is O(M+N)

        HashSet<Integer> h_row = new HashSet<>();
        HashSet<Integer> h_col = new HashSet<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    h_row.add(i);
                    h_col.add(j);
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(h_row.contains(i) || h_col.contains(j))
                    matrix[i][j]=0;
            }
        }
    }

    public void Approach2(int[][] matrix,int row,int col){
        // This code uses flags to idetify the row and col 
        // time is O(M*N) and space is O(1)

        boolean iscol = false;
        for(int i=0;i<row;i++){
            if(matrix[i][0]==0)
                iscol = true;
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0)
                    matrix[i][j]=0;
            }
        }
        if(iscol){
            for(int i=0;i<row;i++){
                matrix[i][0]=0;
            }
        }
        if(matrix[0][0]==0)
            for(int i=0;i<col;i++)
                matrix[0][i]=0;
    }

    public void setZeros(int[][] matrix,int row,int col){
        // Approach1(matrix,row,col);
        Approach2(matrix,row,col);
    }

    public static void main(String[] args) {
        int[][] matrix={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        Set_Matrix_Zeros SMZ = new Set_Matrix_Zeros();
        SMZ.setZeros(matrix,matrix.length,matrix[0].length);
        System.out.print(Arrays.deepToString(matrix));
    }
}