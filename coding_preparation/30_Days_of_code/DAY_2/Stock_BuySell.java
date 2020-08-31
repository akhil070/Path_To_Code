public class Stock_BuySell {
    public int Approach1(int[] arr,int n){
        // Takes O(N^2) time because of (n*n+1)/2 time 
        int profit = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                profit = Math.max(profit,arr[j]-arr[i]);
            }
        }
        return profit;
    }
    public int Approach2(int[] arr,int n){
        // Takes O(N) time 
        if(n==0 || n==1)
            return 0;
        int min_ele = Integer.MAX_VALUE;
        int max_ele = Integer.MIN_VALUE;
        min_ele = Math.min(min_ele,arr[0]);
        for(int i=1;i<n;i++){
            min_ele = Math.min(min_ele, arr[i]);
            max_ele = Math.max(max_ele,arr[i]-min_ele);
        }
        return max_ele;
    }
    public int maxProfit(int[] arr,int n){
        int profit;
        // profit = Approach1(arr,n);
        profit = Approach2(arr,n);
        return profit;
    }
    public static void main(String[] args) {
        // int arr[]={7,1,5,3,6,4};
        int arr1[] = {7,6,4,3,1};
        Stock_BuySell SB = new Stock_BuySell();
        System.out.println(SB.maxProfit(arr1,arr1.length));
    }
}