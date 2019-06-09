package dataset;


public class IfElseB
{
    public String foo()
    {
        Integer i = 5;
        if (i > 20)
        {
            return "gt";
        } else if (i < 20)
        {
            return "lt";
        } else
        {
            return "eq";
        }
    }
}
