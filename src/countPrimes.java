
public class countPrimes {
	public int countPrimes(int n) {
	   int count = 0;
	   for (int i = 1; i < n; i++) {
	      if (isPrime(i)) count++;
	   }
	   return count;
	}

	private boolean isPrime(int num) {
	   if (num <= 1) return false;
	   // Loop's ending condition is i * i <= num instead of i <= sqrt(num)
	   // to avoid repeatedly calling an expensive function sqrt().
	   for (int i = 2; i * i <= num; i++) {
	      if (num % i == 0) return false;
	   }
	   return true;
	}
	
	public int countPrimes1(int n){
		boolean [] isPrime = new boolean[n];
		for(int i=2; i<n; i++)
		{
			isPrime[i] = true;
		}
		
		for(int i=2; i*i<n; i++){
			if(!isPrime[i]) continue;
			for(int j=i*i; j<n; j+=i){
				isPrime[j] = false;
			}
		}
		
		int count = 0;
		for(int i=2; i<n; i++){
			if(isPrime(i)) count++;
		}
		return count;
	}
}
