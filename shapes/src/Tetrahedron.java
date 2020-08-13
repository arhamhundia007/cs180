public class Tetrahedron extends Polyhedron {

    public Tetrahedron(double sideLength){
        super(sideLength);
    }

    @Override
    public double getSideLength() {
        return super.getSideLength();
    }

    @Override
    public double getVolume() {
        return (Math.pow(super.getSideLength(), 3.0) / (6.0 * Math.sqrt(2.0)));
    }

    @Override
    public double getSurfaceArea() {
        return (Math.sqrt(3.0) * Math.pow(super.getSideLength(),2));
    }

    public String toString(){
        String s = String.format("Tetrahedron[%f]", getSideLength());
        return s;
    }

    @Override
    public boolean equals(Object anObject) {
        if (anObject instanceof Tetrahedron)    {
            if (((Tetrahedron) anObject).getSideLength() == this.getSideLength())   {
                return true;
            }
        }
        return false;
    }
}
