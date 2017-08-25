package Third;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ranran
 * @version V1.0
 * @Title:
 * @Package Third
 * @Description: 2017年阿里巴巴 java 编程题 AC 40% 没找到方法
 * @date 2017/8/25 19:52
 */
public class FirstAlibaba {
    public static final int CUSTOMS_LIMIT_MONEY_PER_BOX = 2000;

    static class BoxTemplate {
        public int price;
        public int length;
        public int width;
        public int height;

    }

    static class Model {
        public int price;
        public int length;
        public int width;
        public int height;
    }

    private static int process(BoxTemplate boxTemplate, Model[] items) {
        int count = 0;
        int totalPrice = 0;
        int totalVoculum = 0;
        ArrayList<BoxTemplate> arrayList = new ArrayList<>();
        BoxTemplate template = new BoxTemplate();
        template = getBoxTemplate(template, boxTemplate);
        arrayList.add(template);
        for (int i = 0; i < items.length; i++) {

            if (judgeSuitable(boxTemplate, items[i])) {
            } else {
                return -1;
            }
            totalPrice += items[i].price;
            totalVoculum = totalVoculum + items[i].width * items.length * items.length;
        }
        count = Math.max(totalPrice / 2000, totalVoculum / (boxTemplate.width * boxTemplate.height * boxTemplate.length));

        for (int i = 0; i < items.length; i++) {
            int j = 0;
            boolean control = true;
            while (j < arrayList.size()) {
                if (getSub(arrayList.get(j), items[i])) {
                    control = false;
                    break;
                }
                j++;
            }
            if (control) {
                BoxTemplate template2 = new BoxTemplate();
                template2 = getBoxTemplate(template2, boxTemplate);
                getSub(template2, items[i]);
                arrayList.add(template2);
            }

        }
        return Math.max(count, arrayList.size());
    }

    public static BoxTemplate getBoxTemplate(BoxTemplate template, BoxTemplate boxTemplate) {
        template.price = boxTemplate.price;
        template.length = boxTemplate.length;
        template.width = boxTemplate.width;
        template.height = boxTemplate.height;
        return template;
    }

    public static boolean judgeSuitable(BoxTemplate boxTemplate, Model item) {
        if (boxTemplate.price >= item.price &&
                boxTemplate.length >= item.length &&
                boxTemplate.height >= item.height &&
                boxTemplate.width >= item.width) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean getSub(BoxTemplate boxTemplate, Model item) {
        if (boxTemplate.price >= item.price) {
            if (boxTemplate.length * boxTemplate.width *boxTemplate.height >= item.height* item.width* item.height) {
                boxTemplate.length -= item.length;
                boxTemplate.width -= item.width;
                boxTemplate.height -= item.height;
                boxTemplate.price -= item.price;
                return true;
            }
            if (boxTemplate.length - item.length >= 0) {
                boxTemplate.length -= item.length;
                boxTemplate.price -= item.price;
                return true;
            } else if (boxTemplate.width - item.width >= 0) {
                boxTemplate.width -= item.width;
                boxTemplate.price -= item.price;
                return true;
            } else if (boxTemplate.height - item.height >= 0) {
                boxTemplate.height -= item.height;
                boxTemplate.price -= item.price;
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        BoxTemplate boxTemplate = new BoxTemplate();
        boxTemplate.price = CUSTOMS_LIMIT_MONEY_PER_BOX;

        while (scanner.hasNext()) {
            boxTemplate.length = scanner.nextInt();
            boxTemplate.width = scanner.nextInt();
            boxTemplate.height = scanner.nextInt();
            Model[] items;
            int itemNum = scanner.nextInt();
            items = new Model[itemNum];
            for (int i = 0; i < itemNum; i++) {
                Model item = new Model();
                item.price = scanner.nextInt();
                item.length = scanner.nextInt();
                item.width = scanner.nextInt();
                item.height = scanner.nextInt();
                items[i] = item;
            }
            long startTime = System.currentTimeMillis();
            int boxMinNum = Integer.MAX_VALUE;
            System.out.println(process(boxTemplate, items));

        }
    }
}
