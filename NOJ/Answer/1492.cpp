//NOJ-1492    稀疏矩阵的乘法
//2019.08.23
//Author：hxl

#include<iostream>
#define MAXSIZE 20   //稀疏矩阵最大元素个数
#define MAXRC   20   //稀疏矩阵最大行数

using namespace std;

typedef struct{
    int row,col;
    int elem;
}Triple;
typedef struct{
    Triple data[MAXSIZE+1];
    int rpos[MAXRC+1];  //各行第一个非零元的位置
    int rowNum,colNum,elemNum;
}TSMatrix;

void MulTSMatrix(TSMatrix &A,TSMatrix &B,TSMatrix &C) //稀疏矩阵乘法
{
   int arow,brow,p,q,ccol,ctemp[MAXRC+1],t,tp;
   if(A.elemNum*B.elemNum==0) return;    //有一个是零矩阵，不能相乘
   if(A.colNum!=B.rowNum) return;        //A的列数不等于B的行数，不能相乘
   C.rowNum=A.rowNum;
   C.colNum=B.colNum;
   C.elemNum=0;                          //初始化C
   //从M的第一行开始到最后一行，arow是A的当前行
   for(arow = 1;arow <= A.rowNum;arow++){
        for(ccol=1;ccol <= C.colNum;ccol++){
            ctemp[ccol] = 0;//的当前行的各列元素清零
        }
        C.rpos[arow] = C.elemNum + 1;//开始时从第一个存储位置开始存，后面是基于前面的
        if(arow < A.rowNum){
            tp = A.rpos[arow+1];//下一行的起始位置
        }else{
            tp = A.elemNum + 1;//最后一行的边界
        }
        for(p = A.rpos[arow];p < tp;p++){
            //对M当前行的每一个非零元
            //找到对应元素在B中的行号，即A中当前元的列号
            brow = A.data[p].col;
            //原理同上
            if(brow < B.rowNum){
                t = B.rpos[brow + 1];
            }else{
                t = B.elemNum + 1;
            }
            for(q = B.rpos[brow];q < t;q++){
                ccol = B.data[q].col;//乘积元素在C中列的位置
                ctemp[ccol] += A.data[p].elem * B.data[q].elem;
            }//for_q
        }//for_p
        //该压缩存储该行非零元了
        for(ccol = 1;ccol <= C.colNum;ccol++){
            if(0 != ctemp[ccol]){
                if(++C.elemNum > MAXSIZE){//注意这里有个++
                    return;
                }
                C.data[C.elemNum].row = arow;
                C.data[C.elemNum].col = ccol;
                C.data[C.elemNum].elem = ctemp[ccol];
            }
        }
    }//for_arow
   
}
void PrintSMatrix(TSMatrix &T) //打印稀疏矩阵
{
    for (int i = 1; i <=T.elemNum; i++)
        cout << T.data[i].row << " " << T.data[i].col << " " << T.data[i].elem << endl;
}
void InputTSMatrix(TSMatrix &A)  //稀疏矩阵输入
{   
    cin>>A.rowNum>>A.colNum;
    int i,j,k,m=1;
    while(1){
        cin>>i>>j>>k;
        if(i==0&&k==0&&j==0) break;
        A.data[m].row=i;
        A.data[m].col=j;
        A.data[m].elem=k;
        m++;
    }
    A.elemNum=--m;
    A.rpos[1]=1;
    int num[A.rowNum]={0}; //A每行非零元个数
    for(int q=1;q<=A.elemNum;q++)
        ++num[A.data[q].row];
    for(int p=2;p<=A.rowNum;p++)  //统计第一个非零元的位置表
       A.rpos[p]=A.rpos[p-1]+num[p-1];
}
int main()
{
    TSMatrix A,B,C;
    InputTSMatrix(A);
    InputTSMatrix(B);
    MulTSMatrix(A,B,C);
    PrintSMatrix(C);
    return 0;
}