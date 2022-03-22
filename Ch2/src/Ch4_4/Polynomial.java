package Ch4_4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;


public class Polynomial {

    public char name;
    public LinkedList<Term> terms;

    public Polynomial( char name ){
        this.name = name;
        terms = new LinkedList<Term>();
    }

    // 기존의 다항식에 새로운 항을 추가하는 메서드
    public void addTerm( int coef, int expo ){
        if( coef == 0 )
            return;

        ListIterator<Term> iter = terms.listIterator();
        while(iter.hasNext()){
            Term t = iter.next();
            if(t.expo == expo ){
                t.coef += coef;
                if(t.coef ==0 ){
                    iter.remove();
                }
                return;
            }
            else if(t.expo < expo ){
                iter.previous();
                iter.add( new Term(coef, expo));
                return;
            }
        }
        iter.add( new Term(coef, expo));

    }

    public int calc( int x ){
        int result = 0;
        
        // //다형성 + 인터페이스 개념이 들어감.
        // Iterator<Term> iter = terms.iterator();
        // while(iter.hasNext()){
        //     Term t = iter.next();
        //     result += t.calc(x);
        // }

    //enhanced for문 으로 바꾸기
        for(Term t : terms)
            result += t.calc(x);
        
        return result;
    }

    public String toString() {
        String result = "";
        Iterator<Term> iter = terms.iterator();
        while(iter.hasNext()){
            Term t = iter.next();
            result += ("+" + t.toString() ) ;
        }

        return result;

    }


    public static void main(String[] args){

    }
    
}

