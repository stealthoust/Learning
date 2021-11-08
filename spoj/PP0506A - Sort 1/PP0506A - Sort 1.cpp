
#include <iostream>
#include<algorithm>
#include <cmath>
using namespace std;

class Punkt
{
public:
	string nazwa;
	int x;
	int y;
	float wynik;

};
bool operator<(Punkt const& a, Punkt const& b)
{
	return a.wynik < b.wynik;
}

int main()
{
	int n, lp, l = 0;
	cin >> n;
	while (n)
	{
		cin >> lp;
		Punkt* tablica = new Punkt[lp];
		while (l < lp)
		{
			cin >> tablica[l].nazwa;
			cin >> tablica[l].x;
			cin >> tablica[l].y;
			tablica[l].wynik = sqrt(pow(tablica[l].x * 1.0, 2) + pow(tablica[l].y * 1.0, 2));
			l++;
		}

		sort(tablica, tablica + lp);
		l = 0;
		while (l < lp)
		{
			cout << tablica[l].nazwa << " " << tablica[l].x << " " << tablica[l].y << endl;
			l++;
		}
		cout << endl;
		l = 0;
		delete[] tablica;
		n--;
	}

	return 0;
}
