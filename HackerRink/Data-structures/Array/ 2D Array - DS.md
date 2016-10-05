```C++
int main(){
    int temp=0;
    
    vector< vector<int> > arr(6,vector<int>(6));
    for(int arr_i = 0;arr_i < 6;arr_i++){
       for(int arr_j = 0;arr_j < 6;arr_j++){
          cin >> arr[arr_i][arr_j];
       }
    }
    int max_sum = -100;
    for(int i=0;i<4;i++){
        for(int j=0;j<4;j++){
            temp = 0;
            temp = arr[i][j]+arr[i][j+1]+arr[i][j+2];
            temp += arr[i+1][j+1];
            temp += arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
            max_sum = max(max_sum,temp);
        }
    }
    cout << max_sum;
    return 0;
}
```
