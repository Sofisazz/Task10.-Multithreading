import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args){

        String[] strings = new String[]{"Привет\n", "Друг\n", "Мама, пойдём гулять!\n","Идем есть\n"};

        try (ExecutorService executor = Executors.newFixedThreadPool(3)) {


            for (int k = 1; k <= 10; k++) {

                final int number = k;

                Callable<ArrayList<String>> task = () -> {

                    var fileNames = new ArrayList<String>();

                    for (int i = 1; i <= 10; i++) {

                        String filePath = "Files\\Task_" + number + " File_" + i + ".txt";

                        File file = new File(filePath);

                        try (FileOutputStream fos = new FileOutputStream(file)) {

                            for (int j = 0; j < 10; j++) {
                                int n = new Random().nextInt(strings.length);
                                byte[] buffer = strings[n].getBytes();

                                fos.write(buffer);
                            }
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }

                        fileNames.add(file.getName());
                    }

                    Thread.sleep(new Random().nextInt(2001) + 1000);
                    System.out.println("Поток: " + Thread.currentThread().getName());

                    return fileNames;
                };

                executor.submit(task);
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}