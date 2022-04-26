package leetcode;

/**
 * @author fxzou
 * @descrition 10.3打卡题
 * @date 2021/10/3
 * @since IntelliJ IDEA
 */
public class Lc166FractionToDecimal {

    public String fractionToDecimal(int numerator, int denominator) {

        long numeratorL = numerator;

        long denominatorL = denominator;

        if (numeratorL % denominatorL == 0) {
            return String.valueOf(numeratorL / denominatorL);
        }


        StringBuilder sb = new StringBuilder();

        // 如果有一个是负数，先追加负号
        if (numeratorL * denominatorL < 0) {
            sb.append("-");
        }

        numeratorL = Math.abs(numeratorL);

        denominatorL = Math.abs(denominatorL);


        return null;
    }
}
