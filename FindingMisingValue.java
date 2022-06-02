import java.io.*;
import java.util.Arrays;

// class FindNumber{
//     public int findMisingValue(int a, int b[]){
//         int arr[] = b;
        
//         int i,x,y;
//         Arrays.sort(arr);
//         for(i=0; i<arr.length-1; i++){
//             x = arr[i];
//             y = arr[i+1];
//             if (x+1 != y){
//                 System.out.println(x+1);
//             }
//         }
//         if (x+1 == y){
//                 System.out.println(x+1);
//         }
//     }
// }

class FindingMisingValue{
    public static void main(String args[]){
        // int arr[] = new Arrays[10];
        // count = 10;
        int arr[] = {26,24,25,22,21,27,28,29,30};
        int i,x,y;
        Arrays.sort(arr);
        for(i=0; i<arr.length-1; i++){
            x = arr[i];
            y = arr[i+1];
            if (x+1 != y){
                System.out.println(x+1);
                break;
            }else if((x+1 == y) && (i==arr.length-2)){
                System.out.println(y+1);
            }
        }
    }
}