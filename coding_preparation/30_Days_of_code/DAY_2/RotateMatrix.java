import java.util.Arrays;

public class RotateMatrix {

    public void Approach1(int[][] matrix,int n){
         // The conventional O(M*N) method
        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-i-1;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-j];;
                matrix[j][n-1-j] = temp;
            }
        }
    }

    public void Approach2(int[][] matrix,int n){
        // ** The intial array example **/
        // 1  2  3             
        // 4  5  6
        // 7  8  9
        // ** After transposing matrix 
        // 7  8  9
        // 4  5  6
        // 1  2  3
        //  ** After flipping matrix horizantally by swapping two elements at a time**
        // 7  4  1
        // 8  5  2
        // 9  6  3
        for(int i=0;i<n/2;i++){
            int[] tmp = matrix[i];
            matrix[i] = matrix[n-1-i];
            matrix[n-1-i] = tmp;
        }
        System.out.println(Arrays.deepToString(matrix));
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    public void Rotate(int[][] matrix,int n){
        // Approach1(matrix,n); 
        Approach2(matrix,n); 
    }
   public static void main(String[] args) {
       int[][] matrix={
        {5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}
       };
       RotateMatrix RM = new RotateMatrix();
       RM.Rotate(matrix,matrix.length);
       System.out.println(Arrays.deepToString(matrix));
   } 
}