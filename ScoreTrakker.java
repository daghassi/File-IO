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
        FileReader reader = null;
		try {
			reader = new FileReader(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        Scanner in = new Scanner(reader);
        int lineNumber = 1;
        int score = 0;
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
        in.close();
        return;
    }
    public void printInOrder(){
        Collections.sort(students);
        for(Student s : students){
            System.out.println(s);
        }
        return;
    }
    public void processFiles() throws FileNotFoundException{
        for(String file : files){
            loadDataFile(file);
        }
        loadDataFile("scores.txt");
        printInOrder();
    }

    public static void main(String[] args) {
        ScoreTrakker scoreTrakker = new ScoreTrakker();
        try {
			scoreTrakker.processFiles();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }

}
