package client;

/**
 * Created by futaner on 02/06/16.
 */
public class BullsAndCows {

    public static void getException(){
        try {
            getChildException();
        } catch (RuntimeException e) {
            System.out.println("catched runtime");
        }catch (Exception e){
            System.out.println("catched exception");
        }

    }
    public static void getChildException() throws RuntimeException{
        throw new RuntimeException("skjdnks");
    }
    public static void main(String[] args){
        getException();
    }
}

class bulls extends BullsAndCows {
    public static void getChildException() throws NullPointerException{
        throw new RuntimeException("skjdnks");
    }
    //IN CASE OF UNCHECKED EXCEPTIONS overriden method can throw any exception but
    //in case of checked exceptions like IOEXception overriden method in subclass can only throw sublass of the exception which method in superclass is throwing
}
