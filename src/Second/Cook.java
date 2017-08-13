package Second;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Second
 * @Description:
 * @date 2017/8/12 11:27
 */
public class Cook {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while(sc.hasNext()) {
            String string = sc.nextLine();
            String[] stringsList = string.split(" ");
            set.addAll(Arrays.asList(stringsList));
        }
        System.out.println(set.size());
    }

}
