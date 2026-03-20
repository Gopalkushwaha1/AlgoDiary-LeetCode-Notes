/*

## 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha

🧠 Problem: 3567. Minimum Absolute Difference in Sliding Submatrix  
🔗 Platform: LeetCode  
🏷 Difficulty: Medium  

---------------------

💡 Problem Statement:

You are given a 2D grid and an integer k.

For every k × k submatrix, find the **minimum absolute difference**
between any two distinct elements inside that submatrix.

Return a matrix where each cell represents the answer for that submatrix.

----------------------------------------------

📌 Example (Concept)

Grid:
1 3 6
4 8 2
7 5 9

k = 2

Submatrices:
[1,3,4,8] → min diff = 1  
[3,6,8,2] → min diff = 1  
...

----------------------------------------------

⚠️ Approach 1 (Brute Force + Sorting)

Idea:

• Traverse every k × k submatrix  
• Store elements in a set (to remove duplicates)  
• Convert to list and sort  
• Find minimum difference between adjacent elements  

Steps:

1. Fix top-left corner (i, j)  
2. Extract k × k elements  
3. Sort unique values  
4. Compute min difference  

----------------------------------------------

⏱ Time Complexity:

O((n * m * k²) + sorting)

≈ O(n * m * k² log k²)

📦 Space Complexity:

O(k²)

----------------------------------------------

⚡ Optimization Ideas (For Future)

• Use balanced BST / TreeSet for dynamic window  
• Sliding window optimization in 2D  
• Avoid re-sorting from scratch  

----------------------------------------------

✍️ Author: Gopal Kushwaha  
📚 Repository: AlgoDiary-LeetCode-Notes  

=======================================

*/

class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;

        // Result matrix
        int[][] ans = new int[row - k + 1][col - k + 1];

        // Traverse all possible k x k submatrices
        for (int i = 0; i <= row - k; i++) {
            for (int j = 0; j <= col - k; j++) {

                // Store unique elements
                HashSet<Integer> set = new HashSet<>();

                // Extract k x k window
                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        set.add(grid[x][y]);
                    }
                }

                // Convert to list & sort
                List<Integer> list = new ArrayList<>(set);
                Collections.sort(list);

                // Find minimum absolute difference
                int min = Integer.MAX_VALUE;

                for (int idx = 1; idx < list.size(); idx++) {
                    min = Math.min(min, list.get(idx) - list.get(idx - 1));
                }

                // If all elements same → return 0
                ans[i][j] = (min == Integer.MAX_VALUE) ? 0 : min;
            }
        }

        return ans;
    }
}
