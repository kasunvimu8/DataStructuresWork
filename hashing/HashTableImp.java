/*********************************************
 * CO322: Data structures and algorithms
 * Implementation of the hashTable
 *********************************************/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class HashTableImp implements HashTable {
  public int buckets;

    public objectList [] arrayOfBuckets ;


     public HashTableImp(int buckets) {

        this.buckets=buckets;
        arrayOfBuckets=new objectList[buckets];

    }

    public void insert(String key){

   algorithem codeGenerate = new algorithem();
   int mod=codeGenerate.generateHashValue2(key,buckets); //give the index taking function1

   objectList temp=arrayOfBuckets[mod];

        if (temp == null){
            temp = new objectList(key);
            arrayOfBuckets[mod] = temp;
            // break;
        }
        else{
            if( temp.getKey().equals(key)){
                temp.count();
                //break;
            }else{

                while (true){
                    if(temp.getNext() == null ){
                        objectList objectList = new objectList(key);
                        temp.setNextNode(objectList);
                        break;
                    }
                    else{
                        //if entered key is there then add into this
                        if (temp.getKey().equals(key)){
                            temp.count();
                        }
                        temp = temp.getNext();
                    }
                }

            }

        }

    }

    public int search(String key){

        algorithem codeGenerate = new algorithem();
        int mod=codeGenerate.generateHashValue1(key,buckets); //give the index
        objectList temp =arrayOfBuckets[mod];
        while(temp != null){

            if(temp.getKey().equals(key)){
                return temp.getValue();
            }
            temp = temp.getNext();

        }

        return 0;

    }





    public void distributionDisplay(){

        int[] count = new int[buckets];

        for(int i=0;i<this.buckets;i++) {
            int total=0;
            objectList temp = arrayOfBuckets[i];
            while (temp != null) {
                   total+=temp.getValue();
                   temp = temp.getNext();
            }
            //System.out.println(total);
           count[i]=total;
           // System.out.println(count[i]);
        }

        for(int i=0;i<count.length;i++){
            System.out.println("index"+" "+i+" "+"frequency"+" "+count[i]);


            PrintWriter outputStream = null;
            try {
                outputStream = new PrintWriter(new FileWriter("file.csv"));

                for(int j=0 ; j < count.length ; j++){
                    //outputStream.println( "bucket[" + i + "]" + "," + data[i] );

                    outputStream.println(count[j] );
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (outputStream != null) {
                    outputStream.close();
                }
            }



        }


  }


}// end HashTableImp
