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

# Java Solution

```java
class Solution {

    // Function to get GCD
    public int gcd(int a, int b) {

        if (b == 0)
            return a;

        return gcd(b, a % b);
    }

    public int findGCD(int[] nums) {

        // Find maximum and minimum element
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int ele : nums) {
            max = Math.max(max, ele);
            min = Math.min(min, ele);
        }

        // Return GCD of max and min
        return gcd(max, min);
    }
}
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
