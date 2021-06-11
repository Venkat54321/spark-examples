package problems.linkedlist;

public class CheckCycleInLL {

    public static void main(String[] args) {
        LLNode head = new LLNode().createCycle();
        boolean isCycle =  checkCycle(head);
        System.out.println(isCycle);
    }

    private static boolean checkCycle(LLNode head) {
        LLNode slow = head;
        LLNode fast = head;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }
        System.out.println(slow.value);
        return false;

    }
}
