package Sec8_LinkedList;

import java.util.Arrays;


public class SinglyLinkedList {

    private  Node head;
    private Node tail;
    private int length;
    
    public SinglyLinkedList(int value){
        head = new Node(value);
        tail = head;
        length = 1;
    }

    public void append(int value){
        //새 노드를 꼬리에 붙이기
        Node newN = new Node(value);
        tail.next = newN;
        tail = newN;
        length++;

    }

    public void prepend(int value){
        //새 노드를 헤드에 붙이기
        Node newN = new Node(value);
        newN.next = head;
        head = newN;
        length++;

    }

    public int[] printList(){
        int[] myList = new int[length];
        Node current = this.head;
        int i = 0;
        while(current != null){
            myList[i] = current.value;
            current = current.next;
            i++;
        }
        return myList;
    }

    public void insert(int index, int value){

        if(index < 0 || index > length){
            System.err.println("Index out of bounds for length "+ length);

        } else if(index == 0){
            prepend(value);
        } else if(index == length){
            append(value);
        } else{
            Node current = head;
            for(int i = 0; i < index -1; i ++){
                current = current.next;
            }
            Node newNode = new Node(value);
            newNode.next = current.next;
            current.next = newNode;
            length++;
        }
      

    }
    
    public int getLength() {
        return length;
    }



    public void remove(int index){

        if(index < 0 || index > length){
            System.err.println("Index out of bounds for length "+ length);

        } else if(index == 0){
            head = this.head.next;
            length--;
        } else{
            Node current = head;
            int i;
            for(i = 0; i < index -1; i ++){
                current = current.next;
            }
          
           
            current.next = current.next.next;
            length--;
            if(i == length-1){
                tail = current;
            }
        }
      

    }

    public SinglyLinkedList reverse(SinglyLinkedList linkedList) {
        SinglyLinkedList newList = new SinglyLinkedList(linkedList.head.value);
        Node current = linkedList.head;
        while (current.next != null) {
            current = current.next;
            Node newNode = new Node(current.value);
            newNode.next = newList.head;
            newList.head = newNode;
            newList.length++;
        }
        return newList;
    }


    public static void main(String[] args) {
      

        SinglyLinkedList myLinkedList = new SinglyLinkedList(10);
        //append
        myLinkedList.append(12);
        myLinkedList.append(16);
        //prepend
        myLinkedList.prepend(20);
        myLinkedList.prepend(50);
        System.out.println("length: " + myLinkedList.getLength());
        System.out.println("list: " + Arrays.toString(myLinkedList.printList()));
        //insert
        myLinkedList.insert(2, 25);
        System.out.println("length: " + myLinkedList.getLength());
        System.out.println("list: " + Arrays.toString(myLinkedList.printList()));
        //remove
        myLinkedList.remove(4);
        System.out.println("length: " + myLinkedList.getLength());
        System.out.println("list: " + Arrays.toString(myLinkedList.printList()));
        //reverse
        SinglyLinkedList linkedList2 = myLinkedList.reverse(myLinkedList);
        System.out.println("reverse linkedList" + Arrays.toString(linkedList2.printList()));
    }


  
}
