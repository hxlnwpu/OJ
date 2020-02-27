#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define STACK_INIT_SIZE 100
#define STACK_INCREMENT 10
typedef char ElemType;
typedef struct tagStack
{
    ElemType *base;
    ElemType *top;
    int stacksize;
} Stack;
char Precede(char left,char right)
{
    int isp;//in stack priority
    int icp;//incoming priority
    switch(left)
    {
    case '*':
    case '/':
        isp=3;
        break;
    case '+':
    case '-':
        isp=2;
        break;
    case '#':
        isp=1;
        break;
    case '(':
        if(right == ')') return '=';
        else if(right == '#') return -1;
        else return '<';
        break;
    case ')':
        if(right == '(') return -1;
        else return '>';
        break;
    default:
        ;
    }
    switch(right)
    {
    case '*':
    case '/':
        icp=3;
        break;
    case '+':
    case '-':
        icp=2;
        break;
    case '#':
        icp=1;
        break;
    case '(':
        return '<';
    case ')':
        return '>';
    default:
        ;
    }
    if(isp<icp) return '<';
    else return '>';
}
int is_optr(char c)
{
    if(c == '+' || c == '-' || c == '*' || c == '/'
            || c == '(' || c == ')' || c == '#') return 1;
    return 0;
}
void InitStack(Stack *S)
{
    S->base= (ElemType *)malloc(STACK_INIT_SIZE*sizeof(ElemType));
    S->top=S->base;
    S->stacksize=STACK_INIT_SIZE;
}
int StackEmpty(Stack S)
{
    return S.top==S.base;
}

int GetTop(Stack S,ElemType *e)
{
    if(S.top>S.base && e!=NULL)
    {
        *e = *(S.top-1);
        return 1;
    }
    return 0;
}

int Push(Stack *S,ElemType e)
{
    ElemType *nptr;
    if(S->top - S->base >= S->stacksize)
    {
        nptr=(ElemType *)realloc(S->base ,
                                 (S->stacksize + STACK_INCREMENT)*sizeof(ElemType));
        if(!nptr) return -1;
        else S->base=nptr;
        S->top = S->base + S->stacksize;
        S->stacksize += STACK_INCREMENT;
    }
    *(S->top++) = e;
    return 0;
}

int Pop(Stack *S,ElemType *e)
{
    if(S->top == S->base || e==NULL) return -1;
    *e=*(--(S->top));
    return 0;
}
int main()
{
    Stack OPTR;//operator
    char c,tope;
    char str[100];
    int i=0;

    InitStack(&OPTR);
    Push(&OPTR,'#');
    gets(str);
    strcat(str,"#");
    GetTop(OPTR,&tope);
    c=str[i++];
    while ( (c!='#') || tope != '#')
    {
        if (!is_optr(c))
        {
            putchar(c);
            c=str[i++];
        }
        else
        {
            switch(Precede(tope,c))
            {
            case '<':
                Push(&OPTR,c);
                c=str[i++];
                break;
            case '=':
                Pop(&OPTR,&tope);
                c=str[i++];
                break;
            case '>':
                Pop(&OPTR,&tope);
                //÷ÿµ„
                putchar(tope);
                break;
            }
        }

        GetTop(OPTR,&tope);
    }

    putchar('\n');

    return 0;
}

