public class Cell {

    boolean state;

    Cell(boolean state){
        this.state = state;
    }

    Cell(){
        this(false);    
    }

    boolean isAlive() {
        return this.state;
    }

    public String toString(){
        return (this.isAlive()) ? "X" : ".";
    }

    public void kill(){
        this.state = false;
    }

    public void create(){
        this.state = true;
    }

    public boolean getNextState(int count){
        if( isAlive() ){
            if (count )
            create();
        }
        else{

        }
    }

}