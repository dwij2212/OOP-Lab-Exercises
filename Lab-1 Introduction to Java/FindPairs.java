public class FindPairs {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[args.length - 1]);
        int count = 0;
        for (int i = 0; i < args.length - 2; i++) {
            for (int j = i; j < args.length - 1; j++) {
                int sum = Integer.parseInt(args[i]) + Integer.parseInt(args[j]);

                if (sum == x) {
                    count = count + 1;
                    System.out.println(
                            "Pair #" + count + ": " + Integer.parseInt(args[i]) + " " + Integer.parseInt(args[j]));
                }
            }
        }
    }
}