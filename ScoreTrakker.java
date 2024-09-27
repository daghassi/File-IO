import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreTrakker {
    private ArrayList<Student> students;

    public void loadDataFile(String filename){
        FileReader reader = new FileReader(filename);
        Scanner in = new Scanner(reader);
        int lineNumber = 1;
        while (in.hasNextLine()) {
            String name = in.nextLine();
            int score = in.nextInt();
            students.add(new Student(name, score));
            lineNumber++;
        }
        out.close();
        return;
    }
    public void printInOrder(){
        Collections.sort(students);
        for(Student s : students){
            System.out.println(s);
        }
        return;
    }
    public void processFiles(){
        loadDataFile("C:\\Users\\dagha\\Desktop\\csci2000\\CSCI306\\File-IO\\scores.txt");
        printInOrder();
    }

    public static void main(String[] args) {
        ScoreTrakker scoreTrakker = new ScoreTrakker();
        scoreTrakker.processFiles();
    }

}
