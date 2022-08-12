public class BinarySearch {
    // Binary Search - Problem 1
    public int search(int[] nums, int target) {
        if (nums == null)
            return -1;

        boolean found = false;
        int lb  = 0;
        int ub  = nums.length - 1;
        int mid = 0;

        while ( lb <= ub && !found ) {
            mid = (lb + ub)/2;

            if ( nums[mid] == target )
                found = true;
            else if ( nums[mid] < target )
                lb = mid + 1;
            else
                ub = mid - 1;
        }
        return found ? mid : -1;
    }


    // Binary Search - Problem 2
    public boolean searchMatrix(int[][] matrix, int target) {

        if ( matrix == null || matrix[0] == null )
            return false;

        boolean found = false;

        int rStart = 0;
        int rEnd   = matrix.length - 1;
        int mid   = 0;

        int cStart = 0;
        int cEnd   = matrix[0].length - 1;


        while ( rStart <= rEnd && !found ) {
            mid = ( rStart + rEnd ) / 2;

            if ( matrix[mid][cStart] <= target && matrix[mid][cEnd] >= target )
                found = true;
            else if ( matrix[mid][cStart] > target )
                rEnd = mid - 1;
            else
                rStart = mid + 1;
        }

        if ( found ) {
            if ( matrix[mid][cStart] != target && matrix[mid][cEnd] != target )
                found = searchCol(matrix[mid], target);
        }

        return found;
    }

    public boolean searchCol(int[] nums, int target) {

        if (nums == null)
            return false;

        boolean found = false;
        int lb  = 0;
        int ub  = nums.length - 1;
        int mid = 0;

        while ( lb <= ub && !found ) {
            mid = (lb + ub)/2;

            if ( nums[mid] == target )
                found = true;
            else if ( nums[mid] < target )
                lb = mid + 1;
            else
                ub = mid - 1;
        }

        return found;
    }

    public static void main(String[] args) {
        int matrix[][] = {
                {1,3},
        };

        BinarySearch bs = new BinarySearch();
        System.out.println( bs.searchMatrix(matrix, 1) );
    }
}
