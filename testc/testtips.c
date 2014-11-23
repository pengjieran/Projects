#include <stdio.h>
#include <stdlib.h>
int main()
{
	printf("请输入第一个数：");
    int a = 0;
	scanf("%d", &a);
    
    printf("请输入第一个数：");
    int b = 0;
    scanf("%d", &b);
    if (a > b) {
    
			printf("第一个数大于第二个数");
        }
        else {
			
			printf("第一个数小于第二个数");
        }
      
	system("pause");
	return 0;
}
