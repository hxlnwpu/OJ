#include   <stdlib.h>
#include   <stdio.h>
#define   MAXSIZE   50     //假设非零元个数的最大值为50
#define   MAXROW 10        //矩阵最大行为10
#define   ElemType   int
typedef struct
{
    int row,col;  //该非零元素的行下标和列下标
    ElemType e;   //该非零元素的值
} Triple;
typedef struct
{
    Triple data[MAXSIZE+1];   //非零元素的三元组表，data[0]未用
    int m,n,len;           //矩阵的行数、列数和非零元素的个数
} TSMatrix;
void AddSMatrix(TSMatrix *M,TSMatrix *N,TSMatrix *Q)//求采用三元组顺序表存储表示的稀疏矩阵M和N的和,结果赋给矩阵Q
{

    int i,j,p,q,x=0,y=0;
    Q->m=M->m;
    Q->n=M->n;
    Q->len=0;
    for(i=1; i<=Q->m; i++)
    {
        for(j=1; j<=Q->n; j++)
        {
            for(p=1; p<=M->len; p++)
            {
                if((i==M->data[p].row)&&(j==M->data[p].col))
                {
                    x=M->data[p].e;
                    break;
                }
                else x=0;
            }
            for(q=1; q<=N->len; q++)
            {
                if((i==N->data[q].row)&&(j==N->data[q].col))
                {
                    y=N->data[q].e;
                    break;
                }
                else y=0;
            }
            if((x+y)!=0)
            {
                Q->data[Q->len+1].row=i;
                Q->data[Q->len+1].col=j;
                Q->data[Q->len+1].e=x+y;
                Q->len++;
            }
        }
    }

}
void InputMatrix(TSMatrix *A,int m,int n,int z)
{
    int k=1,i,j;
    A->m=m;
    A->n=n;
    A->len=z;
    for(i=1; i<=A->m; i++)
        for(j=1; j<=A->n; j++)
        {
            for(; k<=A->len;)
            {
                if(k<=A->len)
                    scanf("%d",&A->data[k].row);
                scanf("%d",&A->data[k].col);
                scanf("%d",&A->data[k++].e);

            }
        }

}
void OutputTSMatrix(TSMatrix *A)
{
    int k=1,i,j;
    for(i=1; i<=A->m; i++)
        for(j=1; j<=A->n; j++)
        {
            if(i==A->data[k].row&&j==A->data[k].col)
                for(k=1; k<=A->len; k++)
                {
                    printf("%d %d %d\n",A->data[k].row,A->data[k].col,A->data[k].e);
                }
        }
}
int main()
{
    int m,n,p,q;

    TSMatrix *A,*B,*C;
    A=(TSMatrix *)malloc(sizeof(TSMatrix));
    B=(TSMatrix *)malloc(sizeof(TSMatrix));
    C=(TSMatrix *)malloc(sizeof(TSMatrix));
    scanf("%d%d%d%d",&m,&n,&p,&q);
    InputMatrix(A,m,n,p);
    InputMatrix(B,m,n,q);
    AddSMatrix(A,B,C);
    OutputTSMatrix(C);
    return 0;
}
