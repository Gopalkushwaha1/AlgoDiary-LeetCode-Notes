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

# Java Solution

```java
class Solution {

    public String smallestSubsequence(String s) {

        // Store last occurrence of every character
        int[] lastIdx = new int[26];
        boolean[] visited = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            lastIdx[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Skip if already present
            if (visited[ch - 'a'])
                continue;

            // Remove larger characters if they occur later
            while (!stack.isEmpty()
                    && stack.peek() > ch
                    && lastIdx[stack.peek() - 'a'] > i) {

                visited[stack.pop() - 'a'] = false;
            }

            stack.push(ch);
            visited[ch - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();

        for (char ch : stack) {
            ans.append(ch);
        }

        return ans.toString();
    }
}
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
