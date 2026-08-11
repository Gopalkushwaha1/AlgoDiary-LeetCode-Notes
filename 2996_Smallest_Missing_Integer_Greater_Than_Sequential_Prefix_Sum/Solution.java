# /*

## 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha

🧠 Problem: 2996. Smallest Missing Integer Greater Than Sequential Prefix Sum  
🔗 Platform: LeetCode  
🏷 Difficulty: Easy

---

💡 Problem Statement:

You are given a 0-indexed array of integers `nums`.

A prefix `nums[0..i]` is sequential if every element after the first is exactly `1` greater than the previous element.

Return the smallest integer `x` that is:

• Greater than or equal to the sum of the longest sequential prefix.
• Missing from the entire array.

---

💡 Approach (HashSet + Sequential Prefix)

Steps:

• Store all elements of the array in a `HashSet`.
• Find the longest sequential prefix starting from `nums[0]`.
• Calculate the sum of this sequential prefix.
• Find the maximum element in the array.
• If the prefix sum is greater than the maximum element, return the sum directly.
• Otherwise, check every number from the prefix sum to the maximum element.
• Return the first number that is not present in the `HashSet`.
• If every number exists, return `max + 1`.

Why it works?

The sequential prefix gives us the minimum possible starting value.

After calculating its sum, we only need to find the first missing
integer from that value onward.

The `HashSet` allows us to check whether an integer exists in
the array efficiently.

---

⏱ Time Complexity : O(n)

📦 Space Complexity: O(n)

---

✍️ Author: Gopal Kushwaha

📚 Repository: AlgoDiary-LeetCode-Notes

=======================================

*/

# Java Solution

```java
class Solution {

    public int missingInteger(int[] nums) {

        // Take HashSet
        HashSet<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;

        // putting all element in hashset
        for (int ele : nums) {
            set.add(ele);
            max = Math.max(max, ele);    // find max
        }

        // find sequential break
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) break;
            sum += nums[i];
        }

        // sum > max return sum
        if (sum > max) return sum;

        // check array contains sum -> Find smallest missing integer
        for (int i = sum; i <= max; i++) {
            if (!set.contains(i)) return i;
        }

        return max + 1;
    }
}
