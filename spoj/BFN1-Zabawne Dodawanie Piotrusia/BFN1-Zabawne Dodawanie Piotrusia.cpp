#include <iostream>
using namespace std;

int main()
{

	int n, liczba, odwrocona, licznik, pomocnicza, reszta, j = 0;
	cin >> n;
	while (j < n)
	{
		cin >> liczba;
		licznik = 0;
		while (true)
		{
			pomocnicza = liczba;
			odwrocona = 0;
			while (pomocnicza != 0)
			{
				reszta = pomocnicza % 10;
				odwrocona = odwrocona * 10 + reszta;
				pomocnicza /= 10;

			}
			if (liczba == odwrocona)
			{
				cout << odwrocona << " " << licznik << endl;
				break;
			}
			else
			{
				liczba += odwrocona;
				licznik++;
			}
		}
		j++;
	}

}

