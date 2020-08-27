import java.util.HashSet;
import java.util.Arrays;

class Duplicate_Integer_in_array{
    // Problem link 
    // https://leetcode.com/problems/find-the-duplicate-number/

    public int Approach1(int[] nums,int n){
        // Approach 1 is brute force which uses O(1) space and O(N^2) access to memory
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i] == nums[j])
                    return nums[j];
            }
        }
        return -1;
    }

    public int Approach2(int[] nums){
        // Approach 2 is slightly optimized which uses O(N) space and O(N) time
        HashSet<Integer> hs=new HashSet<>();
        for(int i:nums){
            if(hs.contains(i))
                return i;
            hs.add(i);
        }
        return -1;
    }

    public int Approach3(int[] nums,int n){
        // This method requires O(nlogn) time to sort and O(n) time to find the duplicate element
        Arrays.sort(nums);
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1])
                return nums[i];
        }
        return -1;
    }

    public int Approach4(int[] nums,int n){
        // This Approach is modifed from approach 2 and takes 
        // optimal time and space complexity O(N) , O(1)
        // Uses floyd warshall tortise and hare method to find duplicate
        int tortise = nums[0];
        int hare = nums[0];
        do{
            tortise=nums[tortise];
            hare=nums[nums[hare]];
        }while(tortise!=hare);
        //restting the position  of the tortoise to find the orgin node of the loop
        tortise=nums[0];
        while(tortise!=hare){
            tortise=nums[tortise];
            hare=nums[hare];
        }
        return hare;
    }

    public int FindDuplicate(int[] nums,int n){
        // return Approach1(nums,n);
        // return Approach2(nums);
        // return Approach3(nums,n);
        return Approach4(nums,n);
    }
    public static void main(String[] args) {
        int arr[] = {1,3,4,2,2};
        Duplicate_Integer_in_array DA = new Duplicate_Integer_in_array();
        int res = DA.FindDuplicate(arr,arr.length);
        System.out.println("Duplicate Number in  array is: "+res);
    }
}