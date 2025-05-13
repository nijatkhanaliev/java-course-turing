package az.edu.turing.module3.lesson09.wordcounter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileWordCounterTask implements Runnable{
    private final String fullFileName;

    public FileWordCounterTask(String fullFileName){
        this.fullFileName = fullFileName;
    }

    @Override
    public void run() {
        try(BufferedReader reader = new BufferedReader(new FileReader(fullFileName))) {
            int value = reader.read();
            StringBuilder builder = new StringBuilder();
            while(value!=-1){
                if(Character.isLetterOrDigit(value)){
                    builder.append((char)value);
                }else{
                    if(!builder.isEmpty()){
                        String lowerCase = builder.toString().toLowerCase();
                        Main.map.merge(lowerCase,1,Integer::sum);
                        Main.count.incrementAndGet();
                        builder.setLength(0);
                    }
                }

                value = reader.read();
            }

            if(!builder.isEmpty()){
                String lowerCase = builder.toString().toLowerCase();
                Main.map.merge(lowerCase,1,Integer::sum);
                Main.count.incrementAndGet();
            }

        } catch (FileNotFoundException e) {
            System.err.println(Thread.currentThread().getName() + " Not Found Exception: " + e.getMessage());
        } catch (IOException e) {
            System.err.println(Thread.currentThread().getName() + " IO Exception: " + e.getMessage());
        }

    }

}
