#include<stdio.h>
#include<iostream>
using namespace std;

int main(){
	int x;
	cout<< "Enter a two digit number to reverse it\n";
	cin>>x;
	while(x>=10&&x<=99){
		cout <<""<<x%10<<""<<x/10<<"\n";
		cout<< "Enter a two digit number to reverse it\n";
		cin>>x;
	}
	
return 0;}
