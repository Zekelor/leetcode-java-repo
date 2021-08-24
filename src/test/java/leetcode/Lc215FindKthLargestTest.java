package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author fxzou
 * @date 2021/8/23
 * @since IntelliJ IDEA
 */
class Lc215FindKthLargestTest {

    @Test
    void testFindKthLargest() {

        assertEquals(5, Lc215FindKthLargest.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));

    }
}