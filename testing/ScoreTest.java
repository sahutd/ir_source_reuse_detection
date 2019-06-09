import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ScoreTest
{
    Score s, t;
    @BeforeMethod
    public void setUp() throws Exception
    {
        s = new Score(5.0);
        t = new Score(10.0);
    }

    @AfterMethod
    public void tearDown() throws Exception
    {
    }

    @Test
    public void testGetScore() throws Exception
    {
        assertEquals(s.getScore(), 5.0);
    }

    @Test
    public void testCompareTo() throws Exception
    {
        assertTrue(s.compareTo(t) < 0);
    }

}