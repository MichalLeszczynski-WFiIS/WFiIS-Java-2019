import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lab7 {
    private static ArrayList<Integer> readFromFile(int length, Scanner input) {

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            result.add(input.nextInt());
        }
        return result;
    }

    public static void main(String[] argv) {

        Scanner input = new Scanner(System.in);

        int nums_in_line = input.nextInt();
        int lines = input.nextInt();

        ArrayList<ArrayList<Integer>> input_arr = new ArrayList<>(lines);


        for (int i = 0; i < lines; i++) {
            input_arr.add(readFromFile(nums_in_line, input));

        }

        Boolean[][] result = new Boolean[nums_in_line][nums_in_line];
        for (int i = 0; i < nums_in_line; i++) {
            for (int j = 0; j < nums_in_line; j++) {
                result[i][j] = false;
            }
        }

        for(ArrayList<Integer> array : input_arr) {


            int half_size = array.size() / 2;
            List first_half = array.subList(0, half_size);
            List second_half = array.subList(half_size, half_size * 2);

            int u, v;
            for (int i = 0; i < half_size; i++) {

                for (int j = 0; j < half_size; j++) {
                    u = (int) first_half.get(i) - 1;
                    v = (int) second_half.get(j) - 1;
                    result[u][v] = true;
                    result[v][u] = true;
                }
            }
        }

        boolean is_false = false;
        for (int i = 0; i < nums_in_line; i++) {
            for (int j = i+1; j < nums_in_line; j++) {
                if (result[i][j] == false) {
                    is_false = true;
                    break;
                }
            }
        }
        if(is_false)
        {
            System.out.println("NIE");
        }
        else
        {
            System.out.println("TAK");
        }
    }
}
