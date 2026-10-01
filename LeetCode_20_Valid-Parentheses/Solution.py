# /*

## 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha

🧠 Problem: 20. Valid Parentheses  
🔗 Platform: LeetCode  
🏷 Difficulty: Easy

---

💡 Problem Statement:

Given a string `s` containing only the characters `(`, `)`, `{`, `}`, `[` and `]`, determine if the input string is valid.

A string is valid if:

• Every opening bracket is closed by the same type of bracket.

• Brackets are closed in the correct order.

• Every closing bracket has a corresponding opening bracket.

---

💡 Approach:

We use a **Stack** to keep track of all opening parentheses.

The Stack follows the **LIFO (Last In First Out)** principle.

While traversing the string:

• If the character is an opening bracket `(`, `{`, `[`, push it into the Stack.

• If the character is a closing bracket `)`, `}`, `]`, check the top element of the Stack.

• If the top element matches the corresponding opening bracket, remove it using `pop()`.

• If it does not match, the string is invalid.

• If the Stack is empty when a closing bracket is found, return `false`.

At the end, if the Stack is empty, all brackets were matched correctly, so return `true`.

---

🔍 Logic:

For `(`, `{`, `[`:

• Push the opening bracket into the Stack.

For `)`:

• Check if Stack is empty.

• Check if the top element is `(`.

• If matched → pop the element.

• Otherwise → return `false`.

For `}`:

• Check if Stack is empty.

• Check if the top element is `{`.

• If matched → pop the element.

• Otherwise → return `false`.

For `]`:

• Check if Stack is empty.

• Check if the top element is `[`.

• If matched → pop the element.

• Otherwise → return `false`.

Finally:

• If Stack is empty → `true`

• Otherwise → `false`

---

💻 Python Code:

```python
class Solution:
    def isValid(self, s: str) -> bool:

        # Create stack to track valid parentheses
        st = []

        # travel each parentheses
        for ch in s:

            # if opening parentheses then push to stack
            if ch == '(' or ch == '{' or ch == '[':
                st.append(ch)

            elif ch == ')':
                if not st:
                    return False

                prev = st[-1]

                if prev == '(':
                    st.pop()
                    continue
                else:
                    return False

            elif ch == '}':
                if not st:
                    return False

                prev = st[-1]

                if prev == '{':
                    st.pop()
                    continue
                else:
                    return False

            elif ch == ']':
                if not st:
                    return False

                prev = st[-1]

                if prev == '[':
                    st.pop()
                    continue
                else:
                    return False

        return len(st) == 0
