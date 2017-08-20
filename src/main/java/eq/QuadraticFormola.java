package eq;

public class QuadraticFormola implements QuadraticEquationSolver {

    protected ResultDao resultDao;
    protected QuadraticEquationCreator quadraticEquationCreator;

    public QuadraticFormola() {
        resultDao = new ResultDaoImpl();
        quadraticEquationCreator = new QuadraticEquationCreatorImpl();
    }

    @Override
    public Pair solve(int[] qeArr) {
        Pair result;
        QuadraticEquation qe = quadraticEquationCreator.create(qeArr);
        if ((result = resultDao.getResult(qe)) != null) {
            return result;
        }

        int a = qe.getCoefficientQuardic();
        int b = qe.getCoefficientLinear();
        int c = qe.getCoefficient();

        double x1 = (-b + Math.sqrt((b*b)-4*a*c))/2*a;
        double x2 = (-b - Math.sqrt((b*b)-4*a*c))/2*a;

        if (Double.isNaN(x1) || Double.isNaN(x2)) {
            return null;
        }

        result = new Pair(x1,x2);
        resultDao.addResult(qe, result);
        return result;
    }
}
