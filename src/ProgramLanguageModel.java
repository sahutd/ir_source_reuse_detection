import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ProgramLanguageModel
{
    Map<Rule, Integer> ruleCounts;
    private String filePath;
    private String fileName;

    public ProgramLanguageModel(String filePath)
    {
        super();
        this.filePath = filePath;
        this.fileName = new File(filePath).getName();
        this.ruleCounts = new HashMap<Rule, Integer>();
    }

    public String getFilePath()
    {
        return filePath;
    }

    public String getFileName()
    {
        return this.fileName;
    }

    public void incrementRule(Rule rule)
    {
        // TODO Auto-generated method stub
        if (!ruleCounts.containsKey(rule))
        {
            ruleCounts.put(rule, 0);
        }
        ruleCounts.put(rule, ruleCounts.get(rule) + 1);
    }

    public String toString()
    {
        return "filename:" + this.filePath + " " + this.ruleCounts.toString();
    }

}
