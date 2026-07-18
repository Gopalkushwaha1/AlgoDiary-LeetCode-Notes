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

# CPP Solution

```cpp
class Solution {
public:

    // Function to get GCD
    int gcd(int a, int b) {

        if (b == 0)
            return a;

        return gcd(b, a % b);
    }

    int findGCD(vector<int>& nums) {

        // Find maximum and minimum element
        int maxi = INT_MIN;
        int mini = INT_MAX;

        for (int ele : nums) {
            maxi = max(maxi, ele);
            mini = min(mini, ele);
        }

        // Return GCD of max and min
        return gcd(maxi, mini);
    }
};
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
