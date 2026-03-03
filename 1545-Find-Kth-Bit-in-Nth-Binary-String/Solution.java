/*
 ============================================================
 🚀 AlgoDiary - by Gopal Kushwaha
 ------------------------------------------------------------
 Think • Learn • Optimize
 ------------------------------------------------------------
 Problem: 1545. Find Kth Bit in Nth Binary String

*/

/*
 ============================================================
 Approach: 1
 Time Complexity: O(n^2)
 Space Complexity: O(n^2)
 ============================================================

  */

class Solution {
    public char findKthBit(int n, int k) {
        // Take StringBuilder for ans 

        StringBuilder sb = new StringBuilder("0") ;    // s1 -> 0 

        n-- ; 

        while ( n > 0 ) {
            // create new sb 
            // store prev sb and append 1 then append rev(invert(prev sb)) 

            StringBuilder sb2 = new StringBuilder(sb) ; 
            sb2.append("1") ; 

            // for reverse we travel right to left 
            // for invert 
            //     -> if 0 then add 1 
            //     -> if 1 then add 0 

            for ( int i = sb.length() - 1 ; i >= 0 ; i-- ) {
                char ch = sb.charAt(i) ; 

                // invert 
                if(ch == '0') {
                    sb2.append("1") ; 
                }
                else {
                    sb2.append("0") ; 
                }
            }

            sb = sb2 ; 
            n-- ; 
        }

        // return kth idx but 1 based idx k-1 

        return sb.charAt(k-1) ; 
    }
}




/*
 ============================================================
 Approach: 2
 Time Complexity: O(n)
 Space Complexity: O(n)
 ============================================================

*/



class Solution {
    public char ans(int n , int k ) {
        // base case 
        if(n == 1 ) return '0' ; 

        // find total len
        int totalLen = (1<<n) - 1 ; 
        int mid = (totalLen/2) + 1 ; 

        // if mid == k return 1 
        if(mid == k ) return '1' ; 

        // k < mid -> go left side 
        if(k < mid ) {
            return ans(n-1 , k ) ; 
        }

        // find new k
        int newLen = totalLen - k + 1 ; 
        char ch = ans(n-1 , newLen ) ; 

        // invert 
        return ch == '0' ? '1' : '0' ; 
    }
    public char findKthBit(int n, int k) {
        return ans(n , k ) ; 
    }
}






