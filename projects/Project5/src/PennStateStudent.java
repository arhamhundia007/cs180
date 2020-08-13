import java.util.Arrays;
import java.util.Random;

public class PennStateStudent extends CollegeStudent {
    private int age;
    private java.lang.String firstName;
    private java.lang.String housing;
    private java.lang.String id;
    private static java.util.ArrayList<java.lang.String> idNums = new java.util.ArrayList<String>();
    private java.lang.String lastName;
    private java.lang.String major;
    private final String pennStateUniversityCity = "University Park";
    private final String pennStateUniversityMascot = "Nittany Lion";
    private final String pennStateUniversityState = "Pennsylvania";
    private final String[] pennStateUniversityDorms = {"Bigler Hall", "Brumbaugh Hall", "Curtin Hall","Findlay " +
            "Commons", "Fisher Hall", "Geary Hall", "Hastings Hall", "Johnston Commons", "McKean Hall",
            "Packer Hall","Pennypacker Hall", "Pinchot Hall", "Snyder Hall", "Sproul Hall", "Stone Hall",
            "Stuart Hall", "Tener Hall","Brill Hall", "Curry Hall", "Harris Hall", "Miller Hall", "Nelson Hall",
            "Panofsky Hall", "Young Hall","Nittany Apartments", "Nittany Hall", "Beam Hall", "Holmes Hall",
            "Leete Hall", "Runkle Hall","Warnock Commons", "Beaver Hall", "Hartranft Hall", "Hiester Hall",
            "Mifflin Hall", "Pollock Commons","Porter Hall", "Ritner Hall", "Shulze Hall", "Shunk Hall",
            "Wolf Hall", "Atherton Hall", "Cooper Hall", "Cross Hall", "Ewing Hall", "Haller Hall",
            "Hibbs Hall", "Hoyt Hall", "Lyons Hall", "McElwain Hall", "Redifer Commons", "Simmons Hall",
            "Stephens Hall", "Hamilton Hall", "Irvin Hall", "Jordan Hall", "McKee Hall", "Thompson Hall",
            "Waring Commons", "Watts Hall", "Berneuter Hall", "Cunningham Hall", "Donkin Hall",
            "Durham Hall", "Farrell Hall", "Ferguson Hall", "Garban Hall", "Grubb " + "Hall",
            "Haffner Hall", "Holderman Hall", "Ikenberry Hall", "Lovejoy Hall", "Osborn Hall",
            "Palladino Hall","Patterson Hall", "Ray Hall", "Weston Community Center"};
    private java.lang.String stateOfResidency;
    private double tuition;

//    public static void main(String[] args) {
//        PennStateStudent p = new PennStateStudent(2, "Arham", "Hundia", "Indiana", "CS", "Earh");
//        System.out.println(p.getID());
//    }

    public PennStateStudent(){

    }
    public PennStateStudent(java.lang.String id){
        this.id = id;
    }
    public PennStateStudent(int age, java.lang.String firstName, java.lang.String lastName,
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
        if (stateOfResidency.equals(pennStateUniversityState)){
            this.tuition = CollegeConstants.PENN_STATE_UNIVERSITY_IN_STATE_TUITION;
        } else {
            this.tuition = CollegeConstants.PENN_STATE_UNIVERSITY_OUT_OF_STATE_TUITION;
        }
    }

    public void generateID(){
        boolean exists = false;
        do {
            long rand = (long) Math.floor(Math.random() * 9000_000_000L) + 1000_000_000L;
            this.id = "" + rand;
            String[] idArray = new String[10];
            String [] choice = {"0", "1", "2", "3"};
            Random random = new Random();
            for (int i = 0; i < id.length(); i++) {
                idArray[i] = this.id.charAt(i) + "";
                if (i%2 != 0) {
                    idArray[i] = choice[random.nextInt(4)];
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
        return pennStateUniversityCity;
    }

    public java.util.ArrayList<java.lang.String> getDorms(){
        java.util.ArrayList<java.lang.String> dorms = new java.util.ArrayList<java.lang.String>();
        dorms.addAll(Arrays.asList(pennStateUniversityDorms));
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
        return pennStateUniversityMascot;
    }
    public java.lang.String getState(){
        return pennStateUniversityState;
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
