public class Fibonacci {
    public static void main(String[] args) {
        int first = 1;
        int second = 1;

        if (args.length != 1) {
            System.err.println("Only one number as arguement");
        }

        int numberOfTimes = Integer.parseInt(args[0]);

        System.out.println("1");
        System.out.println("1");
        int sum = 1;
        for (int i = 0; i < numberOfTimes - 2; i++) {
            int temp = second;
            second = second + first;
            first = temp;

            sum = sum + second;

            System.out.println(second);
        }

        float avg = (float) sum / (float) numberOfTimes;
        System.out.println("Average is : " + avg);
    }
}