package Sixth;

/**
 * @author ranbo
 * @version V1.0
 * @Title:
 * @Package Sixth
 * @Description:
 * @date 2018/3/10 上午10:20
 */
public class AddBinarySolution {

    public String addBinary(String a, String b) {
        boolean firstLonger = a.length() > b.length();
        String longerString;
        String shorterString;
        if(firstLonger) {
            longerString = a;
            shorterString = b;
        } else {
            longerString = b;
            shorterString = a;
        }
        int afterValue = 0;
        int thisValue = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < longerString.length(); i++) {
            if(i < shorterString.length()) {
                thisValue = thisValue + Integer.parseInt(String.valueOf(shorterString.charAt(shorterString.length() - i - 1)));
            }
            thisValue = thisValue + Integer.parseInt(String.valueOf(longerString.charAt(longerString.length() - i - 1)));
            afterValue = thisValue / 2;
            thisValue = thisValue % 2;
            sb.append(thisValue);
            thisValue = afterValue;
        }
        if(thisValue > 0) sb.append(thisValue);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinarySolution addBinarySolution = new AddBinarySolution();
        addBinarySolution.addBinary("1010", "1011");
    }
}
