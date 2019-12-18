package OfisSelenium.NOVEMBER27;

public interface Camera {
   //break till 12:20
    public final static int MIN_FPS = 0;

    void recordAVideo();

    static void takeAPicture() {
        System.out.println("Taking a snapshot!");
    }

    default void switchToSelfieCamera(){

    }
}
