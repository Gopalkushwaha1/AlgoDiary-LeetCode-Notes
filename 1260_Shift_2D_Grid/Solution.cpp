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

Return the 2D grid after applying the shift operation `k` times.

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
• Traverse every element of the grid.
• Move each element one position forward.
• Place the last element at the first position.
• Return the modified grid.

Why it works?

Each iteration simulates exactly one valid shift operation.
After performing the shift `k` times, the grid reaches the required final state.

----------------------------------------------

⏱ Time Complexity : O(k × m × n)

📦 Space Complexity: O(1)

----------------------------------------------

✍️ Author: Gopal Kushwaha

📚 Repository: AlgoDiary-LeetCode-Notes

=======================================

*/

# C++ Solution

```cpp
class Solution {
public:
    vector<vector<int>> shiftGrid(vector<vector<int>>& grid, int k) {

        int row = grid.size();
        int col = grid[0].size();

        // Remove unnecessary shifts
        k %= (row * col);

        // Perform shift k times
        while (k--) {

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

        return grid;
    }
};
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
