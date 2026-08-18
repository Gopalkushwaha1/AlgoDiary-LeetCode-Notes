# /*
## 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha

🧠 Problem: 3471. Find the Largest Almost Missing Integer
🔗 Platform: LeetCode
🏷 Difficulty: Easy

---

💡 Problem Statement:

You are given an integer array `nums` and an integer `k`.

An integer `x` is called **almost missing** if it appears in exactly one subarray of size `k` within `nums`.

Return the **largest almost missing integer**.

If no such integer exists, return `-1`.

---

💡 Approach (Frequency Counting + Subarray Observation)

The key observation is that we don't need to check every subarray separately.

First, count the frequency of every element in the entire array.

There are three important cases:

### 1️⃣ When `k == nums.size()`

There is only **one subarray**, which is the complete array.

Therefore, every element that exists in the array appears in exactly one subarray.

So, we simply return the **maximum element** in `nums`.

---

### 2️⃣ When `k == 1`

Every subarray contains exactly one element.

An element appears in exactly one subarray only when its frequency in the entire array is exactly `1`.

So, we check the frequency of elements and return the largest element whose frequency is `1`.

---

### 3️⃣ When `1 < k < nums.size()`

For an element to appear in exactly one subarray of size `k`, it must be located at one of the two ends of the array and must occur only once.

Therefore, only `nums[0]` and `nums[nums.size() - 1]` can potentially be almost missing.

We check whether their total frequency in the array is exactly `1`.

Finally, return the larger valid candidate.

If neither is valid, return `-1`.

---

💡 Why it works?

When `1 < k < n`, a size-`k` sliding window moves across the array.

The first element belongs only to the first window.

The last element belongs only to the last window.

But an element appearing somewhere in the middle can be included in more than one window.

Therefore, only a unique endpoint element can be almost missing.

---

🔍 Example:

`nums = [3, 1, 2, 4, 5]`
`k = 3`

Size-3 subarrays are:

`[3, 1, 2]`
`[1, 2, 4]`
`[2, 4, 5]`

The first element `3` appears in only the first subarray.

The last element `5` appears in only the last subarray.

Since both occur only once in the entire array, both are almost missing.

The largest one is:

`5`

Answer = `5`

---

⏱ Time Complexity : O(n)

📦 Space Complexity: O(1)

---

✍️ Author: Gopal Kushwaha

📚 Repository: AlgoDiary-LeetCode-Notes

=======================================

\*/

# C++ Solution

```cpp
class Solution {
public:
    int largestInteger(vector<int>& nums, int k) {

        int count[51] = {0};

        for (int ele : nums) {
            count[ele]++;
        }

        // For k == nums.size()
        if (k == nums.size()) {

            int maxValue = -1;

            for (int ele : nums) {
                maxValue = max(maxValue, ele);
            }

            return maxValue;
        }

        // For k == 1
        if (k == 1) {

            for (int i = 50; i >= 0; i--) {

                if (count[i] == 1) {
                    return i;
                }
            }
        }

        int ans = -1;

        // Check first element
        if (count[nums[0]] == 1) {
            ans = max(ans, nums[0]);
        }

        // Check last element
        if (count[nums[nums.size() - 1]] == 1) {
            ans = max(ans, nums[nums.size() - 1]);
        }

        return ans;
    }
};
