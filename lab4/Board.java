public class Board {

    Board(int size_x, int size_y) {
        System.out.println("Setting x size to: " + size_x);
        this.size_x = size_x;
        System.out.println("Setting y size to: " + size_y);
        this.size_y = size_y;
        System.out.println("Declaring board");
        this.board = new Cell[size_x][size_y];

        for(int x = 0; x < this.size_x; x ++){
            for(int y = 0 ; y < this.size_y; y ++) {
                this.board[x][y] = new Cell();
            }
        }
    }

    int size_x;
    int size_y;
    public Cell[][] board;
    Integer stage = 1;


    public void simulate(int max_stages){
        while(stage < max_stages){
            print();
            updateBoard();
        }
        print();
    }

    public void print() {
        System.out.println(center(stage.toString(), size_y*2 -1, '-'));
        for(int x = 0; x < this.size_x; x ++){
            for(int y = 0 ; y < this.size_y; y ++) {
                System.out.print(board[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void updateBoard(){
        Cell[][] new_board = new Cell[this.size_x][this.size_y];
        for(int x = 0; x < this.size_x; x ++){
            for(int y = 0 ; y < this.size_y; y ++) {
                new_board[x][y] = this.getNextCell(x, y);
            }
        }
        this.stage++;
        this.board = new_board;
    }

    public Cell getNextCell(int x_pos, int y_pos){
        int neighbours_count = 0;
        for(int x = x_pos-1; x < x_pos+2; x++){
            for(int y = y_pos-1 ; y < y_pos+2; y++) {
                if(x != x_pos || y != y_pos){
                    if(isInsideBoard(x,y) && board[x][y].isAlive()) neighbours_count++;
                }
            }
        }
        return new Cell(this.board[x_pos][y_pos].getNextState(neighbours_count));
    }

    public boolean isInsideBoard(int x_pos, int y_pos){
        return x_pos>0 && x_pos<this.size_x && y_pos>0 && y_pos<this.size_y;
    }

    public static String center(String s, int size, char pad) {

        StringBuilder str = new StringBuilder(size);
        for (int i = 0; i < size/ 2; i++) {
            str.append(pad);
        }
        str.append(s);
        while (str.length() < size) {
            str.append(pad);
        }
        return str.toString();
    }

    public void load(int preset){
        switch(preset) {
            case 0: load_random();
                    break;
            case 1: load_ship();
                    break;
            case 2: load_blinker();
                    break;
            case 3: load_spaceship();
                    break;
        }
    }

    

    void load_random(){
        for(int x = 0; x < this.size_x; x ++){
            for(int y = 0 ; y < this.size_y; y ++) {
                this.board[x][y] = new Cell(randomBoolean());
            }
        }
    }

    void load_ship(){
        int x = this.getMidX();
        int y = this.getMidY();
        this.board[x-1][y].create();
        this.board[x-1][y-1].create();
        this.board[x][y-1].create();
        this.board[x][y+1].create();
        this.board[x+1][y].create();
    }

    void load_blinker(){
        int x = this.getMidX();
        int y = this.getMidY();
        this.board[x-1][y].create();
        this.board[x][y].create();
        this.board[x+1][y].create();
    }

    void load_spaceship(){
        int x = this.getMidX();
        int y = this.getMidY();
        this.board[x-1][y].create();
        this.board[x-1][y-1].create();
        this.board[x-1][y+1].create();
        this.board[x][y-1].create();
        this.board[x+1][y].create();
    }

    public int getMidX(){
        return (int)(this.size_x/2);
    }
    public int getMidY(){
        return (int)(this.size_y/2);
    }

    boolean randomBoolean(){
        return Math.random() < 0.5;
    }
}