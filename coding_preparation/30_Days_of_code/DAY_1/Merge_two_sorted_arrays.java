import java.util.Arrays;

public class Merge_two_sorted_arrays {
    // Question link
    //  https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/
    public int binarysearchfloor(int[] nums,int idx){
        int low=idx,high=nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] < nums[0]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low;
    }
    public void insertionsort(int[] nums,int idx){
        int binidx = binarysearchfloor(nums,idx+1);
        if(binidx==idx+1 && nums[0] < nums[1])
            return;
        int temp = nums[idx];
        for(int i=idx;i<binidx;i++){
            if(i+1 < nums.length)
                nums[i]=nums[i+1];
        }
        nums[binidx-1] = temp;
    }
    public void Approach1(int[] arr1,int[] arr2){
        // This method takes O(N+M) time and O(1) space
        int idx1=0;
        int n1=arr1.length;
        for(idx1=0;idx1<n1;idx1++){
            if(arr1[idx1] < arr2[0])
                continue;
            else{ 
                arr1[idx1] = arr2[0] ^ arr1[idx1] ^ (arr2[0]=arr1[idx1]);
                insertionsort(arr2,0);
            }
        }
    }
    public void MergeArrays(int[] arr1,int[] arr2){
        // Time complexity is O(M*N)
        Approach1(arr1,arr2);
    }
    public static void main(String[] args) {
        int arr1[] = {1, 3, 4, 5,10,12,19,20};
        int arr2[] = {-50,-12,-1,1,2, 4, 6, 8};
        // int arbitary[] = {10,0,1,4,5,6,7,8,9,11,12,14};
        Merge_two_sorted_arrays mg = new Merge_two_sorted_arrays();
        mg.MergeArrays(arr1,arr2);
        // System.out.println(mg.binarysearchfloor(arbitary, 0));
        System.out.print(Arrays.toString(arr1)+""+Arrays.toString(arr2));
    }    
}