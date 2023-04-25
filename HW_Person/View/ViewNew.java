package View;

import java.io.*;
import java.net.SocketImpl;
import java.util.*;

public class ViewNew {
    private Map<String, String> data = new LinkedHashMap<>();
    private String[] dataPreliminary = null;
    
    public void inputData() {
        // String[] dataPreliminary = null;

        System.out.println("Введите пожалуйста данные: ");
        try (BufferedReader in = new BufferedReader (new InputStreamReader(System.in))) {
            this.dataPreliminary = in.readLine().split("\\s");
            
            
        } catch (IOException e) {
            
            // e.printStackTrace();
        }
        
    }

    public void parseData() throws IOException {

        if (dataPreliminary.length != 6)
            throw new IOException("Данные введены не верно");

        

        Deque<String> fioQueue = new ArrayDeque<>(
                Arrays.asList(new String[] {"Фамилия", "Имя", "Отчество"})
            ); 
        
        for (int i = 0; i < dataPreliminary.length; i++) {

            boolean flag = false;
            char firstChar = dataPreliminary[i].charAt(0);

            if ((dataPreliminary[i].length() > 1) && !(Character.isDigit(firstChar))) {
                String key = fioQueue.poll();
                this.data.put(key, dataPreliminary[i]);
                // System.out.println(key + " " + dataPreliminary[i]);
                flag = true;
            }

            if ((dataPreliminary[i].length() == 1) && !(Character.isDigit(firstChar))) {
                this.data.put("Пол", dataPreliminary[i]);
                flag = true;
            }


            if ((dataPreliminary[i].chars().allMatch(Character::isDigit))) {
                if (!(this.data.containsKey("Телефон"))) {
                    this.data.put("Телефон", dataPreliminary[i]);
                } else {
                    this.data.put("Дата", dataPreliminary[i]);
                }
                flag = true;
                
            }

            if ((dataPreliminary[i].length() > 1) && (Character.isDigit(firstChar)) && (dataPreliminary[i].contains("."))) {
                if (!(this.data.containsKey("Дата"))) {
                    this.data.put("Дата", dataPreliminary[i]);
                }
                flag = true;
            }

            if (!(this.data.containsKey("Дата")) && !(flag)) {
                this.data.put("Дата", dataPreliminary[i]);
            }

       



        }

    }

    public Map<String, String> getData() {
        return this.data;
    }
}
