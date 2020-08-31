import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Next_Permutation {
    public boolean nextPermutation(List<Integer> arr,int n){
        int i = n-2;
        while (i >=0 && arr.get(i) >= arr.get(i+1))
            i--;
        if(i < 0)   
            return false;
        int j = n-1;
        while(arr.get(i) >= arr.get(j))
            j--;
        Collections.swap(arr,i,j);
        Collections.reverse(arr.subList(i+1, n));
        return true;
    }
    public static void main(String[] args) {
        Integer[] nums={1,2,3};
        List<Integer> arr = Arrays.asList(nums);
        Next_Permutation NP = new Next_Permutation();
        boolean flag = NP.nextPermutation(arr,arr.size());
        if(flag){
            System.out.println("Next possible permutations is:->");
            System.out.print(arr);
        }
        else 
            System.out.println("This is the Last Permutation");
    }
}