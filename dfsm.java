import java.util.ArrayList;

public class dfsm {
    ArrayList<state> states;
    ArrayList<String> alphabet;
    state currState;
    
    public dfsm() {
        //constructor
        states = new ArrayList<state>();
        alphabet = new ArrayList<String>();
        currState = new state();
    }

    public void setAlphabet(String[] alphabet){
        for(int i = 0; i < alphabet.length; i++){
            this.alphabet.add(alphabet[i]);
        }
    }
    public ArrayList<String> getAlphabet(){
        return this.alphabet;
    }

    public void createStates(int numStates){
        //this.numStates = numStates;
        for(int i = 0; i < numStates; i++){
            state s = new state();
            this.states.add(s);
        }
        currState = this.states.get(0);
    }
    
    public ArrayList<state> getStates(){
        return this.states;
    }
    
    public boolean checkString(String str){
        //check if machine accepts the string
        for(int i = 0; i < str.length(); i++){
            //transition for every character in str
            int transitionTo = currState.transition(str.charAt(i));
            currState = states.get(transitionTo);
        }
        if(currState.accepts()){
            return true;
        }

        return false;
    }

    public void reset(){
        currState = states.get(0);
    }
}
