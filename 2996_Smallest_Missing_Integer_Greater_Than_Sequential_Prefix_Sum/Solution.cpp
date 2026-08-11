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

• Store all elements of the array in an `unordered_set`.
• Find the longest sequential prefix starting from `nums[0]`.
• Calculate the sum of this sequential prefix.
• Find the maximum element in the array.
• If the prefix sum is greater than the maximum element, return the sum directly.
• Otherwise, check every number from the prefix sum to the maximum element.
• Return the first number that is not present in the `unordered_set`.
• If every number exists, return `max + 1`.

Why it works?

The sequential prefix gives us the minimum possible starting value.

After calculating its sum, we only need to find the first missing
integer from that value onward.

The `unordered_set` allows us to check whether an integer exists
in the array efficiently.

---

⏱ Time Complexity : O(n)

📦 Space Complexity: O(n)

---

✍️ Author: Gopal Kushwaha

📚 Repository: AlgoDiary-LeetCode-Notes

=======================================

*/

# C++ Solution

```cpp
class Solution {
public:
    int missingInteger(vector<int>& nums) {

        // Take HashSet
        unordered_set<int> set;
        int maxNum = INT_MIN;

        // Putting all elements in HashSet
        for (int ele : nums) {
            set.insert(ele);
            maxNum = max(maxNum, ele);
        }

        // Find sequential break
        int sum = nums[0];

        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] != nums[i - 1] + 1)
                break;

            sum += nums[i];
        }

        // Sum > max return sum
        if (sum > maxNum)
            return sum;

        // Find smallest missing integer
        for (int i = sum; i <= maxNum; i++) {
            if (!set.count(i))
                return i;
        }

        return maxNum + 1;
    }
};
