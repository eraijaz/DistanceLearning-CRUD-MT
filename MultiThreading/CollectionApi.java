import java.util.*;
class  CollectionApi{
    public static void main(String[] args) {
        System.out.println("hello this program is about arrayList()");
        ArrayList al= new ArrayList();
        al.add("b");
        al.add(5);
        al.add(20.8);

        System.out.println(al);
        ArrayList al1 = new ArrayList();
        al1.add(11);
        al1.add(100);
        al1.add(121);
        System.out.println(al1);
        al1.add(al);
        System.out.println(al1);
        System.out.println(al1.contains(11));
         System.out.println(al1.get(2)); //get() is used to retreive the value on the basis of index number
        boolean b=al1.isEmpty();
        System.out.println(b);
        int size=al1.size();
        System.out.println(size);
        al1.clear();
        System.out.println(al1); 
    

    }
}