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

        int n = ll.size();
        System.out.println(n);
        for(int j=0; j<n-1; j++){
            for(int i=0; i<n-j-1; i++){
                int x = ll.get(i);
                int y = ll.get(i+1);
                ll.set(i,y);
                ll.set(i+1,x);
            }
        }
        System.out.println(ll);

    }
}