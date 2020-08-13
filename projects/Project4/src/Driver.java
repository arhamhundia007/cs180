import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    ArrayList<SuperHero> heroList = new ArrayList<SuperHero>();
    Scanner s = new Scanner(System.in);
    public ArrayList<SuperHero> getHeroList(){
        return this.heroList;
    }
    public void run() {
        int choice1;
        String choice;
        do {
            while (true){
                System.out.println("1 - Add Hero");
                System.out.println("2 - Modify Hero");
                System.out.println("3 - Remove Hero");
                System.out.println("4 - Print Hero Details");
                System.out.println("5 - Print all Heroes");
                System.out.println("6 - Read from file");
                System.out.println("7 - Write to file");
                System.out.println("8 - Exit");
                if(s.hasNextInt()) {
                    choice1 = s.nextInt();
                    if(choice1 > 0 && choice1 < 9){
                        break;
                    }
                }
                s.next();
            }
            s.nextLine();
            switch (choice1){
                case 1:{
                    addHero();
                    break;
                }
                case 2:{
                    String modName;
                    System.out.println("Enter a hero name:");
                    modName = s.nextLine();
                    modifyHero(modName);
                    break;
                }
                case 3:{
                    String remName;
                    System.out.println("Enter a hero name:");
                    remName = s.nextLine();
                    removeHero(remName);
                    break;
                }
                case 4:{
                    String printName;
                    System.out.println("Enter a hero name:");
                    printName = s.nextLine();
                    printDetails(printName);
                    break;
                }
                case 5:{
                    printHeroes();
                    break;
                }
                case 6:{
                    System.out.print("Enter the file name in order to read the data:");
                    String filename = s.nextLine();
                    addFromFile(filename);
                    break;
                }
                case 7:{
                    System.out.print("Enter the file name in which you want to write:");
                    String filename = s.nextLine();
                    writeToFile(filename);
                    break;
                }
                case 8:{
                    break;
                }
            } // end switch

            if (choice1 != 8){
                System.out.println("Return to menu?(y/n)");

                while (true){
                    choice = s.nextLine();
                    if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("n")){
                        break;
                    } else{
                        System.out.println("Return to menu?(y/n)");
                    }
                }
            } else {
                choice = "n";
            }
        } while (choice1 != 8 && !(choice.equalsIgnoreCase("n")));   //end of do while
    }

    public void addHero(){

        System.out.println("Enter world:");
        String world;
        world = s.nextLine();                    //determining which world the hero belongs to.

        System.out.println("Enter name:");
        String name;
        name = s.nextLine();                      //name of the hero.
        int z = 0;
        int checker = 0;
        while (z<heroList.size()){
            if (name.equalsIgnoreCase(heroList.get(z).name)){
                checker++;
                break;
            }
            z++;
        }

        if (checker == 1){
            System.out.println("The hero already exists");
        }else {
            System.out.println("Enter weapon:");
            String weapon;
            weapon = s.nextLine();                   //weapon of the hero.

            System.out.println("Enter vehicle:");
            String vehicle;
            vehicle = s.nextLine();                //vehicle of the hero.

            String numpowers;
            ArrayList<String> powersArray = new ArrayList<String>();
            int number = 0;
            while (true) {

                System.out.println("Enter Powers:");
                numpowers = s.nextLine();

                if (numpowers.isEmpty()) {                //checking whether the user hits enter.
                    break;
                } else {
                    powersArray.add(numpowers);//adding the powers of the hero to an ArrayList.
                    number++;
                } //end if

            }// end loop
            String[] powerlist = new String[number];

            for (int i = 0; i < number; i++) //converting and storing and ArrayList into an array.
            {
                powerlist[i] = powersArray.get(i);
            }

            SuperPowers powers = new SuperPowers(powerlist);
            Equipment equipment = new Equipment(weapon, vehicle);
            Arsenal arsenal = new Arsenal(powers, equipment);
            if (world.equalsIgnoreCase("marvel")) {
                SuperHero superHero = new Marvel(name, arsenal);//Bringing all the objects together.
                heroList.add(superHero);
                System.out.printf("%s added\n", name);
            } else if (world.equalsIgnoreCase("dc universe")) {
                SuperHero superHero = new DC(name, arsenal);
                heroList.add(superHero);
                System.out.printf("%s added\n", name);
            } else {
                System.out.println("Please enter either Marvel or DC Universe");
            }
        }

    } //end addHero

    public void modifyHero(String name){
        int i = 0;
        int index = -1;

        while (!(heroList.isEmpty())){
            SuperHero checker = heroList.get(i);
            if (checker.name.equals(name)){
                index = i;
                break;
            }
            i++;
        } // end loop

        if (index == -1){
            System.out.println("The hero doesn't exist");
        } else {
            System.out.println("1 - Change weapon");
            System.out.println("2 - Change vehicle");
            System.out.println("3 - Change powers");
            SuperHero modHero = heroList.get(index);
            int choice = Integer.parseInt(s.nextLine());

            switch (choice) {
                case 1: {
                    System.out.println("========== Change Weapon ==========");
                    System.out.printf("Current Weapon: %s\n", modHero.getArsenal().getEquips().getWeapon());

                    System.out.print("New Weapon: ");
                    String weapon = s.nextLine();
                    modHero.getArsenal().getEquips().setWeapon(weapon);

                    System.out.println("========== Weapon Changed Successfully!!! ==========");
                    System.out.printf("New Weapon: %s\n", modHero.getArsenal().getEquips().getWeapon());

                    break;
                } //end case

                case 2:{
                    System.out.println("========== Change Vehicle ==========");
                    System.out.printf("Current Vehicle: %s\n", modHero.getArsenal().getEquips().getVehicle());

                    System.out.print("New Vehicle: ");
                    String vehicle = s.nextLine();
                    modHero.getArsenal().getEquips().setVehicle(vehicle);

                    System.out.println("========== Vehicle Changed Successfully!!! ==========");
                    System.out.printf("New Vehicle: %s\n", modHero.getArsenal().getEquips().getVehicle());

                    break;
                } //end case

                case 3:{
                    System.out.println("========== Change Powers ==========");
                    System.out.printf("Current Powers: ", modHero.getArsenal().getSuperPowers().getPowers());
                    String[] powers = modHero.getArsenal().getSuperPowers().getPowers();
                    for (int z = 0; z < powers.length-1; z++){
                        System.out.printf("%s, ", powers[z]);
                    }
                    System.out.printf(powers[powers.length-1]);
                    System.out.println();
                    String numpowers;
                    ArrayList<String> powersArray = new ArrayList<String>();

                    int number = 0;
                    while (true){
                        System.out.print("New Powers: ");
                        numpowers = s.nextLine();

                        if (numpowers.isEmpty()){                //checking whether the user hits enter.
                            break;
                        } else{
                            powersArray.add(numpowers);//adding the powers of the hero to an ArrayList.
                            number++;
                        } //end if

                    }// end loop
                    String[] powerlist = new String[number];

                    for (int x = 0; x < number; x++){ //converting and storing and ArrayList into an array.
                        powerlist[x] = powersArray.get(x);
                    }
                    modHero.getArsenal().getSuperPowers().setPowers(powerlist);

                    System.out.println("========== Powers Changed Successfully!!! ==========");
                    System.out.print("New Powers: ");
                    for (int x = 0; x< powerlist.length-1; x++){
                        System.out.printf("%s, " , powerlist[x]);
                    }
                    System.out.printf(powerlist[powerlist.length-1]);
                    System.out.println();


                    break;

                } // end case

                default:{
                    System.out.println("Please choose an appropriate option next time!!!");
                }


            }//end switch
        }

    }

    public void removeHero(String name){
        int i = 0;
        int index = -1;

        while (!(heroList.isEmpty())&& i < heroList.size()){
            SuperHero checker = heroList.get(i);
            if (checker.name.equals(name)){
                index = i;
                break;
            }
            i++;
        } // end loop

        if (index == -1){
            System.out.println("Hero to be removed doesn't exist!!!");
        } else {
            heroList.remove(index);
            System.out.println("========== Hero Removed Successfully!!! ==========");
        }

    }

    public void printDetails(String name){
        int i = 0;
        int index = -1;

        while (!(heroList.isEmpty()) && i < heroList.size()){
            SuperHero checker = heroList.get(i);
            if (checker.name.equals(name)){
                index = i;
                break;
            }
            i++;
        } // end loop

        if (index == -1){
            System.out.println("Hero doesn't exist in the database!!!");
        } else {
            System.out.println("========== Hero Details ==========");
            SuperHero printHero = heroList.get(index);

            if (printHero instanceof Marvel){
                System.out.println("World: Marvel");
            } else if (printHero instanceof DC){
                System.out.println("World: DC Universe");
            }//end if

            System.out.printf("Name: %s\n", printHero.getName());
            System.out.println("========== Equipments ==========");
            System.out.printf("Weapon: %s\n", printHero.getArsenal().getEquips().getWeapon());
            System.out.printf("Vehicle: %s\n", printHero.getArsenal().getEquips().getVehicle());
            System.out.println("========== Powers ==========");

            String [] powers = printHero.getArsenal().getSuperPowers().getPowers();

            for (int x = 0; x < powers.length; x++){
                System.out.printf("%d: %s\n", x+1, powers[x]);
            }
        }//end if

    }

    public void printHeroes(){
        ArrayList<String> marray = new ArrayList<String>();
        ArrayList<String> darray = new ArrayList<String>();
        String [] marvel;
        String [] dc;
        int i = 0;
        int m = 0;
        int d = 0;
        while (!(heroList.isEmpty())&& i<heroList.size()){
            if (heroList.get(i) instanceof Marvel){
                marray.add(heroList.get(i).name);
                m++;
            } else if (heroList.get(i) instanceof DC){
                darray.add(heroList.get(i).name);
                d++;
            }
            i++;
        }

        marvel = new String[m];

        for(int x = 0; x < marvel.length; x++)
        {
            marvel[x] = marray.get(x);   //converting and storing and ArrayList into an array.
        }

        dc = new String[d];

        for(int x = 0; x < dc.length; x++)
        {
            dc[x] = darray.get(x);   //converting and storing and ArrayList into an array.
        }
        System.out.println("========== World: Marvel ==========");
        for (int x = 0; x<marvel.length; x++){
            System.out.printf("%d: %s\n", x+1, marvel[x]);
        }
        System.out.println("========== World: DC Universe ==========");
        for (int x = 0; x<dc.length; x++){
            System.out.printf("%d: %s\n", x+1, dc[x]);
        }
    }

    public void addFromFile(String filename){
        File f = new File(filename);

        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            int index;
            while ((line = br.readLine()) != null){
                if (line.length() == 0){
                    continue;
                }
                index = 0;
                index = line.indexOf(":");
                String world = line.substring(0, index).trim();

                int temp = index + 1;

                index = line.indexOf(";", temp);
                String name = line.substring(temp, index).trim();

                temp = index + 1;

                index = line.indexOf(";", temp );
                String weapon = line.substring(temp, index).trim();

                temp = index + 1;

                index = line.indexOf(";", temp);
                String vehicle = line.substring(temp, index).trim();

                temp = index + 1;

                index = line.indexOf(";", temp);

                int comma = line.indexOf(",", temp);

                ArrayList<String> commaArray = new ArrayList<String>();
                int number = 0;

                while (comma != -1){
                    commaArray.add(line.substring(temp, comma).trim());
                    temp = comma + 1;
                    number++;
                    comma = line.indexOf(",", temp);
                }
                commaArray.add(line.substring(temp, index).trim());
                number++;
                String[] powerlist = new String[number];

                for(int i = 0; i < number; i++){ //converting and storing and ArrayList into an array.
                    powerlist[i] = commaArray.get(i);
                }

                SuperPowers powers = new SuperPowers(powerlist);
                Equipment equipment = new Equipment(weapon, vehicle);
                Arsenal arsenal = new Arsenal(powers, equipment);
                if (world.equalsIgnoreCase("marvel")) {
                    SuperHero superHero = new Marvel(name, arsenal);//Bringing all the objects together.
                    heroList.add(superHero);
                } else if (world.equalsIgnoreCase("dc universe")){
                    SuperHero superHero = new DC(name,arsenal);
                    heroList.add(superHero);
                }

            }
            br.close();
        } catch (Exception e){

        }
    }

    public void writeToFile(String filename)
    {
        try {
            File f = new File(filename);
            FileWriter fw = new FileWriter(f, true);
            BufferedWriter bWriter = new BufferedWriter(fw);
            for (int i = 0; i < heroList.size(); i++) {
                String world = "DC Universe";
                if (heroList.get(i) instanceof Marvel) {
                    world = "Marvel";
                }
                String name = heroList.get(i).getName();
                String weapon = heroList.get(i).getArsenal().getEquips().getWeapon();
                String vehicle = heroList.get(i).getArsenal().getEquips().getVehicle();
                String[] powers = heroList.get(i).getArsenal().getSuperPowers().getPowers();

                bWriter.write(world + ": " + name + "; " + weapon + "; " + vehicle + "; ");
                bWriter.flush();
                for (int x = 0; x < powers.length; x++) {
                    if (x == powers.length - 1) {
                        bWriter.write(powers[x] + ";\n");
                        bWriter.flush();
                    } else {
                        bWriter.write(powers[x] + ", ");
                    }
                }
            }
        }catch (Exception e){

        }

    }

    public void setHeroList(ArrayList<SuperHero> heroList) {
        this.heroList = heroList;
    }
}
