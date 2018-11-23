import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by user on 2/1/2018.
 */
public class fileReader {
    String fileName;
    HashTableImp objectHT;

    public fileReader(String file,HashTableImp object){

        this.fileName=file;
        this.objectHT=object;
    }

    public void  readFile(){
      //  int buckets =10;

        try {

            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            String [] arr;

            while ((line = bufferedReader.readLine()) != null) {
                // initialize the array to null

                arr=line.split(" ");

                for(String ss: arr){
                    int modValue=0;
                    String extract = ss.replaceAll("[^a-zA-Z]+", "");

                    if(!(extract.equals(null) || extract.equals(""))) {


                       //insert to the list
                        objectHT.insert(extract);


                    }

                }


            }

            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();

        }


    }


}
