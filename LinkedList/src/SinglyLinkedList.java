import sun.awt.image.ImageWatched;

import java.util.HashMap;

/**
 * Created by irv on 1/30/15.
 */
public class SinglyLinkedList<T extends Number> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SinglyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public void appendToTail(T data){
        Node<T> new_node = new Node<T>(data);

        // check to see if head is empty
        if (head == null){
            head = new_node;
            tail = new_node;
        }
        else{
            tail.next = new_node;
            tail = new_node;
        }
        size++;
    }

    public boolean delete(T data){
        // linked list is empty
        if(size == 0)
            return false;

        // only one node in list
        if(size == 1 && head.data == data){
            head = null;
            tail = null;
            size = 0;
            return true;
        }


        // it's the first element in the list
        if(head.data == data) {
            head = head.next;
            size--;
            return true;
        }

        // have to search for the node
        Node<T> current = head.next; // we know it's not the first element
        Node<T> prev = head;
        while(current != tail){
            if(current.data == data){
                prev.next = current.next;
                --size;
                return true;
            }
            current = current.next;
            prev = prev.next;
        }

        // check if it was tail
        if(tail.data == data){
            prev.next = null;
            tail = prev;
            size --;
            return true;
        }
        return false;
    }

    public int size (){
        return this.size;
    }

    public void removeDuplicates(){
        HashMap hash = new HashMap();
        Node current = head.next; // the head can't be a duplicate
        hash.put(head.data, true); // need to make sure head is in hashmap
        Node prev = head;

        while(current != tail){ // iterate to the tail
            if(hash.containsKey(current.data)){
                // if hashmap contains, it's a duplicate
                prev.next = current.next;
                current = prev.next;
                --size;
            }
            else {
                hash.put(current.data, true);
                current = current.next;
                prev = prev.next;
            }
        }

        // check if the tail is a duplicate
        if(hash.containsKey(current.data)) {
            prev.next = null;
            tail = prev;
            --size;
        }
    }

    public void removeDuplicatesNoBuffer(){
        Node current = head;

        while(current != tail){
            Node prev = current;
            Node runner = current.next;
            while(runner != null){
                if(current.data == runner.data){
                    prev.next = runner.next;
                    // check the tail
                    if(runner == tail)
                        tail = prev;
                    --size;
                    runner = prev.next; // reset the runner
                }
                else {
                    runner = runner.next;
                    prev = prev.next;
                }
            }
            current = current.next;
        }
    }

    public T findKthLastElement(final int k_index){
        // 1 = last element, 2 = 2nd to last element, so on...
        if (k_index < 0 || k_index > size)
            return null;
        if (k_index == 1)
            return tail.data;

        // have to search for the element
        Node<T> current = head;
        int list_index = size;

        while(current != tail){
            if(list_index == k_index)
                return current.data;
            else{
                --list_index;
                current = current.next;
            }
        }

        return null; // an error happened
    }

    public void clear(){
        size = 0;
        head = null;
        tail = null;
    }

    public void print(){
        Node<T> current = head;
        StringBuffer buff = new StringBuffer();
        if(size == 0)
            buff.append("[]");
        else{
            buff.append('[');
            while (current != tail){
                buff.append(current.data + ", ");
                current = current.next;
            }
            // append the element in tail
            buff.append(tail.data);
            buff.append(']');
        }
        System.out.println(buff.toString());
    }

    @Override
    public String toString(){
        Node<T> current = head;
        StringBuffer buff = new StringBuffer();
        if(size == 0)
            buff.append("[]");
        else{
            buff.append('[');
            while (current != tail){
                buff.append(current.data + ", ");
                current = current.next;
            }
            // append the element in tail
            buff.append(tail.data);
            buff.append(']');
        }
        return buff.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof SinglyLinkedList))
            return false;
        if (obj == this)
            return true;

        SinglyLinkedList lhs = (SinglyLinkedList) obj;
        if(this.size() != lhs.size)
            return false;

        Node rhsNode = head;
        Node lhsNode = lhs.head;

        // loop through the linked list
        while(rhsNode != null){
            if(rhsNode.data != lhsNode.data)
                return false;
            rhsNode = rhsNode.next;
            lhsNode = lhsNode.next;
        }

        return true;
    }
}

class Node<T extends Number> {
    T data;
    Node<T> next = null;

    public Node(T data) {
        this.data = data;
    }
}
