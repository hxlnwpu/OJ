#include<stdio.h>
#include<stdlib.h>
#define OK 1
#define ERROR 0
#define MAXSIZE 100  //最多非0元素的个数
#define MAXR 50      //rpos所能处理的最大行数
#define MAXC 50   //系数矩阵相乘时，保留临时列结果的数组temp[MAXC]
typedef struct NODE  //定义稀疏矩阵结点
{
    int i;
    int j;
    int data;
} Node;
typedef struct MATRIX  //定义稀疏矩阵（可以快速访问）
{
    int mu, nu, tu;
    Node matrix[MAXSIZE+1];
    int rpos[MAXR+1];
} Matrix;
int Mul_SMatrix( Matrix M, Matrix N, Matrix *Q)//稀疏矩阵相乘
{
    int i,Mj;
    int arow, Mlim, Nlim, Mcol, Nrow;
    int ctemp[MAXC];
    Q->tu=0;
//初始化Q
    Q->mu=M.mu;
    Q->nu=M.nu;
    if(M.tu*N.tu!=0)
    {
        //非零矩阵
        for(arow=1; arow<=M.mu; arow++)
        {
            for(i=1; i<=M.nu; i++)//清空累加器
                ctemp[i]=0;
            Q->rpos[arow]=Q->tu+1; //给Q->rpos[]数组赋值
            Mlim =  arow<M.mu ? M.rpos[arow+1] : M.tu+1;
            //M中第arow行在结点数组中的范围
            for( Mcol=M.rpos[arow]; Mcol<Mlim; Mcol++ )
            {
                //遍历M中第arow行的每一个j
                Mj=M.matrix[Mcol].j;
                Nlim =  Mj<N.mu ? N.rpos[Mj+1] : N.tu+1;//在N中找到行号i等于M中的列号j的位置
                for( Nrow=N.rpos[Mj]; Nrow<Nlim; Nrow++ )//乘积元素在Q中的列号
                    ctemp[N.matrix[Nrow].j] += M.matrix[Mcol].data * N.matrix[Nrow].data;


            }
            for(i=1; i<=Q->nu; i++) //列号对应元素不为零，赋值
            {
                if( ctemp[i] )
                {
                    if( ++Q->tu > MAXSIZE )
                        return 0;
                    Q->matrix[Q->tu].i = arow;
                    Q->matrix[Q->tu].j = i;
                    Q->matrix[Q->tu].data = ctemp[i];
                }
            }
        }
    }
    return 1;
}
int CreatSMatrix( Matrix* M )//构建稀疏矩阵
{
    int temp, i,j;
    scanf("%d%d", &M->mu,&M->nu);
    M->tu=0;
    for( i=1; i<=M->mu; i++)
    {
        M->rpos[i]=M->tu+1;  //每计算完一行，给rpos[]赋值
        for( j=1; j<=M->nu; j++)
        {
            scanf("%d",&temp );
            if( temp )       //非0值保存
            {
                M->matrix[M->tu+1].i= i;
                M->matrix[M->tu+1].j= j;
                M->matrix[M->tu+1].data=temp;
                M->tu++;
            }
        }
    }
    return OK;
}
int Print( Matrix M)//打印稀疏矩阵
{
    int i;
    for( i=1; i<=M.tu; i++ )
        printf("%d\t%d\t%d\n", M.matrix[i].i,M.matrix[i].j,M.matrix[i].data);
    return OK;

}
int main()
{
    Matrix A1, A2, A3;
    CreatSMatrix( &A1 );
    CreatSMatrix( &A2 );
    Mul_SMatrix( A1, A2, &A3 );
    Print(A3);
    system("pause");
    return 0;
}
