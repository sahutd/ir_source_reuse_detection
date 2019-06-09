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

public class Util
{
    public static List<File> getFileList(String path)
    {
        List<File> results = new ArrayList<File>();
        File[] files = new File(path).listFiles();

        for (File file : files)
        {
            if (file.isFile())
            {
                results.add(file);
            }
        }
        return results;
    }
    public static List<ProgramLanguageModel> ParseFiles(List<File> files) throws IOException
    {
        List<ProgramLanguageModel> collection = new ArrayList<ProgramLanguageModel>();
        for (File f : files)
        {
            String filePath = f.getAbsolutePath();
            if (f.isFile())
            {
                collection.add(parse(filePath));
            }
        }
        return collection;
    }

    public static ProgramLanguageModel parse(String filePath)
    {
        String source = null;
        try
        {
            source = readFileToString(filePath);
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        HashMap<List<Integer>, Integer> ruleCounts = new HashMap();
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(source.toCharArray());
        parser.setKind(ASTParser.K_COMPILATION_UNIT);

        final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
        TreeVisitor myTreeVisitor = new TreeVisitor(filePath);
        cu.accept(myTreeVisitor);
        ProgramLanguageModel model = myTreeVisitor.getLanguageModel();
        return model;
    }

    public static String readFileToString(String filePath) throws IOException
    {
        StringBuilder fileData = new StringBuilder(1000);
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        char[] buf = new char[10];
        int numRead = 0;
        while ((numRead = reader.read(buf)) != -1)
        {
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
            buf = new char[1024];
        }

        reader.close();

        return fileData.toString();
    }

    public static Result rank(List<ProgramLanguageModel> query, List<ProgramLanguageModel> dataset)
    {
        // TODO Auto-generated method stub
        Result result = null;
        for (ProgramLanguageModel q : query)
        {
            result = new Result(q);
            for (ProgramLanguageModel d : dataset)
            {
                Score score = new Score(q, d);
                result.addScore(score);
                //System.out.println(d);
                //System.out.println(q);

            }
            System.out.println(result);
        }
        return result;
    }
    public static Result process(List<Object> datasetSelection, List<Object> querysetSelection)
    {    List<File> datasetFiles = new ArrayList<File>();
        for(Object o: datasetSelection)
        {
            FileWrapper fw = (FileWrapper)o;
            datasetFiles.add(fw.getFile());
        }
        List<File> queryFiles = new ArrayList<File>();
        for(Object o: querysetSelection)
        {
            FileWrapper fw = (FileWrapper)o;
            queryFiles.add(fw.getFile());
        }
        List<ProgramLanguageModel> DatasetModel = null;
        List<ProgramLanguageModel> querymodel = null;

        try
        {
            DatasetModel = ParseFiles(datasetFiles);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        try
        {
            querymodel = ParseFiles(queryFiles);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return rank(querymodel, DatasetModel);

    }

}
