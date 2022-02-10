// Time Complexity : O(n) where n = length of the source string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0 || p.length() > s.length()) return result;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        
        int match = 0;
        for(int i = 0; i < s.length(); i++){
            char in = s.charAt(i);
            
            // incoming character
            if(map.containsKey(in)){
                int count = map.get(in);
                count--;
                if(count == 0){
                    // 1 --> 0
                    match++;
                }
                map.put(in, count);
            }
            
            // outgoing character
            if(i >= p.length()){
                char out = s.charAt(i - p.length());
                if(map.containsKey(out)){
                    int count = map.get(out);
                    count++;
                    if(count == 1){
                        // 0 --> 1
                        match--;
                    }
                    map.put(out, count);
                }
            }
            
            // if match equals map's size then add that to the result
            if(match == map.size()){
                result.add(i - p.length() + 1);
            }
        }
        
        return result;
    }
}