public class SingeltonPattern {
    public static void main(String[] args){

        SingleObj singleObj = SingleObj.getSingleObj();
        System.out.println(singleObj);

        //Second Instance
        SingleObj singleObj2 = SingleObj.getSingleObj();
        System.out.println(singleObj2);
    }
}