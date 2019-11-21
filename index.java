import java.util.*;
import merapackage.*;
class query_processing{
    static ArrayList<String> FirstWord=null;
    static void checkQuery(String Words[],String command){
        createQuery createObject=new createQuery();
        handling hand=new handling();
        if(FirstWord.contains(Words[0])){
                if(Words[0].equals("create")){
                    try{
                        createObject.checkCreate(Words);
                        hand.setFileName(command,Words[2],command.indexOf("("),command.indexOf(")"));
                        System.out.println("jaskaran > SQL: Table Created.");
                    }
                    catch(Exception e){
                        System.out.println("ORA-00901: invalid CREATE command");
                        System.exit(0);
                    }
                }
                if(Words[0].equals("insert")){
                    try{
                        createObject.checkInsert(Words,command);
                        System.out.println("jaskaran > SQL: 1 row inserted");
                    }
                    catch (Exception e1) {
                        System.out.println("Invalid Insert ");
                        System.exit(0);
                    }
                }
        }
        else{
            System.out.println("ORA-00900: Invalid SQl Statement");
            System.exit(0);
        }
    }
    public static void main(String args[]){
        FirstWord = new ArrayList<String>();
        FirstWord.add("insert");
        FirstWord.add("select");
        FirstWord.add("update");
        FirstWord.add("delete");
        FirstWord.add("create");
        FirstWord.add("EXIT");
        while(true){
            System.out.print("jaskaran > SQL: ");
            Scanner sc=new Scanner(System.in);
            String command=sc.nextLine();
            command=command.trim().replaceAll("\\s+"," ");
            setCreateCommand setObject=new setCreateCommand();
            command=setObject.set(command);//space inserted 
            command=command.trim().replaceAll("\\s+"," ");//convert extra spaces to a single space
            if(command.equals("EXIT")){
                System.exit(0);
            }
            command=command.toLowerCase();
            String []words=command.split(" ");//firstly convert command in lower case then split it into words
            checkQuery(words,command);
        }
    }
}
