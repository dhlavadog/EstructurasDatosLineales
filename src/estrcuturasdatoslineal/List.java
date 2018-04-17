/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrcuturasdatoslineal;

import java.io.*;
import java.util.Random;
/**
 *
 * @author PC
 */
public class List 
{
    Node head = null;
    
    public boolean isEmpty()
    {
        return head == null ? true : false; //return <condicion> ? <- orden en caso de cumplir la condicion  : <- Equivalente a un Else 
    }
    
    public int size()
    {
        Node temp = this.head;
        int size= 0;
        while(temp != null)
        {
            temp = temp.next;
            size++;
        }
        
        return size;
    }
    
    public void insertAtBegin(Node newNode)
    {
        newNode.next = head; // el nuevo nodo apuntará a la cabeza
        head = newNode;  // ahora el nuevo nodo se asignará como la cabeza
    }

    public void insertAtEnd(Node newNode)
    {
        if(isEmpty()) head = newNode; // si esta vacio el nuevo nodo será la cabeza
        else
        {
            Node temp = head; //nodo temporal con la ubicacion de la cabeza
            while(temp.next != null) temp = temp.next; // mientras que haya algun nodo al siguiente del temporal, mover el temporal
            temp.next = newNode; // el nuevo nodo se ubicará en el siguiente al temporal
        }
    }


    public void deleteAtBegin()
    {
       // Node temp = this.head; // no es necesario, preguntar al profe porque existe.
        this.head = head.next; // la nueva cabeza será la siguiente a la que era.
      //  temp = null; // borrar el temporal // no es necesario.
        System.gc(); // garbage collector; limpia la memoria.
    }

    public void deleteAtEnd()
    {
        Node temp = head; //el nodo temporal tendrá la pocision de la cabeza
        while(temp.next.next != null) temp = temp.next; //mientras haya un nodo al siguiente del temporal, que este tome la pocision del que le sigue
        temp.next = null; //eliminar el nodo siguiente al temporal
        System.gc();
    }

    public void deleteAtEnd2()
    {
        Node temp = head; 
        Node toDelete= head.next; 
        while(toDelete.next != null)  temp = temp.next;
        temp.next= null;
        System.gc();
    }

    public void deleteAtIndex(int index) //el entero a ingresar es la pocision qe se desea borrar
    {
        Node temp = head; // temporal en la misma posicion de la cabeza
        Node toDelete; //segundo nodo tempora, innceseraio a mi concepto
        for(int i = 0 ; i < index -1 ; i++) temp = temp.next; //apuntador en una pocision menos de la igresada para poder eliminarse
        toDelete = temp.next; //toDelete tendrá misma posicion del siguiente nodo a temp
        temp.next = temp.next.next; //temp apuntara al siguiente del que antes apuntaba
        toDelete = null;
        System.gc();
    }

    public void deleteAtIndex2(int index)
    {
        Node temp = head;
        for(int i=0 ; i<index-1 ; i++)  temp= temp.next;
        temp.next = temp.next.next;
        temp = null;
        System.gc();
    }
    
    public boolean insertAtIndex(Node newNode, int location) //(nuevo nodo, ubicacion deseada), en mi opinion este metodo debería ser un void
    {
        Node temp = this.head; //nodo tempral en la pocision de la cabeza
        
        if(location < 0 || location > this.size()) return false; // verifica que ubicacion ingresada este dentro del tamañp del arreglo
        
        if(location == 0) // si la posicion ingresada es cero, el nuevo nodo será la cabeza
        {
            this.insertAtBegin(newNode);
            return true; //irrelevante que devuelva un booleano, yo lo quitaría
        }
        
        if(location == this.size()) // si le ubicacion ingresada es igual al tamaño del arreglo, el nuevo nodo estará al final
        {
            this.insertAtEnd(newNode);
            return true;
        }
      
        for(int i=0 ; i<location-1 ; i++) temp = temp.next; //recorro el arreglo 
        newNode.next = temp.next; // el nuevo nodo apuntara al siguiente de temp
        temp.next = newNode; //temp apuntará al nuevo nodo
        
        return true;
    }
    
    public void inverse() //invertir el orden del arreglo
    {
        Stack pila = new Stack();
        Node temp = this.head; //temp en posicion de la cabeza
        
        while(temp != null) // mientras el haya un nodo al siguiente de temp...
        {
            pila.push(temp.clone()); //clona el nodo temp y lo agrega a la pila
            temp = temp.next; // temp pasa a la siguiente posicion
        }
        
        this.head = pila.head; // pone la pila a la cabeza del arreglo, eliminando el que habia.
    }
    
     public int length()
    {
        int length = 0;
        Node temp = this.head;
        
        while(temp != null)
        {
            length++; // conforme temp va recorriendo el arreglo, el contador (length) va subiendo en uno.
            temp = temp.next;
        }
   
        return length; // devuelve el contador y por lo tanto el tamaño de arreglo 
    }
     
     
    public Node get(int index)
    {
        if(index < this.length())
        {
            Node temp = this.head; // temp queda en la posicion de la cabeza
            for( int i=0 ; i<index ; i++) temp = temp.next; // recorre el arreglo y cuando llega a la posicion que
            return temp;                                    // se ingresó devuelve el nodo.
        }
        else return null;
    }
    
    public Node binarySearch(int value, int dw, int up) //(valor a buscar,limite inferior, limite sueperior
    {
        int midPoint = (dw + up)/2;
        Node temp = this.get(midPoint);
        
        if(dw == up)
        {
            if(temp.value == value) return temp;
            else return null;
        }
        else
        {
            if(value > temp.value) return binarySearch(value, midPoint+1, up);
            else
            {
                if(value < temp.value) return binarySearch(value, dw, midPoint - 1);
                else return temp;
            }
        }
    }
    
    public List QuickSort()
    {
        if(this.length() <= 1) return this;
	else
        {
            Node pivot = this.head;
            List less_sublist = new List();
            List greater_sublist = new List();
			
            Node temp = this.head.next;
            while(temp != null)
            {
                if(temp.value < pivot.value) less_sublist.insertAtEnd(temp.clone());
                else greater_sublist.insertAtEnd(temp.clone());
                temp = temp.next;
            }
            
            less_sublist = less_sublist.QuickSort();
            greater_sublist = greater_sublist.QuickSort();
			
            pivot.next = greater_sublist.head;
            less_sublist.insertAtEnd(pivot);
			
            return less_sublist;
	}
    }

    public void printList()
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Node temp = head;
    
        try
        {
            bw.write("Grades: \n"); // solo para verificar impresion
            while(temp != null)
            {
                bw.write(temp.toString());
                temp = temp.next;
            }
            bw.flush(); // Lo guardado en el buffer se manda a la consola
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
     
    
    }
    
}
