package section2;

public class MyRectangle2 {
    public MyPoint2 lu;
    public int width;
    public int height;

    public MyRectangle2(int x, int y, int  w, int h){
        lu = new MyPoint2( x, y );
     
        width = w;
        height = h;
    }

    public MyRectangle2( MyPoint2 p, int  w, int h){
        lu = p;
     
        width = w;
        height = h;
    }

    public int calcArea()  // code09에서 이 메서드를 가져와 파라미터의 MyRectangle2 r는 자기자신이기 때문에 지워준다
    {
        return width * height;
    } 

    public String toString(){  // toString 메소드는 특별
        return "("+ lu.x + ", " + lu.y +") " + width + " " + height;
    }

    
}
