import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Result
{

    public String getFilePath()
    {
        return filePath;
    }

    private String filePath;

    public List<Score> getSimilarityScores()
    {
        return similarityScores;
    }

    private List<Score> similarityScores;

    public Result(ProgramLanguageModel q)
    {
        filePath = q.getFilePath();
        this.similarityScores = new ArrayList<Score>();

    }

    public void addScore(Score s)
    {
        this.similarityScores.add(s);
    }

    public String toString()
    {
        this.similarityScores.sort(new Comparator<Score>()
        {

            @Override
            public int compare(Score arg0, Score arg1)
            {
                // TODO Auto-generated method stub
                return arg0.compareTo(arg1);

            }

        });
        String sortedResult = "";
        //todo sort
        for (Score s : this.similarityScores)
        {
            sortedResult += s.toString() + "\n";
        }

        return String.format("Result for: %s\n%s\n\n------\n", filePath, sortedResult);

    }

    public String getName()
    {
        return new File(this.filePath).getName();
    }
}