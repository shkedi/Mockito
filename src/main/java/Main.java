import eq.QuadraticEquation;
import eq.QuadraticEquationSolver;
import eq.QuadraticFormola;
import eq.TrinumFormola;

public class Main {


    public static void main(String[] args) {
        QuadraticEquation qe1 = new QuadraticEquation(1, 5, 4);
        QuadraticEquation qe2 = new QuadraticEquation(1, 5, 6);

        QuadraticEquationSolver qes1 = new TrinumFormola();
        QuadraticEquationSolver qes2 = new QuadraticFormola();

        System.out.println(qes1.solve(new int[]{1,5,4}));
        System.out.println(qes1.solve(new int[]{1,5,6}));
        System.out.println(qes2.solve(new int[]{1,5,4}));
        System.out.println(qes2.solve(new int[]{1,5,6}));
    }

}
