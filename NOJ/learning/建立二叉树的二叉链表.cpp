#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MaxSize 1000
typedef char infotype;
struct Node{
    infotype info;
    struct Node *lchild, *rchild;
};
typedef Node Node, *pNode;
struct Tree{
    pNode root;
    char pre[MaxSize];
    char ino[MaxSize];
    int pos, len;
};
typedef struct Tree Tree, *pTree;
pNode intnode(pTree pT, int l, int r)
{
    if(l > r) return NULL;

    pNode pN = (pNode)malloc(sizeof(struct Node));
    int i=l;
    for(; i<=r; i++)
        if(pT->ino[i] == pT->pre[pT->pos])
            break;
    if(i>r)  i=r;
    pN->info = pT->pre[pT->pos++];
    pN->lchild = intnode(pT, l, i-1);
    pN->rchild = intnode(pT, i+1, r);
    return pN;
}
pTree inttree()
{
    pTree pT = (pTree)malloc(sizeof(struct Tree));
    scanf("%s", pT->pre);
    scanf("%s", pT->ino);
    pT->len = strlen(pT->pre);
    pT->pos = 0;

    pT->root = intnode(pT, 0, pT->len-1);
    return pT;
}

void push(pNode pN){
    if(pN == NULL)  return;
    push(pN->lchild);
    push(pN->rchild);
    printf("%c\n", pN->info);
}
void print(pTree pT)
{
    push(pT->root);
}
int main()
{
    pTree pT = inttree();
    print(pT);
    return 0;
}
