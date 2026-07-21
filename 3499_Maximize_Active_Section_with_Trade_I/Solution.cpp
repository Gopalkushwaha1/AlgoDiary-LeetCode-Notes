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

# C++ Solution

```cpp
class Solution {
public:
    int maxActiveSectionsAfterTrade(string s) {

        // Make the Augmented string
        string t = "1" + s + "1";

        // Store alternate block lengths
        vector<int> blocks;

        int count = 0;
        int i = 0;
        int j = 0;

        while (j < t.length()) {

            // Continue same block
            if (t[i] == t[j]) {
                count++;
                j++;
                continue;
            }

            // New block starts
            blocks.push_back(count);
            count = 0;
            i = j;
        }

        // Add last block
        blocks.push_back(count);

        // Find maximum gain
        int maxGain = 0;

        for (int i = 2; i < blocks.size() - 1; i += 2) {
            maxGain = max(maxGain, blocks[i - 1] + blocks[i + 1]);
        }

        // Count original active sections
        int oneCount = 0;

        for (char ch : s) {
            if (ch == '1')
                oneCount++;
        }

        // Return answer
        return oneCount + maxGain;
    }
};
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
