#include <iostream>

using namespace std;

int binary_search(int a[], int n, int i)
{
    int mid, left, right;
    left = 0;
    right = n - 1;
    while (left <= right)
    {
        mid=left+(right-left)/2;
        if (i == a[mid])
        {
            cout << "Yes" << endl;
            return 0;
        }
        else if (i < a[mid])
        {
            right = mid-1;
        }
        else if (i > a[mid])
        {
            left = mid+1;
        }
    }
    cout << "No" << endl;
    return 0;
}
int main()
{
    int n, m, a[10000], b[50000];
    cin >> n;
    for (int i = 0; i < n; i++)
        cin >> a[i];
    cin >> m;
    for (int i = 0; i < m; i++)
        cin >> b[i];
    for (int i = 0; i < m; i++)
        binary_search(a, n, b[i]);
    return 0;
}