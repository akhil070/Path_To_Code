import java.util.Arrays;

class Dutch_Flag{
    // Question link
    // https://leetcode.com/problems/sort-colors/ 
    public void Approach1(int[] flag,int n){
        // This is a two pass algorithum 
        int ones=0,zeros=0;

        for(int i:flag){
            if(i==0)
                zeros++;
            else if(i==1)
                ones++;
        }

        for(int i=0;i<n;i++){
            if(zeros-- > 0)
                flag[i]=0;
            else if(ones-- > 0)
                flag[i]=1;
            else 
                flag[i]=2; 
        }
    }

    public void Approach2(int[] flag,int n){
        int red=0,white=0,blue=n-1;
        while(white<=blue){
            switch(flag[white]){
                case 0 :
                   // this line is used for swapping two varibles without third 
                   // a = b ^ a ^ (b=a)
                   flag[red]=flag[white]^flag[red]^(flag[white]=flag[red]);
                   red++; white++;
                   break;
                case 1:
                    white++;
                    break;
                case 2:
                    flag[blue]=flag[white]^flag[blue]^(flag[white]=flag[blue]);
                    blue--;
                    break;
            }
        }
    }

    public void SortFlag(int[] flag,int n){
        // The Approach 1 takes O(N+N) time and O(1) space and two pass algorithum
        // Approach1(flag,n);
        // The Approach 2 takes o(N) time and O(1) space
        Approach2(flag,n);
    }

    public static void main(String[] args) {
        int arr[]={1,1,0,2,1,1,0,1,0,2,2,1,0,2};
        Dutch_Flag DF = new Dutch_Flag();
        DF.SortFlag(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}