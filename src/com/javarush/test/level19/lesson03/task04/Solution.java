package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner{

        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner)
        {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException, ParseException
        {
            String line = null;
            if(this.scanner.hasNextLine())
            {
                line = this.scanner.nextLine();
            }
            String[] splited = line.split(" ");
            String firstName = splited[1];
            String middleName = splited[2];
            String lastName = splited[0];
            String dateLit = splited[3] +" "+ splited[4] + " " + splited[5];
            Date birthDate = new SimpleDateFormat("dd MM yyyy").parse(dateLit);

            return new Person(firstName,middleName,lastName,birthDate);
        }

        @Override
        public void close() throws IOException
        {
            this.scanner.close();
        }
    }
}
