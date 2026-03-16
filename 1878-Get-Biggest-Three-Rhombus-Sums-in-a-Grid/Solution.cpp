/*

## 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha

🧠 Problem: 1878. Get Biggest Three Rhombus Sums in a Grid
🔗 Platform: LeetCode
🏷 Difficulty: Medium

---------------------

💡 Problem Statement:

You are given an m × n integer matrix grid.

A rhombus sum is defined as the sum of the elements that form the
border of a rhombus shape in the grid.

The rhombus is basically a square rotated by 45°, and only
the border elements are included in the sum.

Return the three largest distinct rhombus sums in descending order.

If there are fewer than three distinct values, return all of them.

----------------------------------------------

⚡ Approach (Grid Traversal + Simulation)

Key Idea:

• Every cell can act as the top vertex of a rhombus  
• Expand rhombus size k step-by-step  
• Calculate the border sum in four diagonal directions  
• Store distinct sums using set  
• Maintain top 3 largest values using Min Heap

----------------------------------------------

🧠 Data Structures Used

• set → to store distinct rhombus sums  
• priority_queue (Min Heap) → to maintain top 3 largest values

----------------------------------------------

⏱ Time Complexity

O(m × n × min(m,n))

----------------------------------------------

📦 Space Complexity

O(1) extra (excluding result storage)

----------------------------------------------

✍️ Author: Gopal Kushwaha
📚 Repository: AlgoDiary-LeetCode-Notes

=======================================

*/

class Solution {
public:

    int find(vector<vector<int>>& grid, int i, int j, int k) {

        int n = grid.size();
        int m = grid[0].size();

        // Out of bound check
        if (i + 2*k >= n || j + k >= m || j - k < 0) return -1;

        int r = i;
        int c = j;
        int sum = 0;

        // top → left
        for (int l = 0; l < k; l++) {
            sum += grid[r + l][c - l];
        }

        // left → bottom
        r = i + k;
        c = j - k;

        for (int l = 0; l < k; l++) {
            sum += grid[r + l][c + l];
        }

        // bottom → right
        r = i + 2*k;
        c = j;

        for (int l = 0; l < k; l++) {
            sum += grid[r - l][c + l];
        }

        // right → top
        r = i + k;
        c = j + k;

        for (int l = 0; l < k; l++) {
            sum += grid[r - l][c - l];
        }

        return sum;
    }

    vector<int> getBiggestThree(vector<vector<int>>& grid) {

        int row = grid.size();
        int col = grid[0].size();

        priority_queue<int, vector<int>, greater<int>> pq;
        set<int> st;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                // Single cell rhombus
                if (st.insert(grid[i][j]).second) {
                    pq.push(grid[i][j]);
                    if (pq.size() > 3) pq.pop();
                }

                for (int k = 1; k < (min(row, col) / 2) + 1; k++) {

                    int val = find(grid, i, j, k);

                    if (val == -1) break;

                    if (st.insert(val).second) {
                        pq.push(val);
                        if (pq.size() > 3) pq.pop();
                    }
                }
            }
        }

        int n = pq.size();
        vector<int> ans(n);

        for (int i = n - 1; i >= 0; i--) {
            ans[i] = pq.top();
            pq.pop();
        }

        return ans;
    }
};
