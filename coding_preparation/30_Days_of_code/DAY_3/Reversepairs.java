public class Reversepairs {

    public int merge(int[] nums,int[] tmp,int left,int mid,int right){
        int min_val = Integer.MIN_VALUE+1 , max_val = Integer.MAX_VALUE;
        int p1=left,p2=mid;
        int cnt = 0 , k = left;
        // System.out.println(left+"->"+mid+"->"+right);
        // This is the main code which finds out the count 
        while(p1 <= mid-1 && p2 <= right){
            if(nums[p2] == max_val || (nums[p2] > 0 && (nums[p2]*2)<=0)){
                p2++;
                continue;
            }
            else if(nums[p2] == min_val || (nums[p2] < 0 && (nums[p2]*2)>=0)){
                cnt = cnt + mid - p1;
                p2++;
                continue;
            } 
            // System.out.println("next->"+next);
            else if(nums[p1] > nums[p2] * 2){
                cnt = cnt + mid - p1;
                p2++;
            }
            else{
                p1++;
            }
        }
        System.out.println("cnt->"+cnt);
        p1=left;p2=mid;
        while(p1 <= mid-1 && p2 <= right){
            if(nums[p1] <= nums[p2]){
                tmp[k++] = nums[p1++];
            }
            else{
                tmp[k++] = nums[p2++];
            }
        }
        while(p1 <= mid-1)
            tmp[k++] = nums[p1++];
        while(p2 <= right)
            tmp[k++] = nums[p2++];
        for(int i=left;i<=right;i++){
            nums[i] = tmp[i];
        }   
        System.out.println();
        return cnt;
    }
    public int merge_sort(int[] nums,int[] temp,int left,int right){
        int rp_count = 0;
        if(left < right){
            int mid = left + (right-left)/2;
            rp_count += merge_sort(nums,temp,left,mid);
            rp_count += merge_sort(nums,temp,mid+1,right);
            rp_count += merge(nums,temp,left,mid+1,right);
        }
        return rp_count;
    }
    
    public int r_pairsCount(int[] nums){
        int ans; int n = nums.length;
        int temp[] = new int[n];
        ans = merge_sort(nums,temp,0,n-1);
        // System.out.println(Arrays.toString(nums));
        return ans;
    }
    
    public int reversePairs(int[] nums) {
        // The time complexity will be O(Nlogn+n)
        return r_pairsCount(nums);
    }
    public static void main(String[] args) {
        Reversepairs rp = new Reversepairs();
        int arr[]={2147483647,2147483647,-2147483647,-2147483647,-2147483647,2147483647};
        int ans = rp.reversePairs(arr);
        System.out.println("Reverse Pairs count is:"+ans);
    }    
}