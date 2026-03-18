/*

## 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha

🧠 Problem: 3070. Count Submatrices with Top-Left Element and Sum ≤ k  
🔗 Platform: LeetCode  
🏷 Difficulty: Medium  
---------------------

💡 Problem Statement:

You are given a 0-indexed integer matrix grid and an integer k.

Return the number of submatrices that:

• Contain the top-left element (0,0)  
• Have a sum less than or equal to k  

----------------------------------------------

📌 Example

Input: grid = [[7,6,3],[6,6,1]] , k = 18  

Output: 4  

----------------------------------------------

💡 Approach (2D Prefix Sum Optimization)

Steps:

• Traverse the matrix row by row  
• Maintain a prefix array to store cumulative column sums  
• For each row:
    - Compute running row sum  
    - Add it to prefix[j] (this gives submatrix sum from (0,0) to (i,j))  

• If prefix[j] ≤ k → valid submatrix → increment count  

This avoids recomputing sums and gives optimal performance.

----------------------------------------------

✨ Why Prefix Sum?

• Converts O(n^3) brute force into O(n * m)  
• Efficiently calculates submatrix sum in constant time  
• Most important pattern for 2D matrix problems  

----------------------------------------------

⏱ Time Complexity : O(n * m)  
📦 Space Complexity: O(m)

----------------------------------------------

✍️ Author: Gopal Kushwaha  
📚 Repository: AlgoDiary-LeetCode-Notes  

=======================================

*/

#include <vector>
using namespace std;

class Solution {
public:
    int countSubmatrices(vector<vector<int>>& grid, int k) {
        int n = grid.size();
        int m = grid[0].size();

        vector<int> prefix(m, 0);
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int rowSum = 0;

            for (int j = 0; j < m; j++) {
                rowSum += grid[i][j];
                prefix[j] += rowSum;

                // check valid submatrix
                if (prefix[j] <= k) {
                    ans++;
                }
            }
        }
        return ans;
    }
};
