import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TwoPointers {
    // Two Pointers - Problem 1
    public boolean isPalindrome(String s) {
        boolean result = true;

        // 1. Converting to lowercase
        s = s.toLowerCase();
        // 2. Pointers -> indices
        int c1 = 0;
        int c2 = s.length() - 1;


        while ( c1 < c2 && result ) {
            char ch1 = s.charAt(c1);
            char ch2 = s.charAt(c2);

            if ( !Character.isLetterOrDigit(ch1) ) // checking if alphanumeric
                c1++;
            else if ( !Character.isLetterOrDigit(ch2) )
                c2--;
            else {
                if ( ch1 != ch2 )
                    result = false;
                c1++;
                c2--;
            }

        }
        return result;
    }

    // Two Pointers - Problem 2
    public int[] twoSum(int[] numbers, int target) {
        int indices[] = {-1, -1};
        int front = 0;
        int back  = numbers.length - 1;

        while ( front < back && indices[0] == -1 ) {
            if ( target == numbers[front] + numbers[back] ) {
                indices[0] = front + 1;
                indices[1] = back  + 1;
            }
            else if ( target > numbers[front] + numbers[back] )
                front++;
            else
                back--;
        }

        return indices;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        LinkedList<List<Integer>> listOfLists = new LinkedList<List<Integer>>();

        for (int i=0; i<nums.length; i++) {
            if ( i == 0 || nums[i -1] != nums[i] ) {
                int target = -nums[i];
                twoSum(nums, target, i+1, listOfLists);
            }
        }
        return listOfLists;
    }

    public void twoSum(int[] nums, int target, int start, LinkedList<List<Integer>> list) {
        int end = nums.length - 1;

        while ( start < end ) {
            if ( nums[start] + nums[end] == target ) {
                ArrayList<Integer> newGroup = new ArrayList<Integer>();
                newGroup.add( target * -1 );
                newGroup.add( nums[start] );
                newGroup.add( nums[end] );
                list.add( newGroup );
                while ( start < end && nums[start] == nums[start + 1] )
                    start++;
                while ( start < end && nums[end] == nums[end - 1] )
                    end--;
                start++;
                end--;
            }
            else if ( nums[start] + nums[end] < target )
                start++;
            else
                end--;
        }
    }

    public static void main(String[] args) {
        int arr[] = {-1,0,1,2,-1,-4};
        TwoPointers twoPointers = new TwoPointers();
        List<List<Integer>> list = twoPointers.threeSum(arr);
//
//        for ( List<Integer> curr : list ) {
//            for (Integer integer: curr)
//                System.out.print(integer+ " ");
//            System.out.println();
//        }
    }
}
