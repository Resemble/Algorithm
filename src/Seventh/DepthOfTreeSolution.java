package Seventh;

import java.util.Scanner;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package Seventh
 * @Description:
 * 题目描述
 * 现在有一棵合法的二叉树,多叉超过两个子节点不算入其中，树的节点都是用数字表示，现在给定这棵树上所有的父子关系，求这棵树的高度
 * 输入描述:
 * 输入的第一行表示节点的个数n（1 ≤ n ≤ 1000，节点的编号为0到n-1）组成，
 * 下面是n-1行，每行有两个整数，第一个数表示父节点的编号，第二个数表示子节点的编号
 * 输出描述:
 * 输出树的高度，为一个整数
 * @date 2018/7/22 下午5:22
 */


public class DepthOfTreeSolution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n < 3) {
            System.out.println(n);
        } else {
            int parent = 0;
            int child = 0;
            int max = 0;
            int[] height = new int[n];
            int[] binary = new int[n];
            height[0] = 1;
            for (int i = 0; i < n - 1; i++) {
                parent = in.nextInt();
                child = in.nextInt();
                binary[parent] += 1;
                if(binary[parent] < 3) {
                    height[child] = height[parent] + 1;
                }
                max = Math.max(max, height[child]);
            }
            System.out.println(max);
        }
    }

}
