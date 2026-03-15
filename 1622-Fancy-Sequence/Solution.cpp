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

```cpp
class Fancy {
public:
    vector<long long> list;
    long long mod;

    Fancy() {
        mod = 1e9 + 7;
    }

    void append(int val) {
        list.push_back(val);
    }

    void addAll(int inc) {
        for (int i = 0; i < list.size(); i++) {
            list[i] = (list[i] + inc) % mod;
        }
    }

    void multAll(int m) {
        for (int i = 0; i < list.size(); i++) {
            list[i] = (list[i] * m) % mod;
        }
    }

    int getIndex(int idx) {
        if (idx >= list.size()) return -1;
        return list[idx] % mod;
    }
};
```

----------------------------------------------

# Approach 2 : Optimized Lazy Math + Modular Inverse

```cpp
class Fancy {
public:
    vector<long long> list;
    long long mod = 1e9 + 7;

    long long add;
    long long mul;

    Fancy() {
        add = 0;
        mul = 1;
    }

    void append(int val) {

        long long v = (val - add) % mod;

        if (v < 0) v += mod;

        v = (v * modInverse(mul)) % mod;

        list.push_back(v);
    }

    void addAll(int inc) {
        add = (add + inc) % mod;
    }

    void multAll(int m) {
        mul = (mul * m) % mod;
        add = (add * m) % mod;
    }

    int getIndex(int idx) {

        if (idx >= list.size()) return -1;

        long long val = list[idx];

        val = (val * mul) % mod;
        val = (val + add) % mod;

        return val;
    }

    long long modInverse(long long x) {
        return power(x, mod - 2);
    }

    long long power(long long base, long long exp) {

        long long res = 1;
        base %= mod;

        while (exp > 0) {

            if (exp & 1) {
                res = (res * base) % mod;
            }

            base = (base * base) % mod;

            exp >>= 1;
        }

        return res;
    }
};
```

