import java.util.Deque;
import java.util.LinkedList;

public class DequeTest {

    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<String>();
        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque);
        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
        System.out.println(deque);

//      用 add first 或 add last 这套新的 API 改写 Deque 的代码
        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");
        System.out.println(deque);
        String str1 = deque.peekLast();
        System.out.println(str1);
        System.out.println(deque);
        while(deque.size() > 0){
            System.out.println(deque.pollLast());
        }
        System.out.println(deque);
    }



}
