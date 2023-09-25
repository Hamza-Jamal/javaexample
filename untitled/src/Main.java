
import java.util.*;


public class Main {
    public static void main(String[] args) {
        List<Long>list=new ArrayList<>();
        for(int i=0;i<100;i++){
            list.add(1l);
        }
        System.out.println(countTriplets(list,1));
        System.out.println(countTriplets(list,1));
        System.out.println(countTriplets(list,1));
        System.out.println(countTriplets(list,1));
        System.out.println(countTriplets(list,1));
        System.out.println(countTriplets(list,1));
        System.out.println(countTriplets(list,1));
        System.out.println(countTriplets(list,1));
        System.out.println(countTriplets(list,1));
        System.out.println(countTriplets(list,1));
        System.out.println(countTriplets(list,1));
        System.out.println(countTriplets(list,1));
        System.out.println(countTriplets(list,1));
    }

    static long countTriplets(List<Long> arr, long r) {

        Map<Long,Long>nonDuplicate=new HashMap<>();

        for(Long l:arr){
            nonDuplicate.put(l, nonDuplicate.getOrDefault(l, 0l)+1l);
        }
        long numOftriplets=0;
        ArrayList<Long> newArr=new ArrayList<>(nonDuplicate.keySet());
        Collections.sort(newArr);
        for(int i=0;i<=newArr.size()-3;i++){
            double x0=newArr.get(i);
            double x1=newArr.get(i+1);
            double x2=newArr.get(i+2);
            if(x0==Math.pow(r, i) && x1==Math.pow(r,i+1) && x2==Math.pow(r, i+2)){
                numOftriplets++;
            }
        }
        long duplicates=1;
        for(Long l:nonDuplicate.values()){
            duplicates*=l;
        }
        numOftriplets=numOftriplets*duplicates;
        return numOftriplets;
    }
    static long triplets(int[] a, int[] b, int[] c) {
        long numOfTriplets=0;
        for(int i=0;i<b.length;i++){
            int q=b[i];
            for(int j=0;j<a.length;j++){
                int p=a[j];
                if(p>q)break;
                for(int z=0;z<c.length;z++){
                    int r=c[z];
                    if(p<=q && r<=q) numOfTriplets++;
                    else break;
                }
            }
        }
        return numOfTriplets;
    }
    public static int maxMin(int k, List<Integer> arr) {
        Collections.sort(arr);
        int maxmin=Integer.MAX_VALUE;
        for(int i=0;i<=arr.size()-k;i++){
            int temp=arr.get(i+k-1)-arr.get(i);
            if(maxmin>temp) maxmin=temp;
        }
        return maxmin;
    }
    public static int minimumAbsoluteDifference(List<Integer> arr) {
        int sub=Integer.MAX_VALUE;
        for(int i=0;i<arr.size();i++){
            int temp=0;
            for(int j=1;j<arr.size();j++){
                temp=Math.abs(arr.get(i)-arr.get(j));
                if(temp<sub) sub=temp;
            }
        }
        return sub;
    }
    public static String isValid(String s) {
        char[]chars=s.toCharArray();
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:chars){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int diff=Collections.max(map.values())-Collections.min(map.values());
        if(diff>=2) return "NO";
        else if(diff==0) return "YES";
        HashMap<Integer,Integer> countsMap=new HashMap<>();
        Iterator<Integer>valIt=map.values().iterator();
        try{
            while (valIt.hasNext()) {
                int x=valIt.next();
                if(countsMap.containsKey(x)) countsMap.replace(x,countsMap.get(x),countsMap.get(x)+1);
                else countsMap.put(x,1);
            }
        }catch (Exception e){

        }

        if(countsMap.values().size()>2) return "NO";
        else {
            int min=Collections.min(countsMap.values());
            return min==1?"YES":"NO";
        }

    }
    public static int makeAnagram(String a, String b) {
        char[]c1=a.toCharArray();
        char[]c2=b.toCharArray();
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        HashMap<Character,Integer> common=new HashMap<>();
        for(char c:c1){
            if(map1.containsKey(c)){
                map1.replace(c,map1.get(c), map1.get(c)+1);
            }else map1.put(c, 1);
        }
        for(char c:c2){
            if(map2.containsKey(c)){
                map2.replace(c,map2.get(c), map2.get(c)+1);
            }else map2.put(c, 1);
        }
        for(Character c:map1.keySet()){
            if(map2.containsKey(c)){
                if(map1.get(c)==map2.get(c))
                    common.put(c, map1.get(c));
            }
        }
        int sum=0;
        for(int i:common.values()){
            System.out.print(i+" ");
            sum+=i;
        }
        System.out.println(new StringBuilder().append("\n").append(a).toString());
        System.out.println(b);
        System.out.println(common.keySet());
        return (a.length()-sum)+(b.length()-sum);
    }
    public static long countInversions2(List<Integer> arr) {
        // Write your code here

        long swap = 0;
        swap=mergeSort(arr);
        return swap;

    }
    public static long  mergeSort(List<Integer> inputArr){

        // Creating a left and Right Array
        List<Integer> leftArr = new ArrayList<>();
        List<Integer> rightArr = new ArrayList<>();

        //The count for the number of inversions
        long count = 0;

        //If the array is less than 2 which means that it is either empty or has one element in it. It will stop the recursion
        if(inputArr.size()<2){
            return count ;
        }

        //The length of the left array (Half of the entire array)
        int lengthen = inputArr.size()/2;
        //populating the left array
        for(int i = 0;i<lengthen;i++){
            leftArr.add(inputArr.get(i));
        }
        //Populating the right array which is the other half of the initial unsorted array
        for(int i = lengthen;i<inputArr.size();i++){
            rightArr.add(inputArr.get(i));
        }

        //calling the method again recursively until above if statement is met
        // and adding the number of inversions the sort() functions returns
        count += mergeSort(leftArr);

        count += mergeSort(rightArr);

        // Sorts the left and right array and gives the number of inversions possible
        count  += sort(leftArr, rightArr, inputArr);

        return count;
    }

