import java.util.Arrays;
import java.util.HashMap;

public class Two_Sum {
    public int[] Approach1(int[] arr,int n,int target){
        // takes O(N^2) time complexity
        int[] ans = new int[2];
        Arrays.fill(ans,Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]+arr[j]==target){
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }
    public int[] Approach2(int[] arr,int n,int target){
        int[] ans = new int[2];
        Arrays.fill(ans,Integer.MAX_VALUE);
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            if(hm.containsKey(target-arr[i])){
                ans[0] = hm.get(target-arr[i]);
                ans[1] = i;
            }
            else{
                hm.put(arr[i],i);
            }
        }
        return ans;
    }
    public int[] hastwoSum(int[] arr,int target){
        int n =arr.length;
        // return Approach1(arr,n,target);
        return Approach2(arr,n,target);
    }
    public static void main(String[] args) {
        int arr[]={2,7,11,15};
        Two_Sum TS = new Two_Sum();
        int ans[];
        int target = 9;
        ans=TS.hastwoSum(arr,target);
        if(ans[0]!=Integer.MAX_VALUE && ans[1]!=Integer.MAX_VALUE)
            System.out.println("Array has two sum at "+ans[0]+"->"+ans[1]);
        else 
            System.out.print("No two sum");
    }
}