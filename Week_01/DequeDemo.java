import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Jiawei Zhang
 * 4/18/2020
 * 11:26 PM
 */
public class DequeDemo {

    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");

        System.out.println(deque);

        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.pollFirst());
        }
        System.out.println(deque);

    }


}
