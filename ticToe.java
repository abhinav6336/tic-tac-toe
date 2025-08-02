import java.util.*;
class ticToe{
    static int chance=1;
	static int comrow,comcol;
	static int game =0;
	static int arr[][]=new int[4][4];
	public static void who_one(){
        int flag=0,co=0,p=0;int k=0;
        for(int i=1;i<=3;i++){
            for(int c=1;c<=3;c++){
                if(arr[i][c]==1)
                    flag++;
                if(arr[c][i]==1)
                    co++;
                if(arr[i][c]==2)
                    k++;    
                if(arr[c][i]==2)
                    p++;}
        if(flag==3 || co==3){
            display();
            System.out.println("You win !");
            System.exit(0);}
        if(k==3 || p==3){
            display();
            System.out.println("Computer wins !");
            System.exit(0);}
            co=0;
            p=0;
            flag=0;
            k=0;}}
            static boolean place_col(int n){
                for(int i=1;i<=3;i++){
                    if(arr[i][n]!=1 && arr[i][n]!=2){
                        chance++;
                        arr[i][n]=2;
                        return  true;}}return  false;}
            static boolean place_row(int n){
                for(int i=1;i<=3;i++){
                    if(arr[n][i]!=1 && arr[n][i]!=2){
                        chance++;
                        arr[n][i]=2;
                        return true;}}return false;}
    public static void tactics(){
        int k=0,cb=0;int c=1,i=1,cop=0,op=0;boolean flag;
        for( i=1;i<=3;i++){
            for(c=1;c<=3;c++){
                if(arr[i][c]==1){k++;}
                if(arr[i][c]==2){cop++;}
                if(arr[c][i]==1){cb++;}
                if(arr[c][i]==2){op++;}}
            if(k==2){flag=place_row(i);
                if(flag==true)return ;}
            if(cb==2){flag=place_col(i);
                if(flag==true)return ;}
            if(cop==2){flag=place_row(i);
                if(flag==true)return ;}
            if(op==2){flag=place_col(i);
            if(flag==true)return ;}k=0;cb=0;}is_Safe();}
    static void tactic2(){
    int flag=0,co=0,p=0,r=0,num,num1,c=3,i=1;int cop=0,op=0,bit=0,bit_not=0;
    for(i=1,c=3;c>=1;c--,i++){
    num = arr[i][c]
    num1= arr[i][i];
    if(num==1){flag++;}
    if(num==2){bit++;}
    if(num1==2){bit_not++;}
    if(num1==1){co++;}
    if(num!=1 && num!=2){p=i;r=c;}
    if(num1!=1 && num1!=2){cop=i;op=c;}
    //if(bit==2 || bit_not==2 ){break;}
    }if(bit==2 && p!=0 && r!=0){arr[p][r]=2;chance++;display();System.out.println("Computer wins ");System.exit(0);}
    if(bit_not==2 && cop!=0 && op!=0){arr[cop][op]=2;chance++;display();System.out.println("Computer wins");System.exit(0);}
    if(flag==2 && arr[p][r]!=1 && arr[p][r]!=2 && p!=0 && r!=0){arr[p][r]=2;chance++;return;}
    if(co==2 && arr[cop][op]!=1 && arr[cop][op]!=2 && cop!=0 && op!=0){arr[cop][op]=2;chance++;return ;}
    if(flag==3 || co==3){display();System.out.println("You win !");System.exit(0);}
    if(bit==3 || bit_not==3){display();System.out.println("Computer wins ");System.exit(0);}
    tactics();}
	public static void is_Safe(){
	    boolean flag=true;
		for(int row=1;row<=3;row++){
			for(int col=1;col<=3;col++){
				if(arr[row][col]!=1 && arr[row][col]!=2){
                 arr[row][col]=2;
                 chance++;
                 flag=false;
                 break;}}
			if(flag==false)
			break;}}
	static void display(){
        System.out.println("      col=1  col=2   col=3 ");
		for(int row=1;row<=3;row++){
            System.out.print("row= "+row+" ");
			for(int col=1;col<=3;col++){
				System.out.print(" "+arr[row][col]+"      ");}
			System.out.println();}}
	public static void main(String [] args){
	    int i=1;
		Scanner sc = new Scanner(System.in);
        System.out.println("This is TicTacToe game where you are displayed as 1 and computer is displayed as 2\n the game is in array format\n so you have to write row number and column number of the array to  fill the array\n format : ");
        display();
        System.out.println("type any key to start the game or press (^c) to exit the game ");
        sc.next();   
		while(chance<=9){
			System.out.print("Enter row number : ");
			int row=sc.nextInt();
			System.out.print("Enter column number : ");
			int col=sc.nextInt();
                        if(arr[row][col]!=1 && arr[row][col]!=2){arr[row][col]=1;}
                        else{System.out.println("PLease don't try to exploit the code !");continue;}
			chance++;
                        who_one();
                        tactic2();
                        who_one();
                        display();
	        i++;}sc.close();System.out.println("TIE !");}}
