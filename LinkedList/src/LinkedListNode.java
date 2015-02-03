/**
 * Created by irv on 1/30/15.
 */
public class LinkedListNode {
    private LinkedListNode next = null;
    private int data;

    public LinkedListNode(int data){
        this.data = data;
    }

    public void appendToTail(int data) {
        LinkedListNode new_node = new LinkedListNode(data);
        LinkedListNode current_node = this;
        while(current_node.next != null)
            current_node = current_node.next;
        current_node.next = new_node;
    }

    public void print(){
        StringBuffer buff = new StringBuffer();
        buff.append('[');
        LinkedListNode current = this;
        while(current.next != null){
            buff.append(current.data);
            if(current.next != null)
                buff.append(", ");
            current = current.next;
        }
        buff.append(current.data);
        buff.append(']');
        System.out.println(buff.toString());
    }
}