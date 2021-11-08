#include <iostream>
#include <cstring> 
using namespace std;  

string merge(string arg1, string arg2)
{
	int dlugosc, j = 0, i = 0;
	string wynik;
	if (arg1.length() <= arg2.length())
	{
		dlugosc = arg1.length()*2;
	}
	else
	{
		dlugosc = arg2.length()*2;
	} 
	while (i + j < dlugosc) 
	{
		if (i == j)
		{
			wynik += arg1[i];
			i++; 
		}
		else
		{
			wynik += arg2[j];
			j++;
		}   
	}
	return wynik;
}
int main()
{   
	string n1, n2;
	int n;

	cin >> n;
	while (n)
	{
		cin >> n1 >> n2;
		cout << endl << merge(n1, n2);
		n--;
	}
	
	
return 0; 
} 