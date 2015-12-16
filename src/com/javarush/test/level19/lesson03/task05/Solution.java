package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("Ukraine", "UA");
        countries.put("Russia", "RU");
        countries.put("Canada","CA");
    }
    public static class DataAdapter implements RowItem {
        private Customer cust;
        private Contact cont;
        public DataAdapter(Customer customer, Contact contact) {
         this.cust = customer;
            this.cont = contact;
        }

        @Override
        public String getCountryCode()
        {
            return countries.get(this.cust.getCountryName());
        }

        @Override
        public String getCompany()
        {
            return this.cust.getCompanyName();
        }

        @Override
        public String getContactFirstName()
        {
            String[] pe = this.cont.getName().split(" ");
            return pe[1];
        }

        @Override
        public String getContactLastName()
        {
            String[] pe = this.cont.getName().split(" ");
            return pe[0].substring(0, pe[0].length() - 1);
        }

        @Override
        public String getDialString()
        {


            return "callto://" + this.cont.getPhoneNumber().replaceAll("[()-]","");
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}