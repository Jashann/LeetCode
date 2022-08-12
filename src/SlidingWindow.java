import java.util.HashSet;

public class SlidingWindow {
    // Sliding Window - Problem 1
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int ans = Integer.MIN_VALUE;
        for (int val : prices) {
            min = Math.min(min, val);
            ans = Math.max(ans, val - min);
            // System.out.println( min + " - " + ans );
        }
        return ans;
    }

    // Sliding Window - Problem 2
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> h1 = new HashSet<Character>();
        int max = 0;
        int front = 0;

        for ( int right=0; right<s.length(); right++ ) {
            char ch = s.charAt(right);

            while ( h1.contains(ch) )
                h1.remove( s.charAt(front++) );

            h1.add(ch);
            max = Math.max( max, h1.size() );
        }
        return max;
    }

}
