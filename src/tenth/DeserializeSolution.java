package tenth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: 385. 迷你语法分析器
 * @date 2019-08-18 15:35
 */
public class DeserializeSolution {


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
class NestedInteger {
    // Constructor initializes an empty nested list.
    public NestedInteger() {

    }

    // Constructor initializes a single integer.
    public NestedInteger(int value) {

    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return true;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return 0;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {

    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {

    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return new ArrayList<>();
    }
}
    public NestedInteger deserialize(String s) {
        if (s == null || "".equals(s) || "[]".equals(s)) {
            return new NestedInteger();
        }
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }
        if (s.length() <= 2) {
            return new NestedInteger();
        }

        NestedInteger res = new NestedInteger();
        /** start 开始标识，cnt 判断同一层级 */
        int start = 1, cnt = 0;
        for (int i = 1; i < s.length(); i++) {
            if (cnt == 0 && (s.charAt(i) == ',' || i == s.length() - 1)) {
                res.add(deserialize(s.substring(start, i)));
                start = i + 1;
            } else if (s.charAt(i) == '[') {
                cnt++;
            } else if (s.charAt(i) == ']') {
                cnt--;
            }
        }
        return res;
    }

}
