import java.io.IOException;
public class Association
{
public static void main(String[] args) throws Exception
{
ApAlgo ap = new ApAlgo(); ap.apAlgoExe();
System.out.println("");
System.out.println("Apriori algorithm is ending");
System.out.println("");
System.out.println("Rule Generation is starting");
System.out.println("");
RuleGeneration grR = new RuleGeneration();
grR.generateRule(ap);
System.out.println("");
System.out.println("Rule Generation is ending");
System.out.println("");
}
}
