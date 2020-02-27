#include<stdio.h>
#include<stdlib.h>
#define OK 1
#define ERROR 0
#define MAXSIZE 100  //����0Ԫ�صĸ���
#define MAXR 50      //rpos���ܴ�����������
#define MAXC 50   //ϵ���������ʱ��������ʱ�н��������temp[MAXC]
typedef struct NODE  //����ϡ�������
{
    int i;
    int j;
    int data;
} Node;
typedef struct MATRIX  //����ϡ����󣨿��Կ��ٷ��ʣ�
{
    int mu, nu, tu;
    Node matrix[MAXSIZE+1];
    int rpos[MAXR+1];
} Matrix;
int Mul_SMatrix( Matrix M, Matrix N, Matrix *Q)//ϡ��������
{
    int i,Mj;
    int arow, Mlim, Nlim, Mcol, Nrow;
    int ctemp[MAXC];
    Q->tu=0;
//��ʼ��Q
    Q->mu=M.mu;
    Q->nu=M.nu;
    if(M.tu*N.tu!=0)
    {
        //�������
        for(arow=1; arow<=M.mu; arow++)
        {
            for(i=1; i<=M.nu; i++)//����ۼ���
                ctemp[i]=0;
            Q->rpos[arow]=Q->tu+1; //��Q->rpos[]���鸳ֵ
            Mlim =  arow<M.mu ? M.rpos[arow+1] : M.tu+1;
            //M�е�arow���ڽ�������еķ�Χ
            for( Mcol=M.rpos[arow]; Mcol<Mlim; Mcol++ )
            {
                //����M�е�arow�е�ÿһ��j
                Mj=M.matrix[Mcol].j;
                Nlim =  Mj<N.mu ? N.rpos[Mj+1] : N.tu+1;//��N���ҵ��к�i����M�е��к�j��λ��
                for( Nrow=N.rpos[Mj]; Nrow<Nlim; Nrow++ )//�˻�Ԫ����Q�е��к�
                    ctemp[N.matrix[Nrow].j] += M.matrix[Mcol].data * N.matrix[Nrow].data;


            }
            for(i=1; i<=Q->nu; i++) //�кŶ�ӦԪ�ز�Ϊ�㣬��ֵ
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
int CreatSMatrix( Matrix* M )//����ϡ�����
{
    int temp, i,j;
    scanf("%d%d", &M->mu,&M->nu);
    M->tu=0;
    for( i=1; i<=M->mu; i++)
    {
        M->rpos[i]=M->tu+1;  //ÿ������һ�У���rpos[]��ֵ
        for( j=1; j<=M->nu; j++)
        {
            scanf("%d",&temp );
            if( temp )       //��0ֵ����
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
int Print( Matrix M)//��ӡϡ�����
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
