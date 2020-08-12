

// RuntimeException = tipo de exceção que o compilador não obriga a tratar
// Exception = tipo de exceção que o compilador obriga o tratamento


// Usando o metodo RuntimeException



package model.exceptions;

public class Domain_Exception extends RuntimeException {
    
    public Domain_Exception (String msg){
        super(msg);
    }
}



