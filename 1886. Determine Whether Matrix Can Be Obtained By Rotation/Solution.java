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

Steps:

1. Loop 4 times:
   • Check if mat == target → return true  
   • Rotate matrix by 90°  

2. If no match found → return false  

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

Instead of thinking complex transformations,
just simulate all 4 rotations — simple & effective.

----------------------------------------------

✍️ Author: Gopal Kushwaha  
📚 Repository: AlgoDiary-LeetCode-Notes  

=======================================

*/

class Solution {

    // 🔁 Rotate matrix by 90° clockwise
    public void rotate(int[][] mat) {
        int n = mat.length;

        // Step 1: Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    // ✅ Compare two matrices
    public boolean compare(int[][] mat, int[][] target) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != target[i][j]) return false;
            }
        }
        return true;
    }

    // 🚀 Main function
    public boolean findRotation(int[][] mat, int[][] target) {

        // Try all 4 rotations
        for (int i = 0; i < 4; i++) {
            if (compare(mat, target)) return true;
            rotate(mat);
        }

        return false;
    }
}
