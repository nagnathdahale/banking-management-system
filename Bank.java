import java.io.*;
class Bank
{
int[][] det=new int[100][4];                          // Initializing 2D array
float[] bal=new float[100];
String[] name=new String[100];
int count=0;
void intialize(int t,float b,String d)
{
det[count][0]=count+1;                                //entering values into counter                                                                    
det[count][1]=t;
bal[count]=b;
name[count]=d;
System.out.println("Account No is: "+count+1);
count++;
}
boolean deposit(float amt1,int accno)
{
for(int i=0;i<count;i++)
{
        
if(accno==det[i][0])
{
bal[i]=bal[i]+amt1;
return true;
}
}
return false;
}
boolean withdraw(int accno,float amt1)
{
for(int i=0;i<count;i++)
{
if(accno==det[i][0])
{
bal[i]=bal[i]-amt1;
return true;
}
}
return false;
}
float search(int accno)
{
for(int i=0;i<count;i++)
{
if(accno==det[i][0])
{
return bal[i];
}
}
return -1;
}
boolean search(int accno,int a)
{
for(int i=0;i<count;i++)
{
if(accno==det[i][0])
{
System.out.println("Name: " +name[i]);
System.out.println("Current Balance: " +bal[i]);
return true;
}
}
return false;
}


public static void main(String[] args) throws Exception
{
Bank obj=new Bank();
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));    //Input Reader Stream to read efficient input charectors
System.out.print("Enter the Operation to be Performed\n1.New Account\n2.Deposit Money\n3.Withdraw Money\n4.Search\n5.Exit\n");
int choice;
choice=Integer.parseInt(br.readLine());
do
{
switch(choice)
{

                // Account Management Section


case 1:
System.out.println("Enter Name: ");
String str=br.readLine();

System.out.println("1 savings ");
System.out.println("2 deposit ");
System.out.println("3 demat ");

System.out.println("Enter Account Type: ");
int type=Integer.parseInt(br.readLine());


System.out.println("Enter Starting Deposit: ");
float amt=Float.parseFloat(br.readLine());
obj.intialize(type,amt,str);
break;

                        //Deposit Management
case 2:
System.out.println("Enter Account No ");
int accno=Integer.parseInt(br.readLine());
System.out.println("Enter Amount");
float am1=Float.parseFloat(br.readLine());
boolean state=obj.deposit(am1,accno);
if(state==true)
System.out.println("Deposit Successful");
else
System.out.println("Invalid Details");
break;

                                            //Withdrawl management 

case 3:
System.out.println("Enter Account No ");
int accn=Integer.parseInt(br.readLine());
System.out.println("The Available Balance is: "+obj.search(accn));
System.out.println("Enter the amount for Withrawl");
float amt2=Float.parseFloat(br.readLine());
if(amt2<=obj.search(accn))
{
state=obj.withdraw(accn,amt2);
if(state==true)
System.out.println("WithDrawl Successful");
else
System.out.println("Invalid Details");
}
else
System.out.println("Invalid Amount");
break;

                                        //Searching Module
case 4:
System.out.println("Enter Account No ");
accn=Integer.parseInt(br.readLine());
state=obj.search(accn,1);
if(state==false)
System.out.println("Invalid Details");
break;
}
System.out.print("Enter the Operation to be Performed\n1.New Account\n2.Deposit Money\n3.Withdraw Money\n4.Search\n5.Exit\n");
choice=Integer.parseInt(br.readLine());
}while(choice!=5);
for(int i=0;i<obj.count;i++)
{
System.out.print("Acc No. "+obj.det[i][0]+"\n"+"Type: "+obj.det[i][1]+"\n"+"Balance Available: "+obj.bal[i]+"\n"+"Name: "+obj.name[i]+"\n");
}
}
}

