/*
 * main.cpp
 *
 *  Created on: Nov 19, 2018
 *      Author: hxl
 */
/* PTA基础编程题目集：6-7本题要求实现一个函数，判断任一给定整数N是否满足条件：它是完全平方数，又至少有两位数字相同，如144、676等。*/

#include <stdio.h>
#include <math.h>

int IsTheNumber(const int N);

int main() {
	int n1, n2, i, cnt;
	scanf("%d %d", &n1, &n2);
	cnt = 0;
	for (i = n1; i <= n2; i++) {
		if (IsTheNumber(i))
			cnt++;
	}
	printf("cnt = %d\n", cnt);

	return 0;
}
/*int IsTheNumber(const int N) {
	if (sqrt(N) == (int) sqrt(N)) {
		int temp[10] = { 0 };
		int count, i = 0, ans = 0, tmp = 0;
		int j=0,k=0;
		int n = (int) N;
		while (n != 0) {  //统计位数
			// n = n/10
			n /= 10;
			++count;
		}
		if (count == 1)
			return 0;
		n = (int) N;
		for (i = 0; i < count; i++) {  //获取每一位数字
			tmp = n % 10;
			temp[i] = tmp;
			n = n / 10;
		}
		for (j = 0, k = j + 1; k < count; j++, k++) { //比较是否有相同数字
			if (temp[j] == temp[k]) {
				ans = 1;
				break;
			}
		}
		if (ans)
			return 1;
		else
			return 0;
	} else
		return 0;
}*/
int IsTheNumber ( const int N ){
	int n,m,temp;
	m=N;
	n = (int)sqrt(N);
	if(n*n==m){
		int num[10]= {0};//这里应该定义num的长度为10，因为传入的整数的每位数可能是0~~9，而不是传入数的位数。 
		while(m>0){//遍历N的每一位上的数字，在相应的数组中自加 如果有一个数组元素等于2 说明至少有2个位上的数相同
			temp = m%10;
			for(int i=0 ;i<=9;i++){
				if(temp==i){
					num[i]++;
					if(num[i]==2){
						return 1;
					}
				}

			}
			m/=10;
		}
		return 0;
	}
	return 0;
}


