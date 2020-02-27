#include<stdio.h>
#include<stdlib.h>
#define MAXSIZE 400
typedef int ElemType;
typedef struct{
    int i,j;
    ElemType  e;
}Triple;
typedef struct{
   Triple data[MAXSIZE+1];
   int mu,nu,tu;
}TSMatrix;
void TransposeSMattrix(TSMatrix M,TSMatrix *T){
     (*T).mu=M.nu;
     (*T).nu=M.mu;
     (*T).tu=M.tu;
     int q=1,col,p;
	  for(col=1;col<=M.nu;++col)
		  for(p=1;p<=M.tu;++p)
			 if(M.data[p].j==col){
				(*T).data[q].i=M.data[p].j;
				(*T).data[q].j=M.data[p].i;
				(*T).data[q].e=M.data[p].e;
				++q;
			}

}
int main()
{
	TSMatrix A,B;
	int l;
	scanf("%d%d",&(A.mu),&(A.nu));
	for(A.tu=1;;A.tu++){
           scanf("%d%d%d",&A.data[A.tu].i,&A.data[A.tu].j,&A.data[A.tu].e);
		   if(A.data[A.tu].i==0&&A.data[A.tu].j==0&&A.data[A.tu].e==0) break;
		   }
		 A.tu--;
	TransposeSMattrix(A,&B);
	for(l=1;l<=B.tu;l++)
	    printf("%d %d %d\n",B.data[l].i,B.data[l].j,B.data[l].e);
    return 0;
}

