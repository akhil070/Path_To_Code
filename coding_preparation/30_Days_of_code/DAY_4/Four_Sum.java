import java.util.*;
public class Four_Sum {
    public List<Integer> helper(int[] arr,int i,int j,int left,int right){
        List<Integer> res = new ArrayList<>();
        res.add(arr[i]); res.add(arr[j]);
        res.add(arr[left]); res.add(arr[right]);
        return res;
    }
    public List<List<Integer>> fourSum(int[] arr,int target){
        List<List<Integer>> res = new ArrayList<>();
        if(arr.length < 4)
            return res;
        Arrays.sort(arr);
        for(int i=0;i<arr.length-3;i++){
            if(i > 0 && arr[i]==arr[i+1])
                continue;
            for(int j=i+1;j<arr.length-2;j++){
                if(j > i+1 && arr[j]==arr[j-1])
                    continue;
                int left = j+1 , right = arr.length-1;
                while(left < right){
                    int curr = arr[i]+arr[j]+arr[left]+arr[right];
                    if(curr == target){
                        List<Integer> t = helper(arr,i,j,left,right);
                        res.add(new ArrayList<>(t));
                        left++;right--;
                        while(left < right && arr[left] == arr[left-1]) left++;
                        while(left < right && arr[right] == arr[right-1]) right--;
                    }
                    else if(curr > target){
                        right--;
                    }
                    else{
                        left++;
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[] = {1, 0, -1, 0, -2, 2};
        Four_Sum FS = new Four_Sum();
        int target = 0;
        List<List<Integer>> ans = FS.fourSum(arr,target);
        System.out.println(ans);
    }
}