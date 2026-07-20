# /*

## 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha

🧠 Problem: 1260. Shift 2D Grid  
🔗 Platform: LeetCode  
🏷 Difficulty: Easy  

----------------------------------------------

💡 Problem Statement:

You are given an `m x n` 2D grid and an integer `k`.

In one shift operation:

• Element at `grid[i][j]` moves to `grid[i][j + 1]`.
• Element at the end of a row moves to the beginning of the next row.
• The bottom-right element moves to the top-left corner.

Return the grid after applying the shift operation `k` times.

Example 1:

Input:

grid = [[1,2,3],[4,5,6],[7,8,9]]

k = 1

Output:

[[9,1,2],[3,4,5],[6,7,8]]

----------------------------------------------

💡 Approach (Simulation)

Steps:

• Find the number of rows and columns.
• Reduce unnecessary shifts using `k % (rows × cols)`.
• Perform the shift operation exactly `k` times.
• During each shift, keep track of the previous and current values.
• Move every element one position forward.
• Place the last element at the first position.
• Convert the final grid into `List<List<Integer>>`.

Why it works?

Each iteration simulates exactly one valid shift operation.
After performing the shift `k` times, the grid reaches the required final state.

----------------------------------------------

⏱ Time Complexity : O(k × m × n)

📦 Space Complexity: O(m × n)

----------------------------------------------

✍️ Author: Gopal Kushwaha

📚 Repository: AlgoDiary-LeetCode-Notes

=======================================

*/

# Java Solution

```java
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int row = grid.length;
        int col = grid[0].length;

        List<List<Integer>> list = new ArrayList<>();

        // Remove unnecessary shifts
        k = k % (row * col);

        // Perform shift k times
        for (int i = 0; i < k; i++) {

            int curr = grid[0][0];
            int prev = grid[0][0];

            // Shift every element
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {

                    prev = curr;
                    curr = grid[r][c];
                    grid[r][c] = prev;
                }
            }

            // Move last element to first position
            grid[0][0] = curr;
        }

        // Convert 2D Array -> List<List<Integer>>
        for (int i = 0; i < row; i++) {

            List<Integer> temp = new ArrayList<>();

            for (int j = 0; j < col; j++) {
                temp.add(grid[i][j]);
            }

            list.add(temp);
        }

        return list;
    }
}
```

----------------------------------------------

🔥 Key Concepts

• Simulation

• Matrix Traversal

• 2D Array

• Grid Manipulation

• Index Traversal

• Array

----------------------------------------------

⭐ If this repository helped you, consider giving it a star!
