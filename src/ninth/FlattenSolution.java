package ninth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package ninth
 * @Description:
 * @date 2019-05-13 21:43
 */
public class FlattenSolution {


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer,
        // rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds,
        // if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds,
        // if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }


    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten2(List<NestedInteger> nestedList) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nestedList.size(); i++) {
            NestedInteger nl = nestedList.get(i);
            if (nl.isInteger()) {
                result.add(nl.getInteger());
            } else {
                result.addAll(flatten(nl.getList()));
            }
        }
        return result;
    }

    public List<Integer> flatten(List<NestedInteger> nestedList) {
        boolean isFlat = true;
        List<NestedInteger> ls = nestedList;
        while (isFlat) {
            isFlat = false;
            List<NestedInteger> newLs = new ArrayList<>();
            for (NestedInteger ni : ls) {
                if (ni.isInteger()) {
                    newLs.add(ni);
                } else {
                    newLs.addAll(ni.getList());
                    isFlat = true;
                }
            }
            ls = newLs;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < ls.size(); i++) {
            result.add(ls.get(i).getInteger());
        }
        return result;
    }


}
