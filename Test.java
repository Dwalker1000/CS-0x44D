import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.print(longestPalindrome(s));
    }

    public static int longestPalindrome(String s) {
        int[] letters = new int[52];

        for (int i = 0; i < s.length(); i++) {
            int character = s.charAt(i);
            if (character >= 'A' && character <= 'Z') {
                letters[character - 'A']++;
            } else if (character >= 'a' && character <= 'z') {
                letters[character - 'a' + 26]++;
            }
        }

        int length = 0;
        for (int letter : letters) {
            length += ((letter/2) * 2);
            if (letter % 2 == 1 && length % 2 == 0) {
                length ++;
            }
        }

        return length;
    }
}
