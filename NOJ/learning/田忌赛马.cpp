#include <iostream>
#include <vector>
using namespace std;

void change(int &a, int &b)
{
 int temp;
 temp = a;
 a = b;
 b = temp;
}
void quickSort(int* a, int l, int u)
{
 int i, m;
 if (l >= u) return;
 m = l;
 for (i = l + 1; i <= u; i++)
  if (a[i] > a[l])
   change(a[++m], a[i]);
 change(a[l], a[m]);
 quickSort(a, l, m - 1);
 quickSort(a, m + 1, u);
}
int main()
{
 vector<int> result;
 vector<int> ra;
 vector<int> rb;
 int num;
 int* a;
 int* b;
 while (cin>>num)
 {
  if (num == 0)
   break;
  a = new int[num];
  b = new int[num];
  for (int i = 0; i < num; i++)
   cin>>a[i];
  for (int i = 0; i < num; i++)
   cin>>b[i];
  quickSort(a, 0, num-1);
  quickSort(b, 0, num-1);
  int win = 0;
  int fail = 0;
  int draw = 0;
  int ib = 0, jb = 0;
  int ie = num - 1, je = num - 1;
  while (ib <= ie)
  {
   if (a[ie] > b[je])
   {
    win++;
    ie--;
    je--;
   }else if (a[ie] < b[je])
   {
    fail++;
    ie--;
    jb++;
   }else
   {
    if (a[ib] > b[jb])
    {
     win++;
     ib++;
     jb++;
    }else
    {
     if (a[ie] < b[jb])
      fail++;
     ie--;
     jb++;
    }
   }
  }
  result.push_back(1*(win - fail));

 }
 for (size_t i = 0; i != result.size(); i++)
 {
  cout<<result[i]<<endl;
 }
 return 0;
}
