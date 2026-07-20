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

# Python Solution

```python
from typing import List

class Solution:
    def shiftGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:

        row = len(grid)
        col = len(grid[0])

        # Remove unnecessary shifts
        k %= (row * col)

        # Perform shift k times
        for _ in range(k):

            curr = grid[0][0]
            prev = grid[0][0]

            # Shift every element
            for r in range(row):
                for c in range(col):

                    prev = curr
                    curr = grid[r][c]
                    grid[r][c] = prev

            # Move last element to first position
            grid[0][0] = curr

        return grid
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
