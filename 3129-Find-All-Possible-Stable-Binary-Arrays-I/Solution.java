# /*

## 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha

🧠 Problem: 3129. Find All Possible Stable Binary Arrays I
🔗 Platform: LeetCode
🏷 Difficulty: Medium
---------------------

💡 Approach:
Dynamic Programming + Memoization

We need to construct binary arrays using exactly:
• `zero` number of 0s
• `one` number of 1s

Constraint:
No more than `limit` consecutive identical elements
are allowed.

DP State:
dp[zeroLeft][oneLeft][curr][count]

where:
• zeroLeft → number of 0s remaining
• oneLeft  → number of 1s remaining
• curr     → current element (0 or 1)
• count    → how many consecutive times it appeared

Transition:
• If next element is same → increase count
• If different → reset count = 1
• Ensure count ≤ limit

---

⏱ Time Complexity : O(zero × one × limit × 2)
📦 Space Complexity: O(zero × one × limit × 2)
----------------------------------------------

✍️ Author: Gopal Kushwaha
📚 Repository: AlgoDiary-LeetCode-Notes
=======================================

*/

class Solution {

```
static int[][][][] dp;
static int mod = 1_000_000_007;

public int find(int zeroLeft, int oneLeft, int curr, int count, int limit) {

    // valid array formed
    if (zeroLeft == 0 && oneLeft == 0) {
        return 1;
    }

    // memoization check
    if (dp[zeroLeft][oneLeft][curr][count] != -1) {
        return dp[zeroLeft][oneLeft][curr][count];
    }

    int ways = 0;

    // place 0
    if (zeroLeft > 0) {

        if (curr == 0) {
            if (count + 1 <= limit) {
                ways = (ways + find(zeroLeft - 1, oneLeft, 0, count + 1, limit)) % mod;
            }
        } else {
            ways = (ways + find(zeroLeft - 1, oneLeft, 0, 1, limit)) % mod;
        }
    }

    // place 1
    if (oneLeft > 0) {

        if (curr == 1) {
            if (count + 1 <= limit) {
                ways = (ways + find(zeroLeft, oneLeft - 1, 1, count + 1, limit)) % mod;
            }
        } else {
            ways = (ways + find(zeroLeft, oneLeft - 1, 1, 1, limit)) % mod;
        }
    }

    return dp[zeroLeft][oneLeft][curr][count] = ways;
}

public int numberOfStableArrays(int zero, int one, int limit) {

    dp = new int[zero + 1][one + 1][2][limit + 1];

    // initialize DP with -1
    for (int i = 0; i <= zero; i++) {
        for (int j = 0; j <= one; j++) {
            for (int k = 0; k < 2; k++) {
                for (int l = 0; l <= limit; l++) {
                    dp[i][j][k][l] = -1;
                }
            }
        }
    }

    int ways = 0;

    // start with 0
    if (zero > 0) {
        ways = (ways + find(zero - 1, one, 0, 1, limit)) % mod;
    }

    // start with 1
    if (one > 0) {
        ways = (ways + find(zero, one - 1, 1, 1, limit)) % mod;
    }

    return ways;
}
```

}
