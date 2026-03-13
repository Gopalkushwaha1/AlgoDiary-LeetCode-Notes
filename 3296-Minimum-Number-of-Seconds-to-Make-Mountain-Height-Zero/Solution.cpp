# Approach 1 — Binary Search + Simulation (C++)

### Time Complexity
O((n + H) log H)

### Space Complexity
O(1)

### Code

```cpp
class Solution {
public:

    bool isPossible(long long time, int height, vector<int>& worker) {

        for (int i = 0; i < worker.size(); i++) {

            long long j = 1;
            long long curr = 0;

            while (height > 0 && curr + j * worker[i] <= time) {

                curr += j * worker[i];
                j++;
                height--;
            }

            if (height == 0) return true;
        }

        return height == 0;
    }

    long long minNumberOfSeconds(int mountainHeight, vector<int>& workerTimes) {

        long long left = 1;
        long long right = 0;
        long long slowest = 1;

        for (int t : workerTimes) {
            slowest = max(slowest, (long long)t);
        }

        for (int i = 1; i <= mountainHeight; i++) {
            right += slowest * i;
        }

        while (left < right) {

            long long mid = (left + right) / 2;

            if (isPossible(mid, mountainHeight, workerTimes))
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }
};
```

---

# Approach 2 — Binary Search + Mathematical Trick (C++)

### Time Complexity
O(n log H)

### Space Complexity
O(1)

### Code

```cpp
class Solution {
public:

    bool isPossible(long long time, int height, vector<int>& worker) {

        long long totalHeight = 0;

        for (int w : worker) {

            long long k = (long long)((sqrt(1 + (8.0 * time) / w) - 1) / 2);

            totalHeight += k;

            if (totalHeight >= height)
                return true;
        }

        return false;
    }

    long long minNumberOfSeconds(int mountainHeight, vector<int>& workerTimes) {

        long long left = 1;
        long long right = 0;
        long long slowest = 1;

        for (int w : workerTimes) {
            slowest = max(slowest, (long long)w);
        }

        for (int i = 1; i <= mountainHeight; i++) {
            right += slowest * i;
        }

        while (left < right) {

            long long mid = (left + right) / 2;

            if (isPossible(mid, mountainHeight, workerTimes))
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }
};
```
