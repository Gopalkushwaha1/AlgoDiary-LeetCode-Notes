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
• Traverse the sorted array.  
• Whenever an element equals `target`, add its index to the result list.  
• Return the list of target indices.

⏱ Time Complexity: O(n log n)  
📦 Space Complexity: O(n) for the result list, excluding sorting-related space.

----------------------------------------------

### 2️⃣ Interview Approach (Without Sorting)

**Steps:**

• Count the elements smaller than `target` using `lessCount`.  
• Count the occurrences of `target` using `count`.  
• The first target index will be `lessCount`.  
• Generate `count` consecutive indices starting from `lessCount`.  
• Return the result list.

**Why does this work?**

After sorting, all elements smaller than `target` appear before it. Therefore, the first occurrence of `target` is at index `lessCount`.

If the target occurs multiple times, its indices are consecutive.

⏱ Time Complexity: O(n)  
📦 Space Complexity: O(k), where `k` is the number of occurrences of `target`, excluding the input array.

----------------------------------------------

✍️ Author: Gopal Kushwaha  
📚 Repository: AlgoDiary-LeetCode-Notes

=======================================

*/

# Sorting Approach

```java
import java.util.*;

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {

        // Sort the array
        Arrays.sort(nums);

        // Store target indices
        List<Integer> list = new ArrayList<>();

        // Find target indices
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                list.add(i);
            }
        }

        return list;
    }
}
```

----------------------------------------------

# Interview Approach (Without Sorting)

```java
import java.util.*;

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {

        int count = 0;
        int lessCount = 0;

        // Count elements smaller than target
        // and occurrences of target
        for (int ele : nums) {
            if (ele < target) {
                lessCount++;
            } else if (ele == target) {
                count++;
            }
        }

        // Generate target indices
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            list.add(i + lessCount);
        }

        return list;
    }
}
```

----------------------------------------------

🔥 Key Concepts

• Arrays  
• Sorting  
• Counting Elements  
• Frequency Counting  
• Index Calculation  
• Time Complexity Optimization: O(n log n) → O(n)

----------------------------------------------

⭐ If this repository helped you, consider giving it a star!
