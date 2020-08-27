import java.util.Arrays;
import java.util.Stack;

public class Merge_Intervals {
    //  Problem link
    // https://leetcode.com/problems/merge-intervals/
    public int[][] merge1(int[][] intervals){
    // This is optimum solution takes O(NlogN+N) and O(N) space 
    // With further optimiation space can be reduced to O(1)
       if(intervals.length==0)
        return intervals;
       Arrays.sort(intervals,(a,b)->Integer.compare(a[0], b[0]));
       Stack<int[]> st=new Stack<>();
       st.push(intervals[0]);
       for(int i=1;i<intervals.length;i++){
           int[] temp=st.peek();
           if(intervals[i][0] <= temp[1]){
               temp[0]=Math.min(temp[0],intervals[i][0]);
               temp[1]=Math.max(temp[1],intervals[i][1]);
               st.pop();
               st.push(temp);
           }
           else{
               st.push(intervals[i]);
           }
       }
       int[][] res=new int[st.size()][];
       for(int i=res.length-1;i>=0;i--){
           res[i]=st.pop();
       }
       return res;
   }

   public int[][] merge2(int[][] intervals) {
       // This is optimum solution takes O(NlogN+N) and O(1) space ✔
        if (intervals == null || intervals.length == 0) 
            return intervals;
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int end = 0;
        for (int i = 1; i < intervals.length; i ++) {
            if (intervals[end][1] >= intervals[i][0]) {
                intervals[end][1] = intervals[i][1] > intervals[end][1] ? intervals[i][1] : intervals[end][1];
            } else {
                intervals[++end] = intervals[i];
            }
        }
        int[][] ans = new int[end + 1][];
        for (int i = 0; i <= end; i ++) {
            ans[i] = intervals[i];
        }
        return ans;
    }

   public static void main(String[] args) {
       int[][] intervals={{1,3},{2,6},{8,10},{15,18}};
       Merge_Intervals mi =new Merge_Intervals();
       int[][] res;
       // Takes O(N) space 
      //  res = mi.merge1(intervals);
      // Takes O(1) space 
       res = mi.merge2(intervals);
       System.out.println(Arrays.deepToString(res));
   } 
}