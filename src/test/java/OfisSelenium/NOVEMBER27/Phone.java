package OfisSelenium.NOVEMBER27;

public class Phone {
    private long phoneNumber;

    //initialize instance variables
    public Phone(long phoneNumber){
        this.phoneNumber=phoneNumber;
    }

    public void dial(long phoneNumber){
        System.out.println("Dialing "+phoneNumber);
    }

    public void sendAMessage(String msg, long phoneNumber){
        System.out.println("Sending a message: "+msg);
        System.out.println("To: "+phoneNumber);
    }

    public void ring(){
        System.out.println("Ringing!");
    }
}
