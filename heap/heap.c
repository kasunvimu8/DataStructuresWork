#include "heap.h"
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

#define IMPLEMENT_ME							\
  printf("you need to implement %s function in %s\n",__func__, __FILE__);	\
  exit(-1);

/**
 * Note: typically, in C functions/variables that starts with 
 * __ are local and should not be used unless you really know what you
 * are doing. For example __start 
 */
int __isFull(heap_t heap)
{
  return (heap -> next  == heap -> curr_size);
}

void __resize_heap(heap_t heap)
{
  //IMPLEMENT_ME; 
int * tmp = (int *)malloc((heap->curr_size + INCREASE_BY) *sizeof(int));
int index = 0;

  while( index < heap->curr_size ){
    tmp[index] = heap->data[index];
    index++;
  }

  heap->data = tmp;
  heap->curr_size = heap->curr_size + INCREASE_BY;
}

void __swap(heap_t heap, int i, int j)
{
  int tmp = heap -> data[i];
  heap -> data[i] = heap -> data[j];
  heap -> data[j] = tmp;
}

int isEmpty(heap_t heap)
{
  return (heap -> next == 0);
}

heap_t create()
{ 
 // IMPLEMENT_ME; 
  heap_t heap=(heap_t)malloc (sizeof(heap_t));
  heap->data =(int *)malloc(SIZE *sizeof(int));
  heap->next=0;
  heap->curr_size=SIZE;

  return heap;
}

void checkingHeap(heap_t heap,int index){
  
  
    int  r=2*index+1;//right child
    int  l=2*index+2;//left child 
    static int min,j=1;

      if(l<=SIZE-1 && (heap->data[l]) < (heap->data[index]) ){
        min=l;

      }
      else{
        min=index;

      }

      if(r<=SIZE-1 && (heap->data[r]) < (heap->data[min])){
        min=r;
      }

      if(min!=index){

        __swap(heap,index,min);
        
        checkingHeap(heap,min);
      }

}


 
void insert(heap_t heap, int data)
{

//if heap full then resize that
  if(__isFull(heap)){
    __resize_heap(heap);  
  } 

  int next = heap->next;
  heap -> data[next] = data;

  int parent = (int)(next-1)/2;
  
  //swap element untill lager element come to child position
  while ( heap->data[next] < heap->data[parent]){
    __swap(heap,parent,next);
    next = parent;
    parent = (next - 1)/2;  
  }
  heap -> next = (heap -> next) + 1;



}


int heap_remove(heap_t heap)
{
  int rem = heap -> data[0];//get root element 
  int count = 0;
  int childRight = 2*(count+1);
  int childLeft = childRight-1;

  if(!isEmpty(heap)){
    
    heap -> data[0] = heap -> data[heap->next-1];

    while( heap->next > count){
      
      if( heap->data[childRight] < heap->data[childLeft]){
        __swap(heap,count,childRight);
        count = childRight;      
      }
      else{
        __swap(heap,count,childLeft);
        count = childLeft;
      }

      childRight = 2*(count+1);
      childLeft = childRight-1;
    }
  heap->next = heap->next - 1;
    }

  return rem;
}
  