package Ch4_4;

import java.util.Iterator;
import java.util.ListIterator;

public class KWLinkedList <E>{

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;


    // 왜 static?
    // object member가 아니라 class member다
    // 밖 클래스의 non static 멤버들을 access할 수 없게 한다
    //inner class
    private static class Node<T> {
        public T data;
        public Node<T> next;
        public Node<T> previous;

        public Node( T item ){
            data = item;
            next = null; 
        }
    }

    public Iterator<E> iterator(){
        return new KWListIterator( 0 );

    }

    public ListIterator<E> listiterator(){
        return new KWListIterator( 0 );
    }

    public ListIterator<E> listiterator( int index ){
        return new KWListIterator( index );
    }

    

    private class KWListIterator implements ListIterator<E>{


        // data member and constructor

        private Node<E> nextItem;   //refer the next node
        private Node<E> lastItemReturned;
        private int index;

        public KWListIterator( int i ){
            if( i < 0 || i > size ){
                throw new IndexOutOfBoundsException("Invalid index "+ i);
            }
            lastItemReturned = null;
            if( i == size ){
                index = size;
                nextItem = null;
            } else {
                nextItem = head;
                for( index = 0; index < i; index++ ){
                    nextItem = nextIem.next;
                }
            }

        }

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return nextItem != null;
        }

        @Override
        public E next() {
            // TODO Auto-generated method stub
            if(!hasNext())
                throw new NoSuchElmentException();

            lastItemReturned = nextItem;
            nextItem = nextItem.next;
            index++;

            return lastItemReturned.data;
        }

        @Override
        public boolean hasPrevious() {
            // TODO Auto-generated method stub
            return (nextItem == null && size != 0) || nextItem.previous != null;
        }

        @Override
        public E previous() {
            // TODO Auto-generated method stub
            if(!hasPrevious())
                throw new NoSuchElementException();
            if(nextItem == null) //Iterator past the last element
                nextItem = tail;
            else
                nextItem =  nextItem.previous;
            lastItemReturned = nextItem;
            index--;
            
            return lastItemReturned.data;
        }

        @Override
        public int nextIndex() {
            // TODO Auto-generated method stub
            return index;
        }

        @Override
        public int previousIndex() {
            // TODO Auto-generated method stub
            return index-1;
        }

        @Override
        public void remove() {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void set(E e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void add(E e) {
            if( head == null ){
                head = new Node<E>(e);
                tail = head;
            } else if( nextItem == head ){
                Node<E> newNode = new Node<E>(e);
                newNode.next = nextItem;
                nextItem.previous = newNode;
                head = newNode;
            } else if( nextItem == null ){
                Node<E> newNode = new Node<E>(e);
                tail.next = newNode;
                newNode.previous = tail;
                tail = newNode;

            } else{
                Node<E> newNode = new Node<E>(e);
                newNode.previous = nextItem.previous;
                nextItem.previous.next = newNode;
                newNode.next = nextItem;
                nextItem.previous = newNode;
            }
            size++; index++;
            
        }

    }

    public int indexOf( E item ){

    }
     
    public void add( int index, E item ){

    }

    public E get( int index ){

    }

    public boolean remove( int index ){

    }

    public void remove( E obj ){


    }

    public int size(){
        return size;
    }
    
}
