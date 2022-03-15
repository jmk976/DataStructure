package Ch3_1;

public class Notebook extends Computer {

    public double screenSize;
    public double weight;

    public Notebook( String man, String proc, int ram, int disk, double speed, double screen, double weight){
        //수퍼클래스의 생성자 호출
        super( man, proc, ram, disk, speed );
      
        screenSize = screen;
        this.weight = weight;
    }

// computer class로 부터 상속 받은 메소드를 덮어 쓰기 할 수 있다.
// -> 메소드 오버라이딩
    public String toString(){ // 데이터 출력용
        String result = super.toString() +
                        "\nScreenSize:: " +screenSize + " inches" + 
                        "\nWeight:: " +weight + " kg";
        return result;
    }

    public static void main(String[] args){
        Notebook test = new Notebook("Dell", "15", 4, 1000, 3.2, 15.6, 1.2);
      
        System.out.println( test.computerPower() );
        System.out.println( test.toString() ); // computer class로 부터 상속 받은 메소드
    }
}
