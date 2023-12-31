import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;
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
        File file = new File("example1.txt"); // change to file name
        dfsm machine = new dfsm();
        readDFSM(machine, file);

        //loop for user input
        Scanner input = new Scanner(System.in);
        boolean inAlphabet = false;
        while(true){
            System.out.println("Please enter a string: ");
            String str = input.nextLine();
            //check if str is inside the alphabet of machine
            for(int i = 0; i < str.length();i++){
                if(!machine.getAlphabet().contains(Character.toString(str.charAt(i)))){
                    inAlphabet = false;
                    break;
                }
                else{
                    inAlphabet = true;
                }
            }
            if(inAlphabet){
                //check if str is accepted by the machine
                if(machine.checkString(str)){
                    System.out.println("true");
                }
                else{
                    System.out.println("false");
                }
            }
            
            //ask to continue
            System.out.println("do you wish to continue? (y/n)");
            String cont = input.nextLine();
            if(cont.equals("n")){
                break;
            }
            //transition back to initial state
            machine.reset();
        }
        input.close();     
    }

    public static void readDFSM(dfsm machine, File file){
        //Read the DFSM from the input file
        Scanner sc;
        try{
            sc = new Scanner(file);
        }
        catch(Exception e){
            System.out.println("File not found");
            return;
        }
        //Read the alphabet
        String s = sc.nextLine();
        machine.setAlphabet(s.split(","));

        //Create the states
        int numStates = Integer.parseInt(sc.nextLine());
        
        machine.createStates(numStates);
        //Determine Accepting states
        String[] acceptingStates = sc.nextLine().split(",");
        for(int i = 0; i < acceptingStates.length; i++){
            machine.states.get(Integer.parseInt(acceptingStates[i])).setAccepting(true);
        }
        //Save functions for each state
        while(true){
            //read the rest of the file, input functions into appropriate states
            String[] function = sc.nextLine().split(",");
            //remove parenthesis from each element in function
            for(int i = 0; i < function.length; i++){
                if(function[i].charAt(0) == '('){
                    function[i] = function[i].substring(1);
                }
                if(function[i].length() > 1 && function[i].charAt(1) == ')'){
                    function[i] = function[i].substring(0, function[i].length()-1);
                } 
            }

            ArrayList<String> func = new ArrayList<String>();
            //add the functions for a state to a variable
            for(int i = 0; i < function.length; i++){
                func.add(function[i]);   
            }
            

            //separate the states and add them to the appropriate state
            for(int i = 0; i < Math.ceil(func.size()/3); i++){
                ArrayList<String> f = new ArrayList<String>();
                f.add(func.get(i*3));
                f.add(func.get(i*3+1));
                f.add(func.get(i*3+2));
                machine.states.get(Integer.parseInt(f.get(0))).addFunction(f);
            }
            if(!sc.hasNextLine()){
                break;
            }
        }
        //Close the scanner
        sc.close();
    }
}

