package assignment4;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * created class for read file and perform actions as required.
 */
class scanTextFile{
    String SourceFilePath;
    String firstWord,lastWord;
    HashMap<Integer, ArrayList<String>> words ;

    /**
     * use to declare this class will read words from this file and build data as required.
     * @param sourceFilePath
     */
    public scanTextFile(String sourceFilePath) {
        SourceFilePath = sourceFilePath;
        words= new HashMap<>();
        UpdateMap();
    }

    /**
     * use map to store all words in key of its lengths.
     *
     * and also store first and last word of file.
     */
    private void UpdateMap(){
        try {
            FileReader fileReader = new FileReader(SourceFilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line=bufferedReader.readLine();
            firstWord= line;
            while (line!=null){
                ArrayList<String> val = words.getOrDefault(line.length(),new ArrayList<String>());
                val.add(line);
                words.put(line.length(),val);
                lastWord=line;
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
     * required path where we have to store output data.
     *
     * here it finds min length and max length form map.
     * and also calculating total words in file.
     * calculating avg words length in file.
     * @param path
     */
    public void outputData(String path){
       int total=0;
       int wordsLenght=0;
       int keyTotal=0;
       int min=Integer.MAX_VALUE;
       int max=0;
        for (Map.Entry<Integer,ArrayList<String>> entry :
                words.entrySet()) {
            total+=entry.getValue().size();
            wordsLenght+=entry.getValue().size()*entry.getKey();
           keyTotal+=entry.getKey();
           if(min>entry.getKey()){
               min=entry.getKey();
           }
           if(max<entry.getKey()){
               max =entry.getKey();
           }
       }

        int avg = keyTotal/words.size();
        int avg1 = wordsLenght/total;
        FileWriter fileWriter = null;

        /**
         *  printing on console and file output
         */
        try {
            fileWriter = new FileWriter(path+"/wordsoutput.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("The number of words in the file "+ total);
            bufferedWriter.newLine();
            System.out.println("The number of words in the file "+ total);
            bufferedWriter.write("The average number of letters per word " +avg);
            bufferedWriter.newLine();
            System.out.println("The average number of letters per word " +avg);

            bufferedWriter.write("The average number of letters per word " +avg1);
            bufferedWriter.newLine();
            System.out.println("The average number of letters per word " +avg1);
            bufferedWriter.write("The longest word and its length  "+words.get(max).get(0));
            bufferedWriter.newLine();
            System.out.println("The longest word and its length  "+words.get(max).get(0));
            bufferedWriter.write("The shortest word and its length " +words.get(min).get(0));
            bufferedWriter.newLine();
            System.out.println("The shortest word and its length " +words.get(min).get(0));
            bufferedWriter.write("The first word in the file "+firstWord);
            bufferedWriter.newLine();
            System.out.println("The first word in the file "+firstWord);
            bufferedWriter.write("The last word in the file "+ lastWord);
            System.out.println("The last word in the file "+lastWord);
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

public class Q3 {
    public static void main(String[] args) {
        scanTextFile scanTextFile= new scanTextFile("src/assignment4/words.txt");
        scanTextFile.outputData("src/assignment4");
    }
}
