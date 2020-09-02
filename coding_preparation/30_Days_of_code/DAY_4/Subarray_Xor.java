import java.util.HashMap;
import java.util.Map;

public class Subarray_Xor {
    public int Approach1(int[] arr,int target){
        // Obvisouly takes O(N^2) time 
        int cnt = 0 , n = arr.length;
        for(int i=0;i<n;i++){
            int curr_xor = 0;
            for(int j=i;j<n;j++){
                curr_xor = curr_xor ^ arr[j];
                if(curr_xor == target)
                    cnt++;
            }
        }
        return cnt;
    }
    public int Approach2(int[] arr,int target){
        // Takes O(N) time it based upon sub array cacellation when xored with the same array
        int cnt = 0 , n = arr.length;
        int xor[] = new int[n];
        xor[0] = arr[0];
        for(int i=1;i<n;i++)
            xor[i] = xor[i-1] ^ arr[i];
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            int tmp = xor[i] ^ target;
            cnt += hm.containsKey(tmp) == false ? 0 : hm.get(tmp);
            if(xor[i] == target)
                cnt++;
            if(hm.containsKey(xor[i]))
                hm.put(xor[i],hm.get(xor[i])+1);
            else 
                hm.put(xor[i],1);
        }
        return cnt;
    }

    // This problem is counting sub arrays with the given xor
    public int subarrayXOR(int[] arr,int target){
        int ans;
        ans = Approach1(arr,target);
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {4,2,2,6,4};
        int target = 6;
        Subarray_Xor SX = new Subarray_Xor();
        int ans = SX.subarrayXOR(arr,target);
        System.out.println("The sub array's with the given xor is ->"+ans);
    }
}