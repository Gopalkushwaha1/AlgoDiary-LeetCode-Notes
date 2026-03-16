"""

## 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha

🧠 Problem: 1878. Get Biggest Three Rhombus Sums in a Grid
🔗 Platform: LeetCode
🏷 Difficulty: Medium

---------------------

💡 Problem Statement:

You are given an m × n integer matrix grid.

A rhombus sum is defined as the sum of the elements that form the
border of a rhombus shape in the grid.

The rhombus is basically a square rotated by 45°, and only
the border elements are included in the sum.

Return the three largest distinct rhombus sums in descending order.

If there are fewer than three distinct values, return all of them.

----------------------------------------------

⚡ Approach (Grid Traversal + Simulation)

Key Idea:

• Every cell can act as the top vertex of a rhombus  
• Expand rhombus size k step-by-step  
• Calculate the border sum in four diagonal directions  
• Store distinct sums using a set  
• Maintain top 3 largest values using a Min Heap

Steps:

1. Iterate through each cell of the grid
2. Treat it as the top point of a rhombus
3. Expand rhombus size k
4. Stop when rhombus goes out of bounds
5. Calculate rhombus border sum
6. Maintain top 3 distinct sums

----------------------------------------------

🧠 Data Structures Used

• set → to store distinct rhombus sums  
• heapq (Min Heap) → to maintain top 3 largest values

----------------------------------------------

⏱ Time Complexity

O(m × n × min(m,n))

----------------------------------------------

📦 Space Complexity

O(1) extra (excluding result storage)

----------------------------------------------

✍️ Author: Gopal Kushwaha
📚 Repository: AlgoDiary-LeetCode-Notes

=======================================

"""

import heapq

class Solution:

    def find(self, grid, i, j, k):

        n = len(grid)
        m = len(grid[0])

        # Out of bound check
        if i + 2*k >= n or j + k >= m or j - k < 0:
            return -1

        r, c = i, j
        total = 0

        # top → left
        for l in range(k):
            total += grid[r + l][c - l]

        # left → bottom
        r, c = i + k, j - k
        for l in range(k):
            total += grid[r + l][c + l]

        # bottom → right
        r, c = i + 2*k, j
        for l in range(k):
            total += grid[r - l][c + l]

        # right → top
        r, c = i + k, j + k
        for l in range(k):
            total += grid[r - l][c - l]

        return total


    def getBiggestThree(self, grid):

        row = len(grid)
        col = len(grid[0])

        pq = []
        seen = set()

        for i in range(row):
            for j in range(col):

                # Single cell rhombus
                if grid[i][j] not in seen:
                    seen.add(grid[i][j])
                    heapq.heappush(pq, grid[i][j])
                    if len(pq) > 3:
                        heapq.heappop(pq)

                for k in range(1, min(row, col)//2 + 1):

                    val = self.find(grid, i, j, k)

                    if val == -1:
                        break

                    if val not in seen:
                        seen.add(val)
                        heapq.heappush(pq, val)
                        if len(pq) > 3:
                            heapq.heappop(pq)

        ans = []
        while pq:
            ans.append(heapq.heappop(pq))

        return ans[::-1]
