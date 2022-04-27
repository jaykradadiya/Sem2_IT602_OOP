package assignment4;

import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * created class for read file and perform actions as required.
 */
class scanText{
    String SourceFilePath;
    HashMap<Integer, ArrayList<String>> words ;
    /**
     * use to declare this class will read words from this file and build data as required.
     * @param sourceFilePath
     */
    public scanText(String sourceFilePath) {
        SourceFilePath = sourceFilePath;
        words= new HashMap<>();
        UpdateMap();
    }

    /**
     * use map to store all words in key of its lengths.
     *
     */
    private void UpdateMap(){
        try {
            FileReader fileReader = new FileReader(SourceFilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line=bufferedReader.readLine();
            while (line!=null){
                    ArrayList<String> val = words.getOrDefault(line.length(),new ArrayList<String>());
                    val.add(line);
                    words.put(line.length(),val);
                line= bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * printing  all words in there no length word file.
     * like for 1 length word file name will be words1.txt
     *
     * also print on console no of words are found in words length
     * path where that file will be stored.
     * @param path
     */
    public void outputWordFrequency(String path){
        try {
            for (Map.Entry<Integer,ArrayList<String>> entry :
                words.entrySet()) {
                System.out.println( entry.getKey() + " length words are "+ entry.getValue().size());
                FileWriter fileWriter = new FileWriter(path+"/words"+entry.getKey()+".txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                for (String word:
                        entry.getValue()) {
                    bufferedWriter.write(word);
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


/**
 * inlining object and  executing.
 */
public class Q4 {
    public static void main(String[] args) {
        scanText sc = new scanText("src/assignment4/words.txt");
        sc.outputWordFrequency("src/assignment4");
    }
}
