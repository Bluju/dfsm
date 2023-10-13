import java.util.ArrayList;

public class dfsm {
    ArrayList<state> states;
    ArrayList<String> alphabet;
    int numStates;//maybe unnecessary
    public dfsm() {
        //constructor
        ArrayList<state> states = new ArrayList<state>();
        alphabet = new ArrayList<String>();
        numStates = 0;
    }

    public void setAlphabet(String[] alphabet){
        //this.alphabet = alphabet;
    }

    public void createStates(int numStates){
        this.numStates = numStates;
    }

    public void addState(state s){
        states.add(s);
    }
}
