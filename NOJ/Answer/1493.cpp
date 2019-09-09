//稀疏矩阵的加法（用十字链表实现）
//2019.08.26
//Author: hxl
//注：结果正确，但是用的都是malloc而不是new


#include <iostream>
#include <cstdio>
#include <cmath>
#include <cstdlib>
#define ElemType int
using namespace std;
 
typedef struct OLNode
{
    int i, j;
    ElemType elem;
    OLNode *right, *down;
}OLNode, *OLink;

typedef struct CrossList
{
    OLink*rHead, *cHead;
    int mu, nu, tu;
}CrossList;
 
void CreateList(CrossList &M)
{
    M.rHead = (OLink*)malloc((M.mu+1)*sizeof(OLink));
    M.cHead = (OLink*)malloc((M.nu+1)*sizeof(OLink));
    for( int k = 1; k <= M.mu; k++)
        M.rHead[k] = NULL;
    for(int k = 1; k <= M.nu; k++)
        M.cHead[k] = NULL;
    for(int k = 1; k <= M.tu; k++)
    {
        int i, j, e;
        cin>>i>>j>>e;;
        OLink q;
        OLink p = (OLNode*)malloc(sizeof(OLNode));
        p->i = i;
        p->j = j;
        p->elem = e;
 
        //插入作头结点：行为空，当前结点做头结点
        if(M.rHead[i] == NULL || M.rHead[i]->j > j)
        {
            p->right = M.rHead[i];
            M.rHead[i] = p;
        }
        else
        {
            for(q = M.rHead[i]; (q->right)&&(q->right->j<j); q = q->right)
                ;
            p->right = q->right;
            q->right = p;
        }
		p->down = NULL;
        if(M.cHead[j] == NULL || M.cHead[j]->i > i)
        {
            p->down = M.cHead[j];
            M.cHead[j] = p;
        }
        else
        {
            for(q = M.cHead[j]; (q->down)&&(q->down->i<i); q = q->down)
                ;
            p->down = q->down;
            q->down = p;
        }
        p->right = NULL;
    }
}
 
void DestroyList(CrossList &M)
{
    OLink p;
    for(int k = 1; k <= M.mu; k++)
    {
        p = M.rHead[k];
        while(p)
        {
            M.rHead[k] = p->right;
            free(p);
            p = M.rHead[k];
        }
    }
    M.mu = 0;
    M.nu = 0;
    M.tu = 0;
}
 
void InsertNode(CrossList &M, OLink &p)
{
    int i = p->i, j = p->j;
    int deleted = 0, plused = 0;
    if(M.rHead[i] == NULL)
    {
        M.rHead[i] = p;
        M.tu++;
    }
    else
    {
        OLink q = M.rHead[i];
        OLink pre = q;
        while(q && (q->j < p->j))
        {
            pre = q;
            q = q->right;
        }
        //对应结点相加
        if(q!=NULL && q->j == p->j)
        {
            q->elem += p->elem;
            if(q->elem == 0)
            {
                //第一个结点相加
                if(pre == q)
                    M.rHead[i] = q->right;
                else
                    pre->right = q->right;
                M.tu--;
                deleted = 1;
            }
            else
                plused = 1;
        }
        //插入
        if(!deleted && !plused)
        //else
        {
            //插入作第一个结点
            if(pre == q)
            {
                M.rHead[i] = p;
                p->right = q;
            }
            else
            {
                pre->right = p;
                p->right = q;
            }
            M.tu++;
        }
    }
 
    if(M.cHead[j] == NULL)
        M.cHead[j] = p;
    else
    {
        OLink q = M.cHead[j];
        OLink pre = q;
        while(  q&&(q->i < p->i))
        {
            pre = q;
            q = q->down;
        }
        if(deleted)
        {
            if(q!=NULL)
            {
                //头结点
                if(pre == q)
                    M.cHead[j] = q->down;
                else
                    pre->down = q->down;
                free(q);
                free(p);
                return ;
            }
        }
        if(!plused)
        {
            if(pre == q)
            {
                M.cHead[j] = p;
                p->down = q;
            }
            else
            {
                pre->down = p;
                p->down = q;
            }
        }
    }
 
}
 
void AddList(CrossList &M, CrossList &N)
{
    OLink p, q;
    p = (OLNode*)malloc(sizeof(OLNode));
    for(int k = 1; k <= N.mu; k++)
    {
        p = N.rHead[k];
        while(p)
        {
            q = (OLNode*)malloc(sizeof(OLNode));
            q->down = p->down;
            q->right = p->right;
            q->elem = p->elem;
            q->i = p->i;
            q->j = p->j;
            //插入q，插入操作会更改结点p
            InsertNode(M, q);
            p = p->right;
        }
    }
}
 
void PrintList(CrossList &M)
{
    for(int k = 1; k <= M.mu; k++)
    {
        OLink p = M.rHead[k];
        for(int t = 1; t <= M.nu; t++)
        {
            if(p && (t == p->j))
            {
				cout<<p->i<<' '<<p->j<<' '<<p->elem<<endl;
				p = p->right;
			}
        }
    }
    //cout << endl;
}
int main()
{
    CrossList A, B;
    cin>>A.mu>>A.nu>>A.tu>>B.tu;
    CreateList(A);
    CreateList(B);
    AddList(A, B);
    PrintList(A);
    DestroyList(A);
    DestroyList(B);
    return 0;
}