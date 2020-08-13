import java.util.Arrays;

public class MichiganStudent extends CollegeStudent{
    private int age;
    private java.lang.String firstName;
    private java.lang.String housing;
    private java.lang.String id;
    private static java.util.ArrayList<java.lang.String> idNums = new java.util.ArrayList<String>();
    private java.lang.String lastName;
    private java.lang.String major;
    private final String universityOfMichiganCity = "Ann Arbor";
    private final String universityOfMichiganMascot = "Biff the Wolverine";
    private final String universityOfMichiganState = "Michigan";
    private final String[] universityOfMichiganDorms = {"Betsy Barbour", "East Quadrangle", "Fletcher Hall",
            "Helen" + " Newberry", "Henderson House", "Martha Cook Building", "North Quadrangle",
            "South Quadrangle", "West " + "Quadrangle and Cambridge House", "Baits II", "Bursley Hall",
            "Northwood III", "Alice Lloyd Hall","Couzens Hall", "Mary Markley Hall",
            "Mosher-Jordan Hall", "Oxford Hall", "Stockwell Hall"};
    private java.lang.String stateOfResidency;
    private double tuition;

//    public static void main(String[] args) {
//        MichiganStudent p = new MichiganStudent(2, "Arham", "Hundia", "Indiana", "CS", "Earh");
//        System.out.println(p.getID());
//    }
    public MichiganStudent(){
    }

    public MichiganStudent(java.lang.String id){
        this.id = id;
    }

    public MichiganStudent(int age, java.lang.String firstName, java.lang.String lastName,
                          java.lang.String stateOfResidency, java.lang.String major, java.lang.String housing){
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.stateOfResidency = stateOfResidency;
        this.major = major;
        this.housing = housing;
        generateID();
        calculateTuition();
    }

    public void calculateTuition(){
        if (stateOfResidency.equals(universityOfMichiganState)){
            this.tuition = CollegeConstants.UNIVERSITY_OF_MICHIGAN_IN_STATE_TUITION;
        } else {
            this.tuition = CollegeConstants.UNIVERSITY_OF_MICHIGAN_OUT_OF_STATE_TUITION;
        }
    }

    public void generateID(){
        boolean exists = false;
        do {
            long rand = (long) Math.floor(Math.random() * 9000_000_000L) + 1000_000_000L;
            this.id = "" + rand;
            String[] idArray = new String[10];
            for (int i = 0; i < id.length(); i++) {
                idArray[i] = this.id.charAt(i) + "";
                if (i == 1) {
                    idArray[i] = "1";
                } else if(i == 2){
                    idArray[i] = "3";
                }
            }
            this.id = "";
            for (int i = 0; i < idArray.length; i++) {
                this.id = this.id + idArray[i];
            }

            if (idNums.size() == 0){
                break;
            } else {
                for (int i = 0; i < idNums.size(); i++){
                    if (this.id.equals(idNums.get(i))){
                        exists = true;
                        break;
                    }
                }
            }
        }while(exists == true);

        idNums.add(this.id);
    }

    public java.lang.String getCity(){
        return universityOfMichiganCity;
    }

    public java.util.ArrayList<java.lang.String> getDorms(){
        java.util.ArrayList<java.lang.String> dorms = new java.util.ArrayList<java.lang.String>();
        dorms.addAll(Arrays.asList(universityOfMichiganDorms));
        return dorms;
    }
    public java.lang.String getFullName(){
        return getStudentFirstName()+ " " + getStudentLastName();
    }
    public java.lang.String getHousing(){
        return housing;
    }
    public java.lang.String getID(){
        return this.id;
    }
    public java.lang.String getMajor(){
        return major;
    }
    public java.lang.String getMascot(){
        return universityOfMichiganMascot;
    }
    public java.lang.String getState(){
        return universityOfMichiganState;
    }
    public java.lang.String getStateOfResidence(){
        return stateOfResidency;
    }
    public int getStudentAge(){
        return age;
    }
    public java.lang.String getStudentFirstName(){
        return this.firstName;
    }
    public java.lang.String getStudentLastName(){
        return this.lastName;
    }
    public double getTuition(){
        calculateTuition();
        return this.tuition;
    }
}
