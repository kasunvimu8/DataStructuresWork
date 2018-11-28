 public class DoublyLinkList {

        private Node head;
        private Node tail;
        public int size;
        
        public DoublyLinkList(){
                this.size = 0;
                this.head = null;
                this.tail = null;
        }

        public int getsize(){
            return this.size;
       }
       public Node getTail(){
            return this.tail;
       }

             
                public void insertNode(int diameter) {

                        Node node = new Node(diameter);
                        node.next = null;


                        if (this.head == null) {  // from linkedlist object
                                this.head = node;
                                this.tail = node;
                                this.tail.next = null;
                                this.tail.prev = null;
                                this.size = 1;
                        } else {
                                this.tail.next = node;
                                node.prev = tail;
                                this.tail= node;
                                this.size++;
                        }

                }

         public void printListNodes() {
            if (this.size < 1)
                System.out.println("There are no Nodes in the Doubly linked list");
            else {
                Node current = this.head;
                for (int i = 0; i < this.size; i++) {
                    if(current.prev == null)
                        System.out.println("Node " + current.diameter + " is at location " + i + " : Previous Node: null : Next Node: "+current.next.diameter);
                    else if(current.next == null)
                        System.out.println("Node " + current.diameter + " is at location " + i + " : Previous Node: "+current.prev.diameter + " : Next Node: null");
                    else System.out.println("Node " + current.diameter + " is at location " + i + " : Previous Node: "+current.prev.diameter + " : Next Node: "+current.next.diameter);
                    current = current.next;
                }
                System.out.println("Head: "+ this.head.diameter + " and Tail:"+ this.tail.diameter);
            }
        }

      
        public Node findMaxNode(DoublyLinkList list ,int len){
             Node current = list.head;
             Node maxNode =null;
             int maxDiameter=0;

             if(len ==1 ){
               return head;
             }

                for (int i = 0; i <len; i++) {

                    if(current.diameter>maxDiameter){
                        maxDiameter=current.diameter;
                        maxNode=current;

                    }

                    current=current.next;
                }


        return maxNode;
        }


        public void reverse (DoublyLinkList list,Node reverseNode){

             Node current = list.head,firstNode, secondNode;
             int numberOfRun,count=1;
             
             while(current != reverseNode){
                 count++;
                 current=current.next;   

                }

            firstNode = list.head;
            secondNode = reverseNode;
            numberOfRun = count/ 2; 
           
            int temp; // This will be used in the swapping 2 diameters
            for (int i=0; i < numberOfRun; i++){
            
                // Swap the objects by using a 3rd temporary variable
                temp = firstNode.diameter;
                firstNode.diameter= secondNode.diameter;
                secondNode.diameter = temp;

                // Hop to the next node from the beginning and previous node from the end
                firstNode = firstNode.next;
                secondNode = secondNode.prev;

                        
            }

            
    }



}