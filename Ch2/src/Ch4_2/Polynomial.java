package Ch4_2;

import Ch4_1.MySingleLinkedList;
import Ch4_1.Node;

public class Polynomial {

    public char name;
    public MySingleLinkedList<Term> terms;

    public Polynomial( char name ){
        this.name = name;
        terms = new MySingleLinkedList<Term>();
    }

    // 기존의 다항식에 새로운 항을 추가하는 메서드
    public void addTerm( int coef, int expo ){
        if( coef == 0 )
            return;


        Node<Term> p = terms.head, q = null;
        while( p != null && p.data.expo > expo ){
            q = p;
            p = p.next;
        }

        if( p != null && p.data.expo == expo ) { // 내가 추가 하려는 차수가 이 차수와 동일 할때
            p.data.coef += coef;  //계수를 더해주기
            if(p.data.coef == 0){  //계수를 더했더니 0 이 될때 삭제 해주기
                //remove this node p
                if( q == null) //삭제해야할 노드가 첫번째 노드라면 removeFirst 
                    terms.removeFirst();
                else
                    terms.removeAfter(q);
            }
        }
        else { // add after q  // 내가 추가 하려는 차수와 동일한 차수가 없을 때
            Term t = new Term( coef, expo );
            if( q == null )
                terms.addFirst( t );
            else
                terms.addAfter(q, t) ;

        }

    }

    public int calc( int x ){
        int result = 0;
        
        Node<Term> p = terms.head;
        while( p != null ){
            result += p.data.calc( x );
            p = p.next;
        }
        return result;
    }

    public String toString() {
        String result = "";
        Node<Term> p = terms.head;
        while( p != null ) {
            result += ("+" + p.data.toString() ) ;
            p = p.next;
        }

        return result;

    }






    public static void main(String[] args){

    }
    
}
