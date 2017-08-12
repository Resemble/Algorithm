package Second;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Second
 * @Description:
 * 小明同学把1到n这n个数字按照一定的顺序放入了一个队列Q中。现在他对队列Q执行了如下程序：
 * while(!Q.empty())              //队列不空，执行循环
 *
 * {
 *
 * int x=Q.front();            //取出当前队头的值x
 *
 * Q.pop();                 //弹出当前队头
 *
 * Q.push(x);               //把x放入队尾
 *
 * x = Q.front();              //取出这时候队头的值
 *
 * printf("%d\n",x);          //输出x
 *
 * Q.pop();                 //弹出这时候的队头
 *
 * }
 *
 * 做取出队头的值操作的时候，并不弹出当前队头。
 * 小明同学发现，这段程序恰好按顺序输出了1,2,3,...,n。现在小明想让你构造出原始的队列，你能做到吗？
 * @date 2017/8/12 9:56
 */
public class GetQueue {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();

            Deque<Integer> deque = new ArrayDeque<>();
            deque.push(n);
            for (int i = n - 1; i > 0; i--) {
                deque.push(i);
                int x = deque.getLast();
                deque.removeLast();
                deque.push(x);
            }
            while (deque.size() > 1) {
                System.out.print(deque.pop() + " ");
            }
            System.out.print(deque.pop());
            System.out.println();
            T--;
        }

    }

}
