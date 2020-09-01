public class Power {
    private static int pow(int x,int y){
        // Assuming the power function fits in integer range -2147483648 to 2147483647
        // This is brute force apprach take O(N)
        if(y==0)
            return 1;
        return x*findPow(x, y-1);
    }
    private static int opti_pow(int x,int y){
        // This function takes log(n) steps to execute the power function
        if(y==0)
            return 1;
        int pow = opti_pow(x, y/2);
        if((y & 1)==1)
            return x*pow*pow;
        else
            return pow*pow;
    }
    static int findPow(int x,int y){
        // return pow(x,y);
        return opti_pow(x, y);
    }
    
    public static void main(String[] args) {
        int constant = 2;
        int power = 10;
        System.out.println(constant+" raised to the power of "+power+" is: "+findPow(constant,power));
    }
}