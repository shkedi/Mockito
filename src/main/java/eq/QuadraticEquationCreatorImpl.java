package eq;

public class QuadraticEquationCreatorImpl implements QuadraticEquationCreator {

    public QuadraticEquationCreatorImpl() {

    }

    @Override
    public QuadraticEquation create(int[] qeArr) {
        return new QuadraticEquation(qeArr[0], qeArr[1], qeArr[2]);
    }
}
