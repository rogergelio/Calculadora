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
public class ArrayStack<T> {
    private T[] datos;
    private int cont;
    private final int DEFAULT_CAPACITY=100;
    
    public ArrayStack(){
        datos= (T[]) new Object[DEFAULT_CAPACITY];
        cont=0;
    }
    
    public ArrayStack(int i){
        datos=(T[])(new Object[i]);
        cont=0;
    }
    
    public void push(T dato){
        if(cont>=datos.length){
        expandCapacity();
        }
        datos[cont]=dato;
        cont++;
        }
    
    
    private void expandCapacity(){
        T[] longer = (T[])(new Object[2*datos.length]);
        for(int i=0; i<cont; i++){
            longer[i]=datos[i];
        }
        datos=longer;
        }
    
    
    public T pop(){
        T res;
    if(cont >0){
        res=datos[cont-1];
        datos[cont-1]=null;
        cont--;
    }
    else
        throw new EmptyStackException();
    return res;
        }


    public T peek(){
        T res;
        if(!isEmpty())
            res=datos [cont-1];
        else
            throw new EmptyStackException();
        return res;
        
    }

    public boolean isEmpty(){
        return cont==0;
    }

   
   
    }


