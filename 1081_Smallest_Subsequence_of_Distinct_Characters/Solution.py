# /*

## 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha

🧠 Problem: 1081. Smallest Subsequence of Distinct Characters  
🔗 Platform: LeetCode  
🏷 Difficulty: Medium  

----------------------------------------------

💡 Problem Statement:

Given a string `s`, return the lexicographically smallest
subsequence of `s` that contains all the distinct
characters exactly once.

Example 1:

Input: s = "bcabc"

Output: "abc"

Example 2:

Input: s = "cbacdcbc"

Output: "acdb"

----------------------------------------------

💡 Approach (Greedy + Monotonic Stack)

Steps:

• Store the last occurrence index of every character.
• Use a stack to build the answer.
• Skip characters already present in the stack.
• Remove larger characters from the stack if they appear again later.
• Push the current character into the stack.
• Convert the stack into the final string.

Why it works?

The stack always maintains the smallest possible
lexicographical order while ensuring every distinct
character appears exactly once.

----------------------------------------------

⏱ Time Complexity : O(n)

📦 Space Complexity: O(26) ≈ O(1)

----------------------------------------------

✍️ Author: Gopal Kushwaha

📚 Repository: AlgoDiary-LeetCode-Notes

=======================================

*/

# Python Solution

```python
class Solution:
    def smallestSubsequence(self, s: str) -> str:

        # Store last occurrence of every character
        lastIdx = [0] * 26
        visited = [False] * 26

        for i in range(len(s)):
            lastIdx[ord(s[i]) - ord('a')] = i

        # Create stack
        stack = []

        # Traverse the string
        for i in range(len(s)):

            ch = s[i]

            # Skip if already present
            if visited[ord(ch) - ord('a')]:
                continue

            # Remove larger characters if they appear later
            while (stack and
                   stack[-1] > ch and
                   lastIdx[ord(stack[-1]) - ord('a')] > i):

                visited[ord(stack.pop()) - ord('a')] = False

            stack.append(ch)
            visited[ord(ch) - ord('a')] = True

        # Return answer
        return "".join(stack)
```

----------------------------------------------

🔥 Key Concepts

• Greedy Algorithm

• Monotonic Stack

• Lexicographical Order

• Last Occurrence Array

• Visited Array

• String Processing

----------------------------------------------

⭐ If this repository helped you, consider giving it a star!
