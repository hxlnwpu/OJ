#include<stdio.h>
#include<stdlib.h>
typedef int ElemType;
typedef struct LNode
{
        ElemType e;
        struct LNode *Tail;
        struct LNode *next;
        struct LNode *pre;
}LNode,*LinkList;
void CreateLink(LinkList *L)
{
       int i;
       LinkList p,s;
       p=*L=(LinkList)malloc(sizeof(LNode));
       (*L)->pre=(*L)->next=NULL;
       for(i=0;i<600;i++)
       {
               s=(LinkList)malloc(sizeof(LNode));
               s->e=0;
               s->next=NULL;
               p->next=s;
               s->pre=p;
               p=s;
       }
       (*L)->Tail=s;
}
void ShowList(LinkList *L,int n)
{
       int cnt;
       LinkList p=(*L)->next;
       printf("%d.",p->e);
       p=p->next;
       for(cnt=1;cnt<=n;cnt++,p=p->next)
       {
               printf("%d",p->e);
       }
       printf("\n");
}
void SuperDiv(LinkList *L,int n)
{
        LinkList p;
        int rest,temp;
        p=(*L)->next;
        temp=p->e;
        for(;p->next;p=p->next)
        {
                if(temp>=n)
                {
                        p->e=temp/n;
                        rest=temp%n;
                        temp=rest*10+(p->next->e);
                }
                else
                {
                        p->e=0;
                        rest=temp;
                        temp=rest*10+(p->next->e);
                }
        }
}
void SuperTimes(LinkList *L,int n)
{
       LinkList p;
       int temp,rest;
       for(p=(*L)->Tail;p!=(*L)->next;p=p->pre)
       {
                temp=(p->e)*n+rest;
                rest=temp/10;
                p->e=temp%10;
       }
        p->e=(p->e)*n+rest;
}
void Superplus(LinkList *La,LinkList *Lb)
{
        int rest=0,temp;
        LinkList pa,pb;
        pa=(*La)->Tail;
        pb=(*Lb)->Tail;
        for(;pb->pre!=*Lb;pa=pa->pre,pb=pb->pre)
        {
                temp=pa->e+pb->e+rest;
                rest=temp/10;
                pb->e=temp%10;
        }
        pb->e=pa->e+pb->e+rest;
}

int main()
{
        int n,cir,up=1,down=3;
        LinkList L_Final,L_Temp;
        scanf("%d",&n);
        CreateLink(&L_Final);
        CreateLink(&L_Temp);
        L_Temp->next->e=2;
        L_Final->next->e=2;
        for(cir=0;cir<2000;cir++,up+=1,down+=2)
        {
                SuperTimes(&L_Temp,up);
                SuperDiv  (&L_Temp,down);
                Superplus (&L_Temp,&L_Final);
        }
        ShowList (&L_Final,n);
        return 0;
}
