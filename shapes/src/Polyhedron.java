public abstract class Polyhedron {
    private double sideLength;

    public Polyhedron(double sideLength) throws IllegalArgumentException {
        if (sideLength >= 0){
            this.sideLength = sideLength;
        } else {
            throw new IllegalArgumentException("Argument is negative");
        }
    }

    public double getSideLength(){
        return sideLength;
    }

    public void setSideLength(double sideLength) throws IllegalArgumentException{
        if (sideLength >= 0){
            this.sideLength = sideLength;
        } else {
            throw new IllegalArgumentException("Argument is negative");
        }
    }

    @Override
    public boolean equals(Object anObject) {
        if (anObject instanceof Polyhedron)    {
            if (((Polyhedron) anObject).getSideLength() == this.getSideLength())   {
                return true;
            }
        }
        return false;
    }

    public String toString(){
        String s = String.format("Polyhedron[%f]", getSideLength());
        return s;
    }


    public abstract double getSurfaceArea();
    public abstract double getVolume();

}
