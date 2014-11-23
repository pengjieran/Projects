#include <stdio.h>
#include <stdlib.h>
int main()
{
	//float和double的精度问题
    float a = 3.1415926535897932626;
    double b = 3.1415926535897932626;
    printf("folat类型的值：%.15f\n", a);//.15表示保留后15位，但是在表示小数时，double要更加精确
    printf("double类型的值：%.15lf\n", b);
	system("pause");
	return 0;
}
