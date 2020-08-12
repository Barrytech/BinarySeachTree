
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author barry
 */
public class Tree {
    private node root;
    
    public Tree(){
        root = null;
    }
    
    //find node using a key
    public node find( int key){
        node current = root;
        while(current.iData != key){
            if( key < current.iData){
                current = current.leftChild;
            }else{
                current = current.rightChild;
            }
            if( current == null){
                return null;
            }
        }
        return current;
    }       //end find method
    
    
    //insert method:
    public void insert( int id, double dd){
        node newNode = new node();
        newNode.iData = id;
        newNode.dData = dd;
        
        if( root == null){
            root = newNode;
        }else{
            node current = root;
            node parent;
            
            while( true){
                parent = current;
                if( id < current.iData){        //if go left
                    current = current.leftChild;
                    if( current == null){
                        parent.leftChild = newNode;
                        return;
                    }
                   //end if go left 
                 }else{     // start go right
                    current = current.rightChild;
                    if( current == null){
                        parent.rightChild = newNode;
                        return;
                    }
                 
                }  // end else go right   
            }       // end while
        }   //end else not root
    } //end insert
    
    
    
    public boolean delete( int key){
        node current = root;
        node parent = root;
        boolean isLeftChild = true;
        
        while( current.iData != key){
            parent = current;
            if( key < current.iData){           //go left
                isLeftChild = true;
                current = current.leftChild;
            }else{                              //go right
                isLeftChild = false;
                current = current.rightChild;
            }
            if( current == null){
                return false;
            }
            
        }   // end while
        // if there is no children then simply delete the tree
        if( current.leftChild == null && current.rightChild == null ){
            if( current == root){
                root = null;
            }else if(isLeftChild){
                parent.leftChild = null;
            }else{
                parent.rightChild = null;
            }
        // if there is no right child, replace with left subtree
        }else if( current.rightChild == null){
            if( current == root){
                root = current.leftChild;
            }else if( isLeftChild){
                parent.leftChild = current.leftChild;
            }else{
                parent.rightChild = current.leftChild;
            }
         /// if there is no left child, replace with right subree       
                
        }else if( current.leftChild == null){
            if( current == root){
                root = current.rightChild;    
            }else if( isLeftChild){
                parent.leftChild = current.rightChild;
            }else{
                parent.rightChild = current.rightChild;
            }
        }else{          // let the node's successor delete current
            node successor = getSuccessor(current);
            //connect parent to successor 
            if( current == root){
                root = successor;
            }else if( isLeftChild){
                parent.leftChild = successor;
            }else{
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
   
            return true;
    }
    
    
    private node getSuccessor( node delNode){
        node successorParent = delNode;
        node successor = delNode;
        node current = delNode.rightChild;
        
        while( current != null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
                  
        }
        if( successor != delNode.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }  
        return successor;
    }
    
    
    
    public void traverse( int traverseType){
        switch( traverseType){
            case 1: 
                System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2:
                System.out.print("\nInorder traversal: ");
                inOrder(root);
                break;
            case 3:
                System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
    }
    
    public void preOrder( node localRoot){
        if( localRoot != null ){
            localRoot.displayNode();
            preOrder( localRoot.leftChild);
            preOrder( localRoot.rightChild);
        }
    }
    
    public void inOrder( node localRoot){
        if( localRoot != null ){
            inOrder( localRoot.leftChild);
            localRoot.displayNode();
            inOrder( localRoot.rightChild);
        }
    }
    
    public void postOrder( node localRoot){
        if( localRoot != null ){
            postOrder( localRoot.leftChild);
            postOrder( localRoot.rightChild);
            localRoot.displayNode();

        }
    }
    
    
    
    public void displayTree(){
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println(
        ".........................................................................");
        
        while( isRowEmpty == false){
            Stack localStack = new Stack();
            isRowEmpty = true;
            
            for( int i = 0; i < nBlanks; i++){
                System.out.print(' ');
            }
            while( globalStack.isEmpty() == false){
                node temp = (node)globalStack.pop();
                if( temp != null){
                    System.out.print(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    
                    if( temp.leftChild != null  || temp.rightChild != null){
                        isRowEmpty = false;
                    }
                }else{
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for( int i = 0; i < nBlanks*2-2; i++){
                    System.out.print(" ");
                }
            }
            System.out.println(
            "....................................................................");
        }
        
    }
    
}
