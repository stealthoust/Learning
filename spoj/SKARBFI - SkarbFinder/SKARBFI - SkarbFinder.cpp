#include <iostream>
#include <string>

using namespace std;
string kierunek(int a, int b)
{
	string p = "", d = "";
	if (a == 0 && b == 0) return p = "studnia";
	if (a > 0)  p = "0 " + to_string(a);
	else if (a < 0)  p = "1 " + to_string(-a);
	if (b > 0) d = "\n2 " + to_string(b);
	else if (b < 0) d = "\n3 " + to_string(-b);
	return (p + d);

}
int main()
{
	int n, a, b, l = 0, w, x = 0, y = 0;
	/* n - liczba testow
	a - pierwsza liczba (0 - północ 1 - południe 2 - zachód 3 - wschód)
	b - druga liczba, liczba krokow w danym kierunku
	w - liczba instrukcji uzytkownika
	l - licznik pomocniczy
	x- wspolrzedna x
	y- wspolrzedna y
	*/

	cin >> n;
	while (n)
	{
		cin >> w;
		while (l < w)
		{
			cin >> a >> b;
			switch (a)
			{
			case 0:
				x += b;
				break;
			case 1:
				x -= b;
				break;
			case 2:
				y += b;
				break;
			case 3:
				y -= b;
				break;
			default:
				break;

			}
			l++;
		}
		cout << kierunek(x, y) << endl;
		l = 0;
		x = 0; y = 0;
		n--;
	}
}