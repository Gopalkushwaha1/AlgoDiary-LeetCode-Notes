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

### 1️⃣ When `k == nums.length`

There is only **one subarray**, which is the complete array.

Therefore, every element that exists in the array appears in exactly one subarray.

So, we simply return the **maximum element** in `nums`.

---

### 2️⃣ When `k == 1`

Every subarray contains exactly one element.

For example:

`nums = [1, 2, 3, 2]`

Subarrays of size `1` are:

`[1]`, `[2]`, `[3]`, `[2]`

An element appears in exactly one subarray only when its frequency in the entire array is exactly `1`.

So, we check the frequency array from `50` down to `0` and return the largest element whose frequency is `1`.

---

### 3️⃣ When `1 < k < nums.length`

This is where the main observation comes in.

For any element located in the **middle** of the array, it will belong to multiple subarrays of size `k`.

However, an element at either **end of the array** can belong to only one size-`k` subarray.

Therefore, only `nums[0]` and `nums[nums.length - 1]` can potentially be almost missing.

We check whether their total frequency in the array is exactly `1`.

• If `nums[0]` occurs only once, it is a valid candidate.

• If `nums[n-1]` occurs only once, it is a valid candidate.

Finally, return the larger of these candidates.

If neither is valid, return `-1`.

---

💡 Why it works?

When `1 < k < n`, a size-`k` sliding window moves across the array.

The first element belongs only to the first window.

The last element belongs only to the last window.

But an element appearing somewhere in the middle can be included in more than one window.

Therefore, for an element to appear in exactly one size-`k` subarray, it must be located at an endpoint and must occur only once in the entire array.

This observation allows us to avoid checking every subarray.

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

*/

# Java Solution

```java
class Solution {
    public int largestInteger(int[] nums, int k) {
        
        int[] count = new int[51];

        for (int ele : nums) {
            count[ele]++;
        }

        // For k == nums.length
        if (k == nums.length) {
            int max = -1;

            for (int ele : nums) {
                max = Math.max(ele, max);
            }

            return max;
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
            ans = Math.max(ans, nums[0]);
        }

        // Check last element
        if (count[nums[nums.length - 1]] == 1) {
            ans = Math.max(ans, nums[nums.length - 1]);
        }

        return ans;
    }
}
```
