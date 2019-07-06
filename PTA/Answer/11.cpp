/*7-4 BCD解密：BCD数是用一个字节来表达两位十进制的数，每四个比特表示一位。所以如果一个BCD数的十六进制是0x12，它表达的就是十进制的12。但是小明没学过BCD，把所有的BCD数都当作二进制数转换成十进制输出了。于是BCD的0x12被输出成了十进制的18了！

现在，你的程序要读入这个错误的十进制数，然后输出正确的十进制数。提示：你可以把18转换回0x12，然后再转换回12。*/

#include<iostream>


using namespace std;

int main()
{
    int wrong_num=0,correct_num=0;
    cin>>wrong_num;
    correct_num=wrong_num/16*10+(wrong_num%16);
    cout<<correct_num<<endl;
    return 0;
}
