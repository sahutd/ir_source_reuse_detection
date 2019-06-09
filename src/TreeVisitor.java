import org.eclipse.jdt.core.dom.*;

import java.util.ArrayList;
import java.util.List;


/*
 * Create a results class that should take filepath as args.
 * Should have a method which takes n-strings. 
 * adds a rule/increments count everytime a call is made with those parameters
 * Find a way to extract stringify constants
 *
 *
 * Pending:
 *

assignment
Comments
Character literal vs string literal(length1)
field access ignore "name" of field




goto/break/continue

weightage to type hierarchy in similarity
 * 
 */
public class TreeVisitor extends ASTVisitor
{
    private String filePath;
    private ProgramLanguageModel model;

    public TreeVisitor(String filePath)
    {
        super();
        this.filePath = filePath;
        this.model = new ProgramLanguageModel(filePath);
    }

    private static boolean isNumber(String childType)
    {
        List<String> numberTypes = new ArrayList<String>();
        numberTypes.add("Integer");
        numberTypes.add("int");
        numberTypes.add("float");
        numberTypes.add("double");
        //todo add entire list
        return numberTypes.contains(childType);
    }

    public ProgramLanguageModel getLanguageModel()
    {
        // TODO Auto-generated method stub
        return this.model;

    }

    private Rule extractRule(ASTNode ast)
    {

        ASTNode child = ast;
        ASTNode parent = child.getParent();

        Rule rule = new Rule(parent, child);
        return rule;
    }

    @Override
    public boolean visit(AnnotationTypeDeclaration node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(AnnotationTypeMemberDeclaration node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(AnonymousClassDeclaration node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(ArrayAccess node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(ArrayCreation node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(ArrayInitializer node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(ArrayType node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(AssertStatement node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(Assignment node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(Block node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(BlockComment node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(BooleanLiteral node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(BreakStatement node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(CastExpression node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(CatchClause node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(CharacterLiteral node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(ClassInstanceCreation node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(CompilationUnit node)
    {
        // TODO Auto-generated method stub

        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(ConditionalExpression node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(ConstructorInvocation node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(ContinueStatement node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(DoStatement node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(new Rule(Rule.getNodeName(node.getParent()), "Loop"));
        }
        return true;

    }

    @Override
    public boolean visit(EmptyStatement node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(EnhancedForStatement node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(new Rule(Rule.getNodeName(node.getParent()), "Loop"));
        }
        return true;

    }

    @Override
    public boolean visit(EnumConstantDeclaration node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(EnumDeclaration node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(ExpressionStatement node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(FieldAccess node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(FieldDeclaration node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            // model.incrementRule(extractRule(node));
            String childType = node.getType().toString();
            if (childType.equals("String")){
                ;
            }
            if (isNumber(childType))
            {
                childType = "Number";
            }
            model.incrementRule(new Rule(Rule.getNodeName(node.getParent()), childType));
        }
        return true;

    }

    @Override
    public boolean visit(ForStatement node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(new Rule(Rule.getNodeName(node.getParent()), "Loop"));
        }
        return true;

    }

    @Override
    public boolean visit(IfStatement node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(new Rule(Rule.getNodeName(node.getParent()), "Condition"));
        }
        return true;

    }

    @Override
    public boolean visit(ImportDeclaration node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(InfixExpression node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(new Rule(Rule.getNodeName(node.getParent()), "Increment"));
        }
        return true;

    }

    @Override
    public boolean visit(Initializer node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(InstanceofExpression node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(Javadoc node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(LabeledStatement node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(LineComment node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(MarkerAnnotation node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(MemberRef node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(MemberValuePair node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(MethodDeclaration node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(MethodInvocation node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(MethodRef node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(MethodRefParameter node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(Modifier node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(NormalAnnotation node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(NullLiteral node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(NumberLiteral node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(PackageDeclaration node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(ParameterizedType node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(ParenthesizedExpression node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(PostfixExpression node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(new Rule(Rule.getNodeName(node.getParent()), "Increment"));
        }
        return true;

    }

    @Override
    public boolean visit(PrefixExpression node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(new Rule(Rule.getNodeName(node.getParent()), "Increment"));
        }
        return true;

    }

    @Override
    public boolean visit(PrimitiveType node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {


            model.incrementRule(new Rule(Rule.getNodeName(node.getParent()), "Number"));
        }

        return true;

    }

    @Override
    public boolean visit(QualifiedName node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(QualifiedType node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(ReturnStatement node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(SimpleName node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {

            //model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(SimpleType node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            String childType = node.getName().toString();
            if (isNumber(childType))
            {
                childType = "Number";
            }
            model.incrementRule(new Rule(Rule.getNodeName(node.getParent()), childType));

        }
        return true;

    }

    @Override
    public boolean visit(SingleMemberAnnotation node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(SingleVariableDeclaration node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(StringLiteral node)
    {
        // TODO Auto-generated method stub
        String childType = "StringLiteral";
        if (node != null)
        {
            if (node.toString().length() == 3){
                childType = "CharacterLiteral";
            }
            model.incrementRule(new Rule(Rule.getNodeName(node.getParent()), childType));
        }
        return true;

    }

    @Override
    public boolean visit(SuperConstructorInvocation node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(SuperFieldAccess node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(SuperMethodInvocation node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(SwitchCase node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(SwitchStatement node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(SynchronizedStatement node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(TagElement node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(TextElement node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(ThisExpression node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(ThrowStatement node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(TryStatement node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(TypeDeclaration node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(TypeDeclarationStatement node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(TypeLiteral node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(TypeParameter node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(VariableDeclarationExpression node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(VariableDeclarationFragment node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

    @Override
    public boolean visit(VariableDeclarationStatement node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {

            String childType = node.getType().toString();
            if (isNumber(childType))
            {
                childType = "Number";
            }
            model.incrementRule(new Rule(Rule.getNodeName(node.getParent()), childType));
        }
        return true;

    }

    @Override
    public boolean visit(WhileStatement node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(new Rule(Rule.getNodeName(node.getParent()), "Loop"));
        }
        return true;

    }

    @Override
    public boolean visit(WildcardType node)
    {
        // TODO Auto-generated method stub
        if (node != null)
        {
            model.incrementRule(extractRule(node));
        }
        return true;

    }

}