public class MyThread2  extends Thread{

    Resources res2;
    Resources res3;

    MyThread2(Resources res2, Resources res3) {
        this.res2 = res2;
        this.res3 = res3;
    }

    public void run() {
        synchronized (res2) {

            System.out.println("Поток 2: Значение res2 x: " + res2.x);

            res2.x++;

            try {
                Thread.sleep(100);
            }
            catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }

            synchronized (res3) {
                System.out.println("Поток 2: Значение res3 x: " + res3.x);

                res3.x++;

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
