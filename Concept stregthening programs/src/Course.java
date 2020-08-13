public class Course {

    Professor professor;
    Student[] students;
    String courseName;
    int numEnrolled;

    public Course(Professor professor, String courseName) {
        this.professor = professor;
        this.courseName = courseName;
        students = new Student[100];
        numEnrolled = 0;
    }

    boolean enroll(Student s) {
        if (numEnrolled < students.length && s.addCourse(courseName)) {
            students[numEnrolled] = s;
            numEnrolled++;
            return true;
        } else {
            return false;
        }
    }


    public Professor getProfessor() {
        return professor;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getNumEnrolled() {
        return numEnrolled;
    }

    public void setNumEnrolled(int numEnrolled) {
        this.numEnrolled = numEnrolled;
    }
}