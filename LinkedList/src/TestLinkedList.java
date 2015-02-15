/**
 * Created by irv on 1/30/15.
 */
public class TestLinkedList {
    public static void main (String[] args){
        System.out.println("***Start TestSuite***");
        SinglyLinkedList<Integer> testLinked = new SinglyLinkedList<Integer>();
        System.out.println("Populating List");
        testAppendAndDelete(testLinked);
        testRemoveDuplicates(testLinked);
        testRemoveDuplicatesNoBuffer(testLinked);
        findKthLastElement(testLinked);
    }

    public static void testAppendAndDelete(SinglyLinkedList<Integer> testLinked){
        System.out.println("\n***Test Delete***");
        populate(testLinked);

        testLinked.delete(1);
        assert(testLinked.toString().equals("[2, 3, 4, 5]"));

        testLinked.delete(5);
        assert(testLinked.toString().equals("[2, 3, 4]"));

        testLinked.delete(3);
        assert(testLinked.toString().equals("[2, 4]"));

        testLinked.delete(2);
        assert(testLinked.toString().equals("[4]"));

        testLinked.delete(4);
        assert(testLinked.toString().equals("[]"));

        testLinked.delete(4);
        assert(testLinked.toString().equals("[]"));
    }

    public static void testRemoveDuplicates(SinglyLinkedList<Integer> testLinked){
        System.out.println("\n***Test Remove Duplicates***");
        populate(testLinked);
        testLinked.appendToTail(1);
        testLinked.appendToTail(4);
        testLinked.appendToTail(4);
        testLinked.appendToTail(2);
        assert(testLinked.toString().equals("[1, 2, 3, 4, 5, 1, 4, 4, 2]"));

        testLinked.removeDuplicates();
        assert(testLinked.toString().equals("[1, 2, 3, 4, 5]"));
    }

    public static void testRemoveDuplicatesNoBuffer(SinglyLinkedList<Integer> testLinked){
        System.out.println("\n***Test Remove Duplicates No Buffer***");
        testLinked.appendToTail(1);
        testLinked.appendToTail(4);
        testLinked.appendToTail(4);
        testLinked.appendToTail(2);
        assert(testLinked.toString().equals("[1, 2, 3, 4, 5, 1, 4, 4, 2]"));

        testLinked.removeDuplicatesNoBuffer();
        assert(testLinked.toString().equals("[1, 2, 3, 4, 5]"));
    }

    public static void findKthLastElement(final SinglyLinkedList<Integer> testLinked){
        System.out.println("\n***Test Find Kth Last Element***");
        assert (testLinked.findKthLastElement(1).equals(5));
        assert (testLinked.findKthLastElement(2).equals(4));
        assert (testLinked.findKthLastElement(3).equals(3));
        assert (testLinked.findKthLastElement(4).equals(2));
        assert (testLinked.findKthLastElement(5).equals(1));
    }

    public static void populate(SinglyLinkedList<Integer> testLinked){
        testLinked.appendToTail(1);
        testLinked.appendToTail(2);
        testLinked.appendToTail(3);
        testLinked.appendToTail(4);
        testLinked.appendToTail(5);
        assert(testLinked.toString().equals("[1, 2, 3, 4, 5]"));
    }
}
