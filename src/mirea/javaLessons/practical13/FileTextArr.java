package mirea.javaLessons.practical13;

import java.nio.file.Files;
import java.util.Scanner;
import java.util.ArrayList;
import java.nio.file.Path;
import java.io.*;

public class FileTextArr {
    private Scanner in = new Scanner(System.in);
    private ArrayList<String> words = new ArrayList<>();
    private boolean f = false;

    public FileTextArr() {
        System.out.print("Enter file path: ");
        String strPath = in.nextLine();
        if (!Files.exists(Path.of(strPath))) {
            System.out.println("No such file exists");
            this.f = true;
            return;
        }
        File file = new File(strPath);
        ArrayList<String> strFromFile = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                strFromFile.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < strFromFile.size(); i++) {
            String bufer = "";
            for (int j = 0; j < strFromFile.get(i).length(); j++) {
                if (strFromFile.get(i).charAt(j) == ' ') {
                    this.words.add(bufer);
                    bufer = "";
                    continue;
                }
                bufer += strFromFile.get(i).charAt(j);
            }
        }
    }

    public StringBuilder getLine() {
        if(this.f){
            System.out.println("No such file exists");
            return new StringBuilder();
        }
        StringBuilder res = new StringBuilder(this.words.get(0));
        this.words.remove(0);
        boolean mv = false;
        while (!this.words.isEmpty()) {
            for (int i = 0; i < this.words.size(); i++) {
                mv = false;
                if(res.substring(res.length() - 1).equalsIgnoreCase(this.words.get(i).substring(0, 1))){
                    res.append(" " + this.words.get(i));
                    this.words.remove(i);
                    mv = true;
                    break;
                }
            }
            if(!mv) {
                res.append(" " + this.words.get(0));
                this.words.remove(0);
            }
        }
        return res;
    }
}
