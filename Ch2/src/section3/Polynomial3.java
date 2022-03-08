package section3;

public class Polynomial3 {
    private char name; // 다항식의 이름
    private Term3 [] terms; //항들의 집합, 배열
    private int nTerms; //항의 갯수

    public Polynomial3(){
        nTerms =0;
        terms = new Term3[100];

    }

    public Polynomial3( char name ){
        this.name = name; //이 개체의  name => this.name
        nTerms =0;
        terms = new Term3[100];

    }

    public char getName(){
        return name;
    }


    public void addTerm(  int c, int e ){
        int index = findTerm( e );
        if (index != -1){
            terms[index].setCoef(terms[index].getCoef() +c); // -5x^3    + 5x^3
        }
        else {
            int i = nTerms-1;
            while ( i >= 0 && terms[i].getExpo() < e ){
                terms[i+1] = terms[i];
                i --;
            }
            terms[i+1] = new Term3(c, e);
           
            nTerms++;
        }

    }

    private int findTerm( int e ) {
        for(int i = 0; i < nTerms && terms[i].getExpo() >=e; i++){
            if(terms[i].getExpo() ==e){
                return i;
            }
        }
        return -1;
    }

    public int calcPolynomial( int x ){
        int result =0;
        for(int i =0; i<nTerms; i++)
            result += terms[i].calcTerm(x);
        return result;
    }

    public void printPolynomial(){
        for(int i=0; i < nTerms; i++){
            terms[i].printTerm();
            System.out.print("+");
        }
        System.out.println();
    }

    
}
