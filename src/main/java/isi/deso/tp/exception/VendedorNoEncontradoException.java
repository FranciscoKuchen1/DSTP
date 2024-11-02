/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.tp.exception;

/**
 *
 * @author Nacho
 */
public class VendedorNoEncontradoException extends Exception {
    
    // Constructor por defecto
    public VendedorNoEncontradoException() {
        super("El vendedor no existen");
    }

    // Constructor que permite personalizar el mensaje de error
    public VendedorNoEncontradoException(String msg) {
        super(msg);
    }
    
    
}
