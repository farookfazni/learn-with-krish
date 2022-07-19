import java.io.*;

public class Application {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Your Name: ");
        String name = br.readLine();
        System.out.print("\n");

        System.out.print("Enter Your Student ID: ");
        int studentID = Integer.parseInt(br.readLine());
        System.out.print("\n");

        StudentDetails s = new StudentDetails(studentID,name);
        s.printDetais();

        System.out.println("\n");
        StudentDetails s2 = (StudentDetails) s.getClone();
        s2.printDetais();
    }
}