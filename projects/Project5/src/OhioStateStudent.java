import java.util.Arrays;
import java.util.Random;

public class OhioStateStudent extends CollegeStudent{
    private int age;
    private java.lang.String firstName;
    private java.lang.String housing;
    private java.lang.String id;
    private static java.util.ArrayList<java.lang.String> idNums = new java.util.ArrayList<String>();
    private java.lang.String lastName;
    private java.lang.String major;

    private final String ohioStateUniversityCity = "Columbus";
    private final String ohioStateUniversityMascot = "Brutus Buckeye";
    private final String ohioStateUniversityState = "Ohio";
    private final String[] ohioStateUniversityDorms = {"Archer House", "Baker Hall East", "Baker Hall West",
            "Barrett House", "Blackburn House", "Bowen House", "Bradley Hall", "Busch Hall", "Canfield Hall",
            "Drackett Tower", "Fechko House", "German House", "Halloran House", "Hanley House", "Haverfield House",
            "Houck House", "Houston House", "Jones Tower", "Lawrence Tower", "Lincoln Tower", "Mack Hall",
            "Mendoze " + "House", "Morill Tower", "Morrison Tower", "Neil Avenue", "Norton House", "Nosker House",
            "Park-Stradley " + "House", "Paterson House", "Pennsylvania House", "Pomerene House", "Raney House",
            "Scholars East",
            "Scholars West", "Scott House", "Siebert Hall", "Smith-Steeb Hall", "Taylor Tower",
            "The Residence on " + "Tenth", "Torres House", "Veteran's House", "Worthington Building"};
    private java.lang.String stateOfResidency;
    private double tuition;

//    public static void main(String[] args) {
//        OhioStateStudent p = new OhioStateStudent(2, "Arham", "Hundia", "Indiana", "CS", "Earh");
//        System.out.println(p.getID());
//    }

    public OhioStateStudent(){

    }
    public OhioStateStudent(java.lang.String id){
        this.id = id;
    }
    public OhioStateStudent(int age, java.lang.String firstName, java.lang.String lastName,
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
        if (stateOfResidency.equals(ohioStateUniversityState)){
            this.tuition = CollegeConstants.OHIO_STATE_UNIVERSITY_IN_STATE_TUITION;
        } else {
            this.tuition = CollegeConstants.OHIO_STATE_UNIVERSITY_OUT_OF_STATE_TUITION;
        }
    }

    public void generateID(){
        boolean exists = false;
        do {
            long rand = (long) Math.floor(Math.random() * 9000_000_000L) + 1000_000_000L;
            this.id = "" + rand;
            String[] idArray = new String[10];
            String [] choose = {"0", "1"};
            Random ran = new Random();
            for (int i = 0; i < id.length(); i++) {
                idArray[i] = this.id.charAt(i) + "";
                if (i % 2 != 0) {
                    idArray[i] = choose[ran.nextInt(2)];
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
        return ohioStateUniversityCity;
    }

    public java.util.ArrayList<java.lang.String> getDorms(){
        java.util.ArrayList<java.lang.String> dorms = new java.util.ArrayList<java.lang.String>();
        dorms.addAll(Arrays.asList(ohioStateUniversityDorms));
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
        return ohioStateUniversityMascot;
    }
    public java.lang.String getState(){
        return ohioStateUniversityState;
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
