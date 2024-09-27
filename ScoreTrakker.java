import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreTrakker {
    private ArrayList<Student> students;

    public void loadDataFile(String filename){
        FileReader reader = new FileReader(filename);
        Scanner in = new Scanner(reader);
        PrintWriter out = new PrintWriter(filename);
        int lineNumber = 1;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            out.println("/* " + lineNumber + " */ " + line);
            lineNumber++;
        }
        out.close();
        return;
    }
    public void printInOrder(){
        return;
    }
    public void processFiles(){
        loadDataFile("scores.txt");
        printInOrder();
    }

    public static void main(String[] args) {
        ScoreTrakker scoreTrakker = new ScoreTrakker();
        scoreTrakker.processFiles();
    }

}
