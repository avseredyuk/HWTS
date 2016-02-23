/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwts;

/**
 *
 * @author lenfer
 */
public class MyTreeSet {
    
    Node root;
    int size;
    
    private class Node{
        int value;
        Node left;
        Node right;
        Node parent;
    }
    
    private void recursiveRemove(Node localRoot, int value){
        if (value > localRoot.value) {
            
            if(localRoot.right != null){
                recursiveRemove(localRoot.right, value);
            } else {
                return;
            }
            
        } else if (value < localRoot.value) {
            
            if(localRoot.left != null){
                recursiveRemove(localRoot.left, value);
            } else {
                return;
            }
            
        } else {
            if ( (localRoot.left == null) & (localRoot.right == null) ){
                
                // no childrens
                
                if(localRoot.parent.left == localRoot){
                    localRoot.parent.left = null;
                } else  {
                    localRoot.parent.right = null;
                }
                
            } else if( (localRoot.left == null) | (localRoot.right == null) ){
                
                // only one children
                
                if(localRoot.left == null){
                    
                    if (localRoot.parent.left == localRoot) {
                        localRoot.parent.left = localRoot.right;
                        localRoot.left.parent = localRoot.parent;
                                
                    } else {
                        localRoot.parent.right = localRoot.right;
                        localRoot.right.parent = localRoot.parent;
                    }
                    
                } else {
                    
                    if (localRoot.parent.left == localRoot) {
                        localRoot.parent.left = localRoot.left;
                        localRoot.left.parent = localRoot.parent;
                        
                    } else {
                        localRoot.parent.right = localRoot.left;
                        localRoot.left.parent = localRoot.parent;
                        
                    }
                } 
            } else {
                // both childrens are present
                // look for right->left
                Node lookForLeft = localRoot.right;
                if(lookForLeft.left != null){
                    //right->!null
                    do {
                        lookForLeft = lookForLeft.left;
                    } while (lookForLeft.left != null);
                    // replcae int with what we've found
                    localRoot.value = lookForLeft.value;
                    // kill obj thaat we've found
                    lookForLeft.parent.left = null;
                } else {
                    // looking for 15
                    Node tmpNode = localRoot.left;
                    localRoot.parent.right = lookForLeft;
                    lookForLeft.left = tmpNode;
                }
            }
        }
    }
    
    public void remove(int value){
        if(size == 0){
            return;
        } else {
            recursiveRemove(root, value);
        }
    }
    
    private boolean recursiveFind(Node localRoot, int value){
        if (value > localRoot.value) {
            if (localRoot.right != null) {
                return recursiveFind(localRoot.right, value);
            } else {
                return false;
            }
        } else if (value < localRoot.value) {
            if (localRoot.left != null) {
                return recursiveFind(localRoot.left, value);
            } else {
                return false;
            }
        }
        return true;
    }
    
    public boolean contains(int value){
        if(size == 0){
            return false;
        } else {
            return recursiveFind(root, value);
        }
    }
    
    private void recursiveAdd(Node localRoot, int value){
        if (value > localRoot.value) {
            if(localRoot.right != null){
                recursiveAdd(localRoot.right, value);
            } else {
                localRoot.right = new Node();
                localRoot.right.parent = localRoot;
                localRoot.right.value = value;
                size++;
            }
        } else if (value < localRoot.value) {
            if(localRoot.left != null){
                recursiveAdd(localRoot.left, value);
            } else {
                localRoot.left = new Node();
                localRoot.left.parent = localRoot;
                localRoot.left.value = value;
                size++;
            }
        }
    }
    
    public void add(int value){
        if(size == 0){
            root = new Node();
            root.value = value;
            size++;
        } else {
            recursiveAdd(root, value);
        }
    }
}
