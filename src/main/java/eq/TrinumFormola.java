package eq;

public class TrinumFormola implements QuadraticEquationSolver{

    protected ResultDao resultDao;
    protected QuadraticEquationCreator quadraticEquationCreator;

    public TrinumFormola() {
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

        double m;
        double n;

        int a = qe.getCoefficientQuardic();
        int b = qe.getCoefficientLinear();
        int c = qe.getCoefficient();

        for (m=-10; m<10; m++) {
            for (n= -10; n<10; n++) {
                if (m*n == a*c && m+n == b) {
                    result = new Pair(-m,-n);
                    resultDao.addResult(qe, result);
                    return new Pair(-m,-n);
                }
            }
        }
        return null;
    }
}
