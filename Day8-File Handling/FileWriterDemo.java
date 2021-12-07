package Day8;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {

    public static void main(String[] args) throws IOException {
        FileWriter fileWriter=new FileWriter("a.txt",true);
        fileWriter.write("UST");
        fileWriter.close();


    }
}
