//稀疏矩阵的加法
//2019/08/22 16:08
//Author: Marshmallow
#include<iostream>
#define MAXSIZE 20

using namespace std;

typedef struct {
    int row,col;
    int elem;
}Triple;
typedef struct{
    Triple data[MAXSIZE+1];
    int rowNum,colNum,elemNum;
}TSMatrix;
void  AddTSMatrix(TSMatrix &A,TSMatrix &B,TSMatrix &C)
{
   int m=1,n=1,q=1;
   if(A.rowNum!=B.rowNum || A.colNum!=B.colNum) return;
   while(m<=A.elemNum&&n<=B.elemNum)
   {
       if(A.data[m].row<B.data[n].row) C.data[q++]=A.data[m++];
       else if(A.data[m].row>B.data[n].row) C.data[q++]=B.data[n++];
       else{
           if(A.data[m].col<B.data[n].col) C.data[q++]=A.data[m++];
           else if(A.data[m].col>B.data[n].col) C.data[q++]=B.data[n++];
           else
           {
               C.data[q].row=A.data[m].row;
               C.data[q].col=A.data[m].col;
               C.data[q++].elem=A.data[m++].elem+B.data[n++].elem;
           }
       }
    }
    while(m<=A.elemNum)  C.data[q++]=A.data[m++];
    while(n<=B.elemNum)  C.data[q++]=B.data[n++];
    C.elemNum=--q;
}
void PrintSMatrix(TSMatrix &T) //打印稀疏矩阵
{
    for (int i = 1; i <=T.elemNum; i++)
        cout << T.data[i].row << " " << T.data[i].col << " " << T.data[i].elem << endl;
}
int main()
{
    TSMatrix A,B,C;
    cin>>A.rowNum>>A.colNum>>A.elemNum>>B.elemNum;
    B.rowNum=A.rowNum;C.rowNum=A.rowNum;
    B.colNum=A.colNum;C.colNum=A.colNum;
    for(int i=1;i<=A.elemNum;i++)
        cin>>A.data[i].row>>A.data[i].col>>A.data[i].elem;
    for(int j=1;j<=B.elemNum;j++)
        cin>>B.data[j].row>>B.data[j].col>>B.data[j].elem;
    AddTSMatrix(A,B,C);
    PrintSMatrix(C);
    return 0;
}