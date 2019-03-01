package android.example.miniproject1;

import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

//import java.util.Hashtable;
//import java.util.NoSuchElementException;
//import java.util.Scanner;
//import static java.lang.Integer.toBinaryString;
////import static java.jrockit.jfr.events.Bits.doubleValue;
//import java.math.BigInteger;
//import static java.lang.Math.*;
////import static java.jrockit.jfr.events.Bits.longValue;
//
//class fast_power {
//    public int bottom;
//    public int exponent;
//    public long afterModNumber;
//    public long theAnswer;
//    public long[] binaryArray;
//    public String X;
//
//    public void setBottom(int x) {
//        bottom = x;
//    }
//    public void setExponent(int x) {
//        exponent = x;
//    }
//    public void setAfterModNumber(int x) {
//        afterModNumber = x;
//    }
//
//    public long returnAnswer () {
//        return theAnswer;
//    }
//
//    public void convertToBinary () {
//        X = toBinaryString(exponent);
//        long[] newGuess = new long[X.length()];
//        for (int i = 0; i < X.length(); i++)
//        {
//            newGuess[i] = X.charAt(i) - '0';
//        }
//        binaryArray = newGuess;
//        for (int i = 0; i < X.length(); i++)
//        {
//            System.out.print(binaryArray[i]);
//        }
//        System.out.println();
//    }
//    public void dotheCalc() {
//        BigInteger runningTotal = BigInteger.valueOf(1);
//        int[] last = new int[X.length()];
//        for (int i = 0; i < X.length(); i++){
//            if(i < 3){
//                last[i] = (int)Math.round(Math.pow(bottom, Math.pow(2, i)) % afterModNumber);
//                System.out.print(last[i] + " ");
//            }
//            if(i >= 3){
//                last[i] = (int)Math.round(Math.pow(last[i-1], 2) % afterModNumber);
//                System.out.print(last[i] + " ");
//            }
//            if(binaryArray[(X.length() - 1) - i] == 1){
//                runningTotal = runningTotal.multiply(BigInteger.valueOf(last[i]));
//                System.out.print(runningTotal + "     ");
//            }
//        }
//        System.out.print(runningTotal);
//        theAnswer = (runningTotal.mod(BigInteger.valueOf(afterModNumber))).longValue();
//    }
//    public void runFastPower(){
//        Scanner Bottom = new Scanner(System.in);
//        Scanner Exponent = new Scanner(System.in);
//        Scanner NumAfterMod = new Scanner(System.in);
//
//        System.out.println("Enter the bottom:");
//        bottom = Bottom.nextInt();
//        System.out.println("Enter the Exponent:");
//        exponent = Exponent.nextInt();
//        System.out.println("Enter the number after mod:");
//        afterModNumber = NumAfterMod.nextInt();
//
//        convertToBinary();
//        dotheCalc();
//
//        System.out.println("\ncalculations should be done by now!\n");
//
//        System.out.println("Answer: " + theAnswer);
//    }
//}
//
//class longPlugAndChug {
//    //g^b == x mod p
//    public long g;
//    public long b;
//    public long x;
//    public long p;
//
//    public void getB(long X) {
//        b = X;
//    }
//    public void getG(long X) {
//        g = X;
//    }
//    public void getP(long X) {
//        p = X;
//    }
//    public long returnX(){
//        return x;
//    }
//    public void doTheCalc(){
//        int i = 0;
//        boolean match = false;
//        while (i < 1000000 && !match){
//
//            x = g^i;
//            x = x%p;
//
//            if (x == b) match = true;
//            x = i;
//            i++;
//        }
//        if(!match){
//            System.out.println("No Match!!!");
//        }
//        else System.out.println("Match found.");
//    }
//}
//
////class BabyStepGiantStep {
////    //g^b == x mod p
////    public BigInteger g;
////    public BigInteger b;
////    public BigInteger x;
////    public BigInteger p;
////
////    public BigInteger n;
////
////    public void getB(BigInteger X) {
////        b = X;
////    }
////    public void getG(BigInteger X) {
////        g = X;
////    }
////    public void getP(BigInteger X) {
////        p = X;
////    }
////    public BigInteger returnX(){
////        return x;
////    }
////
////    public static BigInteger logBabyStepGiantStep(BigInteger base, BigInteger residue, BigInteger modulus) {
////        //This algorithm solves base^x = residue (mod modulus) for x using baby step giant step
////        BigInteger m = BigInteger.valueOf(longValue(ceil(sqrt(doubleValue(modulus))))); //look at this casting!
////        //Use a hash table to store the entries-use Java Hashtable class
////        Hashtable h = new Hashtable();
////        BigInteger basePow = BigInteger.valueOf(1);
////        //Build the hash table base^j is the key, index j is the value
////        for (BigInteger j = BigInteger.valueOf(0); j.compareTo(m) < 0; j = j.add(BigInteger.valueOf(1))) {
////            h.put(basePow,j);
////            basePow=basePow.multiply(base).mod(modulus);
////        }
////        //Compute an inverse of base^m modulo p
////        BigInteger basetotheminv = base.modPow(m,modulus).modInverse(modulus);
////        BigInteger y = new BigInteger(residue.toByteArray());
////        //Search the hashtable for a base^j such that y=base^j for some j
////        BigInteger target;
////        for (BigInteger i = BigInteger.valueOf(0); i.compareTo(m) < 0; i = i.add(BigInteger.valueOf(1))) {
////            target = (BigInteger)h.get(y);
////            if (target != null) return i.multiply(m).add(target);
////            y = y.multiply(basetotheminv).mod(modulus);
////        }
////        throw new NoSuchElementException("No solution");
////    }
////
////    public void runBabyStepGiantStep(){
////        Scanner G = new Scanner(System.in);
////        Scanner P = new Scanner(System.in);
////        Scanner B = new Scanner(System.in);
////
////        System.out.println("Enter g:");
////        g = BigInteger.valueOf(G.nextInt());
////        System.out.println("Enter p:");
////        p = BigInteger.valueOf(P.nextInt());
////        System.out.println("Enter b:");
////        b = BigInteger.valueOf(B.nextInt());
////
////        x = logBabyStepGiantStep(g, b, p);
////
////        System.out.println("Answer: " + x);
////    }
////}
//
//class Calculator
//{
//    private String Input[] = {"","","","",""};  //fatal error if you don't initialize arrays
//    private long answer = 0;
//    private int currentInput = 0;
//    private int firstNum = 0;
//    private int secondNum = 0;
//    private int thirdNum = 0;
//    public String theOp = "";
//    public boolean makeNegCheck = false;
//
//    //public String ArrayTest() {return Input[onemore];}
//    public void clearInfo()  //function that clears all the arrays and junk
//    {
//        for(int a = 0; a < 20; a++)
//        {
//            Input[a] = "";
//            answer = 0;
//        }
//    }
//    public void addInput(String IN) {
//        Input[currentInput] += IN;
//    }  //add to the current array element
//
//    public void makeNeg() {
//        if(makeNegCheck = false) {
//            Input[currentInput] = "-" + Input[currentInput];
//            makeNegCheck = true;
//        }
//        else {
//            Input[currentInput] = Input[currentInput].replace("-", "");
//            makeNegCheck = false;
//        }
//    }
//
//    public String returnInputString() {return Input[currentInput];}
//
//    public void setCurrentInput(int ci) {currentInput = ci;}
//    public int returnCurrentInput() {return currentInput;}
//
//    public void setOperation (String X){
//        theOp = X;
//    }
//    public String returnOperation (){
//        //System.out.print(theOp);
//        return theOp;
//    }
//    public void setAnswer (int X){
//        answer = X;
//    }
//    public long returnAnswer (){
//        return answer;
//    }
//
//    public void runTheNumbers()  //runs when the user hits enter (PEMDAS sensitive)
//    {
//        longPlugAndChug LongPlugAndChug = new longPlugAndChug();
//        fast_power fastpower = new fast_power();
//        firstNum = Integer.valueOf(Input[0]); //g
//        secondNum = Integer.valueOf(Input[1]); //x or b
//        thirdNum = Integer.valueOf(Input[2]); //p
//        switch (theOp) {
//            case "Fast Power":
//                fastpower.setBottom(firstNum);
//                fastpower.setExponent(secondNum);
//                fastpower.setAfterModNumber(thirdNum);
//                fastpower.dotheCalc();
//                answer = fastpower.returnAnswer();
//
//                break;
//            case "BabyStep GiantStep":
//                LongPlugAndChug.getG(firstNum);
//                LongPlugAndChug.getB(secondNum);
//                LongPlugAndChug.getP(thirdNum);
//                LongPlugAndChug.doTheCalc();
//                answer = (LongPlugAndChug.returnX());
//                break;
//            case "Brute Force":
//                LongPlugAndChug.getG(firstNum);
//                LongPlugAndChug.getB(secondNum);
//                LongPlugAndChug.getP(thirdNum);
//                LongPlugAndChug.doTheCalc();
//                answer = (LongPlugAndChug.returnX());
//                break;
//        }
//    }
//}

