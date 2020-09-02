import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Longest_Substring_Nonrepeat {
    public int Approach1(String s){
        int start=0 , end = s.length();
        int max = 0;
        HashMap<Character,Integer> hs = new HashMap<>();
        int cnt = 0; int last_removed = 0;
        while(start < end){
            char tmp = s.charAt(start);
            if(!hs.containsKey(tmp)){
                max = Math.max(max,(start-cnt)+1);
                hs.put(tmp,start);
            }
            else if(hs.containsKey(tmp)){
                cnt = hs.get(tmp)+1;
                int t = cnt-1;
                while(last_removed <= t){
                    if(hs.containsKey(s.charAt(last_removed)))
                        hs.remove(s.charAt(last_removed));
                    last_removed++;
                }
                last_removed = t+1;
                hs.put(tmp,start);
            }
            start++;
        }
        max = Math.max(max,(start-cnt));
        return max;
    }
    public int Approach2(String s){
        // Simplified approach 1
        int n = s.length() , ans =0;
        Map<Character,Integer> hm = new HashMap<>();
        for(int j=0,i=0; j < n;j++){
            if(hm.containsKey(s.charAt(j))){
                i = Math.max(hm.get(s.charAt(j)),i);
            }
            ans = Math.max(ans,j-i+1);
            hm.put(s.charAt(j),j+1);
        }
        return ans;
    }
    public int lengthOfLongestSubstring(String s){
        int ans;
        // ans = Approach1(s);
        ans = Approach2(s);
        return ans;
    }
    public static void main(String[] args) {
        Longest_Substring_Nonrepeat LSN = new Longest_Substring_Nonrepeat();
        String tmp = "tmmzuxt";
        // tmp = "abcabcbb";
        int ans = LSN.lengthOfLongestSubstring(tmp);
        System.out.println("Longest sub string is :"+ans);
    }
}