# /*
## 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha

🧠 Problem: 2958. Length of Longest Subarray With at Most K Frequency
🔗 Platform: LeetCode
🏷 Difficulty: Medium

---

💡 Problem Statement:

You are given an integer array `nums` and an integer `k`.

A subarray is called **good** if the frequency of every element in the subarray is less than or equal to `k`.

Return the length of the **longest good subarray**.

---

💡 Approach (Sliding Window + HashMap)

Steps:

• Take a `HashMap` to store the frequency of each element.
• Use two pointers `i` and `j` to maintain the sliding window.
• Add `nums[i]` to the window and increase its frequency.
• If the frequency of the current element becomes greater than `k`, shrink the window from the left.
• Move pointer `j` forward and decrease the frequency of `nums[j]`.
• Continue until the frequency becomes valid again.
• Update `maxLen` using the current window length.
• Return the maximum length found.

Why it works?

The sliding window always maintains a good subarray where every element appears at most `k` times.

Whenever the frequency of an element exceeds `k`, we shrink the window from the left until the condition becomes valid again.

Each element is added and removed from the window at most once, making the solution efficient.

---

⏱ Time Complexity : O(n)

📦 Space Complexity: O(n)

---

✍️ Author: Gopal Kushwaha

📚 Repository: AlgoDiary-LeetCode-Notes

=======================================

\*/

# Java Solution

```java
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        // taking HashMap for freq count
        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;
        int maxLen = 0;

        // Apply sliding window
        while (i < nums.length) {

            int ele = nums[i];

            map.put(ele, map.getOrDefault(ele, 0) + 1);

            // Reduce the window when freq of ele > k
            while (map.get(ele) > k) {

                int frontEle = nums[j];
                int freq = map.get(frontEle);

                map.put(frontEle, freq - 1);
                j++;
            }

            // Update the maxLen
            maxLen = Math.max(maxLen, (i - j) + 1);

            i++;
        }

        return maxLen;
    }
}
