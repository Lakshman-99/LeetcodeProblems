import java.util.*;

public class My_Calendar_I {
    TreeMap<Integer, Integer> bookings;
    public My_Calendar_I() {
        bookings = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prevBook = bookings.floorKey(start);
        Integer nextBook = bookings.ceilingKey(start);
        if((prevBook==null || bookings.get(prevBook)<=start) && (nextBook==null || end<=nextBook))
        {
            bookings.put(start, end);
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        My_Calendar_I myCalendar = new My_Calendar_I();

        // Test the book method
        System.out.println(myCalendar.book(10, 20)); // Expected output: true
        System.out.println(myCalendar.book(15, 25)); // Expected output: false
        System.out.println(myCalendar.book(20, 30)); // Expected output: true
        System.out.println(myCalendar.book(80, 100));
        System.out.println(myCalendar.book(50, 60));
    }
}
