import java.util.Scanner;
import java.math.BigInteger;

public class DiffieHellman {

    static BigInteger power(BigInteger base, int exp) 
    { 
        BigInteger temp; 
        if(exp == 0) {
        return new BigInteger("1"); 
        }
        temp = power(base, exp/2);     

        if (exp%2 == 0) return temp.multiply(temp);
        else{ 
            if (exp > 0) return base.multiply(temp.multiply(temp)); 
            else return (temp.multiply(temp)).divide(base);
        } 
    }


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Calcular o Bruteforce (calculate|bruteforce): ");
            String argument = sc.nextLine();

                 if (argument.equals("calculate")){
                    System.out.println("Valor de n: ");
                    String valorN = sc.nextLine();
                    System.out.println("Valor de p: ");
                    String valorP = sc.nextLine();
                    System.out.println("Valor de a: ");
                    int valorA = sc.nextInt();

                    BigInteger n = new BigInteger(valorN);
                    BigInteger p = new BigInteger(valorP);
                    int a = valorA;
                    BigInteger resultado = new BigInteger((power(n, a).remainder(p)).toString());
                    
                    System.out.println(resultado);
                }
                else if (argument.equals("bruteforce")){
                    System.out.println("Valor de n: ");
                    String valorN = sc.nextLine();
                    System.out.println("Valor de p: ");
                    String valorP = sc.nextLine();
                    System.out.println("Valor de z1: ");
                    String valorZ1 = sc.nextLine();
                    System.out.println("Valor de z2: ");
                    String valorZ2 = sc.nextLine();

                    BigInteger n = new BigInteger(valorN);
                    BigInteger p = new BigInteger(valorP);
                    BigInteger zOne = new BigInteger(valorZ1);
                    BigInteger zTwo = new BigInteger(valorZ2);
                    
                    int x = 1;
                    int y = 1;
    
                    
                    boolean found = false;
                    System.out.println("Buscando el valor de X...");
                    while(!found){
                        long StartTime = System.nanoTime();
                        BigInteger posibleSol = power(n, x).remainder(p);
                        if(posibleSol.compareTo(zOne) == 0){
                            long FinishTime = System.nanoTime() - StartTime;                            
                            System.out.println("X= "+x+ "\nEncontrado en "+FinishTime/100000 +" seg");
                            found = true;
                        }
                        x++;
                    }
                    found = false;
                    System.out.println("Buscando el valor de Y...");
                    while(!found){
                        long StartTime = System.nanoTime();
                        BigInteger posibleSol = power(n, y).remainder(p);
                        if(posibleSol.compareTo(zTwo) == 0){
                            long FinishTime = System.nanoTime() - StartTime;                            
                            System.out.println("Y= "+y+ "\nEncontrado en "+FinishTime/100000+" seg");
                            found = true;
                        }
                        y++;
                    }
                    System.out.println("z = z2^x mod p = "+(power(zTwo, x-1).remainder(p)).toString());
                    System.out.println("z = z1^y mod p = "+(power(zOne, y-1).remainder(p)).toString());
                    
                    //System.out.println("z = n^(x*y) mod p = "+(power(n, (x-1)*(y-1)).remainder(p)).toString());
                    //To much
            }
            else{
                System.out.println("Error");
            }
            




        }
}
