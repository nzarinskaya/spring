package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.configure.MyConfig;
import spring.reader.ReaderText;

import java.io.IOException;

public class AppMain {
    public static void main(String[] args) throws IOException {
        final AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        final ReaderText readerText = context.getBean("readerText",ReaderText.class);
        readerText.run();
    }
}
