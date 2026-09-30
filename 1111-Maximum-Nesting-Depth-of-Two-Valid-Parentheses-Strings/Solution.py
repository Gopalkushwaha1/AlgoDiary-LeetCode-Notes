# /*

## 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha

🧠 Problem: 1111. Maximum Nesting Depth of Two Valid Parentheses Strings  
🔗 Platform: LeetCode  
🏷 Difficulty: Medium

---

💡 Problem Statement:

Given a valid parentheses string `seq`, split it into two subsequences `A` and `B` such that both are valid parentheses strings and the maximum nesting depth is minimized.

Return an array where:

• `0` → character belongs to `A`  
• `1` → character belongs to `B`

---

💡 Approach:

First, find the maximum nesting depth of the given string.

We maintain:

• `currDepth` → current nesting depth  
• `maxDepth` → maximum nesting depth

Then divide the maximum depth into two parts using:

`splitIdx = maxDepth / 2`

While traversing the string again, assign each parenthesis to group `0` or `1` based on its current nesting depth.

---

🔍 Logic:

For `(`:

• Increase `currSplit`

• If `currSplit <= splitIdx` → assign `0`

• Otherwise → assign `1`

For `)`:

• Decrease `currSplit`

• If `currSplit < splitIdx` → assign `0`

• Otherwise → assign `1`

This distributes the nesting levels between the two groups.

---

💻 Python Code:

```python
class Solution:

    def split(self, seq):
        maxDepth = 0
        currDepth = 0

        for ch in seq:

            if ch == '(':
                currDepth += 1
                maxDepth = max(maxDepth, currDepth)

            else:
                currDepth -= 1

        return maxDepth // 2

    def maxDepthAfterSplit(self, seq):

        length = len(seq)
        splitIdx = self.split(seq)

        ans = [0] * length
        currSplit = 0

        for i in range(length):

            ch = seq[i]

            if ch == '(':

                currSplit += 1

                if currSplit <= splitIdx:
                    ans[i] = 0
                else:
                    ans[i] = 1

            else:

                currSplit -= 1

                if currSplit < splitIdx:
                    ans[i] = 0
                else:
                    ans[i] = 1

        return ans
