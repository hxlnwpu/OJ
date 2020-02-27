#include<stdio.h>
#include<math.h>
int n,t,d,num[30];
void hjz(int m){
int i=0,j,x=0,a[30];
while(m!=0){
  a[i]=m%2;
  m=m/2;
  i++;
}
d=i;
for(j=0;j<d;j++){
    num[i-1]=a[j];
    i--;
}
}
int check(){
int i,j,k,q;
k=0;
q=0;
for(i=0;i<d;i++){
  k=num[i]+q*10;
  q=k%n;
}
if(q==0)
    return 1;
else
    return 0;
}
void search(int m){
int i;
hjz(m);
if(check()==1){
   for(i=0;i<d;i++)
    printf("%d",num[i]);
}
else
    search(m+1);

}
int main()
{
    scanf("%d",&n);
    while(n!=0){
    search(1);
    printf("\n");
    scanf("%d",&n);
    }
    return 0;
}
