public class ScoreWrapper
{
    private final Score score;

    public Score getScore()
    {
        return score;
    }

    public ScoreWrapper(Score s)
    {
        this.score = s;
    }

    public String toString(){
        return String.format("%s", score.getDocument().getFileName(), this.score.getScore());
    }
}
