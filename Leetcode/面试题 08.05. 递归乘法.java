/**
 * 由下到上递归
 */
class Solution {
    public int multiply(int A, int B) {
         if(A==0||B==0) return 0;
         if(A==1) return B;
         if(B==1) return A;
         if(A<=B)
         return multiply(A-1,B)+B;
         else
             return multiply(A,B-1)+A;
    }
}
/**
 * 由上到下递归
 */
class Solution {
    public int multiply(int A, int B) {
           return helper(A,B,0);
    }
    public int helper(int A,int B,int sum)
    {
        
        if(A<2) return B+sum;
        if(B<2) return A+sum;
        if(A<=B)
        {
        sum += B;
        return helper(A-1,B,sum);
        }
        else
        {
            sum += A;
            return helper(A,B-1,sum);
        }

    }
}
/**
 * 方法3
 */
public int multiply2(int A, int B) {
    return (A < B) ? multiply2Help(A, B, 0) : multiply2Help(B, A, 0); // 寻找最小循序次数
}

// missPart 为奇数除以 2 时丢失的部分
public int multiply2Help(int A, int B, int missPart) {
    if (A < 2) return missPart + B;   // 最终结果 = 丢失的部分 + 最终 B 的结果
    missPart += (A & 1) == 1 ? B : 0; // 是否为奇数，奇数时记录丢失的部分
    return multiply2Help(A >> 1, B << 1, missPart); // 位移运算优化
}