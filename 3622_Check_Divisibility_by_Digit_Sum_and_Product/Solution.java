# /*
## 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha

🧠 Problem: 3622. Check Divisibility by Digit Sum and Product
🔗 Platform: LeetCode
🏷 Difficulty: Easy

---

💡 Problem Statement:

You are given a positive integer `n`.

Determine whether `n` is divisible by the sum of the following two values:

• The digit sum of `n`
• The digit product of `n`

Return `true` if `n` is divisible by this sum; otherwise, return `false`.

---

💡 Approach (Digit Manipulation + Math)

The important observation is that we need to extract every digit of `n` and calculate two values:

• Sum of all digits
• Product of all digits

Steps:

• Store the original value of `n`.
• Initialize `sum = 0` to calculate the digit sum.
• Initialize `prod = 1` to calculate the digit product.
• Extract each digit using `n % 10`.
• Remove the last digit using `n /= 10`.
• Add the extracted digit to `sum`.
• Multiply the extracted digit with `prod`.
• Calculate `totalSum = sum + prod`.
• Finally, check whether the original number is divisible by `totalSum`.

Why it works?

Every digit of the number contributes to both the digit sum and digit product.

For example:

`n = 99`

Digit Sum:

`9 + 9 = 18`

Digit Product:

`9 × 9 = 81`

Total:

`18 + 81 = 99`

Since:

`99 % 99 = 0`

The answer is `true`.

We can extract digits efficiently using:

`n % 10`

and remove the last digit using:

`n /= 10`

After calculating the digit sum and digit product, we simply check:

`originalN % (sum + prod) == 0`

If the remainder is `0`, the number is divisible and we return `true`.

Otherwise, we return `false`.

---

⏱ Time Complexity : O(log n)

📦 Space Complexity: O(1)

---

✍️ Author: Gopal Kushwaha

📚 Repository: AlgoDiary-LeetCode-Notes

=======================================

\*/

# Java Solution

```java
class Solution {
    public boolean checkDivisibility(int n) {

        // Take Variable to store sum and product
        int sum = 0;
        int prod = 1;
        int totalSum = 0;
        int originalN = n;

        // Calculate digit sum and digit product
        while (n > 0) {

            int rem = n % 10;
            n /= 10;

            sum += rem;   // update the sum (sum = sum + rem)
            prod *= rem;  // update the product (prod = prod * rem)
        }

        // Calculate total sum
        totalSum = sum + prod;

        // Check the divisibility condition
        if (originalN % totalSum != 0) {
            return false;
        }

        return true;
    }
}
