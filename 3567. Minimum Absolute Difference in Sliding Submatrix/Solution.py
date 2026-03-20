"""

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

----------------------------------------------

⚠️ Approach 1 (Brute Force + Sorting)

Idea:

• Traverse every k × k submatrix  
• Store elements in a set (to remove duplicates)  
• Convert to list and sort  
• Find minimum difference between adjacent elements  

----------------------------------------------

⏱ Time Complexity:

O(n * m * k² log(k²))

📦 Space Complexity:

O(k²)

----------------------------------------------

⚡ Optimization Ideas (For Future)

• Use SortedList / Tree structure  
• Sliding Window in 2D  
• Avoid re-sorting every time  

----------------------------------------------

✍️ Author: Gopal Kushwaha  
📚 Repository: AlgoDiary-LeetCode-Notes  

=======================================

"""

from typing import List

class Solution:
    def minAbsDiff(self, grid: List[List[int]], k: int) -> List[List[int]]:
        row, col = len(grid), len(grid[0])

        # Result matrix
        ans = [[0] * (col - k + 1) for _ in range(row - k + 1)]

        # Traverse all k x k submatrices
        for i in range(row - k + 1):
            for j in range(col - k + 1):

                # Store unique elements
                s = set()

                # Extract k x k window
                for x in range(i, i + k):
                    for y in range(j, j + k):
                        s.add(grid[x][y])

                # Sort values
                lst = sorted(s)

                # Find minimum absolute difference
                min_diff = float('inf')

                for idx in range(1, len(lst)):
                    min_diff = min(min_diff, lst[idx] - lst[idx - 1])

                # If all elements same → return 0
                ans[i][j] = 0 if min_diff == float('inf') else min_diff

        return ans
