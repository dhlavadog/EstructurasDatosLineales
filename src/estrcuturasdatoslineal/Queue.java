/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrcuturasdatoslineal;

/**
 *
 * @author PC
 */
public class Queue //Cola
{
    Node head;
    int q;
    int[] consultas;
    
    public Queue()
    {
        this.head = null;
        this.q = 0;
        this.consultas = null;
    }
    
    public boolean isEmpty()
    {
        return head == null ? true : false;
    }
    
    public void Enqueue(Node newNode)
    {
        if(isEmpty()) this.head = newNode;
        else
        {
            Node temp = head;
            
            while(temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
        
    }
    
    public int Dequeue()
    {
        Node temp = this.head;
        int data = this.head.value;
        this.head = this.head.next;
        temp = null;
        System.gc();
        return data;
    }
    
    
}
