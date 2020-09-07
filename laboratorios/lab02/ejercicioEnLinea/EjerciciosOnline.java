
public class EjerciciosOnline
{
    //Array2
public int countEvens(int[] nums) { 
int cont=0; 
for(int i=0;i<nums.length;i++){ 
if(nums[i]%2==0){ 
cont++; 
} 
} 
return cont; 
} 

public int bigDiff(int[] nums) { 
  int minimo = nums[0]; 
  int maximo = nums[0]; 
  for (int i = 0; i < nums.length; i++){ 
    minimo = Math.min(minimo,nums[i]); 
    maximo = Math.max(maximo,nums[i]); 
  } 
  return maximo-minimo; 
} 

public int sum13(int[] nums) { 
int sum = 0; 
for (int i=0; i<nums.length; i++) { 
if (nums[i]==13) i++; 
else sum+=nums[i]; 
} 
return sum; 
} 

public boolean isEverywhere(int[] nums, int val) { 
for(int i=0;i<nums.length-1;i++){ 
if(nums[i]!=val && nums[i+1]!=val) 
return false; 
} 
return true; 
} 

public boolean only14(int[] nums) { 
for (int i=0; i<nums.length; i++) { 
if(nums[i] != 1 && nums[i] != 4) { 
return false; 
} 
} 
return true; 
} 
//Array3

public int maxSpan(int[] nums) {
  int span = 0;
  int x = 0;
  for (int i = 0; i<nums.length;i++){
    for (int j= 0; j<nums.length; j++){
      if (nums[i] == nums[j]){
      x = j-i+1;
      span = Math.max(x,span);
      }
    }
  }  
  return span;
}

public int[] seriesUp(int n) {
  int[] array = new int[n*(n+1)/2];
  int limite = 1;
  for (int i = 0; i<n ; i++){
    for (int j = 0; j<=i; j++){
      array[i*(i+1)/2+j] = j+1;
    }
  }
  return array;
}

public int countClumps(int[] nums) {
  int cont = 0;
for(int i = 0; i<nums.length-1; i++){
if(nums[i] == nums[i+1]){
if(i==0||nums[i-1]!=nums[i]){
cont++;
}
}
}
return cont;
}

public boolean canBalance(int[] nums) {
  int der = 0;
  int izq = 0;
  for (int i = 0; i<nums.length;i++){
    der = der+nums[i];
  }
  for (int i = 0; i < nums.length;i++){
    izq = izq+nums[i];
    der = der-nums[i];
    if (der == izq){
      return true;
    }
  }
  return false;
}

public int[] squareUp(int n) {
  int array[] = new int [n*n];
  for (int i = 1; i<=n; i++){
    for (int j = 1; j<=i; j++){
      array[i*n-j]= j;
    }
  }
  return array;
}

}
