

import java.util.Scanner;
class PrimeNumberGenerator{
public static void nestedFor(int low, int high) {	
	int f;
	for (int i=low;i <= high;i++)
    {
        f=0;
        for(int j=1;j<=i;j++)
        {
            if(i%j==0)
                f++;
        }
        if(f==2) {
          System.out.print(i+" ");  ;
        }
    }
	
}
/*We check whether or not the number has a factor within the range [2, number/2].
 * */
public static void innerLoopTillnbyTwoElement(int low, int high) {
	while(low < high) {
		boolean flag = false;
		for(int i = 2 ; i<=low/2;i++){
		if(low % i == 0){
		flag = true;
		break;
		}
		}
		if(flag == false && low != 0 && low != 1){
		System.out.print(" "+low);
		}
		low++;
		}
	}
//A number n is not a prime, if it can be factored into two factors a & b:
// n = a * b

/*Now a and b can't be both greater than the square root of n, since
  then the product a * b would be greater than sqrt(n) * sqrt(n) = n.
  So in any factorization of n, at least one of the factors must be
  smaller than the square root of n, and if we can't find any factors
  less than or equal to the square root, n must be a prime.
 */
public static void squareRootInner(int low, int high) {
	while (low < high) { //it will execute the code until the low is not less than high
		boolean flag = false;
		int sqrt = (int) Math.sqrt(low) + 1; //finding the square root using Math method and adding 1 to the value 
		for (int i = 2; i < sqrt; i++) {  // loop will run till the value is less than square root  and check if low is divisble by i and remainder is 0.
			if (low % i == 0) { //if true flag will set to true and then it is not a prime number
				flag = true;
				
			}
		}

		if (flag == false && low != 0 && low != 1) { // if flag is false and low is not 1 and 0 since both are not prime the below code will get executed 
			System.out.print(" " + low); // it will just print all the prime numbers 
		}
		low++; //low will be incremented since we want to end the while loop 
	}


}	


public static void main(String[] args){
int lowerBound = 0, upperBound = 0;
String method;
Scanner input = new Scanner(System.in);
while(true){
System.out.print("Enter the lowerBound value: ");
lowerBound = input.nextInt();
System.out.print("Enter the upperBound value: ");
upperBound = input.nextInt();
if(upperBound != 0 && upperBound > lowerBound &&  lowerBound > 0){
break;
}else{
System.out.println("Please enter again");
}
}
System.out.println("Select one of the generation method");
System.out.println("\"squareRootInner\",\"innerLoopTillnbyTwoElement\",\"nestedFor\"");
method = input.next();
switch(method) {

case "nestedFor":
System.out.print("Prime Numbers are: ");
nestedFor(lowerBound,upperBound);
break;
case "innerLoopTillnbyTwoElement":
System.out.print("Prime Numbers are: ");	
innerLoopTillnbyTwoElement(lowerBound,upperBound);
break;
case "squareRootInner":
System.out.print("Prime Numbers are: ");
squareRootInner(lowerBound,upperBound);
break;
default:
System.out.print("Unknown Method");
break;
}



}}