/*
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
 backtracking. For quick lookup, all given strings are stored
 inside a HashSet.

 During generation:
 • If the constructed string is NOT present in the HashSet,
   we found our answer.
 • Stop recursion early once the answer is found.

 ---------------------------------------------------------------
 ⏱ Time Complexity : O(2^n)
 📦 Space Complexity: O(n)
 ---------------------------------------------------------------
 ✍️ Author: Gopal Kushwaha
 📚 Repository: AlgoDiary-LeetCode-Notes
 ================================================================
*/

class Solution {
    static String ans;

    public void find(int n, StringBuilder sb, HashSet<String> set) {

        // stop recursion if answer already found
        if (ans.length() != 0) return;

        // when binary string length becomes n
        if (n == sb.length()) {
            if (!set.contains(sb.toString())) {
                ans = sb.toString();
            }
            return;
        }

        // choose '1'
        sb.append("1");
        find(n, sb, set);
        sb.deleteCharAt(sb.length() - 1);

        // choose '0'
        sb.append("0");
        find(n, sb, set);
        sb.deleteCharAt(sb.length() - 1);
    }

    public String findDifferentBinaryString(String[] nums) {
        ans = "";
        StringBuilder sb = new StringBuilder();
        HashSet<String> set = new HashSet<>();

        // store all strings in HashSet
        for (String s : nums) {
            set.add(s);
        }

        // generate all binary strings
        find(nums.length, sb, set);

        return ans;
    }
}



/*
 ================================================================
 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha
 ---------------------------------------------------------------
 🧠 Problem: 1980. Find Unique Binary String
 🔗 Platform: LeetCode
 🏷 Difficulty: Medium
 ---------------------------------------------------------------
 💡 Approach 2 (Optimal):
 Cantor's Diagonalization Trick

 Instead of generating all possible binary strings, we build
 a new string by flipping the diagonal bits.

 For each index i:
 • Check nums[i][i]
 • If it is '0' → append '1'
 • If it is '1' → append '0'

 This guarantees that the generated string differs from
 every string in nums at least in one position.

 ---------------------------------------------------------------
 ⏱ Time Complexity : O(n)
 📦 Space Complexity: O(n)
 ---------------------------------------------------------------
 ✍️ Author: Gopal Kushwaha
 📚 Repository: AlgoDiary-LeetCode-Notes
 ================================================================
*/

class Solution {
    public String findDifferentBinaryString(String[] nums) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {

            char currChar = nums[i].charAt(i);

            char flip = currChar == '0' ? '1' : '0';

            sb.append(flip);
        }

        return sb.toString();
    }
}
