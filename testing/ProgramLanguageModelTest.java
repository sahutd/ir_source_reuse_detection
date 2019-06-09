import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ProgramLanguageModelTest
{
    ProgramLanguageModel model;
    @BeforeMethod
    public void setUp() throws Exception
    {
        model = new ProgramLanguageModel("./src/");
    }

    @AfterMethod
    public void tearDown() throws Exception
    {
    }

    @Test
    public void testGetFilePath() throws Exception
    {
        assertEquals(model.getFileName(), "src");
    }

    @Test
    public void testGetFileName() throws Exception
    {
        assertEquals(model.getFileName(), "asdf");

    }

    @Test
    public void testIncrementRule() throws Exception
    {
    }

}