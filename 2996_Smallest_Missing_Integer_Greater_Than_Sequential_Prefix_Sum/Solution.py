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

• Store all elements of the array in a `set`.
• Find the longest sequential prefix starting from `nums[0]`.
• Calculate the sum of this sequential prefix.
• Find the maximum element in the array.
• If the prefix sum is greater than the maximum element, return the sum directly.
• Otherwise, check every number from the prefix sum to the maximum element.
• Return the first number that is not present in the `set`.
• If every number exists, return `max + 1`.

Why it works?

The sequential prefix gives us the minimum possible starting value.

After calculating its sum, we only need to find the first missing
integer from that value onward.

The `set` allows us to check whether an integer exists in
the array efficiently.

---

⏱ Time Complexity : O(n)

📦 Space Complexity: O(n)

---

✍️ Author: Gopal Kushwaha

📚 Repository: AlgoDiary-LeetCode-Notes

=======================================

*/

# Python Solution

class Solution:
    def missingInteger(self, nums):

        # Take HashSet
        set_nums = set()
        max_num = float('-inf')

        # Putting all elements in set
        for ele in nums:
            set_nums.add(ele)
            max_num = max(max_num, ele)

        # Find sequential break
        total = nums[0]

        for i in range(1, len(nums)):
            if nums[i] != nums[i - 1] + 1:
                break
            total += nums[i]

        # Sum > max return sum
        if total > max_num:
            return total

        # Find smallest missing integer
        for i in range(total, max_num + 1):
            if i not in set_nums:
                return i

        return max_num + 1

---

🔥 Key Concepts

• Array

• HashSet / Set

• Sequential Prefix

• Prefix Sum

• Searching

• Array Traversal

• Greedy

• DSA

• Coding Interview

---

⭐ If this repository helped you, consider giving it a star!
