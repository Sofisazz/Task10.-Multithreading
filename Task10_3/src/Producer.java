public class Producer extends Thread{

    Queue queue;

    Producer(Queue queue) {
        this.queue = queue;
    }

    public void run(){
        while (!queue.finish) {
            queue.add();
        }
    }
}
