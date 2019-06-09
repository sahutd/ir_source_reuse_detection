package queryset;


public class TestIfCondition
{
    public String foo()
    {
        Integer i = 5;
        if (i == 20)
        {
            return "eq";
        } else if (i > 20)
        {
            return "gt";
        } else
        {
            return "lt";
        }
    }
}
