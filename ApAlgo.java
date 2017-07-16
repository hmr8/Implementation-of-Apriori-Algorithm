import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;
public class ApAlgo
{
HashMap<String, String> mi = new HashMap<String, String>();
Vector<String> keys=new Vector<String>();
String db;
static int iop;
static int iot;
static Vector<Vector<String>> isf = new Vector<Vector<String>>();
double supval;
static double conval;
public static Set[] key1 = null;
String dbop1 = "ip.txt";
HashMap<String, Integer> mii = new HashMap<String, Integer>();
String nNum[];
public static List<String[]> lt = new ArrayList<String[]>();
String diff = " ";
HashMap<Integer, String> mir = new HashMap<Integer, String>();
public String keytype(Vector<String> key1)
{
String senkey = "";
for(String chr : key1)
{
String[] chsp = chr.trim().split(" ");
for(String item1 : chsp)
senkey += mir.get(Integer.parseInt(item1)-1) + " ";
senkey += " , ";
}
return senkey;
}
public void inputFile(String iden) throws Exception
{
BufferedReader reader = new BufferedReader(new FileReader(iden));
String ipsen = "";
HashMap<String, String> mi = new HashMap<String, String>();
HashMap<String, Integer> mii = new HashMap<String, Integer>();
while((ipsen = reader.readLine())!= null)
{
String[] dub = ipsen.split(" ");
for(String dub1 : dub)
{
if(mi.containsKey(dub1));
else mi.put(dub1, "");
}
int nif = 0;
for(String chk : mi.keySet())
{
mii.put(chk,nif);
nif++;
}
}
}
public double confidenceCal(
AssociationRule rfa) throws Exception {
Itemset union = rfa.getItemsetA().unionWith(
rfa.getItemsetB());
return supportCal(union)
/ (supportCal(rfa.getItemsetA()) * 1.0);
}
private void Setup() throws NumberFormatException, IOException
{
BufferedReader readip = new BufferedReader(new InputStreamReader(System.in));
System.out.print("Enter support:");
String ip = readip.readLine();
supval= Double.parseDouble(ip);
System.out.print("Enter Confidence:");
ip = readip.readLine();
conval = Double.parseDouble(ip);
System.out.print("Enter Transaction File [With Full Path]:");
ip = readip.readLine();
db = ip;
FileInputStream ipfile = new FileInputStream(db);
BufferedReader reader = new BufferedReader(new InputStreamReader(ipfile));
String sen = "";
int col = 0;
while((sen = reader.readLine())!= null)
{
col++;
String[] noi = sen.split(",");
for(String nois : noi)
{
nois = nois.trim();
if(mi.containsKey(nois));
else mi.put(nois, "");
}
}
int nif = 0;
for(String noi : mi.keySet())
{
mii.put(noi,nif);
mir.put(nif, noi);
System.out.println(noi + " " + (nif+1));
nif++;
}
iop=mi.size();
iot= col;
System.out.println("");
System.out.println("Number of items in the input file: "+iop+" items " );
System.out.println("");
System.out.println("Number of transactions in the input file: " +iot);
System.out.println("");
System.out.println("Support value = "+supval+"%");
System.out.println("");
System.out.println("Confidence value = "+conval+"%");
System.out.println("");
System.out.println("");
supval/=100.0;
nNum = new String[iop];
for(int i=0; i<nNum.length; i++)
{
nNum[i]="1";
}
reader.close();
ipfile = new FileInputStream(db);
reader = new BufferedReader(new InputStreamReader(ipfile));
sen = "";
BufferedWriter writer = new BufferedWriter(new FileWriter(dbop1));
while((sen = reader.readLine()) != null)
{
String[] keyset = new String[mi.size()];
for(int i=0; i<keyset.length; i++)
keyset[i] = "0";
String nois[] = sen.split(",");
for(String noi : nois)
{
noi = noi.trim();
keyset[mii.get(noi)] = "1";
}
String kosk = " ";
for(String yot : keyset)
kosk += yot + " ";
kosk = kosk.trim();
writer.write(kosk+"\n");
System.out.println(kosk);
lt.add(keyset);
}
writer.close();
}
private void keygen(int n)
{
Vector<String> genset = new Vector<String>();
String t1, t2;
StringTokenizer r1, r2;
if(n == 1)
{
for(int i=1; i<=iop; i++)
{
genset.add(Integer.toString(i));
}
}
else if(n == 2)
{
for(int i=0; i<keys.size(); i++)
{
r1 = new StringTokenizer(keys.get(i));
t1 = r1.nextToken();
for(int j=i+1; j<keys.size(); j++)
{
r2 = new StringTokenizer(keys.elementAt(j));
t2 = r2.nextToken();
genset.add(t1 + " " + t2);
}
}
}
else if(n > 2)
{
for(int a=0; a<keys.size(); a++)
{
for(int b=a+1; b<keys.size(); b++)
{
t1 = new String();
t2 = new String();
r1 = new StringTokenizer(keys.get(a));
r2 = new StringTokenizer(keys.get(b));
for(int p=0; p<n-2; p++)
{
t1 = t1 + " " + r1.nextToken();
t2 = t2 + " " + r2.nextToken();
}
if(t2.compareToIgnoreCase(t1)==0)
genset.add((t1 + " " + r1.nextToken() + " " + r2.nextToken()).trim());
}
}
}
keys = new Vector<String>(genset);
genset.clear();
}
private void genoffrei(int itemsetNumber) throws IOException
{
Vector<String> keysf = new Vector<String>();
FileInputStream ipfr;
BufferedReader ipd;
StringTokenizer rs, rsf;
boolean seting;
boolean keyr[] = new boolean[iop];
int getr[] = new int[keys.size()];
ipfr = new FileInputStream(dbop1);
ipd = new BufferedReader(new InputStreamReader(ipfr));
for(int a=0; a<iot; a++)
{
rsf = new StringTokenizer(ipd.readLine(), diff);
for(int b=0; b<iop; b++)
{
keyr[b]=(rsf.nextToken().compareToIgnoreCase(nNum[b])==0);
}
for(int z=0; z<keys.size(); z++)
{
seting = false;
rs = new StringTokenizer(keys.get(z));
while(rs.hasMoreTokens())
{
seting = (keyr[Integer.valueOf(rs.nextToken())-1]);
if(!seting)
{
break;
}
}
if(seting)
{
getr[z]++;
}
}
}
for(int h=0; h<keys.size(); h++)
{
if((getr[h]/(double)iot)>=supval)
{
keysf.add(keys.get(h));
}
}
keys.clear();
keys = new Vector<String>(keysf);
keysf.clear();
ipd.close();
}
public void apAlgoExe() throws IOException
{
int noi=0;
Setup();
System.out.println("Apriori algorithm is starting");
key1 = new Set[iop];
do
{
noi++;
keygen(noi);
System.out.println();
genoffrei(noi);
HashSet<Itemset> keysmn = new HashSet<Itemset>();
if(keys.size()!=0)
{
System.out.println("Frequent " + noi + "-itemsets");
for(String str : keys)
{
String item[] = str.split(" ");
Itemset itemset = new Itemset();
for(String obj : item)
{
Item ind = new Item(obj);
itemset.addItem(ind);
}
keysmn.add(itemset);
}
key1[noi] = keysmn;
if(noi>=2)
isf.add(keys);
System.out.println(keytype(keys));
}
}while(keys.size()>1);
for(Vector vector : isf)
{
System.out.print(keytype(vector) + " , ");
}
System.out.println();
}
public int supportCal(Itemset soi) throws Exception
{
int indx = 0;
for(String[] yot : lt)
{
boolean srch = true;
for(Object si : soi.items)
{
int nif = Integer.parseInt(si.toString()) - 1;
if(yot[nif].equals("0"))
srch = false;
}
if(srch)
indx++;
}
return indx;
}
}
