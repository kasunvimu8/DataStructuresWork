import java.io.*;
import java.util.Stack;
import java.util.EmptyStackException;

public class lab{

public static int legalMove(Stack A, Stack B) {
	int a,b;
		try{
	a=Integer.parseInt(A.peek().toString());
	}

	catch(EmptyStackException e){
	a=0;
	}

	try{
	b=Integer.parseInt(B.peek().toString());
	}

	catch(EmptyStackException e){
	b=0;
	}

	if(a==b) return 0;

					if(a == 0)             // If peg A is empty, then pop from B and push the disk onto A
			{
					A.push(B.pop());
							return 2;           // Return 2 as move occurred from B to A
			}
					else if(b == 0 )        // If peg B is empty, then pop from A and push the disk onto B
					{
					B.push(A.pop());
					return 1;           // Return 1 since move occurred from A to B
			}

					if(a<b)
					{
					B.push(A.pop());
					return 1;               // Return 1 since move occurred from A to B
					}
					else if(a > b)            // value of top disk of peg A is greater than the value of topmost disk of peg B
					{
					A.push(B.pop());
					return 2;               // Return 2 since move occurred from B to A
					}
					return -1;
			}

			public static boolean isOdd(int n){
			if(n%2==1) return true;
			return false;
			}

			public static void main(String[] args) {
				if(args.length !=4){
					System.out.println("Enter the aragument like this :");
					System.out.println("java javafile disksNumber from to via");
					System.exit(1);
				}

				int n=Integer.parseInt(args[0]);
				if(n<0){
					System.out.println("Sorry wrong input, enter postive number");
					System.exit(1);

				}

				String first =args[1];
				String middle =args[2];
				String last =args[3];
   			int stepNumber = 0;
	         int status = 0;
	         try {
						 	Stack first1 = new Stack();
				 			Stack middle2 = new Stack();
				 			Stack last3 = new Stack();

				 		/*	System.out.println("Enter the number of disks : ");
				 			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
				 			int n = Integer.parseInt(input.readLine()); */
				 			if(n<=0)
				 			{
				 				System.out.println("Sorry wrong input, enter postive number.");
				 				System.exit(1);
				 			}
				 			for(int i=n; i>0; i--)
				 				first1.push(i);

				 			do {
				 				if(isOdd(n))
				 				{
			           if((status = legalMove(first1,last3)) == 1)
				                     System.out.println((++stepNumber) + ". "+ first +" -->"+ last);
				                 else if (status == 2)
				                     System.out.println((++stepNumber) + ". "+ last +" -->"+ first);

				                 if((status = legalMove(first1,middle2)) == 1)
				                     System.out.println((++stepNumber)+ ". "+ first +" -->"+ middle);
				                 else if(status == 2)
				                     System.out.println((++stepNumber) + ". "+ middle +" -->"+ first);
				                 else
				                     break;
				 				}

				 				else
				 				{

				 					if((status = legalMove(first1,middle2)) == 1)
				 						System.out.println((++stepNumber) + ". "+ first +" -->"+ middle);
				 					else if (status == 2)
				 						System.out.println((++stepNumber) + ". "+ middle +" -->"+ first);

				 					if((status = legalMove(first1,last3)) == 1)
				 						System.out.println((++stepNumber) + ". "+ first +" -->"+ last);
				 					else if(status == 2)
				 						System.out.println((++stepNumber) + ". "+ last +" -->"+ first);

				 				}

				 				if((status = legalMove(middle2,last3)) == 1)
				 					System.out.println((++stepNumber) + "."+ middle+" -->"+ last);
				 				else if(status == 2)
				 					System.out.println((++stepNumber) + "."+ last +" -->"+ middle);

				 				}

				 			while(last3.size()!=n);
				 		   }

	         catch (Exception e){
	         }
	         }

}
