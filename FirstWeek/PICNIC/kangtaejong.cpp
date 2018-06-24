#include <iostream>
#include <vector>
using namespace std;

void func(int index, int &n, int &m, int &ans, bool isVisited[], vector<int> info[]){
    if(index == n){
        for(int i = 0;i < n;i++){
            if(isVisited[i] == false){
                return;
            }
        }

        ans = ans + 1;
        return;
    }

    if(isVisited[index] == true){
        func(index + 1, n, m, ans, isVisited, info);
    }
    else{
        for(int i = 0;i < info[index].size();i++){
            if(isVisited[info[index][i]] == false){
                isVisited[index] = true;
                isVisited[info[index][i]] = true;
                func(index + 1, n, m, ans, isVisited, info);
                isVisited[index] = false;
                isVisited[info[index][i]] = false;
            }
        }
    }
}

int main(){
    ios::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);

    int t;

    cin >> t;
    while(t--){
        int n, m, ans = 0;
        bool isVisited[10] = {false};
        vector<int> info[10];

        cin >> n >> m;
        for(int i = 0;i < m;i++){
            int a, b;

            cin >> a >> b;
            info[a].push_back(b);
            info[b].push_back(a);
        }

        func(0, n, m, ans, isVisited, info);
        cout << ans << "\n";
    }
}

