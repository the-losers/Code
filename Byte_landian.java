Byte Landian
Send Feedback
In Byteland, they have a very strange monetary system. Each Bytelandian gold coin has an integer number written on it. A coin n can be exchanged in a bank into three coins: n/2, n/3 and n/4. But these numbers are all rounded down (the banks have to make a profit). The coins can be exchanged as many times as you want. That is, if initially you have a coin of value 500, you can first exchange into 250, 166 and 125. And after that you can further exchange your 250 coin into 125, 83, 62. So we can exchange our any coin as many times as we want.
You can also sell Bytelandian coins for American dollars. The exchange rate is 1:1. But you can not buy Bytelandian coins.
You have one gold coin. What is the maximum amount of American dollars you can get for it?
Input format : A single integer N, denoting value of your gold coin

Output Format : A single integer, denoting the maximum amount of American dollars you can make

Sample Input 1 :
12
Sample Output 1 :
13
Sample Output 1 Explanation :
You can change 12 into 6, 4 and 3, and then change these into $6+$4+$3 = $13.
Sample Input 2 :
2
Sample Output 1 :
2
Sample Output 2 Explanation :
If you try changing the coin 2 into 3 smaller coins, you will get 1, 0 and 0, and later you can get no more than $1 out of them. It is better just to change the 2 coin directly into $2.


import java.util.*;

public class Solution {


     static Map<Long, Long> map = new HashMap<>();;
    public static long bytelandian (long c) {
        if (c == 0) return c;
        if (map.containsKey(c)) return map.get(c);
        long c1 = c/2;
        long c2 = c/3;
        long c3 = c/4;

        map.put(c, Math.max(c, bytelandian(c1)+bytelandian(c2)+bytelandian(c3)));
        return map.get(c);
    }
}
