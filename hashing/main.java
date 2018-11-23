
/**
 * Created by user on 2/1/2018.
 */
public class main {
    public static void main(String[] args) {



        HashTableImp test =new HashTableImp(13);
        fileReader start=new fileReader("sample-text2.txt",test);
        start.readFile();
        test.distributionDisplay();

      //  System.out.println( test.search("for"));


    }



}
