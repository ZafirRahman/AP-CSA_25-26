package sorting;

public class InsertionSort implements Sorter {

    public void sort(int[] input) {
        for(int i = 1; i < input.length; i++){
            int current = input[i];
            int k = i - 1;

            while(k >= 0 && input[k] > current){
                input[k+1] = input[k];
                k--;
            }

            input[k+1] = current;
        }
        System.out.println("Insertion Sort!!!");
    }
}
