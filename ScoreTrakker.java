import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker {
    private ArrayList<Student> students;
    private String[] files = {"scores.txt", "badscore.txt", "nofile.txt" };

    public void loadDataFile(String filename){
        FileReader reader = new FileReader(filename);
        Scanner in = new Scanner(reader);
        int lineNumber = 1;
        int score;
        while (in.hasNextLine()) {
            String name = in.nextLine();
            String stringScore = in.nextLine();
            try {
                score = Integer.parseInt(stringScore);
            } catch(NumberFormatException e){
                System.out.println("Incorrect format for " + name + " not a valid score: " + stringScore);
            }
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
        for(String file : files){
            try {
                loadDataFile(file);
            }catch (FileNotFoundException e){
                System.out.println("Cant open file: " + file);
            }
        }
        loadDataFile("scores.txt");
        printInOrder();
    }

    public static void main(String[] args) {
        ScoreTrakker scoreTrakker = new ScoreTrakker();
        scoreTrakker.processFiles();
    }

}
