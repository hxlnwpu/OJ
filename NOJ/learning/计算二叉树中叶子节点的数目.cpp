#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MaxSize 1000
typedef char DataType;
struct Node{
    DataType info;
    struct Node *lchild, *rchild;
};
typedef Node Node, *pNode;

struct Tree{
    pNode root;
    char str[MaxSize];
    int pos;
};
typedef struct Tree Tree, *pTree;
pNode initialize_node(pTree pT)
{
    if(pT->str[pT->pos] == '\0')  return NULL;
    if(pT->str[pT->pos] == '#') {pT->pos++; return NULL;}

    pNode pN = (pNode)malloc(sizeof(struct Node));
    pN->info   = pT->str[pT->pos++];
    pN->lchild = initialize_node(pT);
    pN->rchild = initialize_node(pT);

    return pN;
}
pTree initialize_tree()
{
    pTree pT = (pTree)malloc(sizeof(struct Tree));
    scanf("%s", pT->str);
    pT->pos = 0;
    pT->root = initialize_node(pT);
    return pT;
}
int push(pNode pN){
    if(!pN->lchild && !pN->rchild)  return 1;
    int res = 0;
    if(pN->lchild) res += push(pN->lchild);
    if(pN->rchild) res += push(pN->rchild);
    return res;
}
int search(pTree pT){
    if(pT->root == NULL) return 0;
    return push(pT->root);
}
int main()
{
    pTree pT = initialize_tree();
    printf("%d\n",search(pT));
    return 0;
}
