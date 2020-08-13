public class SuperHero {
    String name;
    Arsenal arsenal;

    public SuperHero(String name, Arsenal arsenal){
        this.name = name;
        this.arsenal = arsenal;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Arsenal getArsenal() {
        return arsenal;
    }

    public void setArsenal(Arsenal arsenal) {
        this.arsenal = arsenal;
    }
}
