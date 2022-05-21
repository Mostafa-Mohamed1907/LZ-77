package assign_1_lz.pkg77;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
//ABAABABAABBBBBBBBBBBBA
/*
    <0,0,”A”>
    <0,0,”B”>
    <2,1,”A”>
    <3,2,”B”>
    <5,3,”B”>
    <2,2,”B”>
    <5,5,”B”>
    <1,1,”A”>
 */
public class Assign_1_LZ77 {

    static String stock;
    static List nextchar_arr = new Vector();
    static ArrayList pointer_arr = new ArrayList();

    public static String Compress(String date) 
    {
        ArrayList len_arr = new ArrayList();

        
        int check = 0;
        for (int i = 0; i < date.length(); i++) 
        {
            stock = date.substring(0, i);
            int x = i + 1;
            do {
                String st = date.substring(i, x);
                check = stock.lastIndexOf(st);
                if (check == -1) 
                {
                    //ababc
                    len_arr.add((int) st.length() - 1);
                    String clean = "";                       // abc (ab -> without c)
                    for (int y = 0; y < st.length() - 1; y++)   // abc (without -> c)
                    {
                        clean += st.charAt(y);			//	abc (ab -> without c)
                    }
                    int last_clean = stock.lastIndexOf(clean);	// ab -> (lastIndexOf)
                    i = stock.length() + (st.length() - 1);
                    if (st.length() == 1) 
                    {
                        pointer_arr.add(0);         // awel mara tzhar
                    } 
                    else 
                    {
                        pointer_arr.add(i - last_clean - clean.length());
                    }
                    // length (stock)	(st--->(without -->c)
                    nextchar_arr.add(st.charAt(st.length() - 1));
                    break;
                } 
                else 
                {
                    x++;
                    if (x > date.length()) 
                    {
                        pointer_arr.add(i - stock.lastIndexOf(st));
                        len_arr.add(st.length());
                        nextchar_arr.add("NULL");
                        i = date.length() - 1;
                        break;
                    }
                }
            } while (check != -1);
        }
        String res = "";
        for (int i = 0; i < pointer_arr.size(); i++) 
        {
            res+="<"+pointer_arr.get(i) + ", "+len_arr.get(i) + ", "+nextchar_arr.get(i)+">\n";
        }
        System.out.print(res);
        return res;
    }

    public static void DeCompress(ArrayList len_arr) {
        String  date = "";
        for (int i = 0; i < pointer_arr.size();i++) 
        {
            int  pointer = (int) pointer_arr.get(i);
            int length = (int) len_arr.get(i);
            String ff =  "";
            ff+=nextchar_arr.get(i);
            if (length == 0) 
            {
                date += ff;
            } 
            else 
            {
                date = date + date.substring(date.length() - pointer, date.length() - pointer + length);
                if(!ff.equals("NULL"))
                       date = date + ff;
            }
        }
        System.out.println("The String line is : " + date);
    }

    
    public static void main(String[] args) {
        /*
           String d = "";
	   System.out.println(d);
	   d+='a';
	   System.out.println(d);
	   d+='a';
	   System.out.println(d);
	   d+='b';
	   System.out.println(d);
	   System.exit(0);
        */
    	
           }
}
