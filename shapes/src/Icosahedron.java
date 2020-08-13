public class Icosahedron extends Polyhedron {

    public Icosahedron(double sideLength){
        super(sideLength);
    }

    @Override
    public double getSideLength() {
        return super.getSideLength();
    }

    @Override
    public double getVolume() {
        return ((15.0 + (5.0 * Math.sqrt(5.0))) / 12.0) * Math.pow(getSideLength(),3.0);
    }

    @Override
    public double getSurfaceArea() {
        return (5.0 * Math.sqrt(3.0) * Math.pow(getSideLength(),2.0));
    }

    public String toString(){
        String s = String.format("Icosahedron[%f]", getSideLength());
        return s;
    }

    @Override
    public boolean equals(Object anObject) {
        if (anObject instanceof Icosahedron)    {
            if (((Icosahedron) anObject).getSideLength() == this.getSideLength())   {
                return true;
            }
        }
        return false;
    }
}
