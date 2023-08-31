public class Resolution {
    public static interface A {
        default void hello() {
            System.out.println("Hello from A");
        }
    }

    public  interface B  extends A{
        default void hello() {
            System.out.println("Hello from B");
        }
    }

    public interface C extends A  {
        default void hello() {
            System.out.println("Hello from C");
        }
    }

    public static class D implements B,C  {
    }

    public static void main(String... args) {
        new D().hello();
    }
}
