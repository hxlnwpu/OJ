/*PTA基础编程题目集7-3（逆序的三位数）：程序每次读入一个正3位数，然后输出按位逆序的数字。注意：当输入的数字含有结尾的0时，输出不应带有前导的0。比如输入700，输出应该是7。*/

#include<iostream>
using namespace std;

int main()
{
    int number,i,j,k;
    cin>>number;
    i=number/100;
    j=number%100/10;
    k=number%100%10;
    if(k==0)
    {
        if(j==0)
            cout<<i;
        else
            cout<<j<<i;
    }
    else
        cout<<k<<j<<i<<endl;

}
