package section3;

public class Term3 {
    public int coef; //계수
    private int expo; //차수 

    public Term3(int c, int e){
        coef = c;
        expo = e;
    }

    public int getExpo(){  //getter method
        return expo;
    }

    public int getCoef(){  //getter method, accessor
        return coef;
    }

    public int setCoef(int coef){  //setter method, mutator
        return coef;
    }
    
    public int calcTerm(int x){
        return (int) (coef * Math.pow(x, expo));
    }

    public void printTerm(){
        System.out.print( coef + "x^"+ expo);
    }
    
}
