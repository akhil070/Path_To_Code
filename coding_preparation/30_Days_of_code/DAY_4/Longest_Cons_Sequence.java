import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Longest_Cons_Sequence {
    public int Approach1(int[] nums){
        // The time complexity is O(nlogn)
        if(nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int res = 1;
        int cnt = 1;
        
        for(int i=1;i<nums.length;i++){
            if(nums[i] != nums[i-1])
                if(nums[i-1] == nums[i]-1)
                    cnt++;
                else{
                    res = Math.max(res,cnt);
                    cnt = 1;
                }
        }
        res = Math.max(res,cnt);
        return res;
    }
    public int Approach2(int[] arr){
        // By using hashset method intelligently bulding up the sequence the time 
        // complexity is O(N) and space is O(N)
        Set<Integer> arr_set = new HashSet<>();
        int longest_streak = 0;
        for(int i : arr)
            arr_set.add(i);
        for(int num:arr_set){
            if(!arr_set.contains(num-1)){
                int curr_num = num;
                int curr_streak = 1;
                while(arr_set.contains(curr_num+1)){
                    curr_num++;
                    curr_streak++;
                }
                longest_streak = Math.max(longest_streak,curr_streak);
            }
        }
        return longest_streak;
    }
    public int longestConsecutive(int[] arr){
        // return Approach1(arr);
        return Approach2(arr);
    }
    public static void main(String[] args) {
        int[] arr = {100,4,200,1,3,2};
        Longest_Cons_Sequence LS = new Longest_Cons_Sequence();
        int ans = LS.longestConsecutive(arr);
        System.out.println("The longest consecutive elements in array is->"+ans);
    }
}