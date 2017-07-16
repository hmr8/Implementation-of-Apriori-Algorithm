import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
public class RuleGeneration
{
Vector<Vector<String>> frequentItemSet = new Vector<Vector<String>>();
public static HashMap<String, Integer> itemIndexMap ;
public static HashMap<Integer, String> indexItemMap ;
@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
public void generateRule(ApAlgo aprioriObj) throws Exception
{
frequentItemSet = aprioriObj.isf;
Set[] candidates = aprioriObj.key1;
itemIndexMap = aprioriObj.mii;
indexItemMap = aprioriObj.mir;
Collection discoveredAssociationRules = new LinkedList();
for (int numItems = 1; numItems < ApAlgo.iop && candidates[numItems] != null &&!candidates[numItems].isEmpty(); numItems++) {
for (Iterator itItemsetCandidate = candidates[numItems].iterator(); itItemsetCandidate.hasNext();) {
Itemset itemsetCandidate = (Itemset) itItemsetCandidate.next();
for (Iterator itItemsetSub = itemsetCandidate.generateAllNonEmptySubsets().iterator(); itItemsetSub.hasNext();) {
Itemset itemsetSub = (Itemset) itItemsetSub.next();
Itemset itemsetA = itemsetSub;
Itemset itemsetB = itemsetCandidate.minusAllIn(itemsetSub);
AssociationRule candidateAssociationRule = new AssociationRule(
itemsetA, itemsetB);
if (aprioriObj.confidenceCal(candidateAssociationRule) > aprioriObj.conval) {
discoveredAssociationRules.add(candidateAssociationRule);
}
}
}
}
for(Object obj : discoveredAssociationRules)
{
AssociationRule rule = (AssociationRule)obj;
Itemset a = rule.getItemsetA();
System.out.println(a.toItemString() + " => " + rule.getItemsetB().toItemString());
}
}
}
