public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");
        Encaps i = new Encaps(5);
        System.out.println(i.getI());
        i.setI(7);
        System.out.println(i.getI());
    }
}
