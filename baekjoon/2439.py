'''
    *
   **
  ***
 ****
*****
'''

import sys
n = int(input())
str = [' ']*n
for i in range(n-1,-1,-1):
    #print(i)
    str[i] = '*'
    for x in str:
        sys.stdout.write(x)
        #print(x)
    print('')


'''
for i in range(1,a+1) :
	print(' '*(a-i) + '*'*i)
'''

'''
for r in range(1, n+1):
    print(' '*(n-r),'*'*r, sep="")
'''
