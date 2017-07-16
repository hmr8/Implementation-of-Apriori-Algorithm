import java.util.*;
public class Itemset {
public Set items;
public Itemset() {
this.items = new HashSet();
}
private Itemset(Itemset itemset) {
this.items = new HashSet(itemset.items);
}
public void addItem(Item item) {
items.add(item);
}
public Itemset intersectWith(Itemset otherSet) {
Itemset newItemset = new Itemset(this);
newItemset.items.retainAll(otherSet.items);
return newItemset;
}
public Itemset unionWith(Itemset otherSet) {
Itemset newItemset = new Itemset(this);
newItemset.items.addAll(otherSet.items);
return newItemset;
}
public Itemset minusAllIn(Itemset otherSet) {
Itemset newItemset = new Itemset(this);
newItemset.items.removeAll(otherSet.items);
return newItemset;
}
private void generateAllNonEmptySubsets(Vector itemsVector, int level,
Set allNonEmptySubsets, Itemset currentItemset) {
currentItemset = new Itemset(currentItemset);
boolean itemAdded = false;
while (true) {
if (level == itemsVector.size() - 1) {
if (currentItemset.size() != 0
&& currentItemset.size() != itemsVector.size()) {
allNonEmptySubsets.add(currentItemset);
}
} else {
generateAllNonEmptySubsets(itemsVector, level + 1,
allNonEmptySubsets, currentItemset);
}
if (itemAdded) {
break;
} else {
currentItemset = new Itemset(currentItemset);
currentItemset.addItem((Item) itemsVector.elementAt(level));
itemAdded = true;
}
}
}
public Set generateAllNonEmptySubsets() {
HashSet allNonEmptySubsets = new HashSet();
generateAllNonEmptySubsets(new Vector(items), 0, allNonEmptySubsets,
new Itemset());
return allNonEmptySubsets;
}
public int size() {
return items.size();
}
public Iterator getItemIterator() {
return items.iterator();
}
public boolean hasItem(String item)
{
if(items.contains(item))
return true;
return false;
}
public String getCandidate(Vector<String> candidate)
{
String candidateStr = "";
for(String item : candidate)
{
String[] itemarr = item.trim().split(" ");
for(String item1 : itemarr)
candidateStr += RuleGeneration.indexItemMap.get(Integer.parseInt(item1)-1) + " ";
candidateStr += " , ";
}
return candidateStr;
}
public String toString() {
StringBuffer out = new StringBuffer();
Iterator itItem = items.iterator();
while (itItem.hasNext()) {
Item item = (Item) itItem.next();
out.append(item.toString());
if (itItem.hasNext()) {
out.append(" ");
}
}
return out.toString();
}
public String toItemString() {
StringBuffer out = new StringBuffer();
Iterator itItem = items.iterator();
while (itItem.hasNext()) {
Item item = (Item) itItem.next();
out.append(RuleGeneration.indexItemMap.get(Integer.parseInt(item.toString())-1));
if (itItem.hasNext()) {
out.append(" ");
}
}
return out.toString();
}
public boolean equals(Object o) {
return ((Itemset) o).items.equals(items);
}
public int hashCode() {
return items.hashCode();
}
}
