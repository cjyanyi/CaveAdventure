import java.io.InputStream;
import java.util.Scanner;

public class textScanner {

    static Scanner sc = new Scanner(System.in);
    static int scanInt(int maxint, String text)
    {
        System.out.println(text);
        System.out.print("> ");
        int num = sc.nextInt();

        if(num > maxint || num < 1)
        {
            System.out.println("Give valid number! \n");
            num = scanInt(maxint, text);
        }

        return num;
    }

    static String next() {
        return sc.next();
    }
    static String nextLine() {
        return sc.nextLine();
    }
    static int nextInt() {
        return sc.nextInt();
    }
}
