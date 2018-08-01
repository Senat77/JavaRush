package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush.
Метод main реализован только для вас и не участвует в тестировании.


Требования:
1. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список users пустой.
2. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список users не
    пустой.
3. Класс Solution.JavaRush не должен поддерживать интерфейс Serializable.
4. Класс Solution.JavaRush должен быть публичным.
5. Класс Solution.JavaRush не должен поддерживать интерфейс Externalizable.
*/
public class Solution
{
    public static void main(String[] args)
    {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try
        {
            //File your_file_name = File.createTempFile("your_file_name", null);
            File your_file_name = new File("d:/i.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.users = new ArrayList<>();
            for (int i = 0; i < 3; i++)
            {
                User user = new User();
                user.setFirstName("FirstName" + i);
                user.setLastName("LastName" + i);
                user.setBirthDate(new Date());
                user.setMale(i%2 == 0);
                user.setCountry(User.Country.UKRAINE);
                javaRush.users.add(user);
            }

            javaRush.save(outputStream);
            outputStream.flush();
            System.out.println("Запись готова !");

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if(javaRush.equals(loadedObject))
            {
                System.out.println("Равны!");
            }
            else
            {
                /*
                System.out.println("Count = " + loadedObject.users.size());
                for (int i = 0; i < loadedObject.users.size(); i++)
                {
                    User u = loadedObject.users.get(i);
                    System.out.println(u.getFirstName());
                    System.out.println(u.getLastName());
                    System.out.println(u.getBirthDate() + "][" + javaRush.users.get(i).getBirthDate());
                    System.out.println(u.isMale());
                    System.out.println(u.getCountry());
                }
                */
            }

            outputStream.close();
            inputStream.close();

        }
        catch (IOException e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        }
        catch (Exception e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush
    {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            String s = users == null ? "NoUsers" : "Users";
            outputStream.write(s.getBytes());
            outputStream.write('\n');
            // Размер списка
            if(users != null)
            {
                outputStream.write(String.valueOf(users.size()).getBytes());
                outputStream.write('\n');
                for (int i = 0; i < users.size(); i++)
                {
                    outputStream.write(users.get(i).getFirstName().getBytes());
                    outputStream.write('\n');
                    outputStream.write(users.get(i).getLastName().getBytes());
                    outputStream.write('\n');
                    //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss:SSS",Locale.ENGLISH);
                    //outputStream.write(sdf.format(users.get(i).getBirthDate()).getBytes());
                    outputStream.write(String.valueOf(users.get(i).getBirthDate().getTime()).getBytes());
                    outputStream.write('\n');
                    outputStream.write(String.valueOf(users.get(i).isMale()).getBytes());
                    outputStream.write('\n');
                    outputStream.write(users.get(i).getCountry().toString().getBytes());
                    outputStream.write('\n');
                }
            }
        }

        public void load(InputStream inputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            users = new ArrayList<>();
            if("Users".equals(br.readLine()))
            {
                int count = Integer.parseInt(br.readLine());
                for (int i = 0; i < count; i++)
                {
                    User u = new User();
                    u.setFirstName(br.readLine());
                    u.setLastName(br.readLine());
                    //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss:SSS",Locale.ENGLISH);
                    //u.setBirthDate(sdf.parse(br.readLine()));
                    u.setBirthDate(new Date(Long.parseLong(br.readLine())));
                    u.setMale(Boolean.valueOf(br.readLine()));
                    u.setCountry(User.Country.valueOf(br.readLine()));
                    users.add(u);
                }
            }
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
