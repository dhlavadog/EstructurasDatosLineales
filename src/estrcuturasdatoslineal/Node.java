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
public class Node 
{
    String grade;
    int value;
    
    Node next; // Apuntador
    
    // Zero-parmeters constructor
    public Node() {};
    
    public Node(int value)
    {
        this.grade = null;
        this.value = value;
    }
    
    public String toString()
    {
        return "Grade: " + this.grade + "\t" + "Value: " + this.value + "\n";
    }
    
    public Node clone()
    {
        Node temp = new Node(this.value);
        return temp;
    }
    
}
