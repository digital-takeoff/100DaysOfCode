int binarySearch(Vector<int> v,int s,int i, int e){
	int m =(i+e)/2;
	if(i==e|| e==m || i==m){
		return -1;
	}else if(v[m]==s){
		return m;
	}else if(v[m]>s){
		return binarySearch(v,s,i,m);
	}else {
		return binarySearch(v,s,m,e);
	}
}
int binarySearch(Vector<int> v, int s){
	if(v[0]==s){
		return 0;
	}else{
		return binarySearch(v,s,0,v.size());
	}
}