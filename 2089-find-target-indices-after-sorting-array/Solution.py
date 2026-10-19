# /*

## 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha

🧠 Problem: 2089. Find Target Indices After Sorting Array  
🔗 Platform: LeetCode  
🏷 Difficulty: Easy  
📌 Topics: Array, Sorting, Counting

🔗 Problem Link: https://leetcode.com/problems/find-target-indices-after-sorting-array/

---------------------

💡 Problem Statement:

You are given a 0-indexed integer array `nums` and a target element `target`.

Return a list of indices where `nums[i] == target` after sorting `nums` in non-decreasing order.

If the target does not exist in the array, return an empty list.

**Example 1:**

Input: `nums = [1,2,5,2,3], target = 2`  
Output: `[1,2]`

Explanation:

After sorting, the array becomes `[1,2,2,3,5]`.

The target `2` appears at indices `1` and `2`.

----------------------------------------------

💡 Approaches

### 1️⃣ Sorting Approach

**Steps:**

• Sort the array in non-decreasing order.  
• Traverse the sorted array using `enumerate()`.  
• If an element equals `target`, add its index to the result list.  
• Return the list of target indices.

⏱ Time Complexity: O(n log n)  
📦 Space Complexity: O(n) for the result list, excluding sorting-related space.

----------------------------------------------

### 2️⃣ Interview Approach (Without Sorting)

**Steps:**

• Count elements smaller than `target` using `less_count`.  
• Count occurrences of `target` using `count`.  
• The first target index will be `less_count`.  
• Generate `count` consecutive indices starting from `less_count`.  
• Return the result list.

**Why does this work?**

After sorting, every element smaller than `target` appears before it. Therefore, the first target index equals the number of elements smaller than `target`.

All occurrences of the target appear consecutively after sorting.

⏱ Time Complexity: O(n)  
📦 Space Complexity: O(k), where `k` is the number of occurrences of `target`.

----------------------------------------------

✍️ Author: Gopal Kushwaha  
📚 Repository: AlgoDiary-LeetCode-Notes

=======================================

*/

# Sorting Approach

```python
class Solution:
    def targetIndices(self, nums: list[int], target: int) -> list[int]:

        # Sort the array
        nums.sort()

        # Store target indices
        result = []

        # Find target indices
        for i, ele in enumerate(nums):
            if ele == target:
                result.append(i)

        return result
```

----------------------------------------------

# Interview Approach (Without Sorting)

```python
class Solution:
    def targetIndices(self, nums: list[int], target: int) -> list[int]:

        count = 0
        less_count = 0

        # Count elements smaller than target
        # and occurrences of target
        for ele in nums:
            if ele < target:
                less_count += 1
            elif ele == target:
                count += 1

        # Generate target indices
        result = []

        for i in range(count):
            result.append(i + less_count)

        return result
```

----------------------------------------------

🔥 Key Concepts

• Lists and Arrays  
• Sorting  
• Counting Elements  
• Frequency Counting  
• Index Calculation  
• Time Complexity Optimization: O(n log n) → O(n)

----------------------------------------------

⭐ If this repository helped you, consider giving it a star!
