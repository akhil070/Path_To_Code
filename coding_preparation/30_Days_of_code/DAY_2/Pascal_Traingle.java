import java.util.Arrays;

public class Pascal_Traingle {
    public void generatePascal(int rows){
        int[][] pascal=new int[rows][];
        for(int i=0;i<rows;i++){
            pascal[i]=new int[i+1];
            Arrays.fill(pascal[i],1);
        }
        for(int i=2;i<rows;i++){
            for(int j=1;j<pascal[i].length-1;j++){
                pascal[i][j]=pascal[i-1][j-1]+pascal[i-1][j];
            }
        }
        System.out.println("Generated pascal traingles..");
        System.out.println(Arrays.deepToString(pascal));
    }
    public static void main(String[] args) {
        int n = 10;
        Pascal_Traingle PT = new Pascal_Traingle();
        PT.generatePascal(n);
    }
}