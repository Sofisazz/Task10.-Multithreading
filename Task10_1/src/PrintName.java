public class PrintName {

    static synchronized void printThreadName() {

        System.out.println(Thread.currentThread().getName());

        try {

            Thread.sleep(2000);
        } catch (InterruptedException ex) {

            System.out.println(ex.getMessage());
        }
    }
}

