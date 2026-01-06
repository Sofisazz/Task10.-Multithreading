import java.util.Random;

public class Queue {

    private int count = 0;
    private int size = 0;
    private int[] arr = new int[200];
    boolean finish = false;

    public synchronized void add() {
        while (!finish && size >= 100){
            try {
                wait();
            }
            catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }

        if (finish) return;
        arr[size] = new Random().nextInt(100) + 1;
        System.out.println("Производитель: " + Thread.currentThread().getName() + " добавил в очередь число " + arr[size]);

        size++;

        System.out.println("Элементов: " + size);
        notifyAll();
    }

    public synchronized void get() {
        while (!finish && size == 0){
            try {
                wait();
            }
            catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
        if (finish) return;

        size--;
        System.out.println("Потребитель: " + Thread.currentThread().getName() + " взял число " + arr[size]);

        System.out.println("Элементов: " + size);
        notifyAll();
        count++;

        if (count >= 10_000) {
            finish = true;
        }
    }
}
