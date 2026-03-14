"""

## 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha

🧠 Problem: 1415. The k-th Lexicographical String of All Happy Strings of Length n  
🔗 Platform: LeetCode  
🏷 Difficulty: Medium  
---------------------

💡 Problem Statement:

A happy string is a string that:

• Consists only of characters 'a', 'b', and 'c'  
• No two adjacent characters are the same  

Given two integers:

n → length of the string  
k → index of the string in lexicographical order  

Return the k-th lexicographical happy string of length n.  
If there are fewer than k happy strings, return an empty string "".

----------------------------------------------

📌 Example

Input: n = 3 , k = 9  

Happy Strings in lexicographical order:

aba  
abc  
aca  
acb  
bab  
bac  
bca  
bcb  
cab  
cba  

Output: cab

----------------------------------------------

💡 Approach (Backtracking)

Steps:

• Generate strings using characters 'a', 'b', 'c'  
• Ensure adjacent characters are not equal  
• Use recursion + backtracking to build valid strings  
• Maintain a counter of generated happy strings  
• When counter == k, store the answer and stop recursion early  

This ensures we generate strings in lexicographical order.

⏱ Time Complexity : O(2^n)  
📦 Space Complexity: O(n)

----------------------------------------------

✍️ Author: Gopal Kushwaha  
📚 Repository: AlgoDiary-LeetCode-Notes  

=======================================

"""

# Backtracking Approach

class Solution:

    def __init__(self):
        self.count = 0
        self.ans = ""

    def find(self, n, k, sb):

        # early stopping if answer found
        if len(self.ans) > 0:
            return

        # if current string length == n
        if len(sb) == n:
            self.count += 1

            if self.count == k:
                self.ans = "".join(sb)

            return

        # try characters a,b,c
        for ch in ['a', 'b', 'c']:

            # ensure adjacent characters are different
            if len(sb) == 0 or sb[-1] != ch:

                sb.append(ch)
                self.find(n, k, sb)
                sb.pop()   # backtrack

    def getHappyString(self, n: int, k: int) -> str:
        self.find(n, k, [])
        return self.ans
