#include <stdio.h>
#include <stdlib.h>
#define max(a,b)(a>b?a:b)
int price[20];
int favor[20];
int cache[201];
int n,finance;
int sushi() {
	int i,j,result=0,a;
	cache[0] = 0;
	for (i = 1; i <= finance;i++) {
		a = 0;
		for (j = 0; j < n;j++) {
			if (i >= price[j])
				a = max(a,cache[(i-price[j])%201]+favor[j]);
		}
		cache[i % 201] = a;
		result = max(result,a);
	}
	return result;
}
int main(void) {
	int t,t_case,answer,i;
	freopen("input.txt", "r", stdin);
	scanf("%d",&t_case);
	for (t = 0; t < t_case;t++) {
		scanf("%d %d", &n,&finance);
		finance /= 100;
		for (i = 0; i < n;i++) {
			scanf("%d %d", &price[i], &favor[i]);
			price[i] /= 100;
		}
		answer = sushi();
		printf("%d\n",answer);
	
	}
	return 0;
}
