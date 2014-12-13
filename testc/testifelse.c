#include <stdio.h>
#include <stdlib.h>
int main()
{
	int a, b, c, d;
    printf("请输入第一个数：");
    scanf("%d", &a);
    
    printf("请输入第二个数：");
    scanf("%d", &b);
    
    printf("请输入第三个数：");
    scanf("%d", &c);
    
    if (a > b) {
		
        d = a;
    } else {
		
        d = b;
    }
    if (d < c) {
		
        d = c;
    }
    
    printf("最大的数字是：%d\n", d);
    
	system("pause");
	return 0;
}
