#define MAXNODE	100
#define MAXNUM	50

struct HtNode		/* �����������Ľṹ */
{
	int weight;
	int parent, lchild, rchild;
};

struct HtTree
{
	struct HtNode  ht[MAXNODE];
 	int    root; 	/* �����������������е�λ�� */
}HtTree, *PHtTree;
PHtTree huffman (int n, int *w)
/* �������n��Ҷ���Ĺ�������*/
/* ����w[1��n]�д��n��Ȩֵ */
{	PHtTree  pht;
	int  i, j, x1, x2, m1, m2;
  	pht = (PHtTree) malloc (sizeof (struct HtTree));
	/* �����չ������� */
  	assert(pht);
  	for( i=1; i<=2*n - 1; i++ )		/* �ó�̬ */
  	{ 	pht->ht[i].lchild = 0;
		pht->ht[i].rchild = 0;
		pht->ht[i].parent = 0;
		if (i<=n)  pht->ht[i].weight = w[i];
		else 	 pht->ht[i].weight = 0;
  	};
/* ÿѭ��һ�ι���һ���ڲ���� */
  	for( i=1; i < n ; i++ )
  	{
		Select (pht, n+i, &x1, &x2);
		pht->ht[x1].parent = n + i;	/* ����һ���ڲ���� */
		pht->ht[x2].parent = n + i;
		pht->ht[n+i].weight = pht->ht[x1].weight
				        + pht->ht[x2].weight;
		pht->ht[n+i].lchild = x1;
		pht->ht[n+i].rchild = x2;
		pht->root = n+i;
  	}
  	return pht;
}
void Select (PHtTree pht, int pos, int *x1, int *x2)
{    int  m1 = MAXINT, m2 = MAXINT;
      /* ��ر�������ֵ */
      for (j=1; j<pos; j++)	/* ��������СȨ���޸����Ľ�� */
      {
	if (pht->ht[j].weight<m1 && pht->ht[j].parent == 0)
	{ 	m2 = m1;	x2 = x1;
	  	m1 = pht->ht[j].weight;
	  	x1 = j;
	}
	else if (pht->ht[j].weight<m2 && pht->ht[j].parent == 0)
	{	m2 = pht->ht[j].weight;
	 	x2 = j;
	}
      }
}
void TraverseHuffman (PhtTree T, char** HC, int n)
{
	static int	codeLen = 0;    	/* Ϊʲôʹ�þ�̬����? */
	static char	cd[MaxLen];
	if (!T)
		return;
	if (T.ht[n].rchild = = 0)	{ 	/* Why ? */
		cd[codeLen] = '\0';
		strcpy(HC[n], cd);
	}
	else {
		cd[codeLen++] = '0';
		TraverseHuffman (T, HC, T.ht[n].lchild);
		codeLen--;
		cd[codeLen++]  =  '1';
		TraverseHuffman (T, HC, T.ht[n].rchild);
		codeLen--;
	}
}
typedef struct {
    unsigned int weight;
    unsigned int parent, lchild, rchild;
} HTNode, *HuffmanTree;
typedef char  ** HuffmanCode;
void HuffmanCoding(HuffmanTree &HT, HuffmanCode &HC,
                                 int *w, int n) {
    if (n<=1) return;
    m=2*n-1;
    HT= (HuffmanTree) malloc ((m+1)*sizeof(HTNode));
    for (p=HT, i=1; i<=n; ++i, ++p, ++w) *p={*w, 0, 0, 0};
    for (; i<=m; ++i, ++p) *p={0,0,0,0};
    for (i=n+1; i<=m; ++i) {
        Select (HT, i-1, s1, s2);
        HT[s1].parent=i;  HT[s2].parent=i;
        HT[i].lchild=s1;  HT[i].rchild=s2;
        HT[i].weight=HT[s1].weight+HT[s2].weight;
    }
HC=(HuffmanCode) malloc ((n+1)*siezof(char *));
    cd=(char *) malloc (n*sizeof(char));
    cd[n-1]=��\0��;
    for (i=1; i<=n; ++i) {
        start = n-1;
        for ( c=i, f=HT[i].parent; f!=0; c=f, f=HT[f].parent)
            if (HT[f].lchild == c) cd[--start]=��0��;
            else cd[--start]=��1��;
        HC[i]=(char *) malloc ((n-start)*sizeof(char));
        strcpt (HC[i], &cd[start]);
    }
    free (cd);
}
