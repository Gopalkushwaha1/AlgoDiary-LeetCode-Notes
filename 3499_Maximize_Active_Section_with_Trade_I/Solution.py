# /*

## 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha

🧠 Problem: 3499. Maximize Active Section with Trade I  
🔗 Platform: LeetCode  
🏷 Difficulty: Medium  

----------------------------------------------

💡 Problem Statement:

You are given a binary string `s` where:

• '1' represents an active section.
• '0' represents an inactive section.

You can perform at most one trade:

1. Convert a contiguous block of `1`s surrounded by `0`s into `0`s.
2. Then convert a contiguous block of `0`s surrounded by `1`s into `1`s.

Return the maximum number of active sections after performing the optimal trade.

----------------------------------------------

💡 Approach (Block Compression + Greedy)

Steps:

• Count the total number of `1`s in the original string.
• Create the augmented string by adding `1` at both ends.
• Convert the augmented string into alternating block lengths.
• Traverse every valid middle `1` block.
• Calculate the gain using:
  Left `0` Block + Right `0` Block.
• Keep track of the maximum gain.
• Return:
  Original `1`s + Maximum Gain.

Why it works?

Removing a valid `1` block merges the adjacent
`0` blocks into one large block.

When this merged block is converted into `1`s,
the removed `1`s are added back automatically.

Therefore, the final increase depends only on the
sizes of the left and right `0` blocks.

----------------------------------------------

⏱ Time Complexity : O(n)

📦 Space Complexity: O(n)

----------------------------------------------

✍️ Author: Gopal Kushwaha

📚 Repository: AlgoDiary-LeetCode-Notes

=======================================

*/

# Python Solution

```python
class Solution:
    def maxActiveSectionsAfterTrade(self, s: str) -> int:

        # Make the Augmented string
        t = "1" + s + "1"

        # Store alternate block lengths
        blocks = []

        count = 0
        i = 0
        j = 0

        while j < len(t):

            # Continue same block
            if t[i] == t[j]:
                count += 1
                j += 1
                continue

            # New block starts
            blocks.append(count)
            count = 0
            i = j

        # Add last block
        blocks.append(count)

        # Find maximum gain
        max_gain = 0

        for i in range(2, len(blocks) - 1, 2):
            max_gain = max(max_gain, blocks[i - 1] + blocks[i + 1])

        # Count original active sections
        one_count = 0

        for ch in s:
            if ch == '1':
                one_count += 1

        # Return answer
        return one_count + max_gain
```

----------------------------------------------

🔥 Key Concepts

• Binary String

• Greedy

• Block Compression

• Run Length Encoding (RLE)

• String Traversal

• Simulation

----------------------------------------------

⭐ If this repository helped you, consider giving it a star!
