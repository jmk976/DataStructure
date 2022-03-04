package section2;

public class Polynomial2 {
    public char name;
    public Term2 [] terms;
    public int nTerms = 0;

    public int calcPolynomial( int x ){
        int result =0;
        for(int i =0; i<nTerms; i++){
            result += terms[i].calcTerm(x);
        }
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
