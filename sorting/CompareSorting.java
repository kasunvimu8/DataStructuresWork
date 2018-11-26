/**************************************************
 * Simple sorting algorithms 
 * Modified by E/11/XXX
 **************************************************/
import java.util.Random;

class CompareSorting { 

	static int [] t;
	static int [] tmp;
	static int [] tmp1;

    static void bubble_sort(int [] data) { 

   	int doSwap=1;
	
	while(doSwap==1){

		doSwap=0;
	    	for(int i=0;i<t.length-1;i++){
	    		if(t[i]>t[i+1]){
	    				Swap(t,i,i+1);
	    				doSwap=1;

	    		}



	    	}

	    }

    }

    static void Swap(int [] data,int first,int second){
    	int k=data[first];
    	data[first]=data[second];
    	data[second]=k;

   }



    
    static void selection_sort(int [] data) {

    tmp=duplicate_array(data);
    	
    	for (int i = 0; i < tmp.length - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < tmp.length; j++){  
                if (tmp[j] < tmp[index]){  
                    index = j;  
                }  
            }  
            int smallerNumber = tmp[index];   
            tmp[index] = tmp[i];  
            tmp[i] = smallerNumber;  
        }  



    }

    static void insertion_sort(int [] data) { 

      tmp1=duplicate_array(data);	

    	 int i, key, j;
		   for (i = 1; i < tmp1.length; i++)
		   {
		       key =  tmp1[i];
		       j = i-1;

		      
		       while (j >= 0 && tmp1[j] > key)
		       {
		            tmp1[j+1] = tmp1[j];
		           j = j-1;
		       }
		       tmp1[j+1] = key;
		   }


    }


    // Helper functions 

    static int [] generate_data(int sizeOfData) { 
	/* create an array of sizeOfData and 
	 * populate with random integers betweem 0-1000
	 */

	int [] tmp = new int[sizeOfData];
	Random rand = new Random();
	for(int i=0; i < sizeOfData; i++)
	    tmp[i] = rand.nextInt(2*sizeOfData);
	return tmp; 
    }

    static int [] duplicate_array(int [] data) { 
	/* create a duplicate array of the given 
	 * useful when sending the same array to different 
	 * algorithms.
	 */
	int [] tmp = new int[data.length];
	for(int i=0; i< data.length; i++){
	    tmp[i] = data[i];
	}
	
	return tmp; 
    }

    static void show(int [] data) {
	System.out.printf("\n");
	for(int i=0; i < data.length; i++)
	    System.out.printf("%d %c", data[i],
			      i == (data.length - 1) ? ' ' : ',');
	System.out.printf("\n");
    }
    
    static void postCondition(int [] data) { 
	/* if sorted, for any i data[i] > data[i-1]
	 * Need to run this with java -ea CompareSorting
	 */
	int i; 
	for(i=1; i < data.length; i++) 
	    if(data[i] < data[i-1]) break; 

	assert i == data.length : "Sorting algorithm used is broken";
    }

    public static void main(String [] ar) {
	t = generate_data(30);
	//	postCondition(t); 

	//bubble_sort(t);
	//selection_sort(t);
	insertion_sort(t);

	show(tmp1); 
	//show(tmp); 
	//show(t);

    }
}

	   
