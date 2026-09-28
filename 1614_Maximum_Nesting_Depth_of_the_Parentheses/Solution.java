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

• If `(` comes → increase `parentheses`.

• If `)` comes → decrease `parentheses`.

• After every `(`, update `max`.

The maximum value of `parentheses` is the answer.

---

🔍 Example:

`s = "(1+(2*3)+((8)/4))+1"`

The deepest part is:

`((8)/4)`

There are `3` nested parentheses.

Answer = `3`

---

⏱ Time Complexity: O(n)

📦 Space Complexity: O(1)

---

✍️ Author: Gopal Kushwaha

📚 Repository: AlgoDiary-LeetCode-Notes

=======================================

*/

# Java Solution

```java
class Solution {
    public int maxDepth(String s) {
        int parentheses = 0;
        int max = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                parentheses++;
                max = Math.max(max, parentheses);
            }

            else if (ch == ')') {
                parentheses--;
            }
        }

        return max;
    }
}
```
