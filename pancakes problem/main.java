import java.util.Random;
public class main{

	 public static void main(String [] args){
	 	int stackSize=0;
	 	Node maxNode,current;
	 	if(args.length!= 1){
	 		System.out.println("Invalid arguments..run  java main <n> ");
	 		System.exit(1);
	 	}
	 	else{

	 		stackSize=Integer.parseInt(args[0]);
	 	}

	 	 
                DoublyLinkList d =new DoublyLinkList();
                Random rand=new Random();

                for(int i=0;i< stackSize;i++){
                	 d.insertNode(rand.nextInt(50));
                }
               
                d.printListNodes();
                 System.out.println("");
                

               for(int j=0;j< stackSize;j++){

	                maxNode=d.findMaxNode(d,stackSize-j); //this will find the maximum length of pancakes , ignore the allready sorted ones(-j)
	              //	System.out.println(maxNode.diameter);

	                 d. reverse(d,maxNode); //get the max node to the head
	              
	               	current=d.getTail();
	                for(int k=0;k<j;k++){
	                	current=current.prev;
	                	

	                }

	                d.reverse(d,current);
	                	               
             	 }

             	 System.out.println(" ");
             	 System.out.println("-------- After sorting the pancakes--------");
             	 System.out.println(" ");
              d.printListNodes();

           }   



}