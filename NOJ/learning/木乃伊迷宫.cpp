#include <iostream>
#include <math.h>
#include <queue>
int ma[6][6],rr=3,rc=1,mr=3,mc=3,cr=5,cc=5,s=0,f=0,num[6][6][6][6],b[4][2]={
0,1,
0,-1,
1,0,
-1,0
};
using namespace std;
struct mu{
int rrow;
int rcol;
int mrow;
int mcol;
};
int isGo(mu m,int i){
if(i==0){
if(ma[m.rrow][m.rcol]==2)
    return 0;
}
if(i==2){
if(ma[m.rrow][m.rcol]==1){
    return 0;
}
}
return 1;
}
mu go(mu m,int i){
m.rrow+=b[i][0];
m.rcol+=b[i][1];
return m;
}
mu mgo(mu m){
int n=2;
while(n!=0){
    n--;
    if(m.rcol>m.mcol){
        if(ma[m.mrow][m.mcol]!=2)
            m.mcol++;
    }
    else{
       if(m.rcol<m.mcol){
            m.mcol--;
    }
    else {
        if(m.rcol==m.mcol){
            if(m.mrow<m.rrow)
            { if(ma[m.mrow][m.mcol]!=1)
              m.mrow++;
            }
            else{
                if(m.mrow>m.rrow){
                        m.mrow--;
                }
                else{
                    if(m.mrow==m.rrow)
                        s=1;
                }
            }
        }
    }
    }
}
return m;
}
int isAim(mu m){
if(m.rrow==cr && m.rcol==cc)
    return 1;
else
    return 0;
}
int iskeyi(mu m){
if(m.rrow<6 && m.rrow>=0 && m.rcol<6 && m.rcol>=0)
    return 1;
else
    return 0;
}
int isSafe(mu m){
if(m.mcol==m.rcol && m.mrow==m.rrow)
    return 0;
else
    return 1;

}
int isNew(mu m){
if(num[m.rrow][m.rcol][m.mrow][m.mcol]==1)
    return 0;
else
    return 1;
}
void fd(){
mu fir,m,newm;
queue<mu> que;
int i;
fir.rcol=rc;
fir.rrow=rr;
fir.mrow=mr;
fir.mcol=mc;
que.push(fir);
while(!que.empty()){
    m=que.front();
    que.pop();
    for(i=0;i<4;i++){
        if(isGo(m,i)==0)
            continue;
        newm=go(m,i);
        if(isAim(newm)==1){
            f=1;
            return;
        }
        if(iskeyi(newm)==1){
          newm=mgo(newm);
          if(isSafe(newm)==1){
          if(isNew(newm)==1){
          num[newm.rrow][newm.rcol][newm.mrow][newm.mcol]=1;
          que.push(newm);
          }
          }
        }
    }
}
}
int main()
{
    int i,n,a,b,c;
    cin>>n;
    for(i=0;i<n;i++){
        cin>>a>>b>>c;
        if(c==0)
            ma[a][b]=2;
        else
            ma[a][b]=1;
   }
      cin>>mr>>mc;
      cin>>rr>>rc;
      cin>>cr>>cc;
   fd();
   if(rr==cr && rc==cc)
    f=1;
   if(mr==rr && mc==rc)
    f=0;
if(f==1)
    cout<<"Yes"<<endl;
else
    cout<<"No"<<endl;
  return 0;

}
