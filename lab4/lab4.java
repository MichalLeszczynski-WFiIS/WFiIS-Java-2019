import java.lang.Math;

public class lab4{
    
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    
    
    public static void main(String[] args){

        int size_x = Integer.parseInt(args[0]);
        int size_y = Integer.parseInt(args[1]);
        int steps = Integer.parseInt(args[2]);
        int preset = Integer.parseInt(args[3]);

        System.out.println("x = " + size_x);
        System.out.println("y = " + size_y);
        System.out.println("steps = " + steps);
        System.out.println("preset = " + preset);

        Board board = new Board(size_x, size_y, preset);
        board.print();
        board.board[2][2] = new Cell(true);
        board.board[2][3] = new Cell(true);
        board.board[2][4] = new Cell(true);

        board.print();
        board.updateBoard();
        board.print();
        board.updateBoard();
        board.print();
        
    }
}