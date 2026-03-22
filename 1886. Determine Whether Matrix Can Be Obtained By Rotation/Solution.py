"""

## 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha

🧠 Problem: 1886. Determine Whether Matrix Can Be Obtained By Rotation  
🔗 Platform: LeetCode  
🏷 Difficulty: Easy  

---------------------

💡 Problem Statement:

You are given two n × n binary matrices `mat` and `target`.

Your task is to check whether `mat` can be transformed into `target`
by rotating it in **90-degree increments**.

Return **True** if possible, otherwise **False**.

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

Instead of complex thinking,
just simulate all 4 rotations.

----------------------------------------------

✍️ Author: Gopal Kushwaha  
📚 Repository: AlgoDiary-LeetCode-Notes  

=======================================

"""

class Solution:

    # 🔁 Rotate matrix by 90° clockwise
    def rotate(self, mat):
        n = len(mat)

        # Step 1: Transpose
        for i in range(n):
            for j in range(i, n):
                mat[i][j], mat[j][i] = mat[j][i], mat[i][j]

        # Step 2: Reverse each row
        for i in range(n):
            mat[i].reverse()

    # ✅ Compare matrices
    def compare(self, mat, target):
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j] != target[i][j]:
                    return False
        return True

    # 🚀 Main function
    def findRotation(self, mat, target):

        # Try all 4 rotations
        for _ in range(4):
            if self.compare(mat, target):
                return True
            self.rotate(mat)

        return False