public class CalculationActivity extends AppCompatActivity {

    //Calculator calculator = new Calculator();
    boolean cleared = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        Intent intent = getIntent();

        String temp = intent.getStringExtra("Topic");
        //calculator.setOperation(temp);
    }

//    public void setCurrentInput(int X)
//    {
//        calculator.setCurrentInput(X);
//    }
//    public String returnAnswer()
//    {
//        return String.valueOf(calculator.returnAnswer());
//    }
//    public void runtheNumbers() {calculator.runTheNumbers();}
//
//    public void calcClick(View view) {
//        if(cleared)  //resets after the use hits enter, but not before they see their answer
//        {
//            calculator.clearInfo();
//            cleared = false;
//        }
//
//        switch (view.getId()) //all the button values
//        {
//            case R.id.one:
//                calculator.addInput("1");
//                break;
//            case R.id.two:
//                calculator.addInput("2");
//                break;
//            case R.id.three:
//                calculator.addInput("3");
//                break;
//            case R.id.four:
//                calculator.addInput("4");
//                break;
//            case R.id.five:
//                calculator.addInput("5");
//                break;
//            case R.id.six:
//                calculator.addInput("6");
//                break;
//            case R.id.seven:
//                calculator.addInput("7");
//                break;
//            case R.id.eight:
//                calculator.addInput("8");
//                break;
//            case R.id.nine:
//                calculator.addInput("9");
//                break;
//            case R.id.zero:
//                calculator.addInput("0");
//                break;
//            case R.id.neg:
//                calculator.makeNeg();
//                break;
//            case R.id.clear:
//                calculator.clearInfo();
//                break;
//        }
//        FragmentManager fm = getSupportFragmentManager();
//        FastPowerFragment fragment = (FastPowerFragment) fm.findFragmentById(R.id.fast_pow_frag);
//        if(fragment!=null) {
//            fragment.setInput(calculator.returnInputString(), calculator.returnCurrentInput());
//        }
//
//        //if(questionResults){ Toast.makeText(MusicActivity.this, "Correct", Toast.LENGTH_LONG).show();}
//    }

    public void backClick(View view) {
        Intent sendBack = new Intent();
        sendBack.putExtra("Correct", true);

        setResult(RESULT_OK, sendBack);
        finish();
    }
}
