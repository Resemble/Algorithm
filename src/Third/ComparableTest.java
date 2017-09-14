package Third;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Third
 * @Description:
 * @date 2017/9/14 22:50
 */

class Student implements Comparable<Student> {

    public int id;
    public String name;

    public Student(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {

        int temp = this.id - o.id;
        if (temp != 0) return temp;
        return o.name.compareTo(this.name);
    }
}

public class ComparableTest {
    public static void main(String[] args) {

        Student s1 = new Student(1,"小");
        Student s2 = new Student(2,"大");
        Student s3 = new Student(2,"小");
        Student s4 = new Student(2,"大");
        Student s5 = new Student(-2,"大");
        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        System.out.println("Comparable：");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).id +list.get(i).name);
        }
        //由于Student类实现了Comparable接口，所以集合list可以直接排序
        Collections.sort(list);
        System.out.println("=============交换后=============");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).id +list.get(i).name);
        }

    }

}
