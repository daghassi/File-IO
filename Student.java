

public class Student implements Comparable<Student>{
    String name;
    int score;

    public Student(String name, int score){
        this.name = name;
        this.score = score;
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
