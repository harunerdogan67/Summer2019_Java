package OfisSelenium.NOVEMBER27;

public class Iphone extends Smartphone implements IOS{
    public Iphone(long phoneNumber) {
        super(phoneNumber);
    }

    @Override
    public void sendFileOverAirDrop(String fileName) {
        System.out.println("Sending file:"+fileName);
    }
}
