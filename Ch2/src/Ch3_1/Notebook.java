package Ch3_1;

public class Notebook extends Computer {

    public double screenSize;
    public double weight;

    public static void main(String[] args){
        Notebook test = new Notebook();
        test.manufacturer = "Dell";  //notebook class에는 없는 필드지만, 상속된 class에서 받아옴
        test.processor = "i5";
        test.ramSize = 4;
        test.diskSize = 1000;
        test.processorSpeed = 3.2;

        test.screenSize = 15.6;
        test.weight = 1.2;

        System.out.println( test.computerPower() );
    }


    
}
