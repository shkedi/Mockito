package eq;

public interface ResultDao {

    Pair getResult(QuadraticEquation qe);

    void addResult(QuadraticEquation qe, Pair result);
}
