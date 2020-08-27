public class Kadane {

    //  https://leetcode.com/problems/maximum-subarray/

    public int Approach1(int[] arr,int n){
        // This is O(N^3) algorithum and takes quadratic time 
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum = sum+ arr[k];
                    ans = Math.max(ans,sum);
                }
            }
        }
        return ans;
    }

    public int Approach2(int[] arr,int n){
        // this approach is slightly better still takes quadratic time
        int ans = Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<n;i++){
            sum = arr[i];
            ans = Math.max(ans,sum);
            for(int j=i+1;j<n;j++){
                sum += arr[j];
                ans = Math.max(ans,sum);
            }
        }
        return ans;
    }

    public int Approach3(int[] arr,int n){
        int maxsumsofar=Integer.MIN_VALUE,maxuptohere=0;
        for(int i=0;i<n;i++){
            maxuptohere = Math.max(arr[i],maxuptohere+arr[i]);
            maxsumsofar = Math.max(maxuptohere,maxsumsofar);
        }
        return maxsumsofar;
    }

    public int MaximumSubarraysum(int[] arr,int n){
        int ans;
        // ans = Approach1(arr,n);
        // ans = Approach2(arr,n);
        ans = Approach3(arr,n);
        return ans;
    }
   public static void main(String[] args) {
       int arr[]={1,-100,12,-3,4,5,16,19,-21,45};
       Kadane k = new Kadane();
       int ans = k.MaximumSubarraysum(arr,arr.length);
       System.out.print("Maximum subarray sum is: "+ans);
   } 
}