import java.util.*;

public class ReverseLinkedList{
    public static void main(String args[]){

        LinkedList<Integer> ll = new LinkedList<Integer>(); // creating linked list ll object

        // adding values to linked list
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        System.out.println(ll);

        int n = ll.size();  // geting length of linked list

        System.out.println(n);

        for(int j=0; j<n-1; j++){
            for(int i=0; i<n-j-1; i++){
                int x = ll.get(i); // geting the i th value and storing it in x
                int y = ll.get(i+1);  // geting the i+1 th value and storing it in y
                ll.set(i,y); // replacing the i th and i+1 value(Swapping values)
                ll.set(i+1,x);
            }
        }
        System.out.println(ll);

    }
}