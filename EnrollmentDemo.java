import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student implements Comparable <Student>{
    private long studentID;
    private String name;
    private double gpa;
    public Student(long studentID,String name, double gpa){
        this.studentID=studentID;
        this.name=name;
        this.gpa=gpa;
    }

    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public long getStudentID() {
        return studentID;
    }
    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }
    public void printInfo(){
        System.out.println("Student ID: "+ studentID);
        System.out.println("Name: "+ name);
        System.out.println("GPA: "+ gpa);
    }

    @Override
    public int compareTo (Student s) {
        if(studentID>s.getStudentID()){
            return 1;
        } else if (studentID==s.getStudentID()) {
            return 0;
        }else{
            return -1;
        }
    }
}
class Course{
    private String courseCode;
    private String courseName;
    ArrayList<Student> enrolledStudents=new ArrayList<>();
    //private Student[] enrolledStudents;
    public Course(String courseCode, String courseName) {
        this.courseCode=courseCode;
        this.courseName = courseName;
        //this.enrolledStudents=new Student[3];
    }

    /*public Student getEnrolledStudents(int i) {
        return enrolledStudents[i];
    }
    public Student[] getEnrolledStudents() {
        return enrolledStudents;
    }
    public void setEnrolledStudents(Student[] enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }*/

    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    public void addStudent(Student s){
        enrolledStudents.add(s);
    }
    public void displayEnrolledStudents(){
        for (int i = 0; i < enrolledStudents.size(); i++) {
            System.out.println("Student "+(i+1)+": ");
            System.out.println(enrolledStudents.get(i).getStudentID());
            System.out.println(enrolledStudents.get(i).getName());
            System.out.println(enrolledStudents.get(i).getGpa());
            System.out.println("");
        }
    }
    public void removeStudentByID(String id){
        for (int i = 0; i < enrolledStudents.size(); i++) {
            if(Long.toString(enrolledStudents.get(i).getStudentID()).equals(id)){
                enrolledStudents.remove(i);
                System.out.println(enrolledStudents.get(i).getStudentID()+" has been removed");
                break;
            }
            if(i==(enrolledStudents.size()-1)){
                System.out.println("Student not found in this course");
            }
        }
    }
    /*public void addStudent(Student s){
        for (int i = 0; i < enrolledStudents.length; i++) {
            if(enrolledStudents[i]==null){
                enrolledStudents[i]=s;
                break;
            }
            if(i==(enrolledStudents.length)-1){
                System.out.println("Course Full: Cannot enroll more than 3 students.");
            }
        }
    }*/
}
class GpaComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getGpa()>o2.getGpa()){
            return 1;
        } else if (o1.getGpa()==o2.getGpa()) {
            return 0;
        }else{
            return -1;
        }
    }
}
public class EnrollmentDemo {
    public static void main(String[] args){
        Student s1=new Student(123456789L,"Ali",2.56);
        Student s2=new Student(234567890L,"Burak",3.65);
        Student s3=new Student(345678901L,"Cem",4.00);
        Student s4=new Student(111222333L,"Demir",3.58);
        //s1.printInfo();
        //s2.printInfo();
        //s3.printInfo();
        Course c=new Course("SE116", "Intro to Programming II");
        c.addStudent(s1);
        c.addStudent(s2);
        c.addStudent(s3);
        c.addStudent(s4);
        /*c.displayEnrolledStudents();
        c.removeStudentByID("123456789");
        c.removeStudentByID("748361713");
        System.out.println("Course size: "+c.enrolledStudents.size()+ " students");*/
        Collections.sort(c.enrolledStudents);
        c.displayEnrolledStudents();
        Collections.sort(c.enrolledStudents, new GpaComparator());
        c.displayEnrolledStudents();
    }
}
