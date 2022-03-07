package section2;

public class OrthoLine {//수직선
    public MyPoint2 u;  //한 쪽 끝점 (항상 수직선의 경우 위쪽, 수평선의 경우 왼쪽 으로 하기로 한다)
    public MyPoint2 v;  //다른쪽 끝점

    public OrthoLine( MyPoint2 p, MyPoint2 q)
    {
        u = p;
        v = q;
        if(p.x>q.x || p.x==q.x && p.y>q.y) // 수평선일때 x좌표 v가 더 크거나, 수직선일때 y좌표 v가 더 클때
            swap();
    }

    private void swap(){
        MyPoint2 tmp = u;
        u = v;
        v = tmp;
    }

    public OrthoLine( int x1, int y1, int x2, int y2 )
    {
        u = new MyPoint2(x1, y1);
        v = new MyPoint2(x2, y2);
    }

    public boolean isVertical()  // 수직인지 검사
    {
        return u.x == v.x;
    }

    public boolean intersects( OrthoLine other )
    {
        if( isVertical() && !other.isVertical() ){
            return ( other.u.x < u.x && other.v.x  > u.x && u.y < other.u.y && v.y > other.u.y );
        }
        else if ( !isVertical() && other.isVertical() ){
            return ( other.u.y < u.y && other.v.y > u.y && u.x < other.u.x && v.x > other.u.x );
        } 
        else 
            return false;


    }
    
}
