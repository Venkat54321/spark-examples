package problems.linkedlist;

public class LLNode {
    int value;
    LLNode next;

    public LLNode(int value) {
        this.value = value;
        this.next = null;
    }

    public LLNode() {
    }



    public LLNode create(){
        LLNode one = new LLNode(1);
        LLNode two = new LLNode(2);
        LLNode three = new LLNode(3);
        LLNode four = new LLNode(4);
        LLNode five = new LLNode(5);
        LLNode six = new LLNode(6);
        LLNode seven = new LLNode(7);
        LLNode eight = new LLNode(8);
        LLNode nine = new LLNode(9);
        LLNode ten = new LLNode(10);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;
        eight.next = nine;
        nine.next = ten;

        return one;
    }

    public LLNode createCycle(){
        LLNode one = new LLNode(1);
        LLNode two = new LLNode(2);
        LLNode three = new LLNode(3);
        LLNode four = new LLNode(4);
        LLNode five = new LLNode(5);
        LLNode six = new LLNode(6);
        LLNode seven = new LLNode(7);
        LLNode eight = new LLNode(8);
        LLNode nine = new LLNode(9);
        LLNode ten = new LLNode(10);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;
        eight.next = nine;
        nine.next = four;

        return one;
    }

}
