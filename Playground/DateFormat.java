import java.util.Date;

public class DateFormat {
    public static Long timeStamp = 1636203357L;
    public static Date time = new java.util.Date((long)timeStamp*1000);
    public static void main(String[] args){
        System.out.println("Date is" + time);
    }

}
