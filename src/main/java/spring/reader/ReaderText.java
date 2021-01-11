package spring.reader;

import spring.hander.AbstractIHandler;
import spring.hander.IHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import spring.util.ReaderUtils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

@Component
public class ReaderText {
    private ApplicationContext context;
    private ReaderUtils readerUtils;

    final String fileName = readerUtils.readString("Enter file name: ");


    public void run() throws IOException {
        try {
            FileReader fr = new FileReader(fileName);
            Scanner scan = new Scanner(fr);

            String readText = null;
            while (scan.hasNextLine()) {
                readText = scan.nextLine();
            }

            final IHandler iHandler = choiceHandler();
            final String result = iHandler.process(readText);
            System.out.println("Result after processing " + result);
            fr.close();
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public String getFileName() {
        return fileName;
    }

    private IHandler choiceHandler(){
        IHandler ihandler = null;
        while (ihandler == null) {
            String choice = readerUtils.readString("Choose and enter handler (available handlers: -replace, -counter): ");
            try {
                ihandler = context.getBean("handler"+choice, IHandler.class);
            } catch (BeansException e) {
                System.out.println("Wrong operation type handler, available operations: -replace, -counter");
            }
        }
        return ihandler;
    }

    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }
    @Autowired
    public void setReaderUtils(ReaderUtils readerUtils){
        this.readerUtils = readerUtils;
    }
}
