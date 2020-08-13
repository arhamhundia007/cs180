/**
 * College
 *
 * Represents an abstraction of a college. Each college may have courses, professors, students, and teachers.
 *
 * @author You
 *
 * @version date of completion
 *
 */

public class College {

    /**
     * Maximum number of Courses allowed to be added to a College
     */
    protected static final int MAX_COURSES = 10;

    /**
     * Maximum number of Professors allowed to be hired by a College
     */
    protected static final int MAX_PROFESSORS = 5;

    /**
     * Maximum number of Teachers allowed to be hired by a College
     */
    protected static final int MAX_TEACHERS = 25;

    /**
     * Maximum number of Students allowed to be enrolled to a College
     */
    protected static final int MAX_STUDENTS = 500;


    private String name;
    private Professor[] professors;
    private Teacher[] teachers;
    private Student[] students;
    private Course[] courses;
    private int tuition;
    private int counter;


    /**
     * Constructs a new College object with the corresponding parameters as field values, and new arrays of Professors,
     * Students, Teachers, and Courses limited by the corresponding MAX variables.
     *
     * @param name Name of the College to be created.
     * @param tuition Cost for students to attend.
     */
    public College(String name, int tuition) {
        //TODO: Initialize field variables for this College object
        this.name = name;
        this.tuition = tuition;
        teachers = new Teacher[MAX_TEACHERS];
        students = new Student[MAX_STUDENTS];
        courses = new Course[MAX_COURSES];
        professors = new Professor[MAX_PROFESSORS];
    }

    /**
     * Adds course to the College's array of courses. If the course is null, the course is already available at the
     * College, or the College cannot add more courses, nothing changes.
     *
     * @param course A course object to be added to the College's array of courses.
     */
    public void addCourse(Course course) {
        //TODO: Add the course to the courses array, if appropriate
        boolean bool = false;
        if (course != null) {

            for (int i = 0; i < courses.length; i++) {
                if (courses[i] != null && courses[i].equals(course)) {
                    bool = true;
                }
            }
        }

        if (bool == false){
            for (int i = 0; i < courses.length; i++) {
                if (courses[i] == null) {
                        courses[i] = course;
                        break;
                }
            }
        }

    }

    /**
     * Adds professor to the College's array of Professors. If the Professor is null, the College cannot add more
     * Professors, or the Professor is already employed by the College, nothing changes.
     *
     * @param professor Professor to be added to the College's array of Professors
     */
    public void hireProfessor(Professor professor) {
        //TODO: Add the given professor to the professors array, if appropriate
        boolean bool = false;
        if (professor != null) {

            for (int i = 0; i < professors.length; i++) {
                if (professors[i] != null && professors[i].equals(professor)) {
                    bool = true;
                }
            }
        }

        if (bool == false){
            for (int i = 0; i < professors.length; i++) {
                if (professors[i] == null) {
                    professors[i] = professor;
                    break;
                }
            }
        }
    }

    /**
     * Adds teacher to the College's array of Teachers. If teacher is null, the College cannot add more Teachers,
     * or teacher is already employed by the College, nothing changes.
     *
     * @param teacher Teacher to be added to the College's array of teachers
     */
    public void hireTeacher(Teacher teacher) {
        //TODO: Add the given teacher to the teachers array, if appropriate
        boolean bool = false;
        if (teacher != null) {

            for (int i = 0; i < teachers.length; i++) {
                if (teachers[i] != null && teachers[i].equals(teacher)) {
                    bool = true;
                }
            }
        }

        if (bool == false){
            for (int i = 0; i < teachers.length; i++) {
                if (teachers[i] == null) {
                    teachers[i] = teacher;
                    break;
                }
            }
        }
    }

