/* PTA 6-13 折半查找 给一个严格递增数列，函数int Search_Bin(SSTable T, KeyType k)用来二分地查找k在数列中的位置。*/

#include <iostream>
using namespace std;

#define MAXSIZE 50
typedef int KeyType;

typedef  struct
{
    KeyType  key;
} ElemType;

typedef  struct
{
    ElemType  *R;
    int  length;
} SSTable;

void  Create(SSTable &T)
{
    int i;
    T.R=new ElemType[MAXSIZE+1];
    cin>>T.length;
    for(i=1; i<=T.length; i++)
        cin>>T.R[i].key;
}

int  Search_Bin(SSTable T, KeyType k);

int main ()
{
    SSTable T;
    KeyType k;
    Create(T);
    cin>>k;
    int pos=Search_Bin(T,k);
    if(pos==0)
        cout<<"NOT FOUND"<<endl;
    else
        cout<<pos<<endl;
    return 0;
}
int  Search_Bin(SSTable T, KeyType k)
{

    KeyType left=0,right=T.length-1,middle,result=-1;
    while(left<=right)
    {
        middle=(right-left)/2+left;
        if(T.R[middle].key<k)
        {
            left=middle+1;
        }
        else if(T.R[middle].key>k)
        {
            right=middle-1;
        }
        else
        {
            result=k;
            break;
        }

    }
    if(result==k)
        return middle;
    else
        return 0;
}
