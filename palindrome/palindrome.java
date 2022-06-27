import java.util.*;

public class palindrome{

    public static boolean isEqual(LinkedList LL1,LinkedList LL2,int n){
        boolean a = true;
        for(int i=0; i<n; i++){
            if(LL1.get(i) != LL2.get(i)){ // if the elements in same index are not equal 
                a = false; // it returns false
                break;
            }
        }
        return a; 
    }


    public static void main(String args[]){
        LinkedList<String> ll = new LinkedList<String>();
        LinkedList<String> ll2 = new LinkedList<String>();

        ll.add("R");
        ll.add("A");
        ll.add("C");
        ll.add("E");
        ll.add("C");
        ll.add("A");
        ll.add("R");

        System.out.println("Linked List : "+ll);

        ll2 = (LinkedList) ll.clone(); // cloning the linked list

        int n = ll2.size();  // geting length of linked list

        // Reversing the cloned LinkedList
        for(int j=0; j<n-1; j++){
            for(int i=0; i<n-j-1; i++){
                String x = ll2.get(i); 
                String y = ll2.get(i+1); 
                ll2.set(i,y);
                ll2.set(i+1,x);
            }
        }
        System.out.println("Reversed Linked List : "+ll2);

        if(isEqual(ll,ll2,n)==true){ // checking whether Linked List and Reverserd Linked are equal or not
            System.out.println("Palindrome");
        }else{
            System.out.println("Not Palindrome");
        }
    }
}