#include <iostream>
#include <cmath>
using namespace std;
int main()
{
    int n, lg, lc;//lg- liczba graczy, lc-liczba ciastek, lp- liczba pudelek
    float lp = 0;
    int i = 0;
    cin >> n;
    while (n)
    {
        cin >> lg >> lc;
        int* czas = new int[lg];
        while (i < lg)
        {
            cin>>czas[i];
            lp += ceil(86400 / czas[i]);
            i++;
        }
        lp = ceil(lp /lc );
        cout << lp << endl;
        n--;
        lp = 0;
        i = 0;
        delete []czas;
    }
    

}

