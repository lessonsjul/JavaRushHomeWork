package com.javarush.test.level20.lesson10.bonus04;


import java.io.*;
import java.util.*;

/* Свой список
Посмотреть, как реализован LinkedList.
Элементы следуют так: 1->2->3->4  и так 4->3->2->1
По образу и подобию создать Solution.
Элементы должны следовать так:
1->3->7->15
    ->8...
 ->4->9
    ->10
2->5->11
    ->12
 ->6->13
    ->14
Удалили 2 и 9
1->3->7->15
    ->8
 ->4->10
Добавили 16,17,18,19,20 (всегда добавляются на самый последний уровень к тем элементам, которые есть)
1->3->7->15
       ->16
    ->8->17
       ->18
 ->4->10->19
        ->20
Удалили 18 и 20
1->3->7->15
       ->16
    ->8->17
 ->4->10->19
Добавили 21 и 22 (всегда добавляются на самый последний уровень к тем элементам, которые есть.
Последний уровень состоит из 15, 16, 17, 19. 19 последний добавленный элемент, 10 - его родитель.
На данный момент 10 не содержит оба дочерних элемента, поэтому 21 добавился к 10. 22 добавляется в следующий уровень.)
1->3->7->15->22
       ->16
    ->8->17
 ->4->10->19
        ->21

Во внутренней реализации элементы должны добавляться по 2 на каждый уровень
Метод getParent должен возвращать элемент, который на него ссылается.
Например, 3 ссылается на 7 и на 8, т.е.  getParent("8")=="3", а getParent("13")=="6"
Строки могут быть любыми.
При удалении элемента должна удаляться вся ветка. Например, list.remove("5") должен удалить "5", "11", "12"
Итерироваться элементы должны в порядке добавления
Доступ по индексу запрещен, воспользуйтесь при необходимости UnsupportedOperationException
Должно быть наследование AbstractList<E>, List<E>, Cloneable, Serializable
Метод main в тестировании не участвует
*/
public class Solution extends AbstractList<String>
        implements List<String>, Cloneable, Serializable{

    public static void main(String[] args) throws IOException, ClassNotFoundException, CloneNotSupportedException
    {
        List<String> listTree = new Solution();
        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());

        for (int i = 1; i < 16; i++) {
            listTree.add(String.valueOf(i));
        }
        System.out.println(listTree);

        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());
        List<String> list2222 = new Solution();
        System.out.println("Check isEmpty: " + list2222.isEmpty() + " Size: " + list2222.size());
        list2222.add("test");
        System.out.println("Check isEmpty: " + list2222.isEmpty() + " Size: " + list2222.size());
        List<String> list1111 = new Solution();
        System.out.println("Check isEmpty: " + list1111.isEmpty() + " Size: " + list1111.size());

        System.out.println("\nExpected 3, actual is " + ((Solution) listTree).getParent("8"));
        listTree.remove("5");
        System.out.println("Expected null, actual is " + ((Solution) listTree).getParent("11"));
        listTree.clear();
        for (int i = 1; i < 16; i++) {
            listTree.add(String.valueOf(i));
        }

        //For additional check correct work clone method
        Solution list = ((Solution) listTree).clone();

        System.out.println("Start value with using clone: " + listTree);
        System.out.println("\n===== REMOVE Remove 2 and 9 =====");
        list.remove("2");
        list.remove("9");
        for (String s : list) System.out.print(s+ " ");
        System.out.println("\n===== ADD 16, 17, 18, 19, 20 =====");
        list.add("16");
        list.add("17");
        list.add("18");
        list.add("19");
        list.add("20");
        for (String s : list) System.out.print(s+ " ");
        System.out.println("\n===== REMOVE 18 and 20 =====");
        list.remove("18");
        list.remove("20");
        for (String s : list) System.out.print(s+ " ");
        System.out.println("\n===== ADD 21 and 22 =====");
        list.add("21");
        list.add("22");
        list.add("23");
        list.add("24");
        list.add("25");
        list.add("26");
        list.add("27");
        list.add("28");
        list.add("29");
        list.add("30");
        list.add("31");
        list.add("32");
        //list.add(null);
        for (String s : list) System.out.print(s+ " ");
        System.out.println("\n---------------------------------------");
        System.out.println("3 Expected 1, actual is " + ((Solution) list).getParent("3"));
        System.out.println("4 Expected 1, actual is " + ((Solution) list).getParent("4"));
        System.out.println("8 Expected 3, actual is " + ((Solution) list).getParent("8"));
        System.out.println("11 Expected null, actual is " + ((Solution) list).getParent(null));
        System.out.println("15 Expected 7, actual is " + ((Solution) list).getParent("15"));
        System.out.println("16 Expected 7, actual is " + ((Solution) list).getParent("16"));
        System.out.println("10 Expected 4, actual is " + ((Solution) list).getParent("10"));
        System.out.println("17 Expected 8, actual is " + ((Solution) list).getParent("17"));
        System.out.println("19 Expected 10, actual is " + ((Solution) list).getParent("19"));
        System.out.println("21 Expected 10, actual is " + ((Solution) list).getParent("21"));
        System.out.println("22 Expected 15, actual is " + ((Solution) list).getParent("22"));
        System.out.println("--->> By task and add more item:");
        System.out.println("23 Expected 15, actual is " + ((Solution) list).getParent("23"));
        System.out.println("24 Expected 16, actual is " + ((Solution) list).getParent("24"));
        System.out.println("25 Expected 16, actual is " + ((Solution) list).getParent("25"));
        System.out.println("26 Expected 17, actual is " + ((Solution) list).getParent("26"));
        System.out.println("27 Expected 17, actual is " + ((Solution) list).getParent("27"));
        System.out.println("28 Expected 19, actual is " + ((Solution) list).getParent("28"));
        System.out.println("29 Expected 19, actual is " + ((Solution) list).getParent("29"));
        System.out.println("30 Expected 21, actual is " + ((Solution) list).getParent("30"));
        System.out.println("31 Expected 21, actual is " + ((Solution) list).getParent("31"));
        System.out.println("32 Expected 22, actual is " + ((Solution) list).getParent("32"));
        System.out.println("---------------------------------------");
        System.out.println("Size array = " + list.size() + " expected = 22");
        System.out.println();

        System.out.println("=============== Clone test ==================");

        System.out.println("Object: " + list + " --> Size = " + list.size());
        Solution sol = list.clone();
        //list.remove("7"); //Select for test
        System.out.println("Clone object: " + sol + " --> Size = " + sol.size());
        System.out.println("Result: " + list.containsAll(sol));

        System.out.println("\nTest addAll: ");
        Solution add = new Solution();
        add.addAll(sol);
        System.out.println(add + " --> Size: " + add.size() + " = " + sol.size());

        System.out.println("=============== Iterator test ===============");
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            String a = itr.next();
            System.out.print(a + " ");
        }
        System.out.println("\nExpected size 22 = " + list.size());

        System.out.println("\nIter remove");
        Iterator<String> itr2 = list.iterator();
        while (itr2.hasNext()) {
            if (itr2.next().contains("31")) {
                itr2.remove();
            }
        }
        System.out.println("For test " + list + " --> Size = " + list.size());
        System.out.println("Collect size " + list.size() + " Expected 21");

        System.out.println("\n===== SERIALIZATION and DESERIALIZATION =====");
        System.out.println("Collect before serializable " + list);
        System.out.print("Save list");
        FileOutputStream fos = new FileOutputStream("file");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.close();
        fos.close();
        System.out.println(" Serializable done");
        System.out.print("Load list");
        FileInputStream fis = new FileInputStream("file");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<String> list2 = (List<String>) ois.readObject();
        ois.close();
        fis.close();
        System.out.println(" Deserializable done");
        System.out.println("Collect after deserializable " + list2);

        System.out.println("\n================ Clear test =================");
        System.out.println("Before: " + listTree);
        listTree.clear();
        System.out.println("After clear: " + listTree + (listTree.isEmpty() ? " OK" : " Badly"));

    }

    int size;
    Node<String> first;
    Node<String> last;
    Node<String> parent;

    public Solution(){
    }

    private void linkLast(String e)
    {
        checkParentPlaces();
        final Node<String> p = parent;
        final Node<String> l = last;
        final Node<String> newNode = new Node<>(p, e, l, null);
        last = newNode;
        if(l == null)
            first = newNode;
        else
            l.next = newNode;

        if(p == null){
            parent = l;
        }else {
            parent.setChild(newNode);
        }
        size++;
        modCount++;
    }

    private void checkParentPlaces(){
        final Node<String> par = parent;
        if(par != null && !par.hasEmptyPlace())
            parent = par.next;
    }

    private void unlink(Node<String> x)
    {
        final String element = x.value;
        final Node<String> par = x.parent;
        final  Node<String> left = x.left;
        final  Node<String> right = x.right;

        if(parent != null){
            if(element != null && parent.value != null && element.equals(parent.value))
                parent = x.next;
            else if (element == null && parent.value == null)
                parent = x.next;
        }
        if(par != null) par.removeChild(x);
        if(left != null) {
            unlink(left);
            x.left = null;
        }

        if(right != null){
            unlink(right);
            x.right = null;
        }

        final Node<String> prev = x.prev;
        final  Node<String> next = x.next;
        if(prev == null){
            first = next;
        }else{
            prev.next = next;
            x.prev = null;
        }
        if(next == null){
            last = prev;
            parent = prev != null ? prev.parent : null;
        }else{
            next.prev = prev;
            x.next = null;
        }
        checkParentPlaces();
        x.value = null;
        x.parent = null;
        size--;
        modCount++;
    }

    private Node<String> getElement(Object o){
        if(o == null){
            for(Node<String> x = first; x != null; x = x.next){
                if(x.value == null){
                    return x;
                }
            }
        }else{
            for(Node<String> x = first; x != null; x = x.next){
                if(o.equals(x.value)){
                    return x;
                }
            }
        }
        return null;
    }

    public String getParent(String value) {
        //have to be implemented
        Node<String> item = getElement(value);
        return item != null && item.parent != null ? item.parent.value : null;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean add(String e){
        linkLast(e);
        return true;
    }

    @Override
    public boolean remove(Object o){
        Node<String> item = getElement(o);
        if(item != null){
            unlink(item);
            return true;
        }
        return false;
    }

    @Override
    public void clear()
    {
        for (Node<String> x = first; x != null; ) {
            Node<String> next = x.next;
            x.parent = null;
            x.value = null;
            x.next = null;
            x.prev = null;
            x.left = null;
            x.right = null;
            x = next;
        }
        parent = first = last = null;
        size = 0;
        modCount++;
    }

    @Override
    public String get(int index)
    {
        throw null;
    }


    @Override
    public Iterator<String> iterator() {
        return new SolutionIter();
    }

    private class SolutionIter implements Iterator<String>{
        Node<String> next = first;
        Node<String> current = null;
        int expectedModCount = modCount;
        int nextIndex = 0;

        @Override
        public boolean hasNext(){
            return next != null && size > 0;
        }

        @Override
        public String next(){
            checkForComodification();
            if(!hasNext())
                throw new NoSuchElementException();

            current = next;
            next = next.next;
            nextIndex++;
            return current.value;
        }

        @Override
        public void remove(){
            Node<String> p = current;
            checkForComodification();
            if (p == null)
                throw new IllegalStateException();
            unlink(p);
            current = null;
            nextIndex--;
            expectedModCount = modCount;
        }

        void checkForComodification() {
            if (modCount != expectedModCount)
            {
                throw new ConcurrentModificationException();
            }
        }
    }

    private static class Node<E> implements java.io.Serializable {
        private static final long serialVersionUID = 1L;
        Node<E> parent;
        E value;
        Node<E> prev;
        Node<E> next;
        Node<E> left;
        Node<E> right;
        boolean emptyPlace;

        public Node(Node<E> parent, E value, Node<E> prev, Node<E> next)
        {
            this.parent = parent;
            this.value = value;
            this.prev = prev;
            this.next = next;
            emptyPlace = true;
        }

        public boolean hasEmptyPlace() {
            if(left != null && right != null) emptyPlace = false;
            return emptyPlace;
        }

        public void setChild(Node<E> child) {
            if(left == null)  left = child;
            else right = child;
        }

        public boolean removeChild(Node<E> child)
        {
            if(left != null && left == child){
                left = null;
                emptyPlace = true;
                if(right != null)
                {
                    final Node<E> r = right;
                    left = r;
                    right = null;
                }
                return true;
            }
            if(right != null && right == child){
                right = null;
                emptyPlace = true;
                return true;
            }
            return false;
        }
    }

    private static final long serialVersionUID = 7142557871662602445L;

    @Override
    public Solution clone() throws CloneNotSupportedException
    {
        return (Solution) super.clone();
    }
}
