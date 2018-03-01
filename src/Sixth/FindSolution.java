package Sixth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package Sixth
 * @Description:
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @date 2018/3/1 上午9:4
 */
public class FindSolution {

    public boolean Find(int target, int[][] array) {
        if(array == null || array.length == 0 || (array.length == 1 && array[0].length == 0)) return false;
        return findHelper(target, 0, array[0].length, array);
    }

    public boolean findHelper(int target, int rowMark, int width, int[][] array) {
        if (target < array[rowMark][0])
            return false;
        int left = 0;
        for (int i = 0; i < width; i++) {
            if (array[rowMark][i] < target) {
                left = i;
            } else if (array[rowMark][i] == target) {
                return true;
            }
        }
        if(rowMark == array.length - 1) return false;
        rowMark++;
        width = left + 1;
        return findHelper(target, rowMark, width, array);
    }

    // better solution
    public boolean find2(int[][] array, int target) {
        int row = 0;
        int col = array[0].length - 1;
        while(row <= array.length - 1 && col >= 0) {
            if(target == array[row][col])
                return true;
            else if (target > array[row][col])
                row++;
            else
                col--;
        }
        return false;
    }



    public static void main(String[] args) {
        int[][] array = {{1,2,8,9}, {2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int target = 15;
        FindSolution findSolution = new FindSolution();
        if(findSolution.Find(target, array)) {
            System.out.println("true");
        } else {
            System.out.println("flase");
        }
    }
}
