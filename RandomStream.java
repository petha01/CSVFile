import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Random;

public class RandomStream {
    public ArrayList<String> elements;
    public Random rand;
    public int size;

    public RandomStream(String inputFile) {
        elements = new ArrayList<String>();

        try {
            File f = new File(inputFile);
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                elements.add(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        rand = new Random();
        size = elements.size();
    }

    public String get() {
        int index = rand.nextInt(size);
        return elements.get(index);
    }
}
