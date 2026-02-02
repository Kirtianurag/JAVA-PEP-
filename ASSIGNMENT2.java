package ASSIGNMENT2;
interface SportsParticipant {
    void playSport();
}

interface CulturalParticipant {
    void performActivity();
}

abstract class Student {

    private int rollNumber;
    private String name;
    private int semester;

    static String universityName;

    final int MAX_SEMESTER = 8;

    static {
        universityName = "ABC University";
    }

    public Student(int rollNumber, String name, int semester) {
        this.rollNumber = rollNumber;
        setName(name);
        setSemester(semester);
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty())
            this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        if (semester > 0 && semester <= MAX_SEMESTER)
            this.semester = semester;
    }

    abstract double calculateGrade();

    void displayDetails() {
        System.out.println("Roll No: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Semester: " + semester);
    }

    static void displayUniversityName() {
        System.out.println("University: " + universityName);
    }

    final void showRules() {
        System.out.println("Maintain discipline and attendance.");
    }
}

class EngineeringStudent extends Student {

    private int internalMarks;
    private int externalMarks;

    public EngineeringStudent(int rollNumber, String name, int semester,
                              int internalMarks, int externalMarks) {
        super(rollNumber, name, semester);
        this.internalMarks = internalMarks;
        this.externalMarks = externalMarks;
    }

    double calculateGrade() {
        return (internalMarks + externalMarks) / 20.0;
    }
}

class MedicalStudent extends Student {

    private int theoryMarks;
    private int practicalMarks;

    public MedicalStudent(int rollNumber, String name, int semester,
                          int theoryMarks, int practicalMarks) {
        super(rollNumber, name, semester);
        this.theoryMarks = theoryMarks;
        this.practicalMarks = practicalMarks;
    }

    double calculateGrade() {
        return (theoryMarks * 0.7 + practicalMarks * 0.3) / 10;
    }
}

class AllRounderStudent extends Student
        implements SportsParticipant, CulturalParticipant {

    private int marks;

    public AllRounderStudent(int rollNumber, String name, int semester, int marks) {
        super(rollNumber, name, semester);
        this.marks = marks;
    }

    double calculateGrade() {
        return marks / 10.0;
    }

    public void playSport() {
        System.out.println(getName() + " plays sports");
    }

    public void performActivity() {
        System.out.println(getName() + " performs cultural activity");
    }
}

public class ASSIGNMENT2 {

    public static void main(String[] args) {

        Student.displayUniversityName();

        Student s1 = new EngineeringStudent(101, "Rahul", 4, 80, 90);
        Student s2 = new MedicalStudent(102, "Anita", 5, 85, 95);
        Student s3 = new AllRounderStudent(103, "Karan", 3, 88);

        s1.displayDetails();
        System.out.println("Grade: " + s1.calculateGrade());
        s1.showRules();

        System.out.println();

        s2.displayDetails();
        System.out.println("Grade: " + s2.calculateGrade());

        System.out.println();

        s3.displayDetails();
        System.out.println("Grade: " + s3.calculateGrade());

        System.out.println();

        SportsParticipant sp = new AllRounderStudent(104, "Neha", 2, 92);
        sp.playSport();
    }
}
