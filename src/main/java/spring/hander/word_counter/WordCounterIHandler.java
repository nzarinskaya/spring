package spring.hander.word_counter;

import spring.hander.AbstractIHandler;
import org.springframework.stereotype.Component;
import spring.reader.ReaderText;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component("handler-counter")
public class WordCounterIHandler extends AbstractIHandler {
    ReaderText readerText;

    @Override
    public String process(String fileName) throws FileNotFoundException,NullPointerException {

        FileReader fr = new FileReader(readerText.getFileName());
        Scanner scan = new Scanner(fr);

        String resultCount = null;
        while (scan.hasNextLine()) {
            String readText = scan.nextLine();

            Pattern pattern = Pattern.compile("\\b+");
            String[] strings = pattern.split(readText);
            int i=0;
            for (String s : strings) {
                i++;
            } resultCount  = Integer.toString(i/2);
        }
        return resultCount;
    }
}
