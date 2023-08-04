public class Main {
    public static void main(String[] args) {
        HoorayList<String> words = new HoorayList<>();

        System.out.println(words);

        words.add("Aloha");
        words.add("Goodbye");
        System.out.println(words);

        words.add(0,"Hola");
        words.add(0,"Hello");

        System.out.println(words);

        words.remove("Goodbye");

        System.out.println(words);

        words.remove(0);

        System.out.println(words);

        words.set(1, "Adios");

        System.out.println(words);
    }
}