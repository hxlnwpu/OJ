#include<iostream>
#include<malloc.h>

using namespace std;

typedef struct LNode{
   int data;
   struct LNode *next; 
}LNode,*LinkList;

//头插法建立链表：单链表的逻辑顺序与输入数据相反
void CreateHeadList(LinkList &L,int n)
{
    L=(LinkList)malloc(sizeof(LNode));
    L->next=NULL;
    int num;
    for(int i=n;i>0;i--)
    {
      LinkList p=(LinkList)malloc(sizeof(LNode));
      cin>>num;
      p->data=num;
      p->next=L->next;
      L->next=p;
    }
}
//尾插法建立链表:采用尾插入法创建的单链表的逻辑顺序与输入的数据顺序是相同的
void CreateTailList(LinkList &L,int n)
{
    L=(LinkList)malloc(sizeof(LNode));
    LinkList q=(LinkList)malloc(sizeof(LNode));
    q=L;
    L->next=NULL;
    int num;
    for(int i=n;i>0;i--)
    {
      LinkList p=(LinkList)malloc(sizeof(LNode));
      cin>>num;
      p->data=num;
      q->next=p;
      q=p;
    }
    q->next=NULL;
}
//尾插法建立的链表输出时顺序输出
void printLinklist(LinkList &L)   
{
    LinkList p=L->next;
    while(p!=NULL)
    {

        cout<<(p->data)<<endl;
        p=p->next;
    }
}

int main()
{
  int n;
  LinkList L;
  cin>>n;
  CreateTailList(L,n);
  printLinklist(L);
  return 0;
}
