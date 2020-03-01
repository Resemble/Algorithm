package tenth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description:
 * @date 2019-12-29 20:18
 */
public class Test {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("iigy34234");
        list.add(34234);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            System.out.println(list.get(i).getClass());
        }


    }

}
