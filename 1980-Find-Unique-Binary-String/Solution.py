"""
 ================================================================
 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha
 ---------------------------------------------------------------
 🧠 Problem: 1980. Find Unique Binary String
 🔗 Platform: LeetCode
 🏷 Difficulty: Medium
 ---------------------------------------------------------------
 💡 Approach 1:
 Backtracking + HashSet

 We generate all possible binary strings of length n using
 backtracking. All given strings are stored in a HashSet
 for fast lookup.

 During generation:
 • If the constructed string is NOT present in the set,
   we found our answer.
 • Stop recursion early once the answer is found.

 ---------------------------------------------------------------
 ⏱ Time Complexity : O(2^n)
 📦 Space Complexity: O(n)
 ---------------------------------------------------------------
 ✍️ Author: Gopal Kushwaha
 📚 Repository: AlgoDiary-LeetCode-Notes
 ================================================================
"""

class Solution:
    def findDifferentBinaryString(self, nums):

        n = len(nums)
        s = set(nums)
        ans = [""]

        def backtrack(path):

            if ans[0]:
                return

            if len(path) == n:
                candidate = "".join(path)
                if candidate not in s:
                    ans[0] = candidate
                return

            path.append('1')
            backtrack(path)
            path.pop()

            path.append('0')
            backtrack(path)
            path.pop()

        backtrack([])

        return ans[0]


"""
 ================================================================
 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha
 ---------------------------------------------------------------
 🧠 Problem: 1980. Find Unique Binary String
 🔗 Platform: LeetCode
 🏷 Difficulty: Medium
 ---------------------------------------------------------------
 💡 Approach 2 (Optimal):
 Cantor's Diagonalization Trick

 Instead of generating all possible binary strings,
 we construct a new string by flipping diagonal bits.

 For each index i:
 • If nums[i][i] == '0' → append '1'
 • Else append '0'

 This ensures the new string differs from every string
 in the array at least in one position.

 ---------------------------------------------------------------
 ⏱ Time Complexity : O(n)
 📦 Space Complexity: O(n)
 ---------------------------------------------------------------
 ✍️ Author: Gopal Kushwaha
 📚 Repository: AlgoDiary-LeetCode-Notes
 ================================================================
"""

class Solution:
    def findDifferentBinaryString(self, nums):

        res = []

        for i in range(len(nums)):

            curr = nums[i][i]

            if curr == '0':
                res.append('1')
            else:
                res.append('0')

        return "".join(res)
