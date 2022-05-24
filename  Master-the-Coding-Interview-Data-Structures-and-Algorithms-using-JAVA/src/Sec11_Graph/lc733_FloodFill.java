package Sec11_Graph;

public class lc733_FloodFill {

    //Approach #1
    //https://kkokkoma-dev.tistory.com/137

    private int before;
    private int lengthOfSr;
    private int lengthOfSc;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor){
        before = image[sr][sc];
        lengthOfSr = image.length -1;
        lengthOfSc = image[0].length -1;
        dfs(image, newColor, sr, sc);
        return image;
    }

    private void dfs(int[][] image, int newColor, int sr, int sc){
        if(sr<0 || sc<0 || sr>lengthOfSr || sc>lengthOfSc || image[sr][sc] != before || image[sr][sc] == newColor){
            return;
        }
        image[sr][sc] = newColor;
        dfs(image, newColor, sr-1, sc);
        dfs(image, newColor, sr, sc-1);
        dfs(image, newColor, sr+1, sc);
        dfs(image, newColor, sr, sc+1);
    }


    //Approach #2: Depth-First Search [Accepted]  from Leetcode

    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor ){
        int color = image[sr][sr];
        if(color != newColor) dfs2(image, sr, sc, color, newColor);
        return image;
        
    }

    public void dfs2(int[][] image, int r, int c, int color, int newColor ){
        if(image[r][c] == color){
            image[r][c] = newColor;
            if(r >= 1) dfs2(image, r-1, c, color, newColor);
            if(c >= 1) dfs2(image, r, c-1, color, newColor);
            if(r+1 < image.length) dfs2(image, r+1, c, color, newColor);
            if(c+1 < image[0].length) dfs2(image, r, c+1, color, newColor);
        }
    }

    //Approach #3
    //https://ifuwanna.tistory.com/321

    private final int[][] DIRECTIONS = new int[][]{{-1,0},{0,1},{1,0},{0,-1}}; 

    public int[][] floodFill3(int[][] image, int sr, int sc, int newColor) {

        if (image[sr][sc] != newColor) { // 같은 값이면 결과 변함없음. 실행하면 서로 계속 전파해서 SOF 발생
            dfs3(image, sr, sc, image[sr][sc], newColor);
        }
        return image;
    }
    
    public void dfs3(int[][] image, int sr, int sc, int color, int newColor){
        if(sr >= 0 && sr < image.length  && sc >= 0 && sc < image[0].length ){
            int currentColor = image[sr][sc];
            if(currentColor == color){ // 현재 컬러가 전달받은 바꾸기 전 컬러와 같으면 새로운 컬러로 채워넣고 4방향 전파
                image[sr][sc] = newColor;
                for(int[] d : DIRECTIONS){ // 시계방향 전파
                    dfs3(image,sr+d[0],sc+d[1],color,newColor);
                }
            }
        }
    }

    public static void main(String[] args){
        lc733_FloodFill a = new lc733_FloodFill();
        int[][] image ={{1,1,1},{1,1,0},{1,0,1}};

        a.floodFill( image, 1, 1, 2);
        for(int i =0; i < 3; i++){
            for(int j =0; j < 3; j++){
                System.out.println(image[i][j]);

            }

        }
        
        System.out.println("hi");

    }
    
}
