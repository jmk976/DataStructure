package Ch4_1;

public class MySingleLinkedList<T> {

    //첫번째 노드 주소
    public Node<T> head;
    public int size;

    public MySingleLinkedList() {
        head = null;
        size = 0;
    }

    public void addFirst( T item ){
        Node<T> newNode = new Node<T>(item);     // T: type parameter
        newNode.next = head;
        head = newNode;
        size++;

      //  Node<T> [] arr = new Node<T> [100];  //not ok
      // T t = new T() // not ok
    }

    public void addAfter( Node<T> before, T item ){
        Node<T> tmp = new Node<T>( item );
        tmp.next = before.next;
        before.next = tmp;

        size++;
    }
    //addBefore은 구현하기 간단하지 않다.. add한것 before의 자리를 알아내기 위해 첫번째 자리부터 검색해가야한다

    public void add( int index, T item ){   // insert
        if( index < 0 || index > size)
            return;
        if ( index == 0)
            addFirst( item );
        else{
            Node<T> q = getNode(index-1);
            addAfter( q, item );
        }
    }

    public T removeFirst(){
        if(head == null){
            return null;
        }
        T temp = head.data;
        head = head.next;
        size--;

        return temp;
    }

    public T removeAfter( Node<T> before ){
        if( before.next == null){
            return null;
        }
        T temp = before.next.data;
        before.next = before.next.next;

        return temp;
    }
    

    public T remove( int index ){   // delete
        if( index < 0 || index >= size )
            return null;
        if( index == 0 )
            return removeFirst();
        Node<T> prev = getNode( index-1 );
        return removeAfter( prev );
    }

    public T remove( T item ){   // delete
        Node<T> p = head; 
        Node<T> q = null;
        while( p!= null && !p.data.equals( item )){
            q = p;
            p = p.next;
        }
        if( p == null )
            return null;
        if( q == null )
            return removeFirst();
        return removeAfter(q);  
      }


    public int indexOf( T item ){  // search
        Node<T> p = head; //첫번째 노드 가리키기
        int index = 0;
        while ( p!=null ){
            if(p.data.equals(item)){
                return index;
            }
            p = p.next;
            index++;
        }
        return -1;
    }
    
    public Node<T> getNode( int index ){
        if (index < 0 || index >= size){
            return null;
        }
        Node<T> p = head;
        for(int i=0; i<index; i++){
            p = p.next;
        }
        return p; 
    }

    public T get( int index ){
        if (index < 0 || index >= size){
            return null;
        }
        // Node<T> p = head;
        // for(int i=0; i<index; i++){
        //     p = p.next;
        // }
        // return p.data; 
      return getNode(index).data;
    }

    public static void main(String[] args){
        MySingleLinkedList<String> list = new MySingleLinkedList<String>();

        list.add(0, "Saturday");
        list.add(1, "Friday");
        list.add(0, "Monday");
        list.add(2, "Tuesday");

        String str = list.get(2);
        list.remove(2);
        int pos = list.indexOf("Friday");

    }
}
