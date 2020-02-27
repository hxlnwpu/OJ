#include<stdio.h>
#include<stdlib.h>
#define TRUE 1
#define FALSE 0
typedef int ElemType;
typedef int ktype;
#define MAXSIZE 11
#define NULLKEY -1
typedef struct{
	ElemType element[MAXSIZE];
	int	count;
    int sumSL;
}HashTable;
int Hash(ktype key);
int collision(ktype key,int c);
int SearchHash(HashTable *H, ktype key, int *p,int *c);
int insert(HashTable *H, ElemType key);
int main()
{
    int i;
	int tmp=1;
	double ANS;
	HashTable H;

	H.sumSL = 0;
	H.count = 0;
	for(i=0; i<MAXSIZE; i++){
		H.element[i] = NULLKEY;
	}
	scanf("%d",&tmp);
	insert(&H,tmp);
	while( getchar() != '\n' ) {
        scanf("%d",&tmp);
		insert(&H,tmp);
	}

	ANS = (int)( (double)H.sumSL/((double)H.count)*1000)/1000.0;
	printf("%g\n",ANS);

    return 0;
}

int collision(ktype key,int c)
{
    return (Hash(key)+(7*key%10+1)*c) % MAXSIZE;
}

int SearchHash(HashTable *H, ktype key, int *p,int *c)
{
	*p = Hash(key);
	while(H->element[*p]!=NULLKEY && !(H->element[*p]==key))
        *p = collision(key,++*c);

	if (H->element[*p] == key) return TRUE;
	else return FALSE;
}
int Hash(ktype key)
{
    return 3*key%11;
}

int insert(HashTable *H, ElemType key)
{
	int po=0;
	int c=0;
  	if (SearchHash(H, key, &po,&c)) /* 散列表中已有关键码为key 的结点 */
        return -1;
	else if (c<MAXSIZE) {
		H->element[po]=key;  	/* 插入结点 */
		H->sumSL += c+1;
		++H->count;
		return 1;
	}
    else  exit(-1);
}

