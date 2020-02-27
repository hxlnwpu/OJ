#include<stdio.h>
#include<stdlib.h>
#define M 100
#define N 10
typedef char ElemType;
typedef struct tagStack{
	ElemType *base;
	ElemType *top;
	int size;
} Stack;
void InStack(Stack *S){
	S->base=(ElemType *)malloc(M*sizeof(ElemType));
	S->top=S->base;
	S->size=M;
}
void shutStack(Stack *S){
	free(S->base);
	S->base=S->top=NULL;
	S->size=0;
}
int Push(Stack *S, ElemType e){
	if(S->top-S->base >= S->size){

		S->base=(ElemType *)realloc(S->base,S->size*sizeof(ElemType));

		S->top=S->base+S->size;
		S->size+=N;
	}
	*(S->top)++=e;
	return 1;
}
int Pop(Stack *S, ElemType *e){
	if(S->top==S->base||e==NULL) return 0;
	*e=*(--S->top);
	return 1;
}
int GetTop(Stack *S, ElemType *e){
	if(S->top>S->base && e!=NULL){
		*e=*(S->top-1);
		return 1;
	}
	return 0;
}
int StackEmpty(Stack *S){
	return S->top==S->base;
}
int main()
{
	char s[100], e, a;
	int i, cnt=0;
	Stack S;
	InStack(&S);
    while((s[cnt]=getchar())!='\n')
		cnt++;
	for(i=0;i<=cnt;i++){
	    if(i==cnt){
			if(StackEmpty(&S))
	         	printf("Yes\n");
			else
		        printf("No\n");
		}
		else if(s[i] == '{' || s[i] == '(' || s[i] == '[')
			 Push(&S, s[i]);
		else if(s[i] == '}' || s[i] == ')' || s[i] == ']'){
			GetTop(&S, &e);
			if(StackEmpty(&S)){
				printf("No\n");
		    	break;
			}
			else if(s[i] - e < 3 && s[i] - e >-3)
				Pop(&S, &a);
            else {
				printf("No\n");
			    break;
			}
		}
	}
    shutStack(&S);
	return 0;
}






