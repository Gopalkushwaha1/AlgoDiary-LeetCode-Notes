# ================================================================

# 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha

# ---------------------------------------------------------------

# 🧠 Problem: 3129. Find All Possible Stable Binary Arrays I

# 🔗 Platform: LeetCode

# 🏷 Difficulty: Medium

# ---------------------------------------------------------------

# 💡 Approach:

# Dynamic Programming + Memoization

#

# We must construct binary arrays using:

# • exactly `zero` number of 0s

# • exactly `one` number of 1s

#

# Constraint:

# No more than `limit` consecutive identical numbers.

#

# DP State:

# dp[zeroLeft][oneLeft][curr][count]

#

# where:

# • zeroLeft → remaining 0s

# • oneLeft  → remaining 1s

# • curr     → current element (0 or 1)

# • count    → consecutive occurrences of curr

#

# Transition:

# • If placing same element → count + 1

# • If different element → reset count = 1

# • Ensure count ≤ limit

#

# ---------------------------------------------------------------

# ⏱ Time Complexity : O(zero × one × limit × 2)

# 📦 Space Complexity: O(zero × one × limit × 2)

# ---------------------------------------------------------------

# ✍️ Author: Gopal Kushwaha

# 📚 Repository: AlgoDiary-LeetCode-Notes

# ================================================================

class Solution:

```
mod = 10**9 + 7

def find(self, zeroLeft, oneLeft, curr, count, limit):

    # valid array formed
    if zeroLeft == 0 and oneLeft == 0:
        return 1

    # memoization check
    if self.dp[zeroLeft][oneLeft][curr][count] != -1:
        return self.dp[zeroLeft][oneLeft][curr][count]

    ways = 0

    # place 0
    if zeroLeft > 0:
        if curr == 0:
            if count + 1 <= limit:
                ways += self.find(zeroLeft-1, oneLeft, 0, count+1, limit)
        else:
            ways += self.find(zeroLeft-1, oneLeft, 0, 1, limit)

    # place 1
    if oneLeft > 0:
        if curr == 1:
            if count + 1 <= limit:
                ways += self.find(zeroLeft, oneLeft-1, 1, count+1, limit)
        else:
            ways += self.find(zeroLeft, oneLeft-1, 1, 1, limit)

    ways %= self.mod

    self.dp[zeroLeft][oneLeft][curr][count] = ways
    return ways

def numberOfStableArrays(self, zero: int, one: int, limit: int) -> int:

    # initialize dp
    self.dp = [[[[-1]*(limit+1) for _ in range(2)]
                for _ in range(one+1)]
                for _ in range(zero+1)]

    ways = 0

    # start with 0
    if zero > 0:
        ways += self.find(zero-1, one, 0, 1, limit)

    # start with 1
    if one > 0:
        ways += self.find(zero, one-1, 1, 1, limit)

    return ways % self.mod
```
