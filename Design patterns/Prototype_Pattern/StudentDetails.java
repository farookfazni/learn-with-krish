public class StudentDetails implements Prototype{
    private int studentnum;
    private String name;

    public StudentDetails(int studentnum, String name){
        this.studentnum = studentnum;
        this.name = name;
    }

    public void printDetais(){
        System.out.println(name + " has student No :" + studentnum);
    }
    @Override
    public Prototype getClone() {
        return new StudentDetails(studentnum,name);
    }
}