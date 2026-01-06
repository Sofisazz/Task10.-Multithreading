public class Main {

    public static void main(String[] args){

        for (int i = 0; i < 10; i++) {
            new Thread(new MyThread(),"Thread " + (i + 1)).start();
        }
    }
}