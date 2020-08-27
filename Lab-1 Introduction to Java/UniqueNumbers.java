public class UniqueNumbers {
    public static void main(String[] args) {
        int number = Integer.parseInt(args[0]);

        int d = (int) (number % 10);
        // now divide value by 10 to position for next digit.
        number /= 10;

        int c = (int) (number % 10);
        // now divide value by 10 to position for next digit.
        number /= 10;

        int b = (int) (number % 10);
        // now divide value by 10 to position for next digit.
        number /= 10;

        int a = (int) (number % 10);
        // now divide value by 10 to position for next digit.
        number /= 10;

        // Print the number with spaces
        System.out.println(a + " " + b + " " + c + " " + d);
    }
}