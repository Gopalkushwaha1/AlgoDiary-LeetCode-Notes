# 🚀 AlgoDiary | Daily LeetCode Solutions by Gopal Kushwaha

## 🧠 Problem: 3296. Minimum Number of Seconds to Make Mountain Height Zero  
🔗 Platform: LeetCode  
🏷 Difficulty: Medium  

---

## 💡 Problem Statement

You are given an integer **mountainHeight** representing the height of a mountain.

You are also given an array **workerTimes** where each element represents the time a worker takes to work.

Workers reduce the mountain **simultaneously**.

For worker `i`, reducing `x` height takes:

workerTimes[i] + workerTimes[i] * 2 + ... + workerTimes[i] * x seconds.

Return the **minimum number of seconds** required to reduce the mountain height to **0**.

---

# Approach 1 — Binary Search + Simulation

### Idea

We try different time values and check whether workers can reduce the mountain height to **0** within that time.

Binary Search is used to find the **minimum valid time**.

### Time Complexity
O((n + H) log H)

### Space Complexity
O(1)

### Code

```java
class Solution {

    public boolean isPossible(long time , int height , int[] worker ) {

        for ( int i = 0 ; i < worker.length ; i++ ) {

            long j = 1L ;
            long curr = 0 ;

            while ( height > 0 && curr + j * worker[i] <= time ) {

                curr += j * worker[i] ;
                j++ ;
                height-- ;
            }

            if(height == 0) return true ;
        }

        return height == 0 ;
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        long min = 1L ;
        long max = 0 ;
        long dummy = 1L ;

        for ( int ele : workerTimes ) {
            dummy = Math.max(ele , dummy);
        }

        for ( int i = 1 ; i <= mountainHeight ; i++ ) {
            max += dummy * i ;
        }

        while ( min < max ) {

            long mid = (min + max) / 2 ;

            if(isPossible(mid , mountainHeight , workerTimes)) {
                max = mid ;
            }
            else {
                min = mid + 1 ;
            }
        }

        return min ;
    }
}
```

---

# Approach 2 — Binary Search + Mathematical Trick

### Idea

Time required for a worker to reduce `k` height:

t + 2t + 3t + ... + kt

This can be written as:

t * (k(k+1) / 2)

Using this formula we directly calculate how many heights a worker can reduce in given time.

### Time Complexity
O(n log H)

### Space Complexity
O(1)

### Code

```java
class Solution {

    public boolean isPossible(long time , int height , int[] worker ) {

        long totalHeight = 0 ;

        for ( int ele : worker ) {

            long k = (long)((Math.sqrt(1 + (8.0 * time) / ele) - 1) / 2);

            totalHeight += k ;

            if(totalHeight >= height) return true ;
        }

        return false ;
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        long min = 1L ;
        long max = 0 ;
        long dummy = 1L ;

        for ( int ele : workerTimes ) {
            dummy = Math.max(ele , dummy);
        }

        for ( int i = 1 ; i <= mountainHeight ; i++ ) {
            max += dummy * i ;
        }

        while ( min < max ) {

            long mid = (min + max) / 2 ;

            if(isPossible(mid , mountainHeight , workerTimes)) {
                max = mid ;
            }
            else {
                min = mid + 1 ;
            }
        }

        return min ;
    }
}
```

---

⭐ If this repository helped you, consider giving it a star!
