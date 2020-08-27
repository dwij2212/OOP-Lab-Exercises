class Bicycle {
    int speed = 0;
    int noOfGears = 5;
    int cadence = 5;

    public void printState() {
        System.out.println("Bicycle [cadence=" + cadence + ", number of gears=" + noOfGears + ", Speed=" + speed + "]");
    }

    public static void main(String[] args) {
        Bicycle b1 = new Bicycle();

        b1.printState();
    }
}