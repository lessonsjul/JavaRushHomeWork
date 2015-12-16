package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter extends FileWriter{

    public FileConsoleWriter(String fileName) throws IOException
    {
        super(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException
    {
        super(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException
    {
        super(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException
    {
        super(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd)
    {
        super(fd);
    }

    @Override
    public String getEncoding()
    {
        return super.getEncoding();
    }

    @Override
    public void write(int c) throws IOException
    {
        super.write(c);
        System.out.println((char)c);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException
    {
        super.write(cbuf, off, len);

        System.out.println(String.valueOf(cbuf,off,len));
    }

    @Override
    public void write(String str, int off, int len) throws IOException
    {
        super.write(str, off, len);
        System.out.println(str.substring(off,off+len));
    }

    @Override
    public void flush() throws IOException
    {
        super.flush();
    }

    @Override
    public void close() throws IOException
    {
        super.close();
    }
}
