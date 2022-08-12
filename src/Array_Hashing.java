import java.util.*;

class Array_Hashing {

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

    public boolean containsDuplicate2(int[] nums) {

        HashSet<Integer> hashSet = new HashSet<Integer>();

        for ( int i=0; i<nums.length; i++ ) {
            if ( hashSet.contains(nums[i]) )
                return true;
            hashSet.add(nums[i]);
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
    public List<List<String>> groupAnagrams (String[] strs) {
        HashMap<String, ArrayList<String>> words = new HashMap<String, ArrayList<String>>();
        List<List<String>> list = new ArrayList<List<String>>();

        for ( String str: strs ) {
            String key = getKey(str);
            ArrayList<String> anagramGroup = words.get(key); // arrayList

            if ( anagramGroup != null) // something already exists
                anagramGroup.add( str );

            else {
                anagramGroup = new ArrayList<String> ();
                anagramGroup.add( str);
                words.put( key, anagramGroup );
            }
        }

        // Looping though HashMap storing in List of List
        list.addAll(words.values());

        return list;
    }

    public String getKey(String word) {
        word       = word.toLowerCase();
        char arr[] = new char[26];

        for ( int i=0; i<word.length(); i++ )
            arr[word.charAt(i) - 'a']++;

        return (new String(arr));
    }


    // Arrays & Hashing - Problem 5
    // SKIPPED FOR NOW




    // Arrays & Hashing - Problem 6
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int left  = 1;
        int right = 1;
        result[0] = left;

        // for Prefix
        for ( int i=0; i<nums.length - 1; i++ ) {
            int num = nums[i];
            left *= num;
            result[i + 1] = left;
        }

        // for Postfix
        for ( int i=nums.length - 1; i>= 1; i--) {
            int num = nums[i];
            right *= num;
            result[i - 1] *= right;
        }

        return result;
    }

    // Arrays & Hashing - Problem 7
    public boolean isValidSudoku(char[][] board) {

        HashSet[] rows = new HashSet[9];
        HashSet[] cols = new HashSet[9];
        HashSet[] squares = new HashSet[9];

        // initializing the hashSets
        for (int i = 0; i < cols.length; i++) {
            rows[i]    = new HashSet<Character>();
            cols[i]    = new HashSet<Character>();
            squares[i] = new HashSet<Character>();
        }

        // checking rows & columns
        for ( int r=0; r<board.length; r++ )  {
            for ( int c=0; c<board[r].length; c++ )  {
                char ch = board[r][c];
                int sqIndex = ( (r/3)*3 ) + c / 3;

                if ( ch == '.' )
                    continue;

                if ( rows[r].contains(ch) || cols[c].contains(ch) || squares[sqIndex].contains(ch) )
                    return false;

                rows[r].add(ch);
                cols[c].add(ch);
                squares[sqIndex].add(ch);
            }
        }
        return true;
    }




    public static void main(String[] args) {
        Array_Hashing array_hashing = new Array_Hashing();
        System.out.println( array_hashing.getKey("abc") );
    }
}
