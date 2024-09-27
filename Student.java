import java.util.ArrayList;

public class Student implements Comparable<Student>{
    String name;
    int score;

    public class(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }
    @Override
    public int compareTo(Student otherStudent){
        return Integer.compare(this.score, otherStudent.score);
    }

    @Override
    public String toString() {
        return name + " " + score + "\n";
    }
}
