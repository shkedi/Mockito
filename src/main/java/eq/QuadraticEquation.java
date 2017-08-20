package eq;

public class QuadraticEquation {

    private int coefficientQuardic;
    private int coefficientLinear;
    private int coefficient;

    public QuadraticEquation(int coefficientQuardic, int coefficientLinear, int coefficient) {
        this.coefficientQuardic = coefficientQuardic;
        this.coefficientLinear = coefficientLinear;
        this.coefficient = coefficient;
    }

    public int getCoefficientQuardic() {
        return coefficientQuardic;
    }

    public int getCoefficientLinear() {
        return coefficientLinear;
    }

    public int getCoefficient() {
        return coefficient;
    }
}
