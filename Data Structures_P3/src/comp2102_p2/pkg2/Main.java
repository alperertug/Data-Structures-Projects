package comp2102_p2.pkg2;

import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        SeparateChainHash<String> wordHash = new SeparateChainHash<>(301);
        Scanner scanner = new Scanner(System.in);
        
        String text;
                
        for(int j = 1;j<11;j++){
            text = j+".txt";  
            DataInputStream dataIn = new DataInputStream(new FileInputStream(text));
            String recievedData;
            while (true) {
                recievedData = dataIn.readLine();
                if (recievedData == null) {
                    break;
                }
                String[] textArray = recievedData.split(" ");
                for (int i = 0; i < textArray.length; i++) {
                    wordHash.insert(textArray[i].toLowerCase(), text);
                }
            }
        }
        System.out.println("Welcome \nPress 0 to leave. ");
        while (true) {            
            System.out.print("Enter a word: ");
            String input = scanner.nextLine();
            if (input.equals("0")) {
                System.out.println("Good bye...");
                break;
            }else{
                System.out.println(wordHash.find(input.toLowerCase()));
            }
        }
  
    }
}
