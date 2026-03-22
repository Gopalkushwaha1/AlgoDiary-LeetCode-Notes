/*

## 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha

🧠 Problem: 1886. Determine Whether Matrix Can Be Obtained By Rotation  
🔗 Platform: LeetCode  
🏷 Difficulty: Easy  

---------------------

💡 Problem Statement:

You are given two n × n binary matrices `mat` and `target`.

Your task is to check whether `mat` can be transformed into `target`
by rotating it in **90-degree increments**.

Return **true** if possible, otherwise **false**.

----------------------------------------------

📌 Example (Concept)

mat:
0 1
1 0

target:
1 0
0 1

After 90° Rotation:
1 0
0 1  ✅ Match

----------------------------------------------

⚡ Approach (Rotate + Compare)

Idea:

• Rotate matrix by 90° clockwise  
• After each rotation, compare with target  
• Maximum 4 rotations (0°, 90°, 180°, 270°)

----------------------------------------------

🔁 How Rotation Works?

Step 1: Transpose matrix  
Step 2: Reverse each row  

----------------------------------------------

⏱ Time Complexity:

O(n²)

📦 Space Complexity:

O(1) (In-place)

----------------------------------------------

🔥 Key Insight:

Instead of overthinking,
just simulate all 4 rotations.

----------------------------------------------

✍️ Author: Gopal Kushwaha  
📚 Repository: AlgoDiary-LeetCode-Notes  

=======================================

*/

class Solution {
public:

    // 🔁 Rotate matrix by 90° clockwise
    void rotate(vector<vector<int>>& mat) {
        int n = mat.size();

        // Step 1: Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                swap(mat[i][j], mat[j][i]);
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            reverse(mat[i].begin(), mat[i].end());
        }
    }

    // ✅ Compare matrices
    bool compare(vector<vector<int>>& mat, vector<vector<int>>& target) {
        int n = mat.size();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j]) return false;
            }
        }
        return true;
    }

    // 🚀 Main function
    bool findRotation(vector<vector<int>>& mat, vector<vector<int>>& target) {

        // Try all 4 rotations
        for (int i = 0; i < 4; i++) {
            if (compare(mat, target)) return true;
            rotate(mat);
        }

        return false;
    }
};
