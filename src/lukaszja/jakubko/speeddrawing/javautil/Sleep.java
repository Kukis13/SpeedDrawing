package lukaszja.jakubko.speeddrawing.javautil;

public class Sleep {

    public static void sleep(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
