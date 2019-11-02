package tenth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package tenth
 * @Description: 1233. 删除子文件夹
 * @date 2019-11-02 18:34
 */
public class RemoveSubfoldersSolution {

    public List<String> removeSubfolders(String[] folder) {
        if (folder == null || folder.length == 1) {
            return new ArrayList<>();
        }
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        String tempStr = folder[0];
        result.add(tempStr);
        for (int i = 1; i < folder.length; i++) {
            if (!folder[i].startsWith(tempStr) || (folder[i].length() > tempStr.length() && folder[i].charAt(tempStr.length()) != '/')) {
                tempStr = folder[i];
                result.add(tempStr);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] folder = {"/a/b/c","/a/b/ca","/a/b/d"};
//        Arrays.sort(folder);
//        for (int i = 0; i < folder.length; i++) {
//            System.out.println(folder[i]);
//        }

        RemoveSubfoldersSolution solution = new RemoveSubfoldersSolution();
        List<String> result = solution.removeSubfolders(folder);
        result.forEach(System.out::println);
    }

}
