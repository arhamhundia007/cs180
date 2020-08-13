public class Student extends Person {
    private String[] courses;
    private char[] grades;

    public Student(String name, String address){
        super(name, address);
        courses = new String[6];
        grades = new char[6];
        for (int i = 0; i < courses.length; i++) {
            courses[i] = "none";
            grades[i] = 'A';
        }
    }

    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setGrades(char[] grades) {
        this.grades = grades;
    }

    public char[] getGrades(){
        return grades;
    }


    public boolean addCourse(String course){
        boolean bool = false;
        for (int i = 0; i<courses.length; i++){
            if (courses[i].equalsIgnoreCase(course)){
                bool = false;
                break;
            } else {
                bool = true;
            }
        }
        if (bool != false){
            for (int i = 0; i< courses.length; i++){
                if (courses[i].equalsIgnoreCase("none")){
                    courses[i] = course;
                    break;
                } else{
                    bool = false;
                }
            }

        }
        return bool;
    }

}
