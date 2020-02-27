#include <stdio.h>
#include <stdlib.h>
typedef struct NODE
{
    int data;
    int x,y;
    struct NODE *next,*down;
} Node;
int  caculate(Node *p,Node *q)
{
    int sum=0;
    Node *a,*b;
    a=p->next;
    b=q->down;
    while(1)
    {
        if(a==NULL || b==NULL)return sum;
        else
        {
            if(a->y==b->x)
            {
                sum=sum+a->data*b->data;
                a=a->next;
                b=b->down;
            }
            else if(a->y > b->x)
            {
                b=b->down;
            }
            else if(a->y < b->x)
            {
                a=a->next;
            }
        }
    }
}

int main()
{
    int m1,n1,m2,n2,t1,t2;//m为行，n为列,t1\t2为两个元素
    int i,j;
    scanf("%d%d",&m1,&n1);
    Node *Rl,*Cl,*p,*q,*rl,*cl;
    Rl=(Node *)malloc(sizeof(Node));
    Cl=(Node *)malloc(sizeof(Node));
    rl=(Node *)malloc(sizeof(Node));
    cl=(Node *)malloc(sizeof(Node));
    p=Rl;
    for(i=0; i<m1; i++)
    {
        p->down=(Node *)malloc(sizeof(Node));
        p=p->down;
        p->next=NULL;
    }
    p->down=NULL;
    p=Cl;
    for(i=0; i<n1; i++)
    {
        p->next=(Node *)malloc(sizeof(Node));
        p=p->next;
        p->down=NULL;
    }
    p->next=NULL;
    while(1)
    {
        q=(Node *)malloc(sizeof(Node));
        q->next=NULL;
        q->down=NULL;
        scanf("%d%d%d",&(q->x),&(q->y),&(q->data));
        if(q->x==0 &&q->y==0 && q->data==0)break;
        p=Rl;
        for(j=0; j<q->x; j++) //找到对应行的开头
        {
            p=p->down;
        }
        while(1)//插入到行
        {
            if(p->next==NULL)
            {
                p->next=q;
                break;
            }
            else if(p->next->y>q->y)
            {
                q->next=p->next;
                p->next=q;
                break;
            }
            else if(p->next->y<q->y)
            {
                p=p->next;
            }
            else if(p->next->y==q->y)
            {
                p->next->data=p->next->data+q->data;
                break;
            }
        }



        p=Cl;
        for(j=0; j<q->y; j++)
        {
            p=p->next;
        }
        while(1)
        {
            if(p->down==NULL)
            {
                p->down=q;
                break;
            }
            else if(p->down->x>q->x)
            {
                q->down=p->down;
                p->down=q;
                break;
            }
            else if(p->down->x<q->x)
            {
                p=p->down;
            }
            else if(p->down->x==q->x)
            {
                //p->down->data=p->down->data + q->data;
                break;
            }

        }


    }

    scanf("%d%d",&m2,&n2);
    p=rl;
    for(i=0; i<m2; i++)
    {
        p->down=(Node *)malloc(sizeof(Node));
        p=p->down;
        p->next=NULL;
    }
    p->down=NULL;
    p=cl;
    for(i=0; i<n2; i++)
    {
        p->next=(Node *)malloc(sizeof(Node));
        p=p->next;
        p->down=NULL;
    }
    p->next=NULL;
    while(1)
    {
        q=(Node *)malloc(sizeof(Node));
        q->next=NULL;
        q->down=NULL;
        scanf("%d%d%d",&(q->x),&(q->y),&(q->data));
        if(q->x==0 &&q->y==0 && q->data==0)break;
        p=rl;
        for(j=0; j<q->x; j++) //找到对应行的开头
        {
            p=p->down;
        }
        while(1)//插入到行
        {
            if(p->next==NULL)
            {
                p->next=q;
                break;
            }
            else if(p->next->y>q->y)
            {
                q->next=p->next;
                p->next=q;
                break;
            }
            else if(p->next->y<q->y)
            {
                p=p->next;
            }
            else if(p->next->y==q->y)
            {
                p->next->data=p->next->data+q->data;
                break;
            }
        }
        p=cl;
        for(j=0; j<q->y; j++)
        {
            p=p->next;
        }
        while(1)
        {
            if(p->down==NULL)
            {
                p->down=q;
                break;
            }
            else if(p->down->x>q->x)
            {
                q->down=p->down;
                p->down=q;
                break;
            }
            else if(p->down->x<q->x)
            {
                p=p->down;
            }
            else if(p->down->x==q->x)
            {
                //p->down->data=p->down->data + q->data;
                break;
            }

        }
     }       //两个矩阵建立完毕
    p=Rl;
    q=cl;
    for(i=0;i<m1; i++)
    {
        p=p->down;
        int sum=0;
        for(j=0; j<n2; j++)
        {
            q=q->next;
            sum=caculate(p,q);
            if (sum!=0)
                printf("%d %d %d\n",i+1,j+1,sum);
        }
        q=cl;
    }
}

