
public class algorithem {

    String str;
    private int buckets,value;
    int u,n;

    public int generateHashValue1(String str , int buckets){

        int k = str.length();
         int u = 0,n = 0;

        for (int i=0; i<k; i++)
        {
            n = str.charAt(i);
            u += 7*n%31;
        }

        return  findBucket(u%139,buckets);

 }


 public int generateHashValue2(String str , int buckets){
     int hash = 0;

     for ( int i = 0 ; i < str.length() ; i++ ){
         hash += str.charAt(i);
     }
     return findBucket(hash,buckets);
    }





    public int  findBucket(int value,int buckets) {

    return  (value % buckets); //decide the bucket
    }


}