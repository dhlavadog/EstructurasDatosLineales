/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrcuturasdatoslineal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;


/**
 *
 * @author PC
 */
public class EstrcuturasDatosLineal 
{

    /**
     * @param args the command line arguments
     */
      
   public static void main(String[] args) 
   {
       //Listas 
    
       List lista1 = new List();
       
       lista1.printList();
       lista1.insertAtBegin(new Node(3));
       lista1.printList();
       System.out.println("\n");
       lista1.insertAtBegin(new Node(15));
       lista1.printList();
       System.out.println("\n");
       lista1.insertAtIndex(new Node(5),2);
       lista1.printList();
       System.out.println("\n");
       lista1.insertAtEnd(new Node(13));
       lista1.printList();
       System.out.println("\n");
       lista1.deleteAtIndex(2);
       lista1.printList();
       
     /*  BufferedReader br = new BufferedReader( new InputStreamReader(System.in)); 
       List Unsorted = new List();
       Random rd = new Random();
       for(int i = 0 ; i < 1000 ; i++) Unsorted.insertAtBegin(new Node(rd.nextInt(100)));
       Unsorted.printList();
       System.out.print("fin lista en desorten \n Inici lista ordenda");
       Unsorted = Unsorted.QuickSort();
       Unsorted.printList();*/
   }
    
}
