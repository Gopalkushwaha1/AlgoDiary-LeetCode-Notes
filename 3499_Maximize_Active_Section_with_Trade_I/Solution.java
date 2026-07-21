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
• Keep the maximum gain.
• Return:
  Original `1`s + Maximum Gain.

Why it works?

Removing a valid `1` block merges the adjacent
`0` blocks into one large block.

The removed `1`s are added back when that merged
`0` block is converted to `1`s.

Therefore, the net increase depends only on the
sizes of the left and right `0` blocks.

----------------------------------------------

⏱ Time Complexity : O(n)

📦 Space Complexity: O(n)

----------------------------------------------

✍️ Author: Gopal Kushwaha

📚 Repository: AlgoDiary-LeetCode-Notes

=======================================

*/

# Java Solution

```java
class Solution {
    public int maxActiveSectionsAfterTrade(String s) {

        // Make the Augmented string
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        sb.append(s);
        sb.append("1");

        // Store alternate block lengths
        List<Integer> list = new ArrayList<>();

        int count = 0;
        int i = 0;
        int j = 0;

        while (j < sb.length()) {

            // Continue same block
            if (sb.charAt(i) == sb.charAt(j)) {
                count++;
                j++;
                continue;
            }

            // New block starts
            list.add(count);
            count = 0;
            i = j;
        }

        // Add last block
        list.add(count);

        // Find maximum gain
        int max = 0;

        for (i = 2; i < list.size() - 1; i += 2) {
            max = Math.max(max, list.get(i - 1) + list.get(i + 1));
        }

        // Count original active sections
        int oneCount = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '1')
                oneCount++;
        }

        return oneCount + max;
    }
}
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
