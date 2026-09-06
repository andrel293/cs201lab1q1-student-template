import java.lang.*;
import java.util.*;

public class NumbersArray {
    public static void main(String[] args) {
        Integer[] input = {1,2,3,4,1,5};

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input)));       
        
        System.out.println();

        input = new Integer[] {1,2,3,4,1,2,5,3};

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input))); 
    }

    // Write your methods here
    public static int findMax(Integer[] arr) {
        int m = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > m){
                m = arr[i];
            }
        }

        return m;
    }

    public static Integer[] findDuplicates(Integer[] arr){

        List<Integer> dupes = new ArrayList<>();

        Arrays.sort(arr);

        for (int i = 1; i < arr.length; i++){
            int cur = arr[i];

            if (cur == arr[i-1]){

                boolean in = false;

                for (int j = 0; j < dupes.size(); j++){

                    if (dupes.get(j) == cur){
                        in = true;
                    }
                }

                if (!in) {
                    dupes.add(cur);
                }

            }

        }

        return dupes.toArray(Integer[]::new);
        
    }

    public static Integer[] findUnique(Integer[] arr){

        Integer[] dupes = findDuplicates(arr);

        Arrays.sort(arr);

        List<Integer> unique = new ArrayList<>();

        for (int i = 0; i < arr.length; i++){

            int cur = arr[i];

            boolean duplicate = false;

            for (int j = 0; j < dupes.length; j++){
                if (cur == dupes[j]){
                    duplicate = true;
                }
            }

            if (!duplicate){
               unique.add(cur);
            }

        }
        
        return unique.toArray(Integer[]::new);

    }

}