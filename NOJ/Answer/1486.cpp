#include<stdio.h>
#define MAXVALUE 10000

typedef struct{
	int weight;
	int parent;
	int lchild;
	int rchild;
}HNodeType;
typedef struct{
	int bit[100];
	int start;
}HCodeType;
void HaffmanCode(HNodeType HFMTree[], HCodeType HuffCode[], int n){
	HCodeType cd;
	int i, j, c, p;
	for(i=0;i<n;i++){
		cd.start=n-1;
		c=i;
		p=HFMTree[c].parent;
		while(p!=-1){
			if(HFMTree[p].lchild==c)
				cd.bit[cd.start]=0;
			else cd.bit[cd.start]=1;
			cd.start--;
			c=p;
			p=HFMTree[p].parent;
		}
		for(j=cd.start+1;j<n;j++)
			HuffCode[i].bit[j]=cd.bit[j];
		HuffCode[i].start=cd.start+1;

	}

}
int main()
{
	int n, i=0, j=0, t=1, m1, x1, m2, x2, a, b, c;
	scanf("%d", &n);
	HNodeType HFMTree[200];
    HCodeType HuffCode[100];
	int A[100];
	char C[100], D[100];
    for(;i<n;i++)
		if((C[i]=getchar())!='\n'&&(C[i]=getchar())!=' ');
	i=0;
	while(i<n){
		scanf("%d", &A[i]);
		i++;
	}
	scanf("%c", &D[0]);
    while((D[t]=getchar())!='\n') t++;
    for(i=0;i<2*n-1;i++){
		HFMTree[i].weight=0;
		HFMTree[i].parent=-1;
		HFMTree[i].lchild=-1;
		HFMTree[i].rchild=-1;
	}
	for(i=0;i<n;i++)
		HFMTree[i].weight=A[i];
	for(i=0;i<n-1;i++){
		x1=MAXVALUE;
		x2=MAXVALUE;
		m1=0;
		m2=0;
		for(j=0;j<n+i;j++){
			if(HFMTree[j].parent==-1 && HFMTree[j].weight<x1){
				x2=x1;
				m2=m1;
				x1=HFMTree[j].weight;
				m1=j;
			}
			else if(HFMTree[j].parent==-1 && HFMTree[j].weight<x2){
				x2=HFMTree[j].weight;
				m2=j;
			}
		}
		HFMTree[m1].parent=n+i; 
		HFMTree[m2].parent=n+i; 
		HFMTree[n+i].weight=HFMTree[m1].weight+HFMTree[m2].weight;
		HFMTree[n+i].lchild=m1; 
		HFMTree[m1].rchild=m2; 
	}
    HaffmanCode(HFMTree, HuffCode, n);
	for(a=0;a<t;a++){
		for(b=0;b<n;b++){
			if(D[a]==C[b]){
				for(c=HuffCode[b].start;c<=n-1;c++){
					printf("%d", HuffCode[b].bit[c]);
				}
			}
		}
	}
	for(i=0;i<t;i++)
		printf("%c", D[i]); 
	printf("\n");
	return 0;
}
