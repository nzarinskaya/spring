package spring.hander.replace_letters;

import spring.hander.AbstractIHandler;
import org.springframework.stereotype.Component;
import spring.reader.ReaderText;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component("handler-replace")
public class ReplaceLettersIHandler extends AbstractIHandler {
    ReaderText readerText;

    @Override
    public String process(String path) throws FileNotFoundException, NullPointerException {
        FileReader fr = new FileReader(readerText.getFileName());
        Scanner scan = new Scanner(fr);

        String resultReplace = null;
        while (scan.hasNextLine()) {
            String readText = scan.nextLine();
            Pattern pattern = Pattern.compile("a+");
            Matcher matcher = pattern.matcher(readText);
            resultReplace = matcher.replaceAll("A");
        }
        return resultReplace;
    }
}
