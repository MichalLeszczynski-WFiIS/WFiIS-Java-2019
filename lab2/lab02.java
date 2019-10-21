import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class lab02 {

    static public ArrayList<Integer> createRandomArray(int length) {

        ArrayList<Integer> array = new ArrayList<Integer>();
        Random generator = new Random();
        for(int i=0; i < length; i++){
            array.add(generator.nextInt(2));
        }
        return array;
    }

    static public ArrayList<Integer> readFromFile(int length, Scanner input) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < length; i++){
            result.add(input.nextInt());
        }
        return result;
    }

    static public ArrayList<ArrayList<Integer>> generateSubsequences(ArrayList<Integer> array) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < array.size(); i++){
            
        }
        return result;
    }

    public static Boolean hasGoodOrder(ArrayList<Integer> array){
        boolean result = true;
        boolean was_one = false;
        int current_number;
        for(int i=0; i < array.size(); i++){
            current_number = array.get(i);
            if(current_number == 0) {
                if(was_one) {result = false;}
            }
            else {
                was_one = true;
            }
        }
        return result;
    }

    public static int lengthOfTheBiggestSubsetWithOnesAfterZeros(ArrayList<Integer> arr1,ArrayList<Integer> arr2) {
        Random generator = new Random();
        int result = generator.nextInt(arr1.size()/2);
        return result;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        // int length1 = 4;
        // int length2 = 6;

        // ArrayList<Integer> arr1 = createRandomArray(length1);
        // ArrayList<Integer> arr2 = createRandomArray(length2);

        int length1 = input.nextInt();
        int length2 = input.nextInt();
        ArrayList<Integer> arr1 = readFromFile(length1, input);
        ArrayList<Integer> arr2 = readFromFile(length2, input);
        
        System.out.println(arr1.size() + " " + arr2.size());
        System.out.println(arr1 + " " + arr2);
        System.out.println(lengthOfTheBiggestSubsetWithOnesAfterZeros(arr1, arr2));
        input.close();

    }
}