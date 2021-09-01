package leetcode;

/**
 * @author fxzou
 * @date 2021/8/31
 * @since IntelliJ IDEA
 */
public class Lc121MaxProfit {

    public int maxProfit(int[] prices) {
        int result = 0;
        int length = prices.length;

        int pre = 0;

        for (int i = 1; i < length; i++) {
            int differ = prices[i] - prices[i - 1];

            pre = Math.max(differ + pre, 0);

            result = Math.max(pre, result);

        }

        return result;
    }

    public int maxProfitDp(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        // 记录今天买入前的最小值
        int min = prices[0], max = 0;

        for (int i = 1; i < prices.length; i++) {
            // 今天能获取的最大收益是今天的价格减去昨天的价格
            max = Math.max(max, prices[i] - min);
            // 更新昨天的价格
            min = Math.min(min, prices[i]);
        }

        return max;
    }
}
