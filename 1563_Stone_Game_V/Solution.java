# /*

## 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha

🧠 Problem: 1563. Stone Game V
🔗 Platform: LeetCode
🏷 Difficulty: Hard

---

💡 Problem Statement:

There are several stones arranged in a row, and each stone has an associated value given in the array `stoneValue`.

In each round, Alice divides the row into two non-empty rows: a left row and a right row.

Bob calculates the sum of both rows and throws away the row with the maximum sum.

Alice's score increases by the value of the remaining row.

If the values of both rows are equal, Bob lets Alice decide which row to throw away.

The game continues until only one stone remains.

Return the maximum score that Alice can obtain.

---

💡 Approach (Recursion + Memoization + Prefix Sum)

The important observation is that Alice can divide the current range at any possible index.

For a range:

`[left ... right]`

we try every possible split:

`[left ... i] | [i + 1 ... right]`

For every split, calculate the sum of both parts.

### Prefix Sum

To calculate the sum of any range efficiently, we use a Prefix Sum array.

For the left part:

`leftSum = prefix[i + 1] - prefix[left]`

For the right part:

`rightSum = prefix[right + 1] - prefix[i + 1]`

This allows us to calculate both sums in `O(1)` time.

---

### Case 1: Left Sum < Right Sum

If:

`leftSum < rightSum`

Bob throws away the right side.

Alice gets `leftSum`, and the game continues with the left part.

So:

`leftSum + solve(left, i)`

---

### Case 2: Right Sum < Left Sum

If:

`rightSum < leftSum`

Bob throws away the left side.

Alice gets `rightSum`, and the game continues with the right part.

So:

`rightSum + solve(i + 1, right)`

---

### Case 3: Left Sum == Right Sum

If both sums are equal, Alice can choose either side.

So we calculate both possibilities and take the maximum:

`max(leftSum + solve(left, i), rightSum + solve(i + 1, right))`

---

### Why Recursion?

After Alice chooses a split, the game continues with only one of the two parts.

So the same problem is repeated on a smaller range.

We define:

`solve(left, right)`

as:

> The maximum score Alice can obtain from the stones between `left` and `right`.

When only one stone remains:

`left == right`

the game ends, so Alice gets:

`0`

---

### Why Memoization?

Without memoization, the same range can be calculated multiple times.

For example:

`solve(0, 2)`

may be reached from different recursive paths.

Therefore, we store the result in:

`dp[left][right]`

If the value is already calculated, we simply return it.

This avoids repeated calculations.

---

### Why do we take Math.max()?

Alice can choose the split point.

Different split points can produce different scores.

Therefore, for every possible split, we calculate the score and keep the maximum:

`ans = Math.max(ans, currentScore)`

After trying all possible splits, `ans` contains the maximum score Alice can obtain for the current range.

---

### Key DP Idea

The complete idea can be summarized as:

`Range`
↓
`Try every possible split`
↓
`Calculate leftSum and rightSum`
↓
`Bob keeps the smaller side`
↓
`Continue recursively`
↓
`Take the maximum score`
↓
`Memoize the result`

---

⏱ Time Complexity: O(n³)

📦 Space Complexity: O(n²)

Prefix Sum allows each range sum to be calculated in `O(1)` time.

There are `O(n²)` possible `(left, right)` states, and for every state we try `O(n)` split points.

Therefore:

`Time = O(n³)`

`Space = O(n²)`

---

✍️ Author: Gopal Kushwaha

📚 Repository: AlgoDiary-LeetCode-Notes

=======================================

*/

# Java Solution

```java
class Solution {
    int[] prefix;
    int[][] dp;

    public int stoneGameV(int[] stoneValue) {

        int n = stoneValue.length;

        prefix = new int[n + 1];

        dp = new int[n][n];

        // Fill DP with -1
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        // Build Prefix Sum
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        return solve(0, n - 1);
    }

    public int solve(int left, int right) {

        // Only one stone remains
        if (left == right) {
            return 0;
        }

        // Return already calculated result
        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        int ans = 0;

        // Try every possible split
        for (int i = left; i < right; i++) {

            // Calculate left and right sums using Prefix Sum
            int leftSum = prefix[i + 1] - prefix[left];

            int rightSum = prefix[right + 1] - prefix[i + 1];

            // Left side is smaller
            if (leftSum < rightSum) {

                ans = Math.max(
                    ans,
                    leftSum + solve(left, i)
                );
            }

            // Right side is smaller
            else if (rightSum < leftSum) {

                ans = Math.max(
                    ans,
                    rightSum + solve(i + 1, right)
                );
            }

            // Both sides have equal sum
            else {

                ans = Math.max(
                    ans,
                    Math.max(
                        leftSum + solve(left, i),
                        rightSum + solve(i + 1, right)
                    )
                );
            }
        }

        // Store the answer for this range
        dp[left][right] = ans;

        return ans;
    }
}
```
