//稀疏矩阵转置   


#include <iostream>
#define MAXSIZE 20

using namespace std;

typedef struct
{
    int elem;
    int row, col;
} Triple;
typedef struct
{
    Triple data[MAXSIZE + 1]; //data[0]未用
    int rowNum, colNum, elemNum;
} TSMatrix;

void TransposeSMatriT(TSMatrix &M, TSMatrix &T) //普通转置
{
    int q = 1;
    for (int i = 1; i <= M.colNum; i++)
        for (int j = 1; j <= M.elemNum; j++)
        {
            if (M.data[j].col == i)
            {
                T.data[q].row = M.data[j].col;
                T.data[q].col = M.data[j].row;
                T.data[q].elem = M.data[j].elem;
                q++;
            }
        }
}
void QuickTranspose(TSMatrix &M, TSMatrix &T){ //快速转置
    int num_col[M.colNum]={0}; //M每一列非零元的个数
    int cpot[M.elemNum+1]={0}; //M每一列第一个非零元在T的位置索引
    cpot[1]=1;
    int col=0;
    for(int i=1;i<=M.elemNum;i++) ++num_col[M.data[i].col]; 
    for(int j=2;j<=M.elemNum;j++) cpot[j]=cpot[j-1]+num_col[j-1];
    for(int k=1;k<=M.elemNum;k++){
        col=M.data[k].col;
        T.data[cpot[col]].elem=M.data[k].elem;
        T.data[cpot[col]].row=M.data[k].col;
        T.data[cpot[col]].col=M.data[k].row;
        ++cpot[col];
    }
}
void PrintSMatrix(TSMatrix &T) //打印稀疏矩阵
{
    for (int i = 0; i < T.elemNum; i++)
        cout << T.data[i].row << " " << T.data[i].col << " " << T.data[i].elem << endl;
}
int main()
{
    TSMatrix M, T;
    int i, j, k, m = 1;
    cin >> M.rowNum >> M.colNum;
    T.rowNum = M.colNum;
    T.colNum = M.rowNum;
    while (1)
    {
        cin >> i >> j >> k;
        if (i == 0 && j == 0 && k == 0)
            break;
        M.data[m].row = i;
        M.data[m].col = j;
        M.data[m].elem = k;
        m++;
    }
    M.elemNum= T.elemNum = m;
    //TransposeSMatrix(M, T);
    QuickTranspose(M,T);
    PrintSMatrix(T);
    return 0;
}
