#include <stdio.h>
#include <stdlib.h>
typedef struct MNode{
     int row;
     int col;
     struct MNode * next;
 } Node,* PNode;
 PNode head = NULL,tail = NULL;
 int dir[4][2] = {{-1,0},{0,1},{1,0},{0,-1}};
 int maxRow ,maxCol ;
 int i,j,inrow ,incol ,outrow ,outcol ;
 int **mmap;
 void removeItem(){
     PNode tmp = head;
     head = head->next;
     free(tmp);
 }
 int haveItem(){
     if(head==NULL) return 0;
     return 1;
 }
void addItem(int row,int col){
     PNode newPoint = (PNode)malloc(sizeof(Node));
     newPoint->row = row;
     newPoint->col = col;
     newPoint->next = NULL;
     tail->next = newPoint;
     tail = newPoint;
 }
int isCan(int row,int col)
{
     if(row<0||col<0||row>=maxRow||col>=maxCol) return 0;
     if(mmap[row][col]!=0) return 0;
     return 1;
 }

 int main()
 {
     scanf("%d%d%d%d%d%d",&maxRow,&maxCol,&inrow,&incol,&outrow,&outcol);
     mmap = (int **)malloc(sizeof(int*)*maxRow);
     for(i = 0;i<maxRow;i++){
         mmap[i] = (int*)malloc(sizeof(int)*maxCol);
     }

     for(i = 0;i<maxRow;i++)
         for(j = 0;j<maxCol;j++){
             scanf("%d",&mmap[i][j]);
         }

     head = (PNode)malloc(sizeof(Node));
     head->row = inrow;
     head->col = incol;
     head->next = NULL;
     tail = head;
     for(;haveItem();){
         if(head->row==outrow&&head->col == outcol){
             printf("Yes\n");
             for(;haveItem();){
                 removeItem();//free more
             }
             return 0;
         }
         for(i = 0;i<4;i++){
             if(isCan(head->row+dir[i][0],head->col+dir[i][1])){
                 addItem(head->row+dir[i][0],head->col+dir[i][1]);
             }
         }
         mmap[head->row][head->col] = 2;
         removeItem();
     }
     printf("No\n");
     return 0;
 }
