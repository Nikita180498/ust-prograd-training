package Day8;

import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;

public class FileReaderDemo {
    public static void main(String[] args) throws IOException {

        //create new file********

//        File file = new File("a.txt");
//        file.createNewFile();

        //one way to read file*******

//        FileReader reader =new FileReader("a.txt");
//
//        int i;
//        while((i=reader.read())!= -1){
//            System.out.print((char)i);
//        }

        // 2nd way to read file**********

        File file = new File("a.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }

//        raeder.close();
    }
}
