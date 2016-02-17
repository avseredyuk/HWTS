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
    public static void main(String[] args) {
        // TODO code application logic here
        MyTreeSet my = new MyTreeSet();
        my.add(5);
        my.add(7);
        my.add(4);
        my.add(6);
        my.add(2);
        System.out.println(my.contains(4));
        my.remove(4);
        System.out.println(my.contains(4));
    }
    
}
