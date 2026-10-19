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

• Sort the array in non-decreasing order using `sort()`.  
• Traverse the sorted array using an index.  
• If an element equals `target`, add its index to the result vector.  
• Return the vector of target indices.

⏱ Time Complexity: O(n log n)  
📦 Space Complexity: O(k) for the result vector, excluding sorting-related space, where `k` is the number of occurrences of `target`.

----------------------------------------------

### 2️⃣ Interview Approach (Without Sorting)

**Steps:**

• Count elements smaller than `target` using `lessCount`.  
• Count occurrences of `target` using `count`.  
• The first target index will be `lessCount`.  
• Generate `count` consecutive indices starting from `lessCount`.  
• Return the result vector.

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

```cpp
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    vector<int> targetIndices(vector<int>& nums, int target) {

        // Sort the array
        sort(nums.begin(), nums.end());

        // Store target indices
        vector<int> result;

        // Find target indices
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == target) {
                result.push_back(i);
            }
        }

        return result;
    }
};
```

----------------------------------------------

# Interview Approach (Without Sorting)

```cpp
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> targetIndices(vector<int>& nums, int target) {

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
        vector<int> result;

        for (int i = 0; i < count; i++) {
            result.push_back(i + lessCount);
        }

        return result;
    }
};
```

----------------------------------------------

🔥 Key Concepts

• Vectors and Arrays  
• Sorting  
• Counting Elements  
• Frequency Counting  
• Index Calculation  
• Time Complexity Optimization: O(n log n) → O(n)

----------------------------------------------

⭐ If this repository helped you, consider giving it a star!
