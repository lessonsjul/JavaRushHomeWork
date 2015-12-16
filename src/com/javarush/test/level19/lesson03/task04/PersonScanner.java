package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.text.ParseException;

public interface PersonScanner {
    Person read() throws IOException, ParseException;

    void close() throws IOException;
}
