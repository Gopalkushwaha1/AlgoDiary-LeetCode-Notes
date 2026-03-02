/*
 ============================================================
 🚀 AlgoDiary - by Gopal Kushwaha
 ------------------------------------------------------------
 Think • Learn • Optimize
 ------------------------------------------------------------
 Problem: 1536. Minimum Swaps to Arrange a Binary Grid
 Approach: Greedy + Trailing Zero Observation
 Time Complexity: O(n^2)
 Space Complexity: O(n)
 ============================================================
*/

/*
     ------------------------------------------------------------
     💡 Core Idea:
     
     Instead of simulating full 2D row swaps,
     we count trailing zeros in each row.
     
     For row i:
     Required trailing zeros = n - i - 1
     
     We greedily bring the first valid row upward
     using adjacent swaps.
     ------------------------------------------------------------
*/

class Solution {

    // Helper method to bring element at index j to index i
    // by shifting elements left (simulating adjacent swaps)
    public void arrange(int[] arr, int i, int j) {
        for (int k = j - 1; k >= i; k--) {
            int temp = arr[k];
            arr[k] = arr[k + 1];
            arr[k + 1] = temp;
        }
    }

    public int minSwaps(int[][] grid) {

        int n = grid.length;
        int[] trailingZeros = new int[n];
        int swapCount = 0;

        // Step 1: Count trailing zeros in each row
        for (int i = 0; i < n; i++) {

            int countZero = 0;

            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] != 0) break;
                countZero++;
            }

            trailingZeros[i] = countZero;
        }

        // Step 2: Greedy placement
        for (int i = 0; i < n; i++) {

            int required = n - i - 1;

            // If already valid, continue
            if (trailingZeros[i] >= required) continue;

            int validIndex = -1;

            // Find first row below with enough trailing zeros
            for (int j = i + 1; j < n; j++) {
                if (trailingZeros[j] >= required) {
                    validIndex = j;
                    break;
                }
            }

            // If no valid row found → impossible
            if (validIndex == -1) return -1;

            // Count swaps
            swapCount += validIndex - i;

            // Bring row upward
            arrange(trailingZeros, i, validIndex);
        }

        return swapCount;
    }
}
