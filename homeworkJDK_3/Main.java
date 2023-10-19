public class Main {

    public static void main(String[] args) {

        System.out.println(Calculator.sum(55, 55.0));
        System.out.println(Calculator.multiply(2, 3.2));
        System.out.println(Calculator.divide(6.0, 3));
        System.out.println(Calculator.subtract(5.0, 3));

        Integer[] array1 = {1, 2, 3, 4, 5};
        Integer[] array2 = {1, 2, 3, 4, 5};
        Integer[] array3 = {1, 2, 3, 4, 6};
        System.out.println(Calculator.compareArrays(array1, array2));
        System.out.println(Calculator.compareArrays(array1, array3));

        Pair pair1 = new Pair<>("fhf", 1);
        System.out.println(pair1);
        Pair pair2 = new Pair<>("fhf", "ththdf");
        System.out.println(pair2);
        System.out.println(pair2.getFirst());
        System.out.println(pair2.getSecond());
    }

}
