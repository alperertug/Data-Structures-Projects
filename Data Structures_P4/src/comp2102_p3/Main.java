package comp2102_p3;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ListGraph list = new ListGraph(107); //107  11
        DataInputStream dataIn = new DataInputStream(new FileInputStream("got-edges.csv"));
            String recievedData;            
            recievedData = dataIn.readLine();
            while (true) {
                recievedData = dataIn.readLine();
                if (recievedData == null) {
                    break;
                }
                String[] textArray = recievedData.split(",");
                    list.addEdge(textArray[0].toLowerCase(),textArray[1].toLowerCase(),Integer.parseInt(textArray[2]));
            }
            String mainMenu = "******************************\n"
                    + "GoT Network\n"
                    + "1. Show All Characters\n"
                    + "2. Print Closest Characters\n"
                    + "3. Print Farther Characters\n"
                    + "4. Check Connection\n"
                    + "5. Shortest Path\n"
                    + "6. Delete Connection\n"
                    + "7. Change Connection Strength\n"
                    + "8. Number of Character Groups\n"
                    + "9. Most Popular Character(Custom)\n"
                    + "10. Common Characters(Custom)\n"
                    + "11. Exit";
            String input;
            while (true) {            
                
                System.out.println(mainMenu);
                System.out.println("Choice: ");
                input = scanner.nextLine();
                System.out.println("\n");
                if (input.equals("1")){
                    System.out.println(list);
                    
                }
                else if(input.equals("2")){
                    
                    System.out.println("Character: ");
                    String input1 = scanner.nextLine();
                    System.out.println("Threshold: ");
                    String input2 = scanner.nextLine();
                    list.printClosesestCharacters(input1.toLowerCase(), Integer.parseInt(input2));
                }
                else if(input.equals("3")){
                    System.out.println("Character: ");
                    String input1 = scanner.nextLine();
                    System.out.println("Threshold: ");
                    String input2 = scanner.nextLine();
                    list.printFartherCharacters(input1.toLowerCase(), Integer.parseInt(input2));
                }
                else if(input.equals("4")){
                    System.out.println("First Character: ");
                    String input1 = scanner.nextLine();
                    System.out.println("Second Character: ");
                    String input2 = scanner.nextLine();
                    if (list.isConnected(input1.toLowerCase(), input2.toLowerCase()) == true) {
                        System.out.println("Yes! They are connected...");
                    }else{
                        System.out.println("No! They are not connected...");
                    }
                    System.out.println("\n");
                }
                else if(input.equals("5")){
                    System.out.println("First Character: ");
                    String input1 = scanner.nextLine();
                    System.out.println("Second Character: ");
                    String input2 = scanner.nextLine();
                    BreadthFirstSearch bfs = new BreadthFirstSearch(list, input1.toLowerCase());
                    bfs.printPathTo(list, input2.toLowerCase());
                }
                else if(input.equals("6")){
                    System.out.println("First Character: ");
                    String input1 = scanner.nextLine();
                    System.out.println("Second Character: ");
                    String input2 = scanner.nextLine();
                    list.removeEdge(input1.toLowerCase(), input2.toLowerCase());
                }
                else if(input.equals("7")){
                    System.out.println("First Character: ");
                    String input1 = scanner.nextLine();
                    System.out.println("Second Character: ");
                    String input2 = scanner.nextLine();
                    System.out.println("New Weight: ");
                    String input3 = scanner.nextLine();
                    list.change(input1.toLowerCase(), input2.toLowerCase(), Integer.parseInt(input3));
                }
                else if(input.equals("8")){
                    System.out.println("Character Groups: ");
                    ConnectedComponents cc = new ConnectedComponents(list);
                    
                }
                else if(input.equals("9")){
                    System.out.println("Most Popular Character: ");
                    list.muchKnow();
                    
                }
                else if(input.equals("10")){
                    System.out.println("First Character: ");
                    String input1 = scanner.nextLine();
                    System.out.println("Second Character: ");
                    String input2 = scanner.nextLine();
                    list.commanKnow(input1.toLowerCase(), input2.toLowerCase());
                }
                else if(input.equals("11")){
                    System.out.println("Good bye!");
                    break;
                }
            }
    }
}
