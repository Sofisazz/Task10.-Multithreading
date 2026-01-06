public class MyThread1  extends Thread{

    Resources res1;
    Resources res2;

    MyThread1(Resources res1, Resources res2) {
        this.res1 = res1;
        this.res2 = res2;
    }

    public void run() {
        synchronized (res1) {

            System.out.println("Поток 1: Значение res1 x: " + res1.x);

            res1.x++;

            try {
                Thread.sleep(100);
            }
            catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }

            synchronized (res2) {
                System.out.println("Поток 1: Значение res2 x: " + res2.x);

                res2.x++;

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
