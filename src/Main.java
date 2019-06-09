import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main
{

    // use ASTParse to parse string



    // read file content into a string


    // loop directory to get file list
    public static List<ProgramLanguageModel> ParseFilesInDir(String path) throws IOException
    {
        List<ProgramLanguageModel> collection = new ArrayList<ProgramLanguageModel>();
        File dirs = new File(".");
        String dirPath = dirs.getCanonicalPath() + File.separator + "src/" + path + File.separator;

        File root = new File(dirPath);
        File[] files = root.listFiles();
        String filePath = null;

        for (File f : files)
        {
            filePath = f.getAbsolutePath();
            if (f.isFile())
            {
                collection.add(Util.parse(filePath));
            }
        }
        return collection;
    }

    public static void main(String[] args) throws IOException
    {
        List<ProgramLanguageModel> query = buildQueryLanguageModel();
        List<ProgramLanguageModel> collection = buildCollectionLanguageModel();
        Util.rank(query, collection);

    }




    private static List<ProgramLanguageModel> buildCollectionLanguageModel() throws IOException
    {
        // TODO Auto-generated method stub
        List<ProgramLanguageModel> collection = ParseFilesInDir("dataset");

        return collection;

    }

    private static List<ProgramLanguageModel> buildQueryLanguageModel() throws IOException
    {
        // TODO Auto-generated method stub
        List<ProgramLanguageModel> query = ParseFilesInDir("queryset");
        return query;

    }
}