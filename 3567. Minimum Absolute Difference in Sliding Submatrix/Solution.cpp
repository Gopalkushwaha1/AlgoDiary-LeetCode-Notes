/*

## 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha

🧠 Problem: 3567. Minimum Absolute Difference in Sliding Submatrix  
🔗 Platform: LeetCode  
🏷 Difficulty: Medium  

---------------------

💡 Problem Statement:

You are given a 2D grid and an integer k.

For every k × k submatrix, find the **minimum absolute difference**
between any two distinct elements inside that submatrix.

Return a matrix where each cell represents the answer for that submatrix.

----------------------------------------------

📌 Example (Concept)

Grid:
1 3 6
4 8 2
7 5 9

k = 2

Submatrices:
[1,3,4,8] → min diff = 1  
[3,6,8,2] → min diff = 1  

----------------------------------------------

⚠️ Approach 1 (Brute Force + Sorting)

Idea:

• Traverse every k × k submatrix  
• Store elements in a set (to remove duplicates)  
• Convert to vector and sort  
• Find minimum difference between adjacent elements  

----------------------------------------------

⏱ Time Complexity:

O(n * m * k² log(k²))

📦 Space Complexity:

O(k²)

----------------------------------------------

⚡ Optimization Ideas (For Future)

• Use multiset / balanced BST  
• Sliding Window in 2D  
• Avoid re-sorting  

----------------------------------------------

✍️ Author: Gopal Kushwaha  
📚 Repository: AlgoDiary-LeetCode-Notes  

=======================================

*/

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<vector<int>> minAbsDiff(vector<vector<int>>& grid, int k) {
        int row = grid.size();
        int col = grid[0].size();

        // Result matrix
        vector<vector<int>> ans(row - k + 1, vector<int>(col - k + 1, 0));

        // Traverse all k x k submatrices
        for (int i = 0; i <= row - k; i++) {
            for (int j = 0; j <= col - k; j++) {

                // Store unique elements
                unordered_set<int> st;

                // Extract k x k window
                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        st.insert(grid[x][y]);
                    }
                }

                // Convert to vector & sort
                vector<int> vec(st.begin(), st.end());
                sort(vec.begin(), vec.end());

                // Find minimum absolute difference
                int minDiff = INT_MAX;

                for (int idx = 1; idx < vec.size(); idx++) {
                    minDiff = min(minDiff, vec[idx] - vec[idx - 1]);
                }

                // If all elements same → return 0
                ans[i][j] = (minDiff == INT_MAX) ? 0 : minDiff;
            }
        }

        return ans;
    }
};
