
#include <iostream>
using namespace std;
int main()
{
	int i = 0;
	int j = 1;
	int n ;
	int a, b;
	cin >> n;
	while (i < n)
	{
		cin >> a >> b;
		j = 1;
		if (a >= b)
		{
			while (j <= b)
			{
				if ((j * a) % b == 0)
				{
					cout << j * a<<endl;
					break;
				}
				else j++;
			}
		}
		else
			while (j <= a)
			{
				if ((j * b) % a == 0)
				{
					cout << j * b<<endl;
					break;
				}
				else j++;
			}
		
		i++;
	}
	

}

