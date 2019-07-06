#include<cstdio>

int main()
{
    int hour=0,minute=0,temp=0;
    scanf("%d:%d",&hour,&minute);
    temp=hour%12;
    if(hour<12||hour==24)
    {
        printf("%d:%d",temp,minute);
        printf(" AM");
    }
    else if(hour==12)
    {
        printf("%d:%d",hour,minute);
        printf(" PM");
    }
    else
    {
        printf("%d:%d",temp,minute);
        printf(" PM");
    }
   return 0;
}
