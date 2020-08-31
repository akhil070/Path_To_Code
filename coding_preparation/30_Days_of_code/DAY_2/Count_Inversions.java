import java.util.Arrays;

public class Count_Inversions {
    public int Approach1(int[] nums,int n){
        // Time complexity is O(N^2) and space O(1)
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i] > nums[j])
                    cnt++;
            }
        }
        return cnt;
    }

    private int merge(int[] nums,int[] tmp,int left,int mid,int right){
        int p1 = left , p2 = mid;
        System.out.println(right+"->"+left);
        int cnt = 0 , k = left;
        while(p1 <= mid-1 && p2 <= right){
            if(nums[p1] <= nums[p2]){
                tmp[k++] = nums[p1++];
            }
            else{
                tmp[k++] = nums[p2++];
                cnt += mid - p1;
            }
        }
        while(p1 <= mid-1)
            tmp[k++] = nums[p1++];
        while(p2 <= right)
            tmp[k++] = nums[p2++];
        for(int i=left;i<=right;i++){
            nums[i] = tmp[i];
        }
        return cnt;
    }

    public int merge_sort(int[] nums,int[] temp,int left,int right){
        int inv_count = 0;
        if(left < right){
            int mid = left + (right-left)/2;
            inv_count += merge_sort(nums,temp, left, mid);
            inv_count += merge_sort(nums,temp, mid+1, right);
            inv_count += merge(nums, temp,left,mid+1,right);
        }
        return inv_count;
    }

    public int getInversionCount(int[] arr,int n){
        int ans;
        // ans = Approach1(arr,n);
        //  Time complexity is O(Nlogn) and space is O(N)
        int temp[] = new int[n];
        ans = merge_sort(arr, temp, 0, n-1);
        System.out.println(Arrays.toString(arr));
        return ans;
    }
    public static void main(String[] args) {
        Count_Inversions CI = new Count_Inversions();
        int[] arr={5,3,2,1,4};
        System.out.println(CI.getInversionCount(arr,arr.length));
    }
}