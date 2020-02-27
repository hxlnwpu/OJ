#include <stdio.h>
 #include <stdlib.h>

 int change(int **arr,int row,int n){
     int i,j;
     if(n==1){
         return 0;
     }
     change(arr,row,n/2);
     change(arr,row+n/2,n/2);
     //·½¸ñ×ª»»
     for(i = 0;i<n/2;i++){
         for(j = 0;j<n/2;j++){
             arr[row+i][n/2+j] = arr[row+n/2+i][j];
             arr[row+n/2+i][n/2+j] = arr[row+i][j];
         }
     }
     return 0;
 }

 int main()
 {
     int i,j,input,n = 1,**arr;
     scanf("%d",&input);
     for(i = 0;i<input;i++){
         n *= 2;
     }
     arr = (int**)malloc(sizeof(int*)*n);
     for(i = 0;i<n;i++){
         arr[i] = (int*)malloc(sizeof(int)*n);
         arr[i][0] = i+1;
     }

     change(arr,0,n);
     for(i = 0;i<n;i++){
         for(j = 0;j<n;j++){
             if(j==n-1) printf("%d\n",arr[i][j]);
             else printf("%d ",arr[i][j]);
         }
     }
     return 0;
 }
