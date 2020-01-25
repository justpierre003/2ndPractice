 
import java.util.*;

/**
 * Created by Yang on 1/23/20.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return(array[0]);
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return(array[1]);
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return(array[array.length-1]);
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return (array[array.length-2]);
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        List<String> m = Arrays.asList(array);
        if(m.contains(value)){
            return true;
        }
        return false;
    
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        List<String> m = Arrays.asList(array);
        Collections.reverse(m);
        
        return (m.toArray(array));
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        List<String> m = Arrays.asList(array);
        Collections.reverse(m);
        String[] n = m.toArray(array);
        if(array != n){
            return false;
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    
    public static boolean isPangramic(String[] array) {
        
        boolean[] l = new boolean[26];
        Arrays.fill(l,false);

         for(int i = 0; i < array.length; i++){
            String str = array[i].toLowerCase();
            for(String word : str.split("[^a-z]")){
                for(int j = 0; j < word.length(); j++){
                    int letter = ((int)word.charAt(j))%97;
                    l[letter] = true;
                }
            }
        }

         boolean allPresent = true;
        for(int i = 0; i < l.length; i++){
            if(!l[i]){
                allPresent = false;
                break;
            }
        }
        return allPresent;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        
        int c = 0;
        for(int i = 0; i < array.length; i++){
            if(value.equals(array[i])){
                c++;
            }
        }
        return c;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
       ArrayList<String> arrList = new ArrayList<String>(array.length);
        for(int i = 0; i < array.length; i++){
            if(!valueToRemove.equals(array[i])){
                arrList.add(array[i]);
            }
        }
        String[] primitiveArray = new String[arrList.size()];
        return arrList.toArray(primitiveArray);
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        ArrayList<String> arrList = new ArrayList<String>(array.length);
        arrList.add(array[0]);
        String prevStr = array[0];
        for(int i = 1; i < array.length; i++){
            if(!prevStr.equals(array[i])){
                arrList.add(array[i]);
                prevStr = array[i];
            }
        }
        String[] primitiveArray = new String[arrList.size()];
        return arrList.toArray(primitiveArray);
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        StringBuilder sbuild = new StringBuilder(array.length);
        ArrayList<String> arrList = new ArrayList<String>(array.length);
        sbuild.append(array[0]);
        String prevStr = array[0];
        for(int i = 1; i < array.length; i++){
            if(!prevStr.equals(array[i])){
                arrList.add(sbuild.toString());
                prevStr = array[i];
                sbuild.delete(0, sbuild.length());
                sbuild.append(array[i]);
            }
            else {
                sbuild.append(array[i]);
            }
        }
        arrList.add(sbuild.toString());

         String[] primitiveArray = new String[arrList.size()];
        return arrList.toArray(primitiveArray);
    }


}
