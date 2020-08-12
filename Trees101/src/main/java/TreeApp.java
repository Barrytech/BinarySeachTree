
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author barry
 */
public class TreeApp {
    public static void main( String args[]) throws IOException{
        int value;
        Tree theTree = new Tree();
        
        //TODO: promp user to enter or add random values;
        
        theTree.insert(50, 1.5);
        theTree.insert(25, 1.2);
        theTree.insert(75, 1.7);
        theTree.insert(12, 1.5);
        theTree.insert(37, 1.2);
        theTree.insert(43, 1.7);
        theTree.insert(30, 1.5);
        theTree.insert(33, 1.2);
        theTree.insert(87, 1.7);
        theTree.insert(93, 1.5);
        theTree.insert(97, 1.5);
        
        while( true ){
            putText( "Enter first letter of: ");
            putText( "show, insert, find, delete, or traverse: ");
            int choice = getChar();
            
            switch(choice){
                case 's':
                    theTree.displayTree();
                    break;
                case 'i':
                    putText("Enter value to insert: ");
                    value = getInt();
                    theTree.insert(value, value + 0.9);
                    break;
                case 'f':
                    putText("Enter value to find: ");
                    value = getInt();
                    node found = theTree.find(value);
                    if( found != null){
                        putText("Found: ");
                        found.displayNode();
                        putText("/n");
                    }else{
                        putText("Couldn't find " + value + '\n');
                    }
                    break;
                case 'd':
                    putText("Enter value to delete: ");
                    value = getInt();
                    boolean didDelete = theTree.delete(value);
                    
                    if( didDelete){
                        putText("Deleted " + value + '\n');
                    }else{
                        putText("Could not delet " + value + '\n');
                    }
                    break;
                case 't':
                    putText("Enter type 1, 2, or 3: ");
                    value = getInt();
                    theTree.traverse(value);
                    break;
                default:
                    putText("Invalid entry\n");
            }       //closes switch
        }           //closes while
    }               //closes main 
        public static void putText( String s){
            System.out.print(s);
            System.out.flush();
        }
        
        public static String getString() throws IOException{
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String s = br.readLine();
            return s;
        }
        
        
        public static char getChar() throws IOException{
            String s = getString();
            return s.charAt(0);
        }
        
        public static int getInt() throws IOException{
            String s = getString();
            return Integer.parseInt(s);
        }
        
        
    
}
