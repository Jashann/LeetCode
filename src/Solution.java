import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {

    // Arrays & Hashing - Problem 1
    public boolean containsDuplicate(int[] nums) {
        for ( int i=0; i<nums.length; i++ ) {
            for ( int j=i+1; j<nums.length; j++ ) {
                if ( nums[i] == nums[j] )
                    return true;
            }
        }
        return false;
    }



    // Arrays & Hashing - Problem 2
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> h1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> h2 = new HashMap<Character, Integer>();

        if ( s.length() != t.length() )
            return false;

        for ( int i=0; i<s.length(); i++ ) {
            // for s
            char current = s.charAt(i);
            Integer value = h1.get(current);
            if ( value != null )
                h1.put(current, value + 1);
            else
                h1.put(current, 1);

            // for t
            current = t.charAt(i);
            value = h2.get(current);
            if ( value != null )
                h2.put(current, value + 1);
            else
                h2.put(current, 1);
        }

        // Comparing
        for ( char key : h1.keySet() ) {
            if ( h2.get(key) == null || h1.get(key) != h2.get(key) )
                return false;
        }

        return true;
    }



    // Arrays & Hashing - Problem 3
    public int[] twoSum(int[] nums, int target) {
        int indices[] = {-1,-1};

        for ( int i=0; i<nums.length; i++ ) {
            for ( int j=i+1; j<nums.length; j++ ) {
                if ( nums[i] + nums[j] == target ) {
                    indices[0] = i;
                    indices[1] = j;
                    break;
                }
            }
        }

        return indices;
    }

    public int[] twoSum2(int[] nums, int target) {

        int indices[] = {-1, -1};

        // nums = [10, 20, 30, ....]
        // key    -> 10, 20
        // value  -> 0,  1
        // target = 30;
        // i = 1
        // difference = 10

        HashMap<Integer, Integer> h1 = new HashMap<Integer, Integer>();

        for ( int i=0; i<nums.length; i++ ) {

            int difference = target - nums[i];

            if ( h1.get(difference) != null ) {
                indices[0] = h1.get(difference);
                indices[1] = i;
                break;
            }
            else
                h1.put(nums[i], i);
        }

        return indices;
    }



    // Arrays & Hashing - Problem 4
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> listOfListofStrings = new ArrayList<>();

        // initializing array list
//        for (int i = 0; i < strs.length; i++)
//            listOfListofStrings.add( new ArrayList<String>() );


        for (int i = 0; i < strs.length; i++) {
            String str1 = strs[i];
            // Add first item only one time
            if ( !contains(listOfListofStrings, str1) ) {
                listOfListofStrings.add( new ArrayList<String>() );
                listOfListofStrings.get( listOfListofStrings.size() - 1 ).add(str1);
            }

            for (int j = i+1; j < strs.length; j++) {
                String str2 = strs[j];

                if ( isAnagram2(str1, str2) ) {
                    if ( !contains(listOfListofStrings, str2) )
                        listOfListofStrings.get( listOfListofStrings.size() - 1 ).add(str2);
                }
            }
        }
        return listOfListofStrings;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] store = new int[26];

        for (int i = 0; i < s.length(); i++) {
            store[s.charAt(i) - 'a']++;
            store[t.charAt(i) - 'a']--;
        }

        for (int n : store) if (n != 0) return false;

        return true;
    }

    boolean contains( List<List<String>> lists, String searchStr ) {
        for (List<String> list: lists) {
            for (String str: list) {
                if ( str.equals(searchStr) )
                    return true;
            }
        }
        return false;
    }
}

//    String s = "abbcdddd";
//    String s2 = "ad";
//    int[] store = new int[26];
//
//        for (int i = 0; i < s.length(); i++) {
//        store[s.charAt(i) - 'a']++;
//        }
//
//        for (int i = 0; i < s2.length(); i++) {
//        store[s2.charAt(i) - 'a']--;
//        }
//
//        System.out.println( Arrays.toString(store) );