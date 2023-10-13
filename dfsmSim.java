import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
//Team: Julian Sahagun, Diya Kafle
public class dfsmSim{
    //The program should
    //1. Read the DFSM from the input file
    //2. In a loop:
        //a. ask the user to input a string which can be empty
        //b. output "true" if the string is accepted by the machine, "false" otherwise
    //3. Prompt the user to repeat step 2 or stop the program

    public static void main(String[] args) {
        //Read the DFSM
        File file = new File("example1.txt");
        dfsm machine = new dfsm();
        readDFSM(machine, file);

        //loop for user input
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Enter a string: ");
            String str = input.nextLine();
            if(str.equals("")){
                
            }
            else{
                
            }
            System.out.println("Do you want to continue? (y/n)");
            String cont = input.nextLine();
            if(cont.equals("n")){
                break;
            }
        }

        

      
    }

    public static void readDFSM(dfsm machine, File file){
        //Read the DFSM from the input file
        Scanner sc = new Scanner(file);
        //Read the alphabet
        String s = sc.nextLine();
        machine.setAlphabet(s.split(","));

        //Create the states
        int numStates = Integer.parseInt(sc.nextLine());

        machine.createStates(numStates);

        //Determine Accepting states
        for(int i = 0; i < numStates; i++){
            //Read the state
            //Determine if it is an accepting state

        }

        //Save functions for each state


        
        //Close the scanner
        sc.close();
    }


}

