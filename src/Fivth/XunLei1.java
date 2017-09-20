package Fivth;

import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Fivth
 * @Description:
 * @date 2017/9/19 19:18
 */
public class XunLei1 {

    static class Solution {
        public static String solveEquation(String equation) {
            // 例如：equation = "2x+5-3+x=6+x-2";
            // return "Infinite solutions"; // 无穷解
            // return "No solution"; // 无解

            char[] chars = equation.toCharArray();
            int countX = 0;
            int countNum = 0;
            int leftOrRight = 0;
            int firstIndex = 0;
            boolean judge = false;
            for (int i = 0; i < chars.length - 1; i++) {
                if (chars[i] == '=') {
                    leftOrRight = 1;
                    firstIndex = i + 1;
                } else if (chars[i] == '-') {
                    if (chars[i + 1] == 'x') {
                        if (leftOrRight == 0) {
                            countX = countX - 1;  // 左边
                        } else {
                            countX = countX + 1;
                        }

                    } else {
                        if (i + 2 < chars.length) {
                            if (chars[i + 2] == 'x') {
                                if (leftOrRight == 0) {
                                    countX = countX - Integer.parseInt(String.valueOf(chars[i + 1]));
                                } else {
                                    countX = countX + Integer.parseInt(String.valueOf(chars[i + 1]));
                                }
                                if (i + 2 == chars.length - 1) {
                                    judge = true;
                                }
                            } else {
                                if (leftOrRight == 0) {
                                    countNum = countNum - Integer.parseInt(String.valueOf(chars[i + 1]));
                                } else {
                                    countNum = countNum + Integer.parseInt(String.valueOf(chars[i + 1]));
                                }
                            }
                        } else {
                            if (leftOrRight == 0) {
                                countNum = countNum - Integer.parseInt(String.valueOf(chars[i + 1]));
                            } else {
                                countNum = countNum + Integer.parseInt(String.valueOf(chars[i + 1]));
                            }
                        }

                    }
                } else if (chars[i] == '+') {
                    if (chars[i + 1] == 'x') {
                        if (leftOrRight == 0) {
                            countX = countX + 1;  // 左边
                        } else {
                            countX = countX - 1;
                        }

                    } else {
                        if (i + 2 < chars.length) {
                            if (chars[i + 2] == 'x') {
                                if (leftOrRight == 0) {
                                    countX = countX + Integer.parseInt(String.valueOf(chars[i + 1]));
                                } else {
                                    countX = countX - Integer.parseInt(String.valueOf(chars[i + 1]));
                                }
                                if (i + 2 == chars.length - 1) {
                                    judge = true;
                                }
                            } else {
                                if (leftOrRight == 0) {
                                    countNum = countNum + Integer.parseInt(String.valueOf(chars[i + 1]));
                                } else {
                                    countNum = countNum - Integer.parseInt(String.valueOf(chars[i + 1]));
                                }
                            }
                        } else {
                            if (leftOrRight == 0) {
                                countNum = countNum + Integer.parseInt(String.valueOf(chars[i + 1]));
                            } else {
                                countNum = countNum - Integer.parseInt(String.valueOf(chars[i + 1]));
                            }
                        }
                    }

                } else if (firstIndex == i) {
                    if (chars[i] == 'x') {
                        if (leftOrRight == 0) {
                            countX = countX + 1;  // 左边
                        } else {
                            countX = countX - 1;
                        }

                    } else {
                        if (i + 1 < chars.length) {
                            if (chars[i + 1] == 'x') {
                                if (leftOrRight == 0) {
                                    countX = countX + Integer.parseInt(String.valueOf(chars[i]));
                                } else {
                                    countX = countX - Integer.parseInt(String.valueOf(chars[i]));
                                }
                                if (i + 2 == chars.length - 1) {
                                    judge = true;
                                }
                            } else {
                                if (leftOrRight == 0) {
                                    countNum = countNum + Integer.parseInt(String.valueOf(chars[i]));
                                } else {
                                    countNum = countNum - Integer.parseInt(String.valueOf(chars[i]));
                                }
                            }
                        } else {
                            if (leftOrRight == 0) {
                                countNum = countNum + Integer.parseInt(String.valueOf(chars[i]));
                            } else {
                                countNum = countNum - Integer.parseInt(String.valueOf(chars[i]));
                            }
                        }
                    }

                }
            }
            int result = 0;
            if (countNum == 0) {
                return "Infinite solutions";
            } else if (countX == 0) {
                return "No solution";
            } else {
                result = -countNum / countX;
                return "x=" + result;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            System.out.print(Solution.solveEquation(in.nextLine()));
        }
    }

}
