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
public class IndefinitionException extends RuntimeException{
    IndefinitionException(){
        super("Valor no definido");
    }
}
