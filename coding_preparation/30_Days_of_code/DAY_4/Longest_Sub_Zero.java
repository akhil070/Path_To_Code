import java.util.Arrays;
import java.util.HashMap;

public class Longest_Sub_Zero {
    public int Approach1(int[] arr,int n){
        // The time complexity of this solution is O(N^2)
        int ans=0;
        for(int i=0;i<n;i++){
            int sum = arr[i];
            for(int j=i+1;j<n;j++){
                if(sum==0){
                    ans = Math.max(ans,(j-i));
                }
                sum += arr[j];
            }
        }
        return ans;
    }
    public int Approach2(int[] arr,int n){
        // The prefix sum takes O(N) time and time complexity is O(N+N) which is O(N)
        // Space is O(N+N) for the prefix sum and hash table 
        // O(N) time is possible if can re-use array
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1]+arr[i];
        }
        // System.out.println(Arrays.toString(prefix));
        HashMap<Integer,Integer> hm = new HashMap<>();
        int ans = 0;
        for(int i=0;i<n;i++){
            if(!hm.containsKey(prefix[i]))
                hm.put(prefix[i],i);
            else{
                ans = Math.max(ans,i-hm.get(prefix[i]));
            }
        }
        return ans;
    }
    public int maxLen(int[] arr){
        // return Approach1(arr,arr.length);
        return Approach2(arr, arr.length);
    }
    public static void main(String[] args) {
        // int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        int[] arr1 = {1, 0, 3};
        Longest_Sub_Zero LS = new Longest_Sub_Zero();
        int ans = LS.maxLen(arr1);
        System.out.println("Longest sub array with zero sum is :"+ans);
    }
}