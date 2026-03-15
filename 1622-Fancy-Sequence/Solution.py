"""

## 🚀 AlgoDiary | LeetCode Solutions by Gopal Kushwaha

🧠 Problem: 1622. Fancy Sequence  
🔗 Platform: LeetCode  
🏷 Difficulty: Hard  

---------------------

💡 Problem Statement:

Design a sequence that supports the following operations:

• append(val) → Append an integer to the sequence  
• addAll(inc) → Add inc to every element in the sequence  
• multAll(m) → Multiply every element in the sequence by m  
• getIndex(idx) → Return the element at index idx (0-indexed)

All results must be returned modulo **1e9 + 7**.

If the index does not exist, return **-1**.

The challenge is to perform these operations efficiently.

----------------------------------------------

📌 Example

Input:
["Fancy","append","addAll","append","multAll","getIndex"]

[[],[2],[3],[7],[2],[0]]

Operations:

append(2) → [2]  
addAll(3) → [5]  
append(7) → [5,7]  
multAll(2) → [10,14]  
getIndex(0) → 10  

Output:
10

----------------------------------------------

⚠️ Approach 1 (Naive Simulation — TLE)

Idea:

• Store elements in a list  
• For addAll → iterate through list and add inc  
• For multAll → iterate and multiply each element  

Problem:

If operations are large (10⁵), each update becomes **O(n)** → leads to **TLE**.

⏱ Time Complexity : O(N × Q)  
📦 Space Complexity: O(N)

----------------------------------------------

⚡ Approach 2 (Optimized Lazy Math)

Key Idea:

Instead of updating all elements every time:

Maintain two variables

• mul → overall multiplication factor  
• add → overall addition factor  

Actual value formula:

value = (stored_value × mul + add) mod M

When appending:

We reverse the transformation using **modular inverse** so that stored value remains normalized.

This makes all operations **O(1)**.

⏱ Time Complexity : O(1) per operation  
📦 Space Complexity: O(N)

----------------------------------------------

✍️ Author: Gopal Kushwaha  
📚 Repository: AlgoDiary-LeetCode-Notes  

=======================================

"""

# Approach 1 : Naive Simulation (TLE)

```python
class Fancy:

    def __init__(self):
        self.list = []
        self.mod = 10**9 + 7

    def append(self, val: int) -> None:
        self.list.append(val)

    def addAll(self, inc: int) -> None:
        for i in range(len(self.list)):
            self.list[i] = (self.list[i] + inc) % self.mod

    def multAll(self, m: int) -> None:
        for i in range(len(self.list)):
            self.list[i] = (self.list[i] * m) % self.mod

    def getIndex(self, idx: int) -> int:
        if idx >= len(self.list):
            return -1
        return self.list[idx] % self.mod
```

----------------------------------------------

# Approach 2 : Optimized Lazy Math + Modular Inverse

```python
class Fancy:

    def __init__(self):
        self.list = []
        self.mod = 10**9 + 7
        self.add = 0
        self.mul = 1

    def append(self, val: int) -> None:

        v = (val - self.add) % self.mod

        v = (v * self.modInverse(self.mul)) % self.mod

        self.list.append(v)

    def addAll(self, inc: int) -> None:
        self.add = (self.add + inc) % self.mod

    def multAll(self, m: int) -> None:
        self.mul = (self.mul * m) % self.mod
        self.add = (self.add * m) % self.mod

    def getIndex(self, idx: int) -> int:

        if idx >= len(self.list):
            return -1

        val = self.list[idx]

        val = (val * self.mul) % self.mod
        val = (val + self.add) % self.mod

        return val

    def modInverse(self, x):
        return pow(x, self.mod - 2, self.mod)
```

---

