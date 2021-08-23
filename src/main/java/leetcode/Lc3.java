package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fxzou
 * @date 2021/8/22
 * @since IntelliJ IDEA
 */
public class Lc3 {

    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) {
            return 0;
        }

        int max = 0, left = 0;

        Map<Character, Integer> compareMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            if (compareMap.containsKey(s.charAt(i))) {
                left = Math.max(left, compareMap.get(s.charAt(i)) + 1);
            }

            compareMap.put(s.charAt(i), i);

            max = Math.max(max, (i - left + 1));

        }

        return max;

    }
}
