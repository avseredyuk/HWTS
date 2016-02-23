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
public class HWTS {

    /**
     * @param args the command line arguments
     */
    
//    equals & hashcode for key   IN GET()
//    
//    HashMap <K, V>
//            Entry buckets[];
//            v get(k key);
//            put(k key, v value)
//            remove(k key)
//            realloc();
//            
//    MapEntry{
//                k key;
//                v value;
//                Entry next;
//                int hash;
//            }
            
    
    public static void main(String[] args) {
        // TODO code application logic here
        MyTreeSet my = new MyTreeSet();
        my.add(5);
        my.add(7);
        my.add(4);
        my.add(6);
        my.add(2);
        my.add(0);
        my.add(1);
        my.add(3);
        my.add(10);
        my.add(9);
        my.add(8);
        my.add(15);
        my.add(12);
        my.add(11);
        my.add(100);
        my.add(200);
        my.add(150);
        my.add(500);
        System.out.println(my.contains(7));
        my.remove(5);
        System.out.println(my.contains(100));
        
    }
    
}
