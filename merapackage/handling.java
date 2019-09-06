package merapackage;
import java.io.*;
import java.util.Date;
public class handling{
    public static int countComma(String command){
        int c=0;
        for(int i=4;i<command.length()-2;i++){
            if(command.charAt(i)==','){
                c++;
            }
        }
        return c;
    }
    public static void setFileName(String command,String name,int i,int j) throws IOException{

        File path = new File("./tables", name + ".db");
        if (path.exists()) {
            System.out.println("ORA-00955: name is already used by an existing object");
            System.exit(0);
        }
        FileWriter fw = new FileWriter("./tables/" + name + ".db");
        try {
            // Open given file in append mode.
            // if (fw.exists()) {
            //     System.out.println("Table already Exist.");
            //     System.exit(0);
            // }
            String str="./tables/"+name+".db";
            BufferedWriter out = new BufferedWriter(new FileWriter(str));
            String col=new String(command.substring(i+2,j));
            out.write(col);
            out.write("* All Columns are Separated By comma - \n");
            int c=countComma(command);
            // c++;
            out.write("/"+c+"!\n");
            out.close();
        } catch (IOException e) {

        }
    }
    public static void insertValues(int c,int a,int b,String Words[],String command) throws IOException{
        // BufferedWriter out1 = new BufferedWriter(new FileWriter(str, true));
        // out1.write("knlnnjjjjj");
        // out1.close();
        int i; 
        char ch;
        FileReader fr=null; 
        try
        { 
            fr = new FileReader("./tables/"+Words[2]+".db"); 
        } 
        catch (Exception E) 
        { 
            System.out.println("File not found"); 
        } 
        i=fr.read();
        ch=(char)i;
        while (i!=-1){
            if(ch=='/'){
                i=fr.read();
                ch=(char)i;
                break;
            }
            i=fr.read();
            ch=(char)i;
            // System.out.print((char)ch); 
        }
        if((c+48)<ch){
            System.out.println("ORA-00947: not enough values");  
            System.exit(0);          
        }
        else if((c+48)>ch){
            System.out.println("ORA-00913: too many values");
            System.exit(0);
        }
        fr.close();
        String strr="";
        int k=0;
        // strr=command.substring(a,b);
        for(int l=a;l<b;l++){
            if(command.charAt(l)!=','){
                strr+=command.charAt(l);
                if(command.charAt(l+1)==' '){
                    strr+="|";
                }
            }
            
        }
        String str = "./tables/" + Words[2] + ".db";
        BufferedWriter out = new BufferedWriter(new FileWriter(str,true));
        out.write(":\n");
        out.write(strr);
        out.close();
    }
}