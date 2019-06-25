package tenth;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description:
 * @date 2019-06-23 15:58
 */
public class CanFinishSolution {

    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     * TODO！超内存了，哈哈
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        // write your code here
        int[][] solveCourses = new int[numCourses][numCourses];
        List<Short> canFinishList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            canFinishList.add((short)i);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            /* 用 Integer remove就是 object */
            Short toFinishCourse = (short) prerequisites[i][0];

            canFinishList.remove(toFinishCourse);
            for (int j = 1; j < 2; j++) {
                int beforeFinishCourse = prerequisites[i][j];
                solveCourses[toFinishCourse][beforeFinishCourse] = 1;
            }
        }
        /* 递归填上所有的1为0 */
        List<Short> canFinishListAll = new ArrayList<>(canFinishList);
        return finishCourse(canFinishList, solveCourses, numCourses, canFinishListAll);
    }

    public boolean finishCourse(List<Short> canFinishList, int[][] solveCourses, int numCourses, List<Short> canFinishListAll) {
        for (int i = 0; i < canFinishList.size(); i++) {
            for (int j = 0; j < numCourses; j++) {
                solveCourses[j][canFinishList.get(i)] = 0;
            }
        }
        List<Short> newCanFinishList = new ArrayList<>();
        boolean canFinishAll = true;
        boolean canFinish;
        for (short i = 0; i < numCourses; i++) {
            canFinish = true;
            for (int j = 0; j < numCourses; j++) {
                if (solveCourses[i][j] == 1) {
                    canFinishAll = false;
                    canFinish = false;
                }
            }
            if (canFinish) {
                if (!canFinishListAll.contains(i)) {
                    newCanFinishList.add((short)i);
                }
            }
        }
        if (newCanFinishList.size() == 0) {
            return canFinishAll;
        } else {
            canFinishListAll.addAll(newCanFinishList);
            return finishCourse(newCanFinishList, solveCourses, numCourses, canFinishListAll);
        }
    }

//    上完课后：之前学习的topological sorting使用dfs求解，九章推荐使用bfs解决。（因为dfs使用递归容易产生stack overflow）
//    需要计算入度：入度就是指向某个Node的边的条数。
//
//    统计所有店的入度；
//    首先找到入度为0的点，全部送入queue；
//    从queue中拿出一个点，去掉这个点指向其他点的edges，其他node的入度全部-1；
//    一旦某个node入度为0，送入queue；

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] edges = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        Queue queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int course = (int) queue.poll();
            count++;;
            int n = edges[course].size();
            for (int i = 0; i < n; i++) {
                int pointer = (int) edges[course].get(i);
                degree[pointer]--;
                if (degree[pointer] == 0) {
                    queue.add(pointer);
                }
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        int numCourses = 7;
        int[][] prerequisites = new int[7][2];
        prerequisites[0][0] = 1;
        prerequisites[0][1] = 0;
        prerequisites[1][0] = 2;
        prerequisites[1][1] = 1;
        prerequisites[2][0] = 3;
        prerequisites[2][1] = 2;
        prerequisites[3][0] = 4;
        prerequisites[3][1] = 3;
        prerequisites[4][0] = 5;
        prerequisites[4][1] = 4;
        prerequisites[5][0] = 6;
        prerequisites[5][1] = 5;
        prerequisites[6][0] = 0;
        prerequisites[6][1] = 6;
        CanFinishSolution solution = new CanFinishSolution();
        if (solution.canFinish(numCourses, prerequisites) ) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
