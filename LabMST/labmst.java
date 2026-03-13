package LabMST;
import java.util.*;
class Solution {
    List<List<String>> res;
    public boolean isPalin(String str)
    {
        StringBuilder sb=new StringBuilder(str);
        String rev=sb.reverse().toString();
        if(rev.equalsIgnoreCase(str))
        return true;
        return false;
    }
    public void solve(String s, int i, List<String> ans)
    {
        if(i>=s.length()){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int j=1; i+j<=s.length(); j++)  //j is length of string to test; i is start index
        {
            String sub=s.substring(i, i+j);
            System.out.println(sub);
            if(isPalin(sub))
            {
                ans.add(sub);
                solve(s, i+j, ans);
                ans.remove(ans.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        res=new ArrayList<>();
        solve(s, 0, new ArrayList<>());
        return res;
    }
}