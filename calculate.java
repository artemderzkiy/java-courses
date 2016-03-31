public class calculate {

	public static void main(String[] arg){

	System.out.println("Calculate..");
double chis1 = Double.valueOf(arg[0]);
double chis2 = Double.valueOf(arg[1]);
double sum = chis1+chis2;
double min = chis1-chis2;
double mul = chis1*chis2;
double div = chis1/chis2;


System.out.println("sum="+sum);
System.out.println("min="+min);
System.out.println("mul="+mul);
System.out.println("div="+div);

}


}