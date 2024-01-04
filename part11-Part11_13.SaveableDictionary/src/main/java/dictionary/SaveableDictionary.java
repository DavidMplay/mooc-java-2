package dictionary;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class SaveableDictionary {

    private File file;
    private HashMap<String, String> dictionary;

    public SaveableDictionary() {
        this.dictionary = new HashMap<>();
    }

    public SaveableDictionary(String fileName) {
        this.dictionary = new HashMap<>();
        this.file = new File(fileName);
    }

    public boolean load() {
        try {
            Scanner fileReader = new Scanner(Paths.get((this.file.getName())));
            while(fileReader.hasNextLine()){
                String line = fileReader.nextLine();
                String[] parts = line.split(":");
                this.dictionary.put(parts[0], parts[1]);
            }
            return true;
        } catch (Exception e) {
            System.out.println("File load error: " + e.getMessage());
            return false;
        }
    }
    
    public boolean save(){
        try{
            PrintWriter writer = new PrintWriter(this.file.getName());
            for(String word : this.dictionary.keySet()){
                String Word = word;
                String translation = this.dictionary.get(Word);
                writer.println(Word + ":" + translation);
            }
            writer.close();
            return true;
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void add(String words, String translation) {
        this.dictionary.putIfAbsent(words, translation);
    }

    public String translate(String word) {
        for (String item : this.dictionary.keySet()) {
            if (this.dictionary.get(item).equals(word)) {
                return item;
            } else if (this.dictionary.get(word) != null) {
                return this.dictionary.get(word);
            }
        }
        return null;
    }

    public void delete(String word) {
        String remove = "";
        for (String item : this.dictionary.keySet()) {
            if (this.dictionary.get(item).equals(word)) {
                remove = item;
            } else if (this.dictionary.get(word) != null) {
                remove = word;
            }
        }
        this.dictionary.remove(remove);
    }
}
