public class Main {

    public static void main(String[] args){

        Queue queue = new Queue();

        for (int i = 0; i < 3; i++) {
            new Thread(new Producer(queue),"Producer " + (i + 1)).start();
        }

        for (int i = 0; i < 3; i++) {
            new Thread(new Consumer(queue),"Consumer " + (i + 1)).start();
        }

    }
}