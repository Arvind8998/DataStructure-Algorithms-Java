
public class javaInstance{
    public int data;

    public javaInstance(){
        this.data = 0;
    }

    public static void main(String[] args){
        javaInstance obj = new javaInstance();
        if (javaInstance.class.isInstance(obj)) {
            System.out.println(" This is same obj type " + obj);
        } else {
            System.out.println("Not of same type");
        }
    }
}
