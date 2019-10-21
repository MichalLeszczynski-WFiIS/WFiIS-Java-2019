import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class lab3 {
    static public int[] readArray(int length, Scanner in){
        int[] result = new int[length];
        for(int i = 0; i < length; i++){
            result[i] = in.nextInt();
        }
        return result;
    }

    static public int sum(ArrayList<Integer> arr){
        int result = 0;
        for(int a : arr){
            result += a;
        }
        return result;
    }

    static public ArrayList<Integer> del_zeros_from(ArrayList<Integer> seq, int index){
        for(int i = index; i < seq.size(); i++){
            if(seq.get(i) == 0) {
                seq.remove(i);
                i--;
            }
        }
        return seq;
    }
    static public ArrayList<Integer> createRandomArray(int lenght) {
        var result = new ArrayList<Integer>();
        var generator = new Random();
        for(int i = 0; i < lenght; i++){
            result.add(i, generator.nextInt(2));
        }
        return result;
    }

    static public ArrayList<Integer> copy(ArrayList<Integer> seq){
        var result = new ArrayList<Integer>();
        for (int i = 0; i < seq.size(); i++) {
            result.add(i, seq.get(i));
        }
        return result;
    }

    static public void cleanUp(ArrayList<Integer> seq1, ArrayList<Integer> seq2, int sum1, int sum2) {
        if(seq1.size() == seq2.size()){
            if(sum1 != sum2) {
                while(sum1 > sum2){
                    seq1.remove(seq1.size() - 1);
                    seq2.remove(0);
                    sum1--; 
                }
                while(sum2 > sum1){
                    seq2.remove(seq2.size() - 1);
                    seq1.remove(0);
                    sum2--;
                } 
            }
        } else {
            while(sum1 > sum2){
                seq1.remove(seq1.size() - 1);
                sum1--; 
            }
            while(sum2 > sum1){
                seq2.remove(seq2.size() - 1);
                sum2--;
            }
            while(seq1.size() > seq2.size()){
                seq1.remove(0);
            }
            while(seq1.size() < seq2.size()){
                seq2.remove(0);
            }
        }
    }

    static public void resize(ArrayList<Integer> seq1, ArrayList<Integer> seq2, int sum1, int sum2) {
        if(sum1 != sum2){
            while(sum1 > sum2){
                for(int i = 0; i < seq1.size(); i++){
                    if(seq1.get(i) == 1){
                        seq1.remove(i);
                        sum1--; 
                        break;
                    }
                }
            }
            while(sum1 < sum2){
                for(int i = 0; i < seq2.size(); i++){
                        if(seq2.get(i) == 1){
                            seq2.remove(i);
                            sum2--; 
                            break;
                        }
                }
            }
        }
        while(seq1.size() > seq2.size()){
            for(int i = 0; i < seq1.size(); i++){
                if(seq1.get(i) == 0){
                    seq1.remove(i);
                    break;
                }
            }
        }
        while(seq1.size() < seq2.size()){
            for(int i = 0; i < seq2.size(); i++){
                if(seq2.get(i) == 0){
                    seq2.remove(i);
                    break;
                }
            }
        }
    }

    static public int second_and_third_case(ArrayList<Integer> seq1, ArrayList<Integer> seq2, int sum1, int sum2, int i) {
        int temp = 0;
        ArrayList<Integer> seq1_temp = del_zeros_from(copy(seq1), i + 1);
        ArrayList<Integer> seq2_temp = del_zeros_from(copy(seq2), i);
        delete_ones_until(seq1_temp, i);
        delete_ones_until(seq2_temp, i);
        cleanUp(seq1_temp, seq2_temp, sum(seq1_temp), sum(seq2_temp));
        temp = seq1_temp.size();
        var other_copy1 = copy(seq1);
        var other_copy2 = copy(seq2);
        other_copy1.remove(i);
        int other = process(other_copy1, other_copy2);
        if(other > temp){
            temp = other;
        }
        return temp;
    }

    static public void delete_ones_until(ArrayList<Integer> seq1, int index) {
        for(int i = 0; i < index; i++) {
            if(seq1.get(i) == 1){
                seq1.remove(i);
                i--;
                index--;
            }
        }
    }

    static public Boolean correct(ArrayList<Integer> seq1, ArrayList<Integer> seq2) {
        Boolean flag = false;
        for(int i = 0; i < seq1.size(); i++){
            if(seq1.get(i) != seq2.get(i)){
                return false;
            }
            if(!flag && seq1.get(i) == 1 && seq1.get(i) == 1){
                flag = true;
            }
            if(flag && (seq1.get(i) == 0)){
                return false;
            }
        }
        return true;
    }

    static public int process(ArrayList<Integer> seq1, ArrayList<Integer> seq2){
        int max = 0;
        int sum1 = sum(seq1);
        int sum2 = sum(seq2);
        if(seq1.size() != seq2.size()){
            resize(seq1, seq2, sum1, sum2);
            sum1 = sum(seq1);
            sum2 = sum(seq2);
        }
        for (int i = 0; i < seq1.size(); i++) {
            int temp = 0;
            if(seq1.get(i) == 0 && seq2.get(i) == 0){
                if( i < seq1.size() - 1){
                    var seq1_temp = del_zeros_from(copy(seq1), i + 1);
                    var seq2_temp = del_zeros_from(copy(seq2), i + 1);
                    delete_ones_until(seq1_temp, i);
                    delete_ones_until(seq2_temp, i);
                    cleanUp(seq1_temp, seq2_temp, sum(seq1_temp), sum(seq2_temp));
                    temp = seq1_temp.size();
                } else {
                    if(correct(seq1, seq2)){
                        temp = seq1.size();
                    }
                }
            } else if (seq1.get(i) == 1 && seq2.get(i) == 0) {
                temp = second_and_third_case(seq1, seq2, sum1, sum2, i);
            } else if (seq1.get(i) == 0 && seq2.get(i) == 1) {
                temp = second_and_third_case(seq2, seq1, sum2, sum1, i);
            } else {
                var seq1_temp = del_zeros_from(copy(seq1), i + 1);
                var seq2_temp = del_zeros_from(copy(seq2), i + 1);
                delete_ones_until(seq1_temp, i);
                delete_ones_until(seq2_temp, i);
                cleanUp(seq1_temp, seq2_temp, sum(seq1_temp), sum(seq2_temp));
                temp = seq1_temp.size();
                var other_copy1 = copy(seq1);
                var other_copy2 = copy(seq2);
                other_copy1.remove(i);
                other_copy2.remove(i);
                int other = process(other_copy1, other_copy2);
                if(other > temp){
                    temp = other;
                }
            }
            if(temp > max)  {
                max = temp;
            }
        }
        return max;
    }

    static public void fun(int i){
        i += 10;
    }
    static public void main(String[] arg){
        Scanner in = new Scanner(System.in);
        int lenght_1 = 6;//= in.nextInt();
        int lenght_2 = 4;
        ArrayList<Integer> seq1 = createRandomArray(lenght_1);//= readArray(lenght, in);
        ArrayList<Integer> seq2 = createRandomArray(lenght_2);//= readArray(lenght, in);
        System.out.println(seq1 + " " + seq2);
        System.out.println(process(seq1, seq2));
        in.close();
    }
}