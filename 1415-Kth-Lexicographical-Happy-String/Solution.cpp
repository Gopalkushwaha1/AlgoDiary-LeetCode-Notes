/*

## 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha

🧠 Problem: 1415. The k-th Lexicographical String of All Happy Strings of Length n  
🔗 Platform: LeetCode  
🏷 Difficulty: Medium  
---------------------

💡 Problem Statement:

A happy string is a string that:

• Consists only of characters 'a', 'b', and 'c'  
• No two adjacent characters are the same  

Given two integers:

n → length of the string  
k → index of the string in lexicographical order  

Return the k-th lexicographical happy string of length n.  
If there are fewer than k happy strings, return an empty string "".

----------------------------------------------

📌 Example

Input: n = 3 , k = 9  

Happy Strings in lexicographical order:

aba  
abc  
aca  
acb  
bab  
bac  
bca  
bcb  
cab  
cba  

Output: cab

----------------------------------------------

💡 Approach (Backtracking)

Steps:

• Generate strings using characters 'a', 'b', and 'c'  
• Ensure adjacent characters are not equal  
• Use recursion + backtracking to build valid strings  
• Maintain a counter of generated happy strings  
• When counter == k, store the answer and stop recursion early  

This ensures we generate strings in lexicographical order.

⏱ Time Complexity : O(2^n)  
📦 Space Complexity: O(n)

----------------------------------------------

✍️ Author: Gopal Kushwaha  
📚 Repository: AlgoDiary-LeetCode-Notes  

=======================================

*/

# Backtracking Approach

class Solution {
public:
    
    int count = 0;
    string ans = "";

    void find(int n , int k , string &sb){

        // early stopping if answer found
        if(ans.length() > 0) return;

        // if current string length == n
        if(sb.length() == n){
            count++;

            if(count == k){
                ans = sb;
            }
            return;
        }

        // try characters a,b,c
        for(char ch : {'a','b','c'}){

            // ensure adjacent characters are different
            if(sb.length() == 0 || sb.back() != ch){

                sb.push_back(ch);
                find(n , k , sb);
                sb.pop_back(); // backtrack
            }
        }
    }

    string getHappyString(int n, int k) {

        string sb = "";
        find(n , k , sb);
        return ans;
    }
};