    /**
     * Adds student to the College's array of students. If the student is null, the student is already enrolled at the
     * College, or the College cannot add more students, nothing changes.
     *
     * @param student A Student object to be added to the College's array of students.
     */
    public void addStudent(Student student) {
        //TODO: Add the student to the students array, if appropriate
        boolean bool = false;
        if (student != null) {
            for (int i = 0; i < students.length; i++) {
                if (students[i] != null && students[i].equals(student)) {
                    bool = true;
                }
            }
        }

        if (bool == false){
            for (int i = 0; i < students.length; i++) {
                if (students[i] == null) {
                    students[i] = student;
                    counter++;
                    break;
                }
            }
        }
    }

    /**
     * Removes student from the College's array of Students. If the student is enrolled in any Courses, they should be
     * removed from these courses. If student is null or the student is not currently enrolled, nothing changes.
     *
     * *HINT* If you try to remove a student from a Course, an exception is thrown. Consider using a try-catch block.
     *
     * @param student Student to be removed from the College's array of students
     */
    public void dropStudent(Student student) {
        //TODO: Remove the given student from the students array and any courses, if appropriate

        if (student != null) {
            try {
                boolean checker = false;
                for (int i = 0; i < MAX_STUDENTS; i++) {
                    if (students[i] != null && student.equals(students[i])) {
                        students[i] = students[counter-1];
                        students[counter - 1] = null;
                        counter--;
                        checker = true;
                        for (int j = 0; j < courses.length; j++){
                            courses[j].dropStudent(student);
                        }
                        break;
                    }
                }
                if (checker == false) {
                    throw new DropFromCourseException("Student does not exists.");
                }
            } catch (Exception e) {
                System.out.println("Exception was thrown!!!");
                e.printStackTrace();
            }
        }
    }

    /**
     * Returns the net change in the colleges budget. Tuition per student will increase the net change, and payments for
     * Professors and Teachers according to both their base and per course salaries will decrease the net change.
     *
     * @return Net change in the College's funds
     */
    public int calculateNetBudgetChange() {
        //TODO: Calculate the change in budget (Total tuition - Professor Salaries - Teacher Salaries)
        int totalTuition = 0;
        int sumTeachers = 0;
        int sumProf = 0;
        for (int i = 0; i<counter; i++){
            totalTuition = totalTuition + getTuition();
        }
        int x = 0;

        for (int i = 0; i < MAX_STUDENTS; i++){
            if (students[i] != null){
                break;
            }else {
                totalTuition = totalTuition + getTuition();
            }
        }
        for (int i = 0; i < MAX_TEACHERS ; i++){
            if (teachers[i]!= null) {
                sumTeachers = sumTeachers + teachers[i].getBaseSalary();
                sumTeachers = sumTeachers + teachers[i].getPerCourseSalary();
            }
        }
        for (int i = 0; i < MAX_PROFESSORS ; i++){
            if (professors[i]!= null) {
                sumProf = sumProf + professors[i].getBaseSalary();
                sumProf = sumProf + professors[i].getPerCourseSalary();
            }
        }

        return totalTuition - sumTeachers - sumProf;
    }

    /**
     * @return A reference to the array of courses offered by this College.
     */
    public Course[] getCourses()
    {
        //TODO: Return the array of Courses.
        return courses;
    }

    /**
     * @return A reference to the array of Teachers employed by this College.
     */
    public Teacher[] getTeachers()
    {
        //TODO: Return the array of Teachers
        return teachers;
    }

    /**
     * @return A reference to the array of Professors employed by this College.
     */
    public Professor[] getProfessors()
    {
        //TODO: Return the array of Professors
        return professors;
    }

    /**
     * @return A reference to the array of Students enrolled at this College.
     */
    public Student[] getStudents()
    {
        //TODO: Return the array of Professors
        return students;
    }

    /**
     * @return The name of the College object
     */
    public String getName() {
        //TODO: Return the name of the College object
        return name;
    }

    /**
     * @return The tuition charged per student
     */
    public int getTuition() {
        //TODO: Return the tuition of the College object
        return tuition; // I wish
    }
}