    public static long sort(List<Integer> leftArr, List<Integer> rightArr, List<Integer> inputArr){

        int i=0, j=0, k=0;
        long swap = 0;
        while (i< leftArr.size() && j<rightArr.size()){
            if(leftArr.get(i)<=rightArr.get(j)){
                inputArr.set(k, leftArr.get(i));

                i++;
            }else{
                inputArr.set(k, rightArr.get(j));
                //the number of inversions which is how many elements are to the right of the array in the left.
                // Since the two arrays are already sorted if the element on the right array is smaller than the left
                // Than it must also be smaller than all other elements to the right of the current i element in the left Array.
                swap = swap + (leftArr.size()-i);
                j++;
            }
            k++;
        }

        while(i<leftArr.size()){
            inputArr.set(k, leftArr.get(i));
            i++;
            k++;
        }

        while(j<rightArr.size()){
            inputArr.set(k,rightArr.get(j));
            j++;
            k++;
        }
        return swap;

    }

    static long inverstions=0;
    public static long countInversions(List<Integer> arr) {
        mergesort(arr);
        return inverstions;
    }
    private static void mergesort(List<Integer>arr){
        int arrSize=arr.size();
        List<Integer>leftArr=new ArrayList<>();
        List<Integer>rightArr=new ArrayList<>();
        if(arrSize==1) return;
        int mid=arrSize/2;

        for(int i=0;i<mid;i++){
            leftArr.add(arr.get(i));
        }
        for(int i=mid;i<arrSize;i++){
            rightArr.add(arr.get(i));
        }
        mergesort(leftArr);
        mergesort(rightArr);
        merge(arr,leftArr,rightArr);

    }
    private static void merge(List<Integer>arr,List<Integer>leftArr,List<Integer>rightArr){
        int leftSize=leftArr.size();
        int rightSize=rightArr.size();
        int i=0; int j=0; int k=0;
        while(i<leftSize && j<rightSize){
            if(leftArr.get(i) <= rightArr.get(j)){
                arr.set(k, leftArr.get(i));
                i++;
            }else {
                arr.set(k, rightArr.get(j));
                //inverstions+=(leftArr.size()-i);
                j++;
                inverstions++;

            }
            //inverstions++;
            k++;
        }
        while(i<leftSize){
            arr.set(k,leftArr.get(i));
            i++; k++;
        }
        while(j<rightSize){
            arr.set(k,rightArr.get(j));
            j++; k++;
        }
    }
    public static int maximumToys(List<Integer> prices, int k) {
        Collections.sort(prices);
        int numOfToys=0;
        int sumOfPrices=0;
        for(int i=0;i<prices.size()-1;i++){
            if(sumOfPrices+prices.get(i)<k){
                sumOfPrices+=prices.get(i);
                numOfToys++;
            }else break;
        }
        return numOfToys;
    }
    public static int sherlockAndAnagrams(String s) {
        HashMap<String,Integer> countsMap=new HashMap<>();
        for(int i=0;i<s.length();i++){
            for(int len=i;len<s.length();len++){
                char[] charaaray=s.substring(i,len+1).toCharArray();
                Arrays.sort(charaaray);
                String subString=new String(charaaray);
                if(countsMap.containsKey(subString)){
                    countsMap.replace(subString,countsMap.get(subString),countsMap.get(subString)+1);
                }else countsMap.put(subString, 1);
            }
        }
        int sum=0;
        for (Integer i:countsMap.values()){
            sum=sum+(i*(i-1)) /2;
        }
        return sum;
    }
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        HashMap<Integer,Integer>newInts= new HashMap<>();
        List<Integer> out=new ArrayList<>();
        for(List<Integer> query:queries){
            int a=query.get(0);
            int b=query.get(1);
            switch(a){
                case 1:
                    if(newInts.containsKey(b)){
                        int newValue=newInts.get(b);
                        newInts.replace(b,newValue,newValue+1);
                    }else {
                        newInts.put(b, 1);
                    }
                    break;
                case 2:
                    if(newInts.containsKey(b)){
                        int newValue=newInts.get(b);
                        newInts.replace(b,newValue,newValue-1);
                    }

                    break;
                case 3:
                    boolean equals=false;
                    for(Integer i:newInts.keySet()){
                        if(newInts.get(i)==b) {
                            out.add(1);
                            equals=true;
                            break;
                        }
                    }
                    if(!equals)out.add(0);
                    break;
            }
        }
        return out;
    }
    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        long[] arr=new long[n];
        for (List<Integer> query : queries) {
            int a = query.get(0) - 1;
            int b = query.get(1) - 1;
            int k = query.get(2);
            for (int j = a; j < b; j++) {
                arr[j] = arr[j] + k;
            }
        }
        long max =0;
        for (long l : arr) {
            if (max < l)
                max = l;
        }
        return max ;

    }
    static int minimumSwaps(int[] arr) {
        int swaps=0;
        for (int i=0;i<arr.length;i++){
            int minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            if(minIndex!=i){
                swap(arr,i,minIndex);
                swaps++;
            }
        }
        return swaps;
    }
    static void swap(int []arr,int i0,int i1){
        int temp=arr[i0];
        arr[i0]=arr[i1];
        arr[i1]=temp;
    }
    public static String getSmallestAndLargest(String s, int k) {
        String smallest;
        String largest;
        String []sub=new String[s.length()-k];
        for(int i=0;i<sub.length;i++){
            sub[i]=s.substring(i,i+k);
        }
        for(int i=0;i<sub.length;i++){
            for (int j=i+1;j<sub.length;j++){
                if(sub[i].compareTo(sub[j])<0){
                    String temp=sub[i];
                    sub[i]=sub[j];
                    sub[j]=temp;
                }
            }
        }
        smallest=sub[sub.length-1];
        largest=sub[0];
        return smallest + "\n" + largest;
    }
    static boolean isAnagram(String a, String b) {
        // Complete the function
        a=sort(a);
        b=sort(b);
        return a.equals(b);
    }
    public static String sort(String s){
        s=s.toLowerCase();
        char[] c =s.toCharArray();
        for (int i=0;i<c.length;i++){
            for(int j=i+1;j<c.length;j++){
                if (c[j]<c[i]){
                    char temp=c[i];
                    c[i]=c[j];
                    c[j]=temp;
                }
            }
        }
        return s;
    }
}
class Result2 {
    public static int jumpingOnClouds(List<Integer> c) {
        int i=0;
        int numOfmoves=0;
        while(i<c.size()-1){
            try{
                if(c.get(i+1)==1){
                    i+=2;
                    numOfmoves++;
                }else if(c.get(i+2)==0){
                    i+=2;
                    numOfmoves++;
                }else {
                    i+=1;
                    numOfmoves++;
                }
            }catch (IndexOutOfBoundsException e){
                i++;
                numOfmoves++;
            }

        }
        return numOfmoves;
    }
}
class Result {

