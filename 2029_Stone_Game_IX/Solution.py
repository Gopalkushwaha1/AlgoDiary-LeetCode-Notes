# /*
## 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha

🧠 Problem: 2029. Stone Game IX
🔗 Platform: LeetCode
🏷 Difficulty: Medium

---

💡 Problem Statement:

Alice and Bob take turns removing stones from the given `stones` array, with Alice going first.

If a player removes a stone and the sum of all removed stones becomes divisible by `3`, that player loses.

If all stones are removed without making the sum divisible by `3`, Bob wins automatically.

Return `true` if Alice wins and `false` if Bob wins.

---

💡 Approach (Game Theory + Modulo)

The important observation is that we don't need the actual values of the stones. We only need their remainder when divided by `3`.

Every stone belongs to one of three groups:

• `remainder = 0`
• `remainder = 1`
• `remainder = 2`

Steps:

• Count how many stones have remainder `0`, `1`, and `2`.
• Remainder `0` does not change the remainder of the current sum.
• Remainder `1` and `2` are important because `1 + 2 = 3`, which is divisible by `3`.
• If the count of remainder `0` stones is even, Alice wins when both remainder `1` and remainder `2` stones are available.
• If the count of remainder `0` stones is odd, compare the number of remainder `1` and remainder `2` stones.
• Alice wins when `|count1 - count2| > 2`.
• Otherwise, Bob wins.

Why it works?

The game only depends on the remainder of the current sum modulo `3`.

Remainder `0` stones do not change the current remainder, so they mainly affect the turn order.

Remainder `1` and `2` are opposite values because:

`1 + 2 = 3`

Therefore, taking the wrong remainder can make the total sum divisible by `3`, causing the current player to lose.

By counting the three types of remainders and considering whether the number of `0` remainders is even or odd, we can determine the winner without simulating every possible game.

---

⏱ Time Complexity : O(n)

📦 Space Complexity: O(1)

---

✍️ Author: Gopal Kushwaha

📚 Repository: AlgoDiary-LeetCode-Notes

=======================================

\*/

# Python Solution

```python
class Solution:
    def stoneGameIX(self, stones):

        # Count stones based on their remainder when divided by 3
        count0 = 0
        count1 = 0
        count2 = 0

        for ele in stones:

            if ele % 3 == 0:
                count0 += 1
            elif ele % 3 == 1:
                count1 += 1
            else:
                count2 += 1

        # If count of remainder 0 stones is even
        if count0 % 2 == 0:
            return count1 >= 1 and count2 >= 1

        # If count of remainder 0 stones is odd
        return abs(count1 - count2) > 2
