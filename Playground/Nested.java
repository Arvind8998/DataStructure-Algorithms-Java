public class Nested {
    public static class SuperPro {
        SuperPro() {
            System.out.println("-----> George ----");
        }

        public void hello() {
            System.out.print("Adsadsad");
        }
    }

    public static class inner extends SuperPro {
        inner() {
            super();
        }
    }

    public static void main(String[] args) {
        inner in = new inner();
        SuperPro.super.hello();
    }
}
