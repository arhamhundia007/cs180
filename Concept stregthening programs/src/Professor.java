public class Professor extends Person {
    double salary;
    String course;
    String rank;

    public Professor(String name, String address, String course, String rank){
        super(name, address);
        this.course = course;
        this.rank = rank;
        if (rank.equalsIgnoreCase("Assistant")){
            this.salary = 70000;
        }else if (rank.equalsIgnoreCase("Professor")){
            this.salary = 100000;
        }
    }

    public void setRank(String rank){
        if (rank.equalsIgnoreCase("Professor")){
            this.salary = 100000;
        } else {
            this.salary = salary;
        }
    }

    public void setSalary(double salary){
        if (rank.equalsIgnoreCase("Professor")){
            this.salary = 100000;
        } else {
            this.salary = salary;
        }
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getSalary(){

        return salary;
    }

    public String getCourse(){
        return course;
    }

    public String getRank(){
        return rank;
    }
}
