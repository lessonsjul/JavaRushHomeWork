package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("Lion", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            User user = new User();
            user.setFirstName("Halk");
            user.setLastName("ksjdfkv");
            user.setBirthDate(new Date());
            user.setMale(true);
            user.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user);

            System.out.println(user.getCountry());

//            initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            System.out.println(javaRush.users.get(0) == loadedObject.users.get(0));
            System.out.println((javaRush.users.size() == loadedObject.users.size()) + " " + javaRush.users.size());

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        }
         catch (Exception e) {
//                    e.printStackTrace();
             System.out.println("Oops, something wrong with save/load method");
         }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println("Next JavaRush");
            writer.println(users.size());
            for(User user: users){
                writer.println(user.getFirstName());
                writer.println(user.getLastName());
                writer.println(user.getBirthDate().getTime());
                writer.println(user.isMale());
                writer.println(user.getCountry().getDisplayedName());
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            if(reader.readLine().equals("Next JavaRush")){
                int size = Integer.parseInt(reader.readLine());
                if(size != 0)
                {
                    for (int i = 0; i < size; i++)
                    {
                        User user = new User();
                        user.setFirstName(reader.readLine());
                        user.setLastName(reader.readLine());
                        user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                        user.setMale(Boolean.valueOf(reader.readLine()));
                        String c = reader.readLine();
                        User.Country country = (c.equals("Ukraine"))? User.Country.UKRAINE : (c.equals("Russia")) ? User.Country.RUSSIA : User.Country.OTHER;
                        user.setCountry(country);
                        users.add(user);
                    }
                }
            }
        }
    }
}
