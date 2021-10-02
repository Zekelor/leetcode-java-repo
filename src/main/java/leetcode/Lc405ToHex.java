package leetcode;

/**
 * @author fxzou
 * @date 2021/10/2
 * @since IntelliJ IDEA
 */
public class Lc405ToHex {

    public String toHexWithPaw(int _num) {

        if (_num == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        long num = _num;

        if (_num < 0) {
            num = (long) (Math.pow(2, 32) + num);
        }

        while (num != 0) {

            long u = num % 16;

            char c = (char) (u + '0');

            if (u > 10) {
                c = (char) (u - 10 + 'a');
            }

            sb.append(c);

            num /= 16;
        }
        return sb.reverse().toString();
    }

    public String toHex(int _num) {
        String resultStr = "";

        if (_num == 0) {
            return "0";
        }
        // 转成long型 防止转换失败
        long num = _num;

        String dict = "0123456789abcdef";

        if (num < 0) {
            num = 4294967296L + num;
        }

        while (num > 0) {

            long c = num % 16;

            num /= 16;

            resultStr = dict.charAt((int) c) + resultStr;

        }

        return resultStr;


    }

}
