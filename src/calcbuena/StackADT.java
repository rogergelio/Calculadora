/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcbuena;

/**
 *
 * @author Alejandro Bermúdez, Rogelio Torres, Dario Sotelo, José Mejias
 */
public interface StackADT<T> {
    
    public void push(T dato);
    public T pop();
    public T peek();
    public boolean isEmpty();
    
}
