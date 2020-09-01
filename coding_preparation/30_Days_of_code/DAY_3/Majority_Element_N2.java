import java.util.HashMap;

public class Majority_Element_N2 {
    public int Approach1(int[] nums,int n){
        // This is brute force takes O(N^2) time 
        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=i+1;j<n;j++){
                if(nums[i]==nums[j])
                    cnt++;
            }
            if(cnt > n/2)
                return nums[i];
        }
        return -1;
    }

    public int Approach2(int[] nums,int n){
        // This takes O(N) time the basic assumption is that querying hashmap over large 
        // data will significantlly effect the runtime of algorithm
        // For better results we can use BST Implemtation to find in NlogN time
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i:nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
            if(hm.get(i) > n/2)
                return i;
        }
        return -1;
    }

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
        return cnt > n/2;
    }

    public int Approach3(int[] nums,int n){
        // This algorithum is an implemtation of Boyer Moore's Majority Voting Algorithm
        // The Assumption is that if any element is occuring more than n/2 time then there is 
        // high probability of finding the element by cheking neighbour elements
        int cand = findcandidate(nums,nums.length);
        if(ismajority(cand,nums))
            return cand;
        return -1;
    }

    public int majorityElement(int[] nums,int n){
        int ans;
        ans = Approach1(nums,n);
        ans = Approach2(nums, n);
        ans = Approach3(nums, n);
        return ans;
    }

    public static void main(String[] args) {
        Majority_Element_N2 ME = new Majority_Element_N2();
        int[] arr={2,2,1,1,1,2,2};
        int ans = ME.majorityElement(arr,arr.length);
        if(ans!=-1)
            System.out.println("Majority Element in array is: "+ans);
        else 
            System.out.println("No majority element");
    }
}