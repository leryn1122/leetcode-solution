package cn.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/rings-and-rods/description/">rings-and-rods</a>
 */
public class Solution2103 {
    @Test
    public void unittest() {
        Solution2103 solution = new Solution2103();
        Assert.assertEquals(1, solution.countPoints("B0B6G0R6R0R6G9"));
        Assert.assertEquals(1, solution.countPoints("B0R0G0R9R0B0G0"));
        Assert.assertEquals(0, solution.countPoints("G4"));
    }

    public int countPoints(String rings) {
        int[] res = new int[10];
        char[] chars = rings.toCharArray();
        for (int i = 0; i < chars.length; i+=2) {
            res[chars[i + 1] - '0'] |= (
                    (chars[i] == 'R') ? 1 :
                    (chars[i] == 'G') ? 1<<1 : 1<<2
            );
        }

        int count = 0;
        for (int i = 0; i < res.length; i++) {
            count += (res[i] == 7) ? 1 : 0;
        }
        return count;
    }
}
