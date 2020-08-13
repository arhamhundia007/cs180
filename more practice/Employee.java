import java.util.Random;
/*
 * Employee
 *
 * Gives details of the Employee
 *
 * @author Arham Hundia, lab04
 *
 * @version 26 June, 2019
 *
 */
public class Employee {
    private String name;
    private String position;
    private double salary;
    private int idNumber;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
        idNumber = generateIdNumber();


        if  (name == null || position == null) {
            this.name = "";
            this.position = "";
            salary = 25000;
            this.idNumber = generateIdNumber();
        } else if (position.equals("Manager")){
            salary = 50000;
        } else {
            salary = 25000;
        }





}

    private int generateIdNumber() {
        Random r = new Random();
        boolean bool = true;
        int finalNum = 0;
        while (bool) {
            int wow = r.nextInt(1000000);
            String convert = Integer.toString(wow);
            if (convert.length() == 6){
                finalNum = wow;
                bool = false;
            }
        }

        return finalNum;
    }

    public int getIdNumber(){
        return idNumber;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setPosition(String position){
        if (position.equals("Manager")){
            this.salary = 50000;
        } else if (position.equals("")){
            this.salary = 0;
        } else {
            this.salary = 25000;
        }
        this.position = position;
    }

    public void setSalary(double salary){
        if (salary < 0) {
            this.salary = 0;
        } else {
            this.salary = salary;
        }
    }

    public String toString(){

        String convert = String.format("ID Number: %d" + "\n" + "Name: %s" + "\n" + "Position: %s" + "\n" + "Salary: $%.2f", getIdNumber(), name, position, salary);
        return convert;
    }
    public static void main(String[] args) {

        Employee emp = new Employee("Logan", "Manager");
        System.out.println(emp.toString() + "\n");

        emp.setPosition("Clerk");
        System.out.println(emp.toString());

    }
}
