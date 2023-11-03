package cn.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/valid-parentheses/">valid-parentheses</a>
 */
public class Solution20 {
    @Test
    public void unittest() {
        Solution20 solution = new Solution20();
        Assert.assertEquals(false, solution.isValid("(){}}{"));
        Assert.assertEquals(true, solution.isValid("()"));
        Assert.assertEquals(true, solution.isValid("()[]{}"));
        Assert.assertEquals(false, solution.isValid("(]"));
    }

    private static final Map<Character, Character> DICT = Map.of(
            '(', ')', '{', '}', '[', ']', '#', '#');

    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        // Add a dummy entry to prevent NPE at `map.get() == null`
        stack.push('#');
        for (char c: s.toCharArray()) {
            if (DICT.containsKey(c)) {
                stack.push(c);
            } else if (DICT.get(stack.pop()) != c) {
                return false;
            }
        }
        return stack.size() == 1;
    }
}
