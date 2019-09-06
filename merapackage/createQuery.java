package merapackage;
import java.io.*;
public class createQuery{
    static int splchr(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0) {
                c = str.charAt(i);
                if (c == '_') {
                    System.out.println("ORA-00904: : invalid identifier");
                    System.exit(0);
                }
            }

            if (!(Character.isLetterOrDigit(c)) && c != '_') {
                System.out.println("ORA-00904: : invalid identifier");
                System.exit(0);
            }
        }
        return 0;
    }

    static int splchr1(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0) {
                c = str.charAt(i);
                if (c == '_') {
                    System.out.println("ORA-00936: missing expression");
                    System.exit(0);
                }
            }

            if (!(Character.isLetterOrDigit(c)) && c != '_') {
                System.out.println("ORA-00936: missing expression");
                System.exit(0);
            }
        }
        return 0;
    }

    public static void checkCreate(String Words[]) throws IOException{
                int f=0;
                if(!Words[1].equals("table")){
                System.out.println("ORA-00901: invalid CREATE command");
                    System.exit(0);
                }
                splchr(Words[2]);
                if(Words[2].equals("table") || Words[2].equals("create")){
                    System.out.println("ORA-00903: invalid table name");
                    System.exit(0);
                }
                if(!Words[3].equals("(") ){
                 System.out.println("ORA-00922: missing or invalid option");
                 System.exit(0);
                }
                if(Words[Words.length-1].equals(";")){
                    f=1;
                    if(!Words[Words.length-2].equals(")")){
                        System.out.println("ORA-00907: missing right parenthesis");
                        System.exit(0);
                    }
                    splchr(Words[Words.length-3]);
                }
                if(f==0){
                    if(!Words[Words.length-1].equals(")")){
                        System.out.println("ORA-00907: missing right parenthesis");    
                        System.exit(0);              
                    }
                    splchr(Words[Words.length-2]);
                }
                if(f==1){
                for(int i=4;i<Words.length-2;i++){
                    if(i%2!=0){
                        if(!Words[i].equals(",")){
                            System.out.println("ORA-17006: : invalid column name");
                            System.exit(0);
                        }
                    }
                    else {
                        splchr(Words[i]);
                    }
                }
            }
            if (f == 0) {
            for (int i = 4; i < Words.length - 1; i++) {
                if (i % 2 != 0) {
                    if (!Words[i].equals(",")) {
                        System.out.println("ORA-17006: : invalid column name");
                        System.exit(0);
                    }
                }
                else{
                    splchr(Words[i]);
                }

            }
        }
        }
        //  throws IOException
        public static void checkInsert (String Words[],String command) throws IOException{
            int f=0;
            if( Words.length==1 || !Words[1].equals("into")){
                System.out.println("ORA-00925: missing INTO keyword");
                System.exit(0);
            }
            if(Words.length==2){
                System.out.println("ORA-00903: invalid table name");
                System.exit(0);
            }
            File path = new File("./tables", Words[2] + ".db");
            if (!path.exists()) {
                System.out.println("ORA-00942: table or view does not exist");
                System.exit(0);
            }
            if(Words.length==3){
                System.out.println("ORA-00926: missing VALUES keyword");
                System.exit(0);
            }
            if(!Words[3].equals("values")){
                System.out.println("ORA-00926: missing VALUES keyword");
                System.exit(0);
            }
            if(Words.length==4){
                System.out.println("ORA-00936: missing expression");
                System.exit(0);
            }
            if(!Words[4].equals("(")){
                System.out.println("ORA-00922: missing or invalid option");
                System.exit(0);
            }

            if (Words[Words.length - 1].equals(";")) {
            f = 1;
            if (!Words[Words.length - 2].equals(")")) {
                System.out.println("ORA-00907: missing right parenthesis");
                System.exit(0);
            }
            splchr1(Words[Words.length - 3]);
        }
        if (f == 0) {
            if (!Words[Words.length - 1].equals(")")) {
                System.out.println("ORA-00907: missing right parenthesis");
            }
            splchr1(Words[Words.length - 2]);
        }
        if (f == 1) {
            for (int i = 5; i < Words.length - 2; i++) {
                if (i % 2 == 0) {
                    if (!Words[i].equals(",")) {
                        System.out.println("ORA-00917: missing comma");
                        System.exit(0);
                    }
                } else {
                    splchr1(Words[i]);
                }
            }
        }
        if (f == 0) {
            for (int i = 5; i < Words.length - 1; i++) {
                if (i % 2 == 0) {
                    if (!Words[i].equals(",")) {
                        System.out.println("ORA-00917: missing comma");
                        System.exit(0);
                    }
                } else {
                    splchr1(Words[i]);
                }

            }
        }
        handling hand=new handling();
        int c=hand.countComma(command);
        // int a=0,b=0;
        // for(int i=4;i<Words.length-1;i++){
        //     char ch=command.charAt(i);
        //     if(ch=='('){
        //         a=i;
        //     }
        //     else if(ch==')'){
        //         b=i;
        //     }
        // }
        hand.insertValues(c,command.indexOf("(")+2,command.indexOf(")"),Words,command);
        }
}