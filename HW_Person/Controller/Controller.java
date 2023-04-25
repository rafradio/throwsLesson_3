package Controller;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import Model.DateModel;
import Model.FIOModel;
import Model.GenderModel;
import Model.Model;
import Model.PhoneModel;
import Model.Exceptions.DateValueException;
import Model.Exceptions.NameValueException;
import Model.Exceptions.PhoneValueException;
import Model.Exceptions.TypeValueException;
import View.ViewNew;

public class Controller {
    private ArrayList<Model> modelList = new ArrayList<>();
    private boolean print = false;
    private String[] data;
    private ViewNew view;

    public void run() {
        
        this.view = new ViewNew();
        this.makeModel();
        
        Thread newThread = new Thread(() -> {
            this.makeGlobalValidation();
            if (this.print) this.printToFile();
        });
        
        newThread.start();
        
    }

    public void makeModel() {
        this.view.inputData();
        try {
            this.view.parseData();
            this.modelList.add(new FIOModel(this.view.getData().get("Фамилия")));
            this.modelList.add(new FIOModel(this.view.getData().get("Имя")));
            this.modelList.add(new FIOModel(this.view.getData().get("Отчество")));
            this.modelList.add(new DateModel(this.view.getData().get("Дата")));
            this.modelList.add(new PhoneModel(this.view.getData().get("Телефон")));
            this.modelList.add(new GenderModel(this.view.getData().get("Пол")));
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void makeGlobalValidation() {
        try {
            String[] fields = new String[] {"Фамилия", "Имя", "Отчество", "Дата", "Телефон", "Пол"};
            for (int i = 0; i < this.modelList.size(); i++) this.modelList.get(i).makeValidation(fields[i]);
            this.print = true;
            System.out.println("Все ок");
            // System.out.println(this.view.getData());

        }
        catch(NameValueException ex) {
            System.out.println(ex.getMessage());
        }
        catch(PhoneValueException ex) {
            System.out.println(ex.getMessage());
        }
        catch(DateValueException ex) {
            System.out.println(ex.getMessage());
        }
        catch(TypeValueException ex) {
            
        }

    }

    public void printToFile() {
        String nameOfFile = "data/" + this.modelList.get(0).getValue().toLowerCase() + ".txt";
        try {
            FileWriter myWriter = new FileWriter(nameOfFile, true); 
            BufferedWriter buffer = new BufferedWriter(myWriter);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.modelList.size(); i++) {
                sb.append("<");
                sb.append(this.modelList.get(i).getValue());
                sb.append(">");
            }
            sb.append("\n");
            buffer.write(sb.toString());  
            buffer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
