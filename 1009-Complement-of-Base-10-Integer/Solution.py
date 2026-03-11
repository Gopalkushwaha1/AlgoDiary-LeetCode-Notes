# /*

## 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha

🧠 Problem: 1009. Complement of Base 10 Integer
🔗 Platform: LeetCode
🏷 Difficulty: Easy
---------------------

💡 Problem Statement:

The complement of an integer is obtained by flipping all the 0's to 1's
and all the 1's to 0's in its binary representation.

Example:

Input: n = 5
Binary: 101
Complement: 010
Output: 2

----------------------------------------------

💡 Approaches

### 1️⃣ Inbuilt Function Approach

Steps:

• Convert integer to binary string
• Flip each bit (0 → 1, 1 → 0)
• Convert the modified binary back to decimal

⏱ Time Complexity : O(log n)
📦 Space Complexity: O(log n)

----------------------------------------------

### 2️⃣ Interview Approach (Bit Manipulation)

Steps:

• Extract the last bit using `n % 2`
• Flip the bit using `1 - bit`
• Place the flipped bit at correct binary position
• Build the final decimal number

This approach avoids string conversion and is
more efficient for interviews.

⏱ Time Complexity : O(log n)
📦 Space Complexity: O(1)

----------------------------------------------

✍️ Author: Gopal Kushwaha
📚 Repository: AlgoDiary-LeetCode-Notes

=======================================

*/

# Inbuilt Function Approach (Python)

class Solution:
    def bitwiseComplement(self, n: int) -> int:

        # convert into binary
        binary = bin(n)[2:]
        sb = list(binary)

        # flip bits
        for i in range(len(sb)):
            if sb[i] == '0':
                sb[i] = '1'
            else:
                sb[i] = '0'

        # convert back to decimal
        return int("".join(sb), 2)


# ----------------------------------------------

# Interview Approach (Bit Manipulation - Python)

class Solution:
    def bitwiseComplement(self, n: int) -> int:

        ans = 0
        pow = 1

        if n == 0:
            return 1

        while n > 0:

            bit = 1 - (n % 2)

            ans += bit * pow
            pow *= 2
            n //= 2

        return ans
