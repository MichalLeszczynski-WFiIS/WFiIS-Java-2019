public class Cell {

    boolean state;

    Cell(boolean state){
        this.state = state;
    }

    Cell(){
        this(false);    
    }

    void create(){
        this.state=true;
    }

    boolean isAlive() {
        return this.state;
    }

    public String toString(){
        return (this.isAlive()) ? "X" : ".";
    }

    boolean getNextState(int count){
        boolean next = false;
        if( isAlive() ){
            if (count == 2 || count == 3 ) next = true;
        }
        else{
            if (count == 3) next = true;
        }
        return next;
    }

}