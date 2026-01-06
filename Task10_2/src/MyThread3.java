public class MyThread3  extends Thread{

    Resources res1;
    Resources res3;

    MyThread3(Resources res1, Resources res3) {
        this.res1 = res1;
        this.res3 = res3;
    }

    public void run() {
        synchronized (res3) {

            System.out.println("Поток 3: Значение res3 x: " + res3.x);

            res3.x++;

            try {
                Thread.sleep(100);
            }
            catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }

            synchronized (res1) {
                System.out.println("Поток 3: Значение res1 x: " + res1.x);

                res1.x++;

                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

    }

}
