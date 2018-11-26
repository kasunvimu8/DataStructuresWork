#include "heap.h"
#include <stdio.h>
#include <stdlib.h>

int proper_heap(heap_t heap)
{
  /* just keep on removing.
   * if the heap was implmement correctly you should not 
   * remove an item larger than previous 
   */
  if(!heap)         return !printf("bad reference\n");
  if(isEmpty(heap)) return !printf("Empty heap\n");
  
  int pre = heap_remove(heap);
  while(!isEmpty(heap)) {

    int curr = heap_remove(heap);

    if(curr < pre) {return 0;

    }

  }

  return 1; // good work
}
    
  

int main()
{
  int i=0; 
  heap_t heap = create();
 // printf("%d\n",heap->curr_size);
  /*for(i=0;i< heap->curr_size ;i++){
    printf("%d\n",heap->data[i]);

  }*/
  
  for(i=0; i <5*SIZE; i++) {
    int tmp = rand() % 60;
   // printf("%d\t",tmp);
    insert(heap, tmp);
  }

 if(proper_heap(heap))
  printf("Congratulations, you implementation works\n");


//printf("%d\n",heap->curr_size);
  return 0;
}
