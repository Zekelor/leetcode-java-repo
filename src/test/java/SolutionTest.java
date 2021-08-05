import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void lengthOfLongestSubstring() {
        assertEquals(3, Solution.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    void quickSort() {
        assertArrayEquals(new int[]{1, 2, 3, 5, 7}, Solution.quickSort(new int[]{2,3,5,7,1}));
    }


}