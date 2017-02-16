package reynoldstitko.gillian;

import java.util.Scanner;

/**
 * Created by gillianreynolds-titko on 2/15/17.
 */
public class Display {

    private Scanner scanner = new Scanner(System.in);

    public String askUserForTime(String question){
        System.out.print(question);
        String stringValue = scanner.next();
        return stringValue;
    }
}
