#include<queue>
#include<iostream>
#define N 12
using namespace std;

char map[N][N];
int mark[N][N];
int startX,startY,endX,endY;

int isCanMove(int x, int y, int& newX, int& newY, int direction) {
 int tempX = x;
 int tempY = y;
 switch(direction) {

  case 0:
   tempX--;break;
  case 1:
   tempX++;break;
  case 2:
   tempY--;break;
  case 3:
   tempY++;break;
 }

 newX = tempX;
 newY = tempY;
 if(tempX < 0 || tempX >= N || tempY < 0 || tempY >= N) {

  return 0;
 }
 if(map[tempX][tempY] == '.') {

  return 1;
 }
 return 0;
}
int isUesed(int x, int y) {
 if(mark[x][y] == 0) {

  return 0;
 }
 return 1;
}
int isAim(int x, int y) {
 if( x == (endX-1) && y == (endY-1)) {
  return 1;
 }
 return 0;
}
int search(char map[N][N], int start_node) {
 int x;
 int y;
 int newX;
 int newY;
 int num = 0;
 queue<int> not_yet_explored;
 not_yet_explored.push(start_node);
 mark[startX - 1][startY - 1] = 1;
 while(!not_yet_explored.empty()) {

  int node_to_explored = not_yet_explored.front();
  not_yet_explored.pop();

  x = node_to_explored / N;
  y = node_to_explored % N;
  num = mark[x][y];

  for(int i = 0;i < 4;i++) {

   if(isCanMove(x, y, newX, newY, i)) {

    if(isAim(newX, newY)) {

     return num;
    }

    if(!isUesed(newX, newY)) {

     mark[newX][newY] = num + 1;
     not_yet_explored.push(newX*N + newY);
    }
   }
  }
 }
}
int main() {

 cin >> startX >> startY >> endX >> endY;
 for(int i = 0;i < N;i++) {

  for(int j = 0;j < N;j++) {

   cin >> map[i][j];
  }
 }

 for(int row = 0;row < N;row++) {

  for(int col = 0;col < N;col++) {

   if(map[row][col] == '.') {

    mark[row][col] = 0;
   } else {

    mark[row][col] = -2;
   }
  }
 }
 cout << search(map, (startX-1)*N + startY-1) << endl;

 return 0;
}
