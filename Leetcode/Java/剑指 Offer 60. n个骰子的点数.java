/**
 * 方法1：动态规划
 */
class Solution{
    public double[] twoSum(int n) {
        double pre[]={1/6d,1/6d,1/6d,1/6d,1/6d,1/6d};
        for(int i=2;i<=n;i++){
            double tmp[]=new double[5*i+1];
            for(int j=0;j<pre.length;j++)
                for(int x=0;x<6;x++)
                    tmp[j+x]+=pre[j]/6;
            pre=tmp;
        }
        return pre;
    }

}
/**
 * 方法2：动态规划
 */
class Solution{
    public double[] twoSum(int n) {
        if(n==0) return new double[0];
        int code =6;//每个骰子有6个数字
        int[][] count = new int[2][n*code+1];
        int flag = 0;
        //i为骰子数,j为点数,k为移动的位数(1=<k<=6)
        for(int j=1;j<=code;j++) count[flag][j] =1;//第1枚骰子,i=1
        for(int i=2;i<=n;i++){//第2枚到第n枚骰子
            for(int j=1;j<i;j++) count[1-flag][j]=0;//第1~i-1置0,第0位没有进行修改过，始终为初始值0;
            for(int j=i;j<=i*code;j++){
                count[1-flag][j]=0;//这里必须有清空操作,否则后面的+=操作会基于上上次循环的初始值累加
                for(int k=1;k<=6&&j-k>=1;k++){
                    count[1-flag][j]+=count[flag][j-k];
                }
            }
            flag = 1-flag;
        }
        double base = Math.pow(code,n);
        double[] p = new double[n*code-n+1];
        for(int j= 0;j<p.length;j++) p[j] = count[flag][n+j]/base;//base已经是double类型了，这里前面可不用加(double)转换了
        return p;
    }
    
}
