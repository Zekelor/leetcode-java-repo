package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author fxzou
 * @date 2021/8/24
 * @since IntelliJ IDEA
 */
class Lc215QuickSortTest {

    @Test
    void findKthLargest2() {
        assertEquals(5, Lc215QuickSort.findKthLargest2(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}