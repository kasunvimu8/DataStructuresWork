public class Node {

	int diameter;
	Node prev;
	Node next;

	public Node(int diameter){
		this.diameter=diameter;
		this.prev=null;
		this.next=null;
		}


	public void setNext(Node n){
		next =n;

	}

	public void setPrev(Node n){

		prev=n;
	}

}