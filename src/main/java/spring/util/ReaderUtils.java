package spring.util;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ReaderUtils {
    public String readString(String message){
        String input = null;
        while(true){
            final Scanner scanner = new Scanner(System.in);
            System.out.println(message);
            input = scanner.nextLine();
            break;
        }
        return input;
    }
}
