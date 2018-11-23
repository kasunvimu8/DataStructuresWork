/**
 * Created by user on 2/1/2018.
 */
public class objectList {
    String key;
    int value;
    objectList next= null;

    public objectList(String key){

        this.key=key;
        this.value=1;
        this.next=null;

    }

    public void setNextNode (objectList link){

    this.next=link;
    }

    public  objectList getNext(){

     return this.next;
    }

    public String getKey(){

      return this.key;
    }

    public int getValue(){

        return this.value;
    }

    public void count(){
    this.value++;

    }


}
