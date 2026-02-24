package sorting;

public class SelectionSort implements Sorter {

    public void sort(int[] input) {
        for(int i = 0; i < input.length - 1; i++){
            int minimum = i;

            for(int k = i + 1; k < input.length; k++){
                if(input[k] < input[minimum]){
                    minimum = k;
                }
            }
            int temp = input[minimum];
            input[minimum] = input[i];
            input[i] = temp;
        }

        System.out.println("Selection Sort!!!");
    }
}
