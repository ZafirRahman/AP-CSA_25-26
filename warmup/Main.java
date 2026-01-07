package warmup;

public class Main {

    public static void main(String[] args) {
        // Your code here.
        int fiveSum = 0;
        int threeSum = 0;
        int commonFactors = 0;
        for(int i = 0; i < 1000; i++){
            if(i % 5 == 0 && i % 3 ==0){
                commonFactors += i;
            }
        }
        for(int i = 0; i < 1000; i+=5){
            fiveSum += i;
        }
        for(int i = 0; i < 1000; i+=3){
            threeSum += i;
        }
        System.out.print("The sum of all the mulitples of 3 and 5 between 1000 is ");
        System.out.println(fiveSum + threeSum - commonFactors);
    }
}
