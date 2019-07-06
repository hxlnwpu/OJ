/*PTA基础编程题目集7-2（然后是几点）：有时候人们用四位数字表示一个时间，比如1106表示11点零6分。现在，你的程序要根据起始时间和流逝的时间计算出终止时间。
#读入两个数字，第一个数字以这样的四位数字表示当前时间，第二个数字表示分钟数，计算当前时间经过那么多分钟后是几点，
结果也表示为四位数字。当小时为个位数时，没有前导的零，即5点30分表示为530。注意，第二个数字表示的分钟数可能超过60，也可能是负数。*/

#include <iostream>

using namespace std;

int main()
{
    int begin_time,through_time,begin_hour,begin_minute,through_hour,end_hour,end_minute;
    cin>>begin_time>>through_time;
    begin_hour=begin_time/100;
    begin_minute=begin_time%100;
    if(through_time>0)
    {
        through_hour=(begin_minute+through_time)/60;
        end_minute=(begin_minute+through_time)%60;
        end_hour=begin_hour+through_hour;
        cout<<end_hour<<end_minute;
    }
    else
    {
       through_hour=begin_hour-(-through_time)/60-1;
       end_minute=(60 - (-through_time)%60 + begin_minute)%60;
       end_hour=through_hour + (60 - (-through_time)%60 + begin_minute)/60;
       cout<<end_hour<<end_minute;
    }
    return 0;
}
