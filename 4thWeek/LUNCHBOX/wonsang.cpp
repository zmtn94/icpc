#include<iostream>
#include<algorithm>

using namespace std;

int C, n;

class Lunch {
public:
	int cookTime;
	int eatTime;
	
	static bool compare(const Lunch &a, const Lunch &b) {
		return a.eatTime > b.eatTime;
	}
};

int main() {
	Lunch *set = new Lunch[n];
	int result, curEat;
	
	cin >> C;

	for(int i = 0; i < C; i++) {
		cin >> n;
		for (int j = 0; j < n; j++) {
			cin >> set[j].cookTime;
		}

		for (int j = 0; j < n; j++) {
			cin >> set[j].eatTime;
		}

		sort(set, set + n, Lunch::compare);

		result = set[0].cookTime;
		curEat = set[0].eatTime;

		for (int j = 1; j < n; j++) {
			result += set[j].cookTime;
			curEat -= set[j].cookTime;

			if (set[j].eatTime > curEat)
				curEat = set[j].eatTime;
		}

		result += curEat;

		cout << result << endl;
	}
}