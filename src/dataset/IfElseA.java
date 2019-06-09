package dataset;


public class IfElseA
{
    public String foo()
    {
        Integer i = 5;
        if (i < 20)
        {
            return "lt";
        } else if (i == 20)
        {
            return "eq";
        } else
        {
            return "gt";
        }
    }
}
