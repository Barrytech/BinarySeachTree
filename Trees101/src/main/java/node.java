/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author barry
 */
public class node {
    //this node is for a binary tree
    public int iData;      //data used as the key val
    public double dData;    //otheer data
    public node leftChild;
    public node rightChild;
    
    public void displayNode(){
        System.out.print('{');
        System.out.print(iData);
        System.out.print(", ");
        System.out.print(dData);
        System.out.print('}');
    }
}
