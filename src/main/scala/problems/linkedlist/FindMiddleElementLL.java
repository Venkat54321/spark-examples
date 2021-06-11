package problems.linkedlist;

public class FindMiddleElementLL {
    public static void main(String[] args) {

        LLNode head = new LLNode().create();

        findMiddle(head);

    }

    private static void findMiddle(LLNode head) {
        LLNode slow = head;
        LLNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.value);
    }
}
