

public final class LiveCoding3 {

    private String firstName;
    private String middleName;
    private String lastName;
    private int age;

    public LiveCoding3(LiveCoding3 liveCoding3){           //copying the person object
        this.firstName = liveCoding3.firstName;
        this.middleName = liveCoding3.middleName;
        this.lastName = liveCoding3.lastName;
        this.age = liveCoding3.age;
    }

    public LiveCoding3(String firstName, String middleName, String lastName, int age ) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return this.firstName;
    } //get First name

    public String getMiddleName() {
        return this.middleName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    } //getAge

    public String toString() {
        String format = "Person[%s, %s, %s, %f]";

        return String.format(format, firstName, middleName, lastName, age);
    } //toString

} //LiveCoding3


