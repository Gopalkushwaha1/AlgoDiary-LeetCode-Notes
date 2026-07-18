# /*

## 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha

🧠 Problem: 1979. Find Greatest Common Divisor of Array  
🔗 Platform: LeetCode  
🏷 Difficulty: Easy  
---------------------

💡 Problem Statement:

Given an integer array `nums`, return the Greatest Common Divisor (GCD)
of the smallest and the largest number present in the array.

The Greatest Common Divisor (GCD) is the largest positive integer
that divides both numbers without leaving any remainder.

Example:

Input: nums = [2,5,6,9,10]

Smallest = 2
Largest = 10

Output: 2

----------------------------------------------

💡 Approach (Euclid's Algorithm)

Steps:

• Traverse the array to find the smallest element
• Traverse the array to find the largest element
• Apply Euclid's Algorithm to calculate GCD
• Return the Greatest Common Divisor

Euclid's Algorithm:

gcd(a, b)

If b == 0
→ return a

Otherwise

gcd(a, b) = gcd(b, a % b)

----------------------------------------------

⏱ Time Complexity : O(n + log(min))

📦 Space Complexity: O(log(min))
(Recursive Call Stack)

----------------------------------------------

✍️ Author: Gopal Kushwaha

📚 Repository: AlgoDiary-LeetCode-Notes

=======================================

*/

#Python Solution

```python
class Solution:

    # Function to get GCD
    def gcd(self, a: int, b: int) -> int:

        if b == 0:
            return a

        return self.gcd(b, a % b)

    def findGCD(self, nums: List[int]) -> int:

        # Find maximum and minimum element
        maxi = float('-inf')
        mini = float('inf')

        for ele in nums:
            maxi = max(maxi, ele)
            mini = min(mini, ele)

        # Return GCD of max and min
        return self.gcd(maxi, mini)
```

----------------------------------------------

🔥 Key Concepts

• Greatest Common Divisor (GCD)

• Euclid's Algorithm

• Recursion

• Array Traversal

• Mathematics

----------------------------------------------

⭐ If this repository helped you, consider giving it a star!
