/*
 ============================================================
 🚀 AlgoDiary - by Gopal Kushwaha
 ------------------------------------------------------------
 Think • Learn • Optimize
 ------------------------------------------------------------
 Problem: 1582. Special Positions in a Binary Matrix
 Approach 1: Brute Force Row & Column Scan
 Approach 2: Row Count + Column Count Optimization
 Time Complexity:
   Approach 1 -> O(m * n * (m + n))
   Approach 2 -> O(m * n)
 Space Complexity:
   Approach 1 -> O(1)
   Approach 2 -> O(m + n)
 ============================================================
*/

/*
     ------------------------------------------------------------
     💡 Core Idea:

     A position (i, j) is SPECIAL if:

     1️⃣ mat[i][j] == 1
     2️⃣ All other elements in row i are 0
     3️⃣ All other elements in column j are 0

     So effectively:
     Row i must contain exactly ONE '1'
     Column j must contain exactly ONE '1'
     ------------------------------------------------------------
*/


/*
 ============================================================
 🧠 Approach 1 : Brute Force
 ------------------------------------------------------------
 Idea:
 For every cell that contains '1':
    • Check entire row → ensure only one '1'
    • Check entire column → ensure only one '1'

 If both conditions satisfied → Special Position.

 Time Complexity:
 O(m * n * (m + n))

 Space Complexity:
 O(1)
 ============================================================
*/

class Solution {

    public int numSpecial(int[][] mat) {

        int count = 0;
        int row = mat.length;
        int col = mat[0].length;

        // Traverse every cell
        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                if (mat[i][j] == 1) {

                    int localCount = 0;

                    // Check row
                    for (int k = 0; k < col; k++) {
                        if (mat[i][k] == 1) {
                            localCount++;
                        }

                        if (localCount > 1) break;
                    }

                    if (localCount != 1) continue;

                    localCount = 0;

                    // Check column
                    for (int k = 0; k < row; k++) {
                        if (mat[k][j] == 1) {
                            localCount++;
                        }

                        if (localCount > 1) break;
                    }

                    if (localCount != 1) continue;

                    count++;
                }
            }
        }

        return count;
    }
}


/*
 ============================================================
 ⚡ Approach 2 : Optimized Row + Column Counting
 ------------------------------------------------------------
 Idea:

 Step 1:
 Count number of 1s in each row and column.

 Step 2:
 Traverse matrix again.

 If mat[i][j] == 1
 AND rowCount[i] == 1
 AND colCount[j] == 1

 → This position is SPECIAL.

 Time Complexity:
 O(m * n)

 Space Complexity:
 O(m + n)
 ============================================================
*/

class SolutionOptimized {

    public int numSpecial(int[][] mat) {

        int row = mat.length;
        int col = mat[0].length;

        int count = 0;

        int[] rowCount = new int[row];
        int[] colCount = new int[col];

        // Count number of 1s in rows and columns
        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                if (mat[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        // Check special positions
        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                if (mat[i][j] == 1 &&
                    rowCount[i] == 1 &&
                    colCount[j] == 1) {

                    count++;
                }
            }
        }

        return count;
    }
}
