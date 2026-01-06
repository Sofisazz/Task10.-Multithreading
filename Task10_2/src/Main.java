public class Main {

    public static void main(String[] args){

        Resources resource1 = new Resources();
        Resources resource2 = new Resources();
        Resources resource3 = new Resources();


        MyThread1 thread1 = new MyThread1(resource1, resource2);
        MyThread2 thread2 = new MyThread2(resource2, resource3);
        MyThread3 thread3 = new MyThread3(resource1, resource3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}