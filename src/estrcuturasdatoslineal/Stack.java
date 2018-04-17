/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrcuturasdatoslineal;


import java.io.*;

/**
 *
 * @author PC
 */
public class Stack 
{
    Node head;
    
    public Stack()
    {
        this.head = null;
    }
    
    public boolean isEmpty()
    {
        return head == null ? true : false;
    }
    
    public void push(Node newNode)
    {
        newNode.next= this.head;
        this.head = newNode;
    }
    
    public String pop() 
    {
        Node toPop = this.head;
        this.head = this.head.next;
        String data = toPop.toString();
        toPop = null;
        System.gc();
        return data;
    }
    
    public String peek()
    {
        return this.head.toString();
    }
    
    public void printStack() throws IOException
    {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        bw.write("Grades:\n");
        while(!isEmpty()) bw.write(pop());
        bw.flush();;    
    }
    
    
    
}
