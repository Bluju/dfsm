import java.util.ArrayList;

public class state {
    boolean isAccepting;
    ArrayList<ArrayList<String>> functions;
    public state() {
        //constructor
        isAccepting = false;
        functions = new ArrayList<ArrayList<String>>();
    }

    public void setAccepting(boolean isAccepting){
        this.isAccepting = isAccepting;
    }

    public void addFunction(ArrayList<String> function){
        functions.add(function);
    }
    public boolean accepts(){
        return this.isAccepting;
    }

    public int transition(char input){
        //return the index of the next state
        for(int i = 0; i < functions.size(); i++){
            if(functions.get(i).get(1).charAt(0) == input){
                return Integer.parseInt(functions.get(i).get(2));
            }
        }
        return Integer.parseInt(functions.get(0).get(0));
    }




}
