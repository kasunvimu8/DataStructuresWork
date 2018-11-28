
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Maze {
    
    Random rand = new Random();

    private int [][] maze;
    public static Map <Integer,Cordinates> path = new HashMap <> ();
    public static int n=0;

    public Maze() {
	int [][] tmp = {{0,0,1,1,1},
			{1,0,1,0,0},
			{0,0,0,1,0},
			{0,0,0,0,1},
			{1,0,1,0,0}};
	maze = tmp;
    }
    
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
    
    public void printPath(){
        int count=1;
        for(int key:path.keySet()){
            System.out.println("step"+count+"-->"+"("+path.get(key).getX()+","+path.get(key).getY()+") ");
            count++;
        }
      
        System.out.println();
    }

    public void showPath(int x, int y, int X, int Y) {
        
        if(x==X && y ==Y) {
          
            path.put(++n,new Cordinates(x,y));
            printPath();
            return ;
        }
        
    	maze[x][y] = 3;
        path.put(++n,new Cordinates(y,x));

    	if(x-1>0 && maze[x-1][y]==2 ) {
            showPath(x-1,y,X,Y);
        }
    	if(y-1>0 && maze[x][y-1]==2 ) {
            showPath(x,y-1,X,Y);
        }
    	if(x+1<=X && maze[x+1][y]==2) {
            showPath(x+1,y,X,Y);
        }
    	if(y+1<=Y && maze[x][y+1]==2) {
            showPath(x,y+1,X,Y);
        }
        path.remove(n);
        n--;
    }
    
    public static void main(String [] args) {
	Maze m = new Maze();
	m.show();
	if(m.findPath(0,0, 4, 4)) {        
	    System.out.println("There is a path");
	    m.showPath(0,0,4,4);
	}
	else
	    System.out.println("There is no path");
    //m.show();
     }


}

