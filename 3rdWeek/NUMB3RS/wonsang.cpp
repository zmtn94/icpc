#include<iostream>
#include<vector>

using namespace std;

int c, n, d, p, t;
vector<vector<int>> map;
float *percentage;

void Trace(int index, int day, float prob) {
	if (day == 0) {
		float &ref = percentage[index];

		if (ref == 0.0f) { 
			ref = prob;
		}
		else {
			ref += prob;
		}
		return;
	}

	for (int i = 0; i < map[index].size(); i++) {
		Trace(map[index][i], day - 1, prob * (1.0f /  map[index].size()));
	}
}

int main() {
	cin >> c;

	for (int i = 0; i < c; i++) {
		int isConnect, index;		
		cin >> n >> d >> p;

		percentage = new float[n];
		
		for (int j = 0; j < n; j++) {			
			percentage[j] = 0.0f;
			vector<int> buffer;
	
			for (int k = 0; k < n; k++) {
				cin >> isConnect;

				if (isConnect) {
					buffer.push_back(k);
				}
			}
			map.push_back(buffer);
		}

		Trace(p, d, 1.0f);
	
		cin >> t;

		for (int j = 0; j < t; j++) {
			cin >> index;
			cout << percentage[index] << " ";
		}
		cout << endl;

		map.clear();
		delete[] percentage;
	}
}