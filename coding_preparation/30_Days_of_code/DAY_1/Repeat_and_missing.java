import java.util.Arrays;

public class Repeat_and_missing {
    //  Problem link
    // https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/ 

    public int[] Approach1(int[] nums,int n){
        // Assuming array elements are the length of the array and no zero number in array
        int count[]=new int[n+1];
        int repeating=Integer.MAX_VALUE,missing=Integer.MAX_VALUE;
        for(int i:nums){
            count[i]++;
            if(count[i] > 1)
                repeating=i;
        }
        for(int i=1;i<=n;i++){
            if (count[i]==0)
                missing=i;
        }
        return new int[]{repeating,missing};
    }

    public int[] Approach2(int[] nums,int n){
        int repeating=Integer.MAX_VALUE,missing=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int abs=Math.abs(nums[i]);
            if(nums[abs-1] > 0)
                nums[abs-1]*=-1;
            else 
                repeating = abs;
        }
        for(int i=0;i<n;i++){
            if(nums[i] > 0)
                missing = i+1;
        }
        return new int[]{repeating,missing};
    }

    public int[] Approach3(int[] nums,int n){
        int repeating=0,missing=0;
        int xor=0;
        for(int i:nums){
            xor^=i;
        }
        for(int i=1;i<=n;i++){
            xor^=i;
        }
        int right_bit = xor & -xor;
        for(int i=0;i<n;i++){
            if ((nums[i]&right_bit)!=0)
                repeating = repeating ^ nums[i];
            else  
                missing = missing ^ nums[i];
        }
        for(int i=1;i<=n;i++){
            if((i&right_bit)!=0)
                repeating = repeating ^ i;
            else 
                missing = missing ^ i;
        }
        for(int i=0;i<n;i++){
            if(nums[i]==repeating || nums[i]==missing)
                if (nums[i] == repeating)
                    break;
                else{
                    repeating = missing ^ repeating ^ (missing=repeating);
                    break;
                }
        }
        return new int[]{repeating,missing};
    }

    public int[] Find_Repeat_and_missing(int[] arr,int n){
        int res[];
        // res = Approach1(arr,n);
        // res = Approach2(arr,n);
        res = Approach3(arr, n);
        return res;
    }
    public static void main(String[] args) {
        int arr[]={4, 3, 6, 2, 1, 1};
        Repeat_and_missing rm =new Repeat_and_missing();
        int ans[] = rm.Find_Repeat_and_missing(arr,arr.length);
        System.out.print("Repeat, Missing number is :"+Arrays.toString(ans));
    }
}