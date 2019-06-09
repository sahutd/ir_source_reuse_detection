import org.eclipse.jdt.core.dom.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class Rule
{

    private ASTNode parent;
    private ASTNode child;

    public String getParentName()
    {
        return parentName;
    }

    public String getChildName()
    {
        return childName;
    }

    private String parentName;
    private String childName;

    public Rule(ASTNode parent, ASTNode child)
    {
        this.parent = parent;
        this.child = child;
        this.parentName = getNodeName(parent);
        this.childName = getNodeName(child);
    }


    public Rule(String parentName, String childName)
    {
        this.parentName = parentName;
        this.childName = childName;
    }


    public static String getNodeName(ASTNode node)
    {
        String s;
        if (node == null)
        {
            s = "Top of tree";
        } else
        {
            s = node.nodeClassForType(node.getNodeType()).toString();
            s = s.substring(s.lastIndexOf('.') + 1);
        }
        if(isLoopType(s)){
            return "Loop";
        }
        return s;
    }

    private static boolean isLoopType(String s)
    {
        List<String> loopTypes = new ArrayList<String>();
        loopTypes.add("ForStatement");
        loopTypes.add("WhileStatement");
        loopTypes.add("DoStatement");
        return loopTypes.contains(s);
    }

    public String toString()
    {
        return String.format("\nRule:%s -->  %s", parentName, childName);

    }

    @Override
    public boolean equals(Object obj)
    {
        // TODO Auto-generated method stub
        Rule other = (Rule) obj;
        return this.parentName.equals(other.parentName) && this.childName.equals(other.childName);
    }

    @Override
    public int hashCode()
    {

        // TODO Auto-generated method stub
        return String.format("%s-->%s", this.parentName, this.childName).hashCode();
    }
}
