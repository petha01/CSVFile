import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class CSVFile {
	// Change here
    private static int numFiles = 3;
    private static int numLines = 100;
    private static String outputFileName = "output.csv";

    private static String[] createNameArray(Scanner scnr) {
        String[] fileNames = new String[numFiles];
        //fileNames[0] = "names.txt";
        //fileNames[1] = "age.txt";
        //fileNames[2] = "contact.txt";
        for (int i = 0; i < numFiles; ++i) {
            System.out.print("Enter name of file " + (i + 1) + ": ");
            fileNames[i] = scnr.next();
        }
        return fileNames;
    }

    public static RandomStream[] createStreams(String[] fileNames) {
        RandomStream[] streams = new RandomStream[numFiles];
        for (int i = 0; i < numFiles; ++i) {
            streams[i] = new RandomStream(fileNames[i]);
        }
        return streams;
    }


    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter number of files: ");
        numFiles = scnr.nextInt();
        System.out.print("Enter number of lines: ");
        numLines = scnr.nextInt();
        System.out.print("Enter output file name: ");
        outputFileName = scnr.next();


        FileWriter writer;
        try {
            writer = new FileWriter(outputFileName);

            String[] fileNames = createNameArray(scnr);
            scnr.close();
            RandomStream[] streams = createStreams(fileNames);

            for (int i = 0; i < numLines; ++i) {
                for (int j = 0; j < numFiles; ++j) {

                    writer.write(streams[j].get());

                    if (j == numFiles - 1) {
                        writer.write("\n");
                    }
                    else {
                        //System.out.print(",");
                        writer.write(",");
                    }
                }
                writer.flush();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("Done!");
    }
}
