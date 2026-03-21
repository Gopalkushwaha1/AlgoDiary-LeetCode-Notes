/*

## 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha

🧠 Problem: 3643. Flip Square Submatrix Vertically  
🔗 Platform: LeetCode  
🏷 Difficulty: Easy  

---------------------

💡 Problem Statement:

You are given a 2D grid and three integers x, y, and k.

• (x, y) → top-left corner of submatrix  
• k → size of square submatrix (k × k)

Your task is to **flip the submatrix vertically**,  
i.e., reverse the order of rows within that submatrix.

Return the updated grid.

----------------------------------------------

📌 Example (Concept)

Grid:
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16

x = 1, y = 0, k = 3

Selected Submatrix:
5 6 7
9 10 11
13 14 15

After Flip:
13 14 15
9 10 11
5 6 7

----------------------------------------------

⚡ Approach (Row Reversal)

Idea:

• Focus only on k × k submatrix  
• Swap top row with bottom row  
• Move inward until middle  

Steps:

1. Define:
   startRow = x  
   endRow = x + k - 1  

2. While startRow < endRow:
   • Swap elements column-wise from y → y + k - 1  
   • Increment startRow  
   • Decrement endRow  

----------------------------------------------

⏱ Time Complexity:

O(k²)

📦 Space Complexity:

O(1) (In-place)

----------------------------------------------

🔥 Key Insight:

This is simply **row reversal inside a fixed boundary**,  
a very useful pattern in matrix problems.

----------------------------------------------

✍️ Author: Gopal Kushwaha  
📚 Repository: AlgoDiary-LeetCode-Notes  

=======================================

*/


class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int startR = x;
        int endR = x + k - 1;

        while (startR < endR) {
            for (int i = y; i < y + k; i++) {
                int temp = grid[startR][i];
                grid[startR][i] = grid[endR][i];
                grid[endR][i] = temp;
            }
            startR++;
            endR--;
        }

        return grid;
    }
}
