public class Majority_Element_N3 {

    public int findcandidate(int[] nums,int n){
        int maj_index = 0,count=1;
        for(int i=1;i<n;i++){
            if(nums[maj_index]==nums[i])
                count++;
            else
                count--;
            if(count==0){
                maj_index = i;
                count=1;
            }
        }
        return nums[maj_index];
    }

    public boolean ismajority(int cand,int[] nums){
        int n = nums.length;
        int cnt = 0;
        for(int i:nums){
            if(i==cand)
                cnt++;
        }
        return cnt > n/3;
    }

    public int majorityElement(int[] nums,int n){
        // takes O(n+n) which is O(n) time 
        int cand = findcandidate(nums,nums.length);
        if(ismajority(cand,nums))
            return cand;
        return -1;
    }

    public static void main(String[] args) {
        // The idea is to use the Majority_Element_N2 bayer more voting algorithum here 
        Majority_Element_N3 ME = new Majority_Element_N3();
        int[] arr={2,2,1,1,1,2,2,2};
        int ans = ME.majorityElement(arr,arr.length);
        if(ans!=-1)
            System.out.println("Majority Element in array is: "+ans);
        else 
            System.out.println("No majority element");
    }   
}