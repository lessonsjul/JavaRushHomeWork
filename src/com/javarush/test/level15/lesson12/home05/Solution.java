package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    public Solution(){}
    public Solution(String name){
    }
    public Solution(String name, int age){
    }
    protected Solution(int age){
    }
    protected Solution(double salary){
    }
    protected Solution(String name, double salary){
    }
    private Solution(int age, double salary){
    }
    private Solution(String name, int age, double salary){
    }
    private Solution(Boolean doIt){
    }
    Solution(Boolean doIt, String name){}
    Solution(Boolean doIt, String name, int age){}
    Solution(Boolean doIt, String name, int age, double salary){}

}

