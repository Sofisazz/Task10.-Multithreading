import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args){

        try (ExecutorService executor = Executors.newFixedThreadPool(3)) {

            for (int k = 0; k < 10; k++) {

                Callable<String> task = () -> {

                    String text = "Hello World " + new Date() + "\n";
                    writeInFile(text);

                    System.out.println("Поток: " + Thread.currentThread().getName());
                    return text;
                };

                executor.submit(task);
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static synchronized void writeInFile(String text) {

        String filePath = "File.txt";

        File file = new File(filePath);

        try (FileOutputStream fos = new FileOutputStream(file, true)) {

            byte[] buffer = text.getBytes();
            fos.write(buffer);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}