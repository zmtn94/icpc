#include<iostream>

using namespace std;

int C, n;
int *card;
int **cost;

int CalCost(int firstIndex, int lastIndex) {
	int &ref = cost[firstIndex][lastIndex];
	
	if (firstIndex == lastIndex) {
		ref = card[firstIndex] * -1;
		return card[firstIndex];
	}
	else if (lastIndex < firstIndex) 
		return 0;
		
		
	if (ref == 1001) {
		int buffer; 

		for (int i = 0; i < 4; i++) {
			switch (i) {
			case 0:
				buffer = CalCost(firstIndex + 1, lastIndex);
				ref = buffer = card[firstIndex] - buffer;
				break;
			case 1:
				buffer = CalCost(firstIndex, lastIndex - 1);
				buffer = card[lastIndex] - buffer;
				break;
			case 2:
				buffer = CalCost(firstIndex + 2, lastIndex) * -1;
				break;
			case 3:
				buffer = CalCost(firstIndex, lastIndex - 2) * -1;
				break;
			}

			if (buffer > ref)
				ref = buffer;
		}
	}

	return ref;
}

int main() {
	cin >> C;

	for(int i = 0; i < C; i++) {
		int result;
		cin >> n;

		card = new int[n];
		cost = new int*[n];

		for (int j = 0; j < n; j++) {
			cin >> card[j];

			cost[j] = new int[n];
			
			for (int k = 0; k < n; k++) {
				cost[j][k] = 1001;
			}
		}

		result = CalCost(0, n - 1);
		
		cout << result << endl;

		delete[] cost;
		delete[] card;
	}
}