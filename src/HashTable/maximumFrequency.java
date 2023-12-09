package HashTable;

import java.util.LinkedHashMap;
import java.util.Map;

public class maximumFrequency {
    public static String maximumFrequency (String S) {
        //Complete the function
        String[] strs = S.split(" ");
        Map<String,Integer> mp = new LinkedHashMap<>();
        for (String str : strs) {
            if (mp.containsKey(str)) {
                mp.put(str, mp.get(str)+1);
            }
            else mp.put(str,1);
        }
        int max = 0;
        for (String key : mp.keySet()) {
            max = Math.max(max,mp.get(key));
        }
        String res = "";
        for (String key : mp.keySet()) {
            if (mp.get(key)==max) {
                res = key + " " + mp.get(key);
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "rjs kot w lmy nh fn zo cfg bl m q ms pnt tko iym uo nmx jl vn i sin";
        System.out.println(maximumFrequency(s));
    }
}
