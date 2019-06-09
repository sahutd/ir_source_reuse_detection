import java.util.HashMap;
import java.util.Map;

public class Score
{

    private ProgramLanguageModel query;

    public Score(Double score)
    {
        this.score = score;
    }

    public ProgramLanguageModel getQuery()
    {
        return query;
    }

    public ProgramLanguageModel getDocument()
    {
        return document;
    }

    private ProgramLanguageModel document;
    private Double score;
    private String filename;

    public Score(ProgramLanguageModel q, ProgramLanguageModel d)
    {
        // TODO Auto-generated constructor stub
        this.query = q;
        this.document = d;
        findScore();

    }

    private void findScore()
    {
        // TODO Auto-generated method stub
        score = 0.0;


        Map<Rule, Double> queryDistribution = new HashMap<>();
        Map<Rule, Double> documentDistribution = new HashMap<>();

        for (Map.Entry<Rule, Integer> rule : this.query.ruleCounts.entrySet())
        {
            queryDistribution.put(rule.getKey(), 1.0 * rule.getValue());
            documentDistribution.put(rule.getKey(), 1.0 * this.document.ruleCounts.getOrDefault(rule.getKey(), 0) + 1e-14);

        }

        Integer queryTotalCount = queryDistribution.values().stream().mapToInt(Number::intValue).sum();
        Integer documentTotalCount = documentDistribution.values().stream().mapToInt(Number::intValue).sum();


        System.out.println(String.format("rule,%s,%s", query.getFileName(), document.getFileName()));
        for (Rule rule : queryDistribution.keySet())
        {

            if (queryDistribution.get(rule) == 0)
            {
                continue;
            }
            System.out.print(String.format("%s,%.2f,%.2f", rule.toString(), queryDistribution.get(rule), documentDistribution.get(rule)));
            Double q = queryDistribution.get(rule) / queryTotalCount;
            Double d = (documentDistribution.get(rule) / documentTotalCount) + 1e-14;
            Double contribution = (q-d) * Math.log10(q / d);
            score = score + getQueryWeight(rule) * contribution;
        }


    }


    public Double getScore()
    {
        // TODO Auto-generated method stub
        return score;
    }

    public int compareTo(Score other)
    {
        if (this.score > other.score)
        {
            return 1;
        } else
        {
            return -1;
        }
    }

    private Double getQueryWeight(Rule rule)
    {
        return Double.valueOf(1);
    }

    private Double getRelativeWeight(Rule rule)
    {
        return Double.valueOf(1);
    }

    public String toString()
    {
        return String.format("Score for query:%s and document:%s = %f", this.query.getFileName(), this.document.getFileName(), this.score);
    }
}
