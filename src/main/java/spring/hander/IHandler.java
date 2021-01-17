package spring.hander;

import java.io.FileNotFoundException;

public interface IHandler {
    String process(String path) throws FileNotFoundException;
}
