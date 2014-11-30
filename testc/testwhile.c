#include <stdio.h>
#include <stdlib.h>
void main()
{
	int x, y;
    y = 1;
    while(y <= 9) {
		
        x = 1;
        while (x <= y) {
			
            printf("%d*%d=%d\t", x, y, x * y);
            x++;
        }
        
        printf("\n");
        y++;
    }
	system("pause");
}
