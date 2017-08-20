package eq;

import eq.QuadraticEquationCreator;
import eq.QuadraticFormola;
import eq.ResultDao;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class QuadraticFormolaTest {

    QuadraticFormola qes = new QuadraticFormola();

    @Mock
    ResultDao resultDao;

    @Mock
    QuadraticEquationCreator quadraticEquationCreator;

    @Test
    //x^2+5x+4
    public void shouldReturnMinusOneAndMinusFour() {
        qes.resultDao = resultDao;
        qes.quadraticEquationCreator = quadraticEquationCreator;

        int[] eq = new int[]{1,5,4};

        when(resultDao.getResult(any(QuadraticEquation.class))).thenReturn(null);
        when(quadraticEquationCreator.create(eq)).thenReturn(new QuadraticEquation(1,5,4));
        Pair result = qes.solve(eq);
        Assert.assertEquals(result, new Pair(-4,-1));

    }

    @Test
    //x^2+5x+4
    public void shouldReturnMinusOneAndMinusFourWhenResultExistInDB() {
        qes.resultDao = resultDao;
        qes.quadraticEquationCreator = quadraticEquationCreator;

        int[] eq = new int[]{1,5,4};

        when(resultDao.getResult(any(QuadraticEquation.class))).thenReturn(new Pair(-1,-4));
        when(quadraticEquationCreator.create(eq)).thenReturn(new QuadraticEquation(1,5,4));
        Pair result = qes.solve(eq);
        Assert.assertEquals(result, new Pair(-4,-1));

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
