# /*

## 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha

🧠 Problem: 1614. Maximum Nesting Depth of the Parentheses  
🔗 Platform: LeetCode  
🏷 Difficulty: Easy

---

💡 Problem Statement:

Given a valid parentheses string `s`, return its **maximum nesting depth**.

Example:

`s = "(1+(2*3)+((8)/4))+1"`

Answer:

`3`

---

💡 Approach:

We use a simple counter.

• `(` → increase `parentheses`

• `)` → decrease `parentheses`

• Update `max` whenever the depth increases.

The maximum depth is the answer.

---

🔍 Example:

`s = "(1+(2*3)+((8)/4))+1"`

Maximum nested parentheses = `3`

Answer = `3`

---

⏱ Time Complexity: O(n)

📦 Space Complexity: O(1)

---

✍️ Author: Gopal Kushwaha

📚 Repository: AlgoDiary-LeetCode-Notes

=======================================

*/

# C++ Solution

```cpp
class Solution {
public:
    int maxDepth(string s) {
        int parentheses = 0;
        int maxDepth = 0;

        for (char ch : s) {
            if (ch == '(') {
                parentheses++;
                maxDepth = max(maxDepth, parentheses);
            }
            else if (ch == ')') {
                parentheses--;
            }
        }

        return maxDepth;
    }
};
