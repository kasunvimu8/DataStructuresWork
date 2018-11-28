import java.util.*;
class Maze {
  static int mazeSize=3;
  
  static Stack<cordinate> stack = new Stack<cordinate>();


  private int [][] maze;
   public Maze() {
    int [][] tmp = {{0,0,0,1,1},
       {0,0,0,1,0},
       {0,0,0,0,1},
       {0,0,0,0,1},
       {1,0,0,0,0}};
    maze = tmp;
  }
    
  public void show() {
    for(int i=0; i < maze.length; i++) {
      System.out.printf("{");
      for(int j=0; j < maze[i].length; j++)
     System.out.printf("%d%s", maze[i][j],
          j != maze[i].length - 1 ? ", ": " }\n");
    }
  }


  public boolean findPath(int x, int y, int X, int Y) {
     if(x==X && y==Y){
      return true;

     }
      maze[x][y]=2;

      if(x+1 < maze[0].length && maze[x+1][y]==0 && findPath(x+1,y,X,Y)){

        stack.push(new cordinate(x,y));
       return true;
     }

       if(y+1 < maze.length && maze[x][y+1]==0 && findPath(x,y+1,X,Y)){
        stack.push(new cordinate(x,y));
       return true;
     }

     
     if(y-1 >0 && maze[x][y-1]==0 && findPath(x,y-1,X,Y)){
        stack.push(new cordinate(x,y));
       return true;
     }

      if (x-1 >0 && maze[x-1][y]==0 && findPath(x-1,y,X,Y)){
        stack.push(new cordinate(x,y));
       return true;
     }

     

    return false;
  }
//*/
    
  public void showPath(int x, int y, int X, int Y) {
     
  }


 
  public static void main(String [] args) {
     Maze m = new Maze();
     m.show();
     if(m.findPath(0,0, mazeSize, mazeSize)) {
       System.out.println("There is a path");
      
     }
     else{
      
      System.out.println("There is no path");

     }
     
  }
}



