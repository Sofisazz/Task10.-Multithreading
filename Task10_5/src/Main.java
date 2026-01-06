import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args){

        try (ExecutorService executor = Executors.newFixedThreadPool(3)) {

            for (int k = 0; k < 10; k++) {

                Callable<String> task = () -> {

                    var randNumbers = new ArrayList<Integer>();

                    int sum = 0;
                    for (int i = 0; i < 10; i++) {

                        int num = new Random().nextInt(100);
                        randNumbers.add(num);
                        sum += num;
                    }

                    Thread.sleep(new Random().nextInt(9001) + 1000);
                    System.out.println("Поток: " + Thread.currentThread().getName());

                    return Integer.toString(sum);
                };

                executor.submit(task);
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}