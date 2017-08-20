package eq;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrinumFormolaTest {

    TrinumFormola qes = new TrinumFormola();

    @Mock
    ResultDao resultDao;

    @Mock
    QuadraticEquationCreator quadraticEquationCreator;

    @Test
    //x^2+5x+6
    public void shouldReturnMinusTwoAndMinusThree() {
        qes.resultDao = resultDao;
        qes.quadraticEquationCreator = quadraticEquationCreator;

        int[] eq = new int[]{1,5,6};

        when(resultDao.getResult(any(QuadraticEquation.class))).thenReturn(null);
        when(quadraticEquationCreator.create(eq)).thenReturn(new QuadraticEquation(1,5,6));
        Pair result = qes.solve(eq);
        Assert.assertEquals(result, new Pair(-2,-3));

    }

    @Test
    //x^2+5x+6
    public void shouldReturnMinusTwoAndMinusThreeWhenResultExistInDB() {
        qes.resultDao = resultDao;
        qes.quadraticEquationCreator = quadraticEquationCreator;

        int[] eq = new int[]{1,5,6};

        when(resultDao.getResult(any(QuadraticEquation.class))).thenReturn(new Pair(-2,-3));
        when(quadraticEquationCreator.create(eq)).thenReturn(new QuadraticEquation(1,5,6));
        Pair result = qes.solve(eq);
        Assert.assertEquals(result, new Pair(-2,-3));

    }


    @Test
    //x^2+5x+4
    public void shouldReturnNullWhenNoSoultion() {
        qes.resultDao = resultDao;
        qes.quadraticEquationCreator = quadraticEquationCreator;

        int[] eq = new int[]{1,1,1};

        when(resultDao.getResult(any(QuadraticEquation.class))).thenReturn(null);
        when(quadraticEquationCreator.create(eq)).thenReturn(new QuadraticEquation(1,1,1));
        Pair result = qes.solve(eq);
        Assert.assertNull(result);

    }

}
