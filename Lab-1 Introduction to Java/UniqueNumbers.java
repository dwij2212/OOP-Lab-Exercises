public class UniqueNumbers {
    public static void main(String[] args) {

        // This is higly inefficient because complexity increases exponentially
        // when number of digits increases. A recursive function will be the best
        // option for a tree structure like this but it has not yet been taught.

        // Insert I'm limited by the technology of my time meme here.
        char[] str = args[0].toCharArray();

        for (int i = 0; i < 4; i++) {
            char first = str[i];
            for (int j = 0; j < 4; j++) {

                char second = str[j];

                if (first != second) {
                    for (int k = 0; k < 4; k++) {
                        char third = str[k];
                        if (first != third && second != third) {
                            System.out.println(first + " " + second + " " + third);
                        }
                    }
                }
            }
        }

    }
}