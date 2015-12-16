package com.javarush.test;

import com.javarush.test.level20.lesson10.home02.Solution;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class Tests extends Assert{

//    @Ignore
//    @Test
//    public void testOne() throws Exception
//    {
//        Solution.C c = new Solution().new C("Gorila");
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        ObjectOutputStream oos = new ObjectOutputStream(baos);
//        oos.writeObject(c);
//
//        oos.flush();
//        baos.flush();
//        oos.close();
//        baos.close();
//
//        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
//        ObjectInputStream ois = new ObjectInputStream(bais);
//        Solution.C c1 = new Solution().new C("Godzila");
//
//        System.out.println(c.toString());
//        System.out.println(c1.toString());
//
//        c1 = (Solution.C) ois.readObject();
//
//        System.out.println(c1.toString());
//        System.out.println(c.toString());
//
//    }

    @Test
    public void testTwo() throws IOException, ClassNotFoundException
    {

        Solution.A a = new Solution().new A();
        Solution.B b = new Solution().new B();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(a);

        oos.flush();
        baos.flush();
        oos.close();
        baos.close();

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Solution.A a1 = new Solution().new A();
        a1 = new Solution().getOriginalObject(ois);

        System.out.println(a1 instanceof Solution.B);
    }
}