    public static long minTime(List<Integer> files, int numCores, int limit) {
        // Write your code here
        ArrayList<Integer>parrallelFiles=new ArrayList<>();
        for (Integer file : files) {
            if (file % numCores == 0) {
                parrallelFiles.add(file);
            }
        }
        int n=Math.min(numCores, limit);

        parrallelFiles.sort(Collections.reverseOrder());
        files.sort(Collections.reverseOrder());
        long sum=0;
        for(int i=0;i<parrallelFiles.size();i++){
            if(i>n || numCores==1) break;
            sum=sum+(parrallelFiles.get(i)/numCores);
        }
        for (Integer file : files) {
            if (!parrallelFiles.contains(file) || numCores == 1) {
                sum = sum + file;
            }
        }
        return sum;

    }

}
class MyRegex{

    String pattern="^([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\."+
            "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\."+
            "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\."+
            "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])$";
}
class Student{
    private int id;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getId() {return id;}
    public String getFname() {return fname;}
    public double getCgpa() {return cgpa;}
}
class Sorter implements Comparator<Student> {
    @Override
    public int compare(Student a,Student b){
        if(a.getCgpa()<b.getCgpa()) return 1;
        if(a.getCgpa()>b.getCgpa()) return -1;
        if(!a.getFname().equals(b.getFname())) return a.getFname().compareTo(b.getFname());
        else return a.getId()-b.getId();
    }
}


