// Joseph Curtis

package yomommatranslator;

import java.io.*;
import java.util.*;

public class YoMommaTranslator {
   
    public static void main(String[] args) throws FileNotFoundException {
        
        TreeMap<String, String> acronyms = new TreeMap<>();
        File input = new File("acronyms.txt");
        Scanner in = new Scanner(input);
       
        while (in.hasNextLine()) {
             String line = in.nextLine();
             String[] splitted = line.split("\\t");
             acronyms.put(splitted[0].toLowerCase(), splitted[1].toLowerCase());
        }
        
        System.out.print("Enter a sentence containing acronyms: ");
        Scanner in2 = new Scanner(System.in).useDelimiter("\\n");
        String userInput = in2.next();
        String[] split = userInput.split("\\s+");
        String sentence = "";
        
        for(int i = 0; i < split.length; i++) {
            if(acronyms.containsKey(split[i].toLowerCase()))
                sentence += acronyms.get(split[i].toLowerCase()) + " ";
            else
                sentence += split[i] + " ";
        }
        
        System.out.print(sentence);

    }
}
