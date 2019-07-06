/* PTA 7-1 厘米换算英尺英寸  如果已知英制长度的英尺foot和英寸inch的值，那么对应的米是(foot+inch/12)×0.3048。现在，如果用户输入的是厘米数，那么对应英制长度的英尺和英寸是多少呢？别忘了1英尺等于12英寸。*/

#include <stdio.h>

int main()
{

    int cmlen;

    scanf("%d",&cmlen);

    int foot= cmlen/100.0/0.3048;

    int inch = (cmlen/100.0/0.3048-foot)*12;

    printf("%d %d\n",foot,inch);

    return 0;
}
