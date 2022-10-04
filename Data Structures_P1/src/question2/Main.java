package question2;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static DoubleLinkList insert() throws FileNotFoundException, IOException{
        DoubleLinkList l1 = new DoubleLinkList();
        DoubleLinkList l2 = new DoubleLinkList();
        DataInputStream dataIn = new DataInputStream(new FileInputStream("class.txt"));
        String recievedData;
        Random random= new Random();
        for (int i = 0; i < 30; i++) {
            recievedData = dataIn.readLine();
            if(recievedData == null){
                break;
            }
            String[] student = recievedData.split(" ");
            int number = random.nextInt(100);
            if(number%2 == 0){
                l1.insertFirst(student[0]);
            }else if(number%3==0){
                l1.insertLast(student[0]);
            }
            else{
                l2.insertFirst(student[0]);
                i--;
            }
        }
        while(l1.getSize() < 30){
            l1.insertFirst(l2.getFirst().getData());
            l2.removeFirst();
            if(l2.getSize() == 0){
                System.out.println("There aren't that many students!" + "\n"
                        + "There are " + l1.getSize() + " students.");
                break;
            }
        }
        
        
        return l1;
    }
    
    private static boolean isInteger(String s){
        try{
            Integer.parseInt(s);
        }catch(NumberFormatException e){
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
         
        String menu = "1 --> Start\n"
               
                + "2 --> Exit Game";
        String input;
        while(true){
            System.out.println(menu);
            System.out.print("Input: ");
            input = scanner.next();
            if(input.equals("2")){
                break;
            }
            
            else if(input.equals("1")){
                DoubleLinkList l1 = insert();
                System.out.print("Enter the number of hubs: ");
                String hubInt = scanner.next();
                if(isInteger(hubInt)){
                    System.out.println("Invalid input!");
                    continue;
                }
                if(Integer.parseInt(hubInt) > l1.getSize() || Integer.parseInt(hubInt) < 1){
                    System.out.println("Hub number must be between 1 and 30!");
                    continue;
                }
                l1.hubStudents(Integer.parseInt(hubInt));
                
                System.out.println(l1.toString());
                System.out.print("Enter the number of students to pass the message (k): ");
                String k = scanner.next();
                if(isInteger(k)){
                    System.out.println("Invalid input!");
                    continue;
                }
                System.out.print("Enter the message: ");
                String message = scanner.next();
                System.out.print("Enter the source student: ");
                String name = scanner.next();
                System.out.println(l1.transfer(message, new DoubleNode(name),Integer.parseInt(k)));
            }
            else{
                System.out.println("Wrong input!");
            }
        }
    } 
}
