# /*

## 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha

🧠 Problem: 2267. Check if There Is a Valid Parentheses String Path
🔗 Platform: LeetCode
🏷 Difficulty: Hard

---

💡 Problem Statement:

You are given an `m x n` matrix of parentheses `grid`.

Starting from the **top-left cell** and ending at the **bottom-right cell**, you can only move:

• Down ↓
• Right →

The characters collected along the path form a parentheses string.

Return `true` if there exists a path that forms a **valid parentheses string**.

---

💡 Approach:

We use **DFS + 3D Dynamic Programming (Memoization)**.

We maintain a `count` variable to keep track of the current parentheses balance.

• If `(` comes → increase `count`.

• If `)` comes → decrease `count`.

• If `count < 0` → the path is invalid because there are more closing parentheses than opening parentheses.

At every cell, we have two choices:

• Move Down ↓

• Move Right →

We store already calculated states using:

`dp[row][col][count]`

This avoids calculating the same state again.

---

🔍 Important Checks:

Before starting the DFS, we check:

• If the first cell is `)` → immediately return `false`.

• If the last cell is `(` → immediately return `false`.

• The total path length is `r + c - 1`.

• A valid parentheses string must always have an even length.

These checks help eliminate impossible cases early.

---

🔍 Example:

`grid = [["(","(","("],[")","(",")"],["(","(",")"],["(","(",")"]]`

A valid path can form:

`()(())`

or

`((()))`

Both are valid parentheses strings.

Therefore:

`Answer = true`

---

🧠 DP State:

`dp[row][col][count]`

Where:

• `row` → current row

• `col` → current column

• `count` → current parentheses balance

If the same state occurs again, we directly use the previously calculated result.

---

⏱ Time Complexity: O(m × n × (m + n))

📦 Space Complexity: O(m × n × (m + n))

---

✍️ Author: Gopal Kushwaha

📚 Repository: AlgoDiary-LeetCode-Notes

=======================================

*/

# Python Solution

```python
class Solution:
    def hasValidPath(self, grid):
        
        # Taking rows and columns
        r = len(grid)
        c = len(grid[0])

        # First character must be '('
        if grid[0][0] == ')':
            return False

        # Last character must be ')'
        if grid[r - 1][c - 1] == '(':
            return False

        # Valid parentheses string must have even length
        if (r + c - 1) % 2 == 1:
            return False

        # 3D DP:
        # dp[row][col][count]
        dp = [[[None] * (r + c + 1) for _ in range(c)] for _ in range(r)]

        def isValid(row, col, count):

            # Check current character
            if grid[row][col] == '(':
                count += 1
            else:
                count -= 1

            # If closing brackets are more than opening brackets
            if count < 0:
                return False

            # If we reached the destination
            if row == r - 1 and col == c - 1:
                return count == 0

            # Check already calculated state
            if dp[row][col][count] is not None:
                return dp[row][col][count]

            ans = False

            # Move Down
            if row + 1 < r:
                ans = isValid(row + 1, col, count)

            # Move Right
            if not ans and col + 1 < c:
                ans = isValid(row, col + 1, count)

            # Store result
            dp[row][col][count] = ans

            return ans

        # Check for a valid path
        return isValid(0, 0, 0)
```
