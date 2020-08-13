public class Arsenal {
    SuperPowers powers;
    Equipment equipment;

    public Arsenal(SuperPowers powers, Equipment equipment){
        this.powers = powers;
        this.equipment = equipment;

    }

    public SuperPowers getSuperPowers() {
        return powers;
    }

    public void setPowers(SuperPowers powers) {
        this.powers = powers;
    }

    public Equipment getEquips() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }


}
