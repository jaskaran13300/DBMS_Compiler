package merapackage;
public class setCreateCommand{
    public static String set(String command){
        int f=0;
        StringBuilder sb=new StringBuilder(command);
        if((sb.indexOf("("))!=-1){
            f=1;
            sb.insert(sb.indexOf("(")," ");
            sb.insert(sb.indexOf("(")+1," ");
        }
        if ((sb.indexOf(")")) != -1) {
            sb.insert(sb.indexOf(")"), " ");
            sb.insert(sb.indexOf(")") + 1, " ");
        }
        if ((sb.indexOf(";")) != -1) {
            sb.insert(sb.indexOf(";"), " ");
            sb.insert(sb.indexOf(";") + 1, " ");
        }
        String neww=new String(sb.toString());
        neww=neww.replaceAll(",", " , ");
            return neww;
        }
        
}