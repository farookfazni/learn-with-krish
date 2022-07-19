public class SingleObj {

    //Creating an Object of SingleObj class
    private static volatile SingleObj singleObj; 

    public static SingleObj getSingleObj(){

        if(singleObj == null){
            //If it is null we call synchronize to SingleObj class
            synchronized (SingleObj.class){
                if(singleObj == null){
                    singleObj = new SingleObj();
                }
            }
        }
        return singleObj;
    }

}