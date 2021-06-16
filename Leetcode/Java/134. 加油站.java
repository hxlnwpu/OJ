/**
 * 方法1
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            index = i;
            int has = gas[i]-cost[i];
            if(has>=0)
            {
                for (int j = i+1; j < cost.length+i; j++) {
                    has += (gas[j%cost.length]-cost[j%cost.length]);
                    if(has<0) break;
                }
                if(has>=0) return index;
            }
        }
        return -1;
    }
}
/**
 * 方法2
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}
