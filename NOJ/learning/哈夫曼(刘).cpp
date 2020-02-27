#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAXINT 0x7fffffff
typedef struct
{
    int weight;
    int parent, lchild, rchild;
} HTNode, *HfmTree;
typedef char  ** HfmCode;

int main()
{
    HfmTree HT;
    HfmCode HC;
    int w[101];
    char sign[101];
    char binCode[500]="";
    char message[101];
    int n;//符号个数
    int i;
    scanf("%d",&n);
    for(i=1; i<=n; i++) scanf(" %c",&sign[i]);
    for(i=0; i<n; i++) scanf("%d",&w[i]);
    buildHfmTree(HT, w, n);
    getHfmCode(HT, HC, n);
    scanf("%s",message);
    message2binCode(HC,message,sign,n,binCode);
    printf("%s\n",binCode);
    binCode2message(HT,binCode,sign,n);
    return 0;
}

void Select (HfmTree &HT, int top,int &s1,int &s2)/* 找两个最小权的无父结点的结点 */
{
    int i;
    int m1,m2;
    m1=m2=MAXINT;
    for( i=1; i<=top; i++)
    {
        if(HT[i].parent == 0)
        {
            if(HT[i].weight>=m2) ;
            else if(HT[i].weight >= m1)
            {
                s2=i;
                m2=HT[i].weight;
            }
            else
            {
                s2=s1;
                m2=m1;
                s1=i;
                m1=HT[i].weight;
            }
        }
    }
    return;
}
void buildHfmTree(HfmTree &HT, int *w, int n)/*构造哈夫曼树*/
{
    int m,i;
    int s1,s2;
    HfmTree p;
    if (n<=1) return;
    m=2*n-1;
    HT= (HfmTree) malloc ((m+1)*sizeof(HTNode));
    for (p=HT+1, i=1; i<=n; ++i, ++p, ++w)
    {
        p->weight=*w;
        p->parent=0;
        p->lchild=0;
        p->rchild=0;
        //printf("%d %d\n" ,i,*w);///
    }
    for (; i<=m; ++i, ++p)
    {
        p->weight=0;
        p->parent=0;
        p->lchild=0;
        p->rchild=0;
    }
    for (i=n+1; i<=m; ++i)
    {
        Select (HT, i-1, s1, s2);//s1<=s2
        HT[s1].parent=i;
        HT[s2].parent=i;
        HT[i].lchild=s1;
        HT[i].rchild=s2;
        HT[i].weight=HT[s1].weight+HT[s2].weight;
    }
}
void getHfmCode(HfmTree &HT, HfmCode &HC,  int n)/*哈夫曼编码*/
{
    char * cd;
    int start,f,i;
    int c;
    HC=(HfmCode) malloc ((n+1)*sizeof(char *));
    cd=(char *) malloc (n*sizeof(char));
    cd[n-1]='\0';
    for (i=1; i<=n; ++i)
    {
        start = n-1;
        for ( c=i, f=HT[i].parent; f!=0; c=f, f=HT[f].parent)
            if (HT[f].lchild == c) cd[--start]='0';
            else cd[--start]='1';
        HC[i]=(char *) malloc ((n-start)*sizeof(char));
        strcpy (HC[i], &cd[start]);
    }
    free (cd);
}
int binCode2message(HfmTree HT, char* binCode, char* sign,int n_sign)
{
    int i;
    int pNode,p_root;
    int binCode_len;

    binCode_len=strlen(binCode);
    p_root=2*n_sign-1;
    pNode=p_root;
    for(i=0; i<binCode_len; i++)
    {
        switch(binCode[i])
        {
        case '0':
            pNode=HT[pNode].lchild;
            break;
        case '1':
            pNode=HT[pNode].rchild;
            break;
        default:
            ;
        }
        if(pNode <= n_sign)
        {
            printf("%c",sign[pNode]);
            pNode=p_root;
        }
    }
    printf("\n");
    if(pNode != p_root)
        return -1;
    return 0;
}
void message2binCode(const HfmCode HC,const char* message,const char* sign, int n_sign,char* binCode)
{
    int i,j;
    int length;
    length= strlen(message);
    strcpy(binCode,"\0");
    for(i=0; i<length; i++)
    {
        for(j=1; j<=n_sign ; j++)
        {
            if(message[i] == sign[j])
            {
                strcat(binCode,HC[j]);
                break;
            }

        }
    }
}
int main()
{
    HfmTree HT;
    HfmCode HC;
    int w[101];
    char sign[101];
    char binCode[500]="";
    char message[101];
    int n;//符号个数
    int i;
    scanf("%d",&n);
    for(i=1; i<=n; i++) scanf(" %c",&sign[i]);
    for(i=0; i<n; i++) scanf("%d",&w[i]);
    buildHfmTree(HT, w, n);
    getHfmCode(HT, HC, n);
    scanf("%s",message);
    message2binCode(HC,message,sign,n,binCode);
    printf("%s\n",binCode);
    binCode2message(HT,binCode,sign,n);
    return 0;
}
