
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Maze {
    
    Random rand = new Random();

    public static int [][] maze;
    public static Map <Integer,Cordinates> path = new HashMap <> ();
    public static int n=0;

        
    public int[][] Maze20(){
        int [][] tmp = new int [20][20];
        for(int i =0;i<20;i++){
            for (int j =0;j<20;j++){
                tmp[i][j] = rand.nextInt(50)%2;
            }
        }
        tmp[0][0] = 0;
        tmp[19][19] = 0;
        maze = tmp;
        return maze;
    }

    public void show() {
    for(int i=0; i < maze.length; i++) {
        System.out.printf("{");
        for(int j=0; j < maze[i].length; j++)
        System.out.printf("%d%s", maze[i][j],
               j != maze[i].length - 1 ? ", ": " }\n");
    }
    }
    
    public void clearPath(){
        for(int i=0; i < maze.length; i++) {
        for(int j=0; j < maze[i].length; j++)
        if(maze[i][j]==2) maze[i][j] = 0;
    }
    }


    public boolean findPath(int x, int y, int X, int Y) {

        if(x==X && y ==Y) {
           
            maze[x][y] = 2;
            return true;
        }
        
        maze[x][y] = 2;

        if(x-1>0 && maze[x-1][y]==0 && findPath(x-1,y,X,Y)) return true;
        if(y-1>0 && maze[x][y-1]==0 && findPath(x,y-1,X,Y)) return true;
        if(x+1<=X && maze[x+1][y]==0 && findPath(x+1,y,X,Y)) return true;
        if(y+1<=Y && maze[x][y+1]==0 && findPath(x,y+1,X,Y)) return true;

    return false;
    }
    
    
    public static void main(String [] args) {
        float yes=0;
        float no=0;
        for(int in=10;in<=1000000000;in*=10){
            float Average=0;

            for(int j=0;j<10;j++){

                for(int i=0;i<100;i++){

                   Maze m = new Maze();
                     maze=m.Maze20();
                     if(m.findPath(0,0, 19, 19)) {        
                      // System.out.println("There is a path");
                         yes++;
                                  
                     }
                     else{
                         // System.out.println("There is no path");
                         no++;
                     }       

                }

                Average=Average+100*yes/(no+yes);

            } 

              System.out.println("Average probability (out of "+ in +" mazes & 10 samples):"+Average/10+"%");          
        }
    }
}

