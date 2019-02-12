//leetcode runtime:16ms
int myAtoi(char* str){
	int res=0,flag=1;
	char *p=str;
	while(*p==' ' || *p=='\t' || *p=='\n') p++;
	if(*p<'0' && *p>'9') return res;
	char *s;
	if(*p=='-' || *p=='+'){
		flag=(*p=='+')?1:-1;
		p++;
	}
	s=p;
	while(*s>='0' && *s<='9'){
		if(res>INT_MAX/10 || (res==INT_MAX/10 && (*s-'0')>7)){
			return (flag==1)?INT_MAX:INT_MIN;
		}
		res=res*10+(*s++ -'0');
	}
	return res*flag;
}
