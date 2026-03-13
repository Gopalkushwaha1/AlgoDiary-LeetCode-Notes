# Approach 1 — Binary Search + Simulation (Python)

### Time Complexity
O((n + H) log H)

### Space Complexity
O(1)

### Code

```python
class Solution:

    def isPossible(self, time, height, worker):

        for i in range(len(worker)):

            j = 1
            curr = 0

            while height > 0 and curr + j * worker[i] <= time:
                curr += j * worker[i]
                j += 1
                height -= 1

            if height == 0:
                return True

        return height == 0


    def minNumberOfSeconds(self, mountainHeight, workerTimes):

        left = 1
        right = 0
        slowest = 1

        for t in workerTimes:
            slowest = max(slowest, t)

        for i in range(1, mountainHeight + 1):
            right += slowest * i

        while left < right:

            mid = (left + right) // 2

            if self.isPossible(mid, mountainHeight, workerTimes):
                right = mid
            else:
                left = mid + 1

        return left
```

---

# Approach 2 — Binary Search + Mathematical Trick (Python)

### Time Complexity
O(n log H)

### Space Complexity
O(1)

### Code

```python
import math

class Solution:

    def isPossible(self, time, height, worker):

        totalHeight = 0

        for w in worker:

            k = int((math.sqrt(1 + (8 * time) / w) - 1) / 2)

            totalHeight += k

            if totalHeight >= height:
                return True

        return False


    def minNumberOfSeconds(self, mountainHeight, workerTimes):

        left = 1
        right = 0
        slowest = 1

        for w in workerTimes:
            slowest = max(slowest, w)

        for i in range(1, mountainHeight + 1):
            right += slowest * i

        while left < right:

            mid = (left + right) // 2

            if self.isPossible(mid, mountainHeight, workerTimes):
                right = mid
            else:
                left = mid + 1

        return left
```
