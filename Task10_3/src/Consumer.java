public class Consumer  extends Thread{

    Queue queue;

    Consumer(Queue queue) {
        this.queue = queue;
    }

    public void run(){
        while (!queue.finish) {
            queue.get();
        }
    }
}
