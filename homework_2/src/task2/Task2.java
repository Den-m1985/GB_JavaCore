package task2;

public class Task2 {
    public static void main(String[] args) {
        String origin = "Hello world";
        int key = 1;
        boolean crypt = true;
        String shifr = caesar(origin, key, crypt);
        System.out.println(shifr);

        boolean encrypt = false;
        String originAfterCrypt = caesar(shifr, key, encrypt);
        System.out.println(originAfterCrypt);

    }


    private static String caesar(String in, int key, boolean encrypt) {
        if (in == null || in.isEmpty())
            return null;

        final int len = in.length();
        char[] out = new char[len];
        for (int i = 0; i < len; ++i) {
            out[i] = (char) (in.charAt(i) + ((encrypt) ? key : -key));
        }
        return new String(out);
    }
}
