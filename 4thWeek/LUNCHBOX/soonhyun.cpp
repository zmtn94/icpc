#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
typedef long long ll;
 

class lunch {
public:
	int m, e; 
	lunch() {}
	bool operator < (const lunch & other) {
		return e > other.e;
	}
}L[10001];
int main() {
	int t; cin >> t;
	while (t--) {
		int n; cin >> n;
		int ans = 0;
		int tmp = 0;
		for (int i = 0; i < n; i++) {
			cin >> L[i].m;
		}
		for (int i = 0; i < n; i++) {
			cin >> L[i].e;
		}
		sort(L, L + n);  
    
		int s[10001] = { 0, };
		for (int i = 0; i < n; i++) {
			for (int j = i; j >= 0; j--) {
				s[i] += L[j].m; 
			}
		}
    
		for (int i = 0; i < n; i++) {
			tmp = max(tmp, s[i] + L[i].e);
			ans += L[i].m;
		}
    
		if (ans + L[n-1].e < tmp) 
			cout << tmp << "\n";
		else 
			cout << ans + L[n - 1].e << "\n";
		
	}
}
