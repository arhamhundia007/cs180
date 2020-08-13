import java.util.ArrayList;

/**
 * Program Name
 *
 * Abstraction of a college course. Each course is uniquely identifiable by its course name.
 *
 * @author You
 *
 * @version date of completion
 *
 */

public class Course {
    /**
     * Maximum number of students allowed to be enrolled in a Course
     */
    protected final static int MAX_STUDENTS = 100;

    private String name;
    private Professor professor;
    private Teacher[] teachers;
    private Student[] students;
    private int boundary = 0;
    private int counter;

    /**
     * Constructs a Course object with the corresponding parameters as its name and a reference to the lead Professor.
     * Creates an array to contain at most 100 students enrolled in the course and ensures the Professor adds the course
     * to their list of courses.
     *
     * @param name Name of the Course to be offered.
     * @param professor A reference to the lead professor for the course.
     */
    public Course(String name, Professor professor) {
        //TODO: Initialize field variables for this Course object
        this.name = name;
        this.professor = professor;
        professor.addCourse(this);
        students = new Student[MAX_STUDENTS];
        teachers = new Teacher[5];
        this.counter = 0;
    }

    /**
     * Adds student to the course. Throws AddToCourseException if the course is full, if student is null, or
     * if the student is already enrolled in the course
     *
     * @param student Student to be added to the Course
     * @throws AddToCourseException If the course is full, if student is null, or if the student is already enrolled in
     * the course
     */
    public void addStudent(Student student) throws AddToCourseException {
        //TODO: Add student to Course, if possible
        if (student == null){
            throw new AddToCourseException("Student cannot be null");
        } else {
            int tester = 0;
            for (int i = 0; i < boundary; i++){
                if (students[i].equals(student)){
                    tester += 1;
                    break;
                }
            }
            if (tester > 0){
                throw new AddToCourseException("Student already exists.");
            } else {
                if (boundary < MAX_STUDENTS){
                  students[boundary] = student;
                  boundary++;
                } else {
                    throw new AddToCourseException("Class Already full.");
                }
            }
        }

    }

    /**
     * Removes student from the course. Throws DropFromCourseException if student is null or if the student
     * is not enrolled in the course.
     *
     * @param student Student to be removed from the course
     * @throws DropFromCourseException If student is null or if the student is not enrolled in the course.
     */
    public void dropStudent(Student student)throws DropFromCourseException{
        //TODO: Remove student from Course, if possible
        if (student == null){
            throw new DropFromCourseException("Cannot drop a null student");
        }
        boolean checker = true;
        for (int i = 0; i < boundary; i++){
            if (students[i] != null && student.equals(students[i])){
                students[i] = students[boundary-1];
                students[boundary-1] = null;
                checker = true;
                boundary--;
                break;
            } else{
                checker = false;
            }
        }
        if (checker == false){
            throw new DropFromCourseException("Student not found");
        }
    }

    /**
     * Adds teacher to the course. If the teachers array is full, then its size is doubled and the teacher is added.
     * A Teacher may teach the same course more than once (like having multiple sections). Throws AddToCourseException
     * if teacher is null. The teacher should add this course to their personal list of courses.
     *
     * @param teacher Teacher to be added to the Course
     * @throws AddToCourseException If the course is full or if teacher is null
     */
    public void addTeacher(Teacher teacher) throws AddToCourseException {
        //TODO: Add teacher to Course, if possible, and add Course to teacher's array of Courses.
        if (teacher == null){
            throw new AddToCourseException("Teacher cannot be null");
        } else {
            if (counter < teachers.length) {
                teachers[counter] = teacher;
                counter++;
                teacher.addCourse(this);
            } else {
                Teacher[] array = new Teacher[counter * 2];
                for (int i = 0; i < teachers.length; i++){
                    array[i] = teachers[i];

                }
                array[teachers.length+1] = teacher;
                teachers = array;
                counter++;
                teacher.addCourse(this);
            }
        }

    }

    /**
     * Removes teacher from the courses's array of teachers. If teacher teaches multiple instances of the
     * course, only one is removed. Throws DropFromCourseException if teacher is null or if teacher is not found.
     *
     * @param teacher Teacher to be added to the Course
     * @throws DropFromCourseException Uf teacher is null or if teacher is not found.
     */
    public void dropTeacher(Teacher teacher)throws DropFromCourseException{
        //TODO: Remove teacher from Course, if possible, and remove Course from teacher's array of Courses.
        boolean check = false;
        if (teacher == null){
            throw new DropFromCourseException("Teacher cannot be null");
        }
        for (int i = 0; i < counter; i++){
            if (teachers[i] != null && teachers[i].equals(teacher)){
                teachers[i] = teachers[counter - 1];
                teachers[counter - 1] = null;
                counter -= 1;
                check = true;
                teacher.dropCourse(this);
                break;
            }
        }

        if (check == false){
            throw new DropFromCourseException("Teacher not present to be removed.");
        }
    }

    /**
     * @return Reference to Professor leading this Course
     */
    public Professor getProfessor()
    {
        //TODO: Return a reference to the Professor for this course.
        return professor;
    }

    /**
     * Creates and returns a new array containing the list of Students. The new array should have a length equal to the
     * number of students currently enrolled in the course. Returns an array of length 0 if the course has no Students.
     *
     * @return A new array containing the Course's Students with no null elements.
     */
    public Student[] getRoster() {
        //TODO: Create and return a new array containing references to each Student in this course's Student array
        Student [] temp = new Student[boundary];
        for (int i = 0; i<boundary; i++){
            temp[i] = students[i];
        }

        return temp;
    }
    /**
     * @return The name of the Course
     */
    public String getName() {
        //TODO: Return the name of this course
        return name;
    }

    /**
     * Returns a new array containing the Courses's Teachers. The new array should have a length equal to the
     * number of Teachers currently teaching the course, duplicates included. Returns an array of length 0 if the course
     * has no Teachers.
     *
     * @return A new array containing the Course's Teachers with no null elements.
     */
    public Teacher[] getTeachers() {
        //TODO: Create and return a new array containing references to each Teacher in this course's Teacher array, including duplicates
        return teachers;
    }

    /**
     * Makes professor the Course professor and updates the old and new Professors involved accordingly.
     *
     * @param professor Reference to Professor object to be made the lead Professor of the course.
     */
    public void changeProfessor(Professor professor) {
        //TODO: Change the Professor for this Course and add/remove the course from the respective Professor's arrays of courses
        if (professor != null) {
            this.professor.dropCourse(this);
            this.professor = professor;
            professor.addCourse(this);
        }
    }

    /**
     * Returns a String representation of the Course object. This method must exist, but will not be tested.
     *
     * @return String
     */
    public String toString() {
        return "";
    }

    public int getBoundary(){
        return boundary;
    }

    public boolean equals(Course course2) {
        if (course2.getName().equals(name)){
            return true;
        } else {
            return false;
        }
    }
}
