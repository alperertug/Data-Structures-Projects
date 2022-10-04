
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
     public static CircularList insertData(int k) throws FileNotFoundException, IOException{
        CircularList l1 = new CircularList();
        CircularList l2 = new CircularList();
        DataInputStream dataIn = new DataInputStream(new FileInputStream("class.txt"));
        String recievedData;
        Random random= new Random();
        for (int i = 0; i < k; i++) {
            recievedData = dataIn.readLine();
            if(recievedData == null){
                break;
            }
            String[] student = recievedData.split(" ");
            int number = random.nextInt(100);
            if(number%2 == 0){
                l1.insertAfterCurrent(student[0]);
            }else if(number%3==0){
                l1.insertBeforeCurrent(student[0]);
            }
            else{
                l2.insertAfterCurrent(student[0]);
                i--;
            }
        }
        while(l1.getSize() < k){
            l1.insertAfterCurrent(l2.getCurrent().getData());
            l2.removeNotPrint(l2.getCurrent());
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
        int i=1;
        String menu = "1 --> Start a new game\n"
                + "2 --> Exit";
        while(true){
            
            System.out.println(menu);
            System.out.print("Input: ");
            String input = scanner.next();
            
            if(input.equals("1")){
                String studentNumber;
                System.out.print("Enter student number: ");
                studentNumber = scanner.next();
                
            
                if(isInteger(studentNumber)){
                    System.out.println("Invalid input!");
                    continue;
                }
                int cInt = Integer.parseInt(studentNumber);
                CircularList l1 = insertData(cInt);
                Random random= new Random(); 
                System.out.println("Studen list: ");
                System.out.println(l1.toString());
                
                while(l1.getSize() != 1){
                    
                    int k = random.nextInt(l1.getSize()-1);
                    System.out.println("Selected number is "+(k+1));
                    Node student = l1.kthStudent(k);
                    System.out.println("Selected student: "+student.getData());
                    l1.deleteNodeChar(student);
                    System.out.println("Selected student has "+student.getControlData()+" letters");
                    System.out.println(l1.toString());
                    l1.deleteNodeStar(student);
                    l1.rotatekth(k);
                    System.out.println(i+" round over.");
                    i++;
                    System.out.println("-----------------------------------");
                    System.out.println(l1.toString());
                } 
                 i=0;
            }
            else if(input.equals("2")){
                break;
            }
            else{
                System.out.println("Wrong input!");
            }
        }
            
    }
        
       
   
}

