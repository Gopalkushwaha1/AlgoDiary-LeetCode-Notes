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

# C++ Solution

```cpp
class Solution {
    vector<vector<vector<int>>> dp;

public:

    bool isValid(int startR, int startC,
                 int endR, int endC,
                 vector<vector<char>>& grid,
                 int count) {

        // Check current character
        if (grid[startR][startC] == '(') {
            count++;
        }
        else {
            count--;
        }

        // If closing brackets are more than opening brackets
        if (count < 0) {
            return false;
        }

        // If we reached the destination
        if (startR == endR && startC == endC) {
            return count == 0;
        }

        // Check already calculated state
        if (dp[startR][startC][count] != -1) {
            return dp[startR][startC][count];
        }

        bool ans = false;

        // Move Down
        if (startR + 1 <= endR) {
            ans = isValid(
                startR + 1,
                startC,
                endR,
                endC,
                grid,
                count
            );
        }

        // Move Right
        if (!ans && startC + 1 <= endC) {
            ans = isValid(
                startR,
                startC + 1,
                endR,
                endC,
                grid,
                count
            );
        }

        // Store result
        return dp[startR][startC][count] = ans;
    }

    bool hasValidPath(vector<vector<char>>& grid) {

        // Taking rows and columns
        int r = grid.size();
        int c = grid[0].size();

        // DP initialization
        dp.assign(
            r,
            vector<vector<int>>(
                c,
                vector<int>(r + c + 1, -1)
            )
        );

        // First character must be '('
        if (grid[0][0] == ')') {
            return false;
        }

        // Last character must be ')'
        if (grid[r - 1][c - 1] == '(') {
            return false;
        }

        // Valid parentheses string must have even length
        if ((r + c - 1) % 2 == 1) {
            return false;
        }

        // Check for a valid path
        return isValid(
            0,
            0,
            r - 1,
            c - 1,
            grid,
            0
        );
    }
};
```
