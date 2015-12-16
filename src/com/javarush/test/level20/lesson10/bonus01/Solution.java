package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.List;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static void main(String[] args)
    {
        int i = 153;
        System.out.println(i%10);
        i = i /10;
        System.out.println(i%10);
        i = i/10;
        System.out.println(i%10);
        System.out.println((int)Math.log10(20)+1);

    }
    public static int[] getNumbers(int N) {
        int [][] stepen = new int [10][10];

        for(int i = 1; i < stepen.length; i++){
            for(int j = 1; j < stepen[i].length; j++){
                stepen[i][j] = (int)Math.pow((double)i,(double)j);
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int n = 1; n < N; n++){
            int sum = 0, tmp, r;
            tmp = n;

            int length = (int)Math.log10(n)+1;
            while(tmp != 0){
                for(int i = 0; i < length; i++){
                    int prod;
                    r = tmp%10;

                    prod = stepen[r][length];

                    sum = sum + prod;
                    tmp = tmp/10;
                }
            }
            if(n == sum) res.add(n);
        }

        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            result[i] = res.get(i);
        }

        return result;
    }
}
