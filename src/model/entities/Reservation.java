
/*

Fazer um programa para ler os dados de uma reserva de hotel (número do quarto, data
de entrada e data de saída) e mostrar os dados da reserva, inclusive sua duração em
dias. Em seguida, ler novas datas de entrada e saída, atualizar a reserva, e mostrar
novamente a reserva com os dados atualizados. O programa não deve aceitar dados
inválidos para a reserva, conforme as seguintes regras:
- Alterações de reserva só podem ocorrer para datas futuras
- A data de saída deve ser maior que a data de entrada

*/



// METODO BOM = usando tratamento de exceções 
// CRIANDO EXCEÇÕES

// USANDO O METODO EXCEPTION =  no Pacote model.exceptions na classe Domain_Exceptions



package model.entities;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import model.exceptions.Domain_Exception;

public class Reservation {
    
    private Integer roomNumber;
    private Date checkin;
    private Date checkout;
    
    //para nao ser instanciado cada objeto da aplicação
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    
    //construtores
    public Reservation(Integer roomNumber, Date checkin, Date checkout) {
    // tratando exceções
       if ( ! checkout.after(checkin) ) {
               throw new Domain_Exception ("Check-out date must be after check-in date");
            }
            this.roomNumber = roomNumber;
            this.checkin = checkin;
            this.checkout = checkout;
        }
    
    
    //modificadores 
    public Integer getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
    public Date getCheckin() {
        return checkin;
    }
    public Date getCheckout() {
        return checkout;
    }
    
    //metodo de duração de estadia em dias
    public long duration(){
      long diff = checkout.getTime() - checkin.getTime(); // diferença entre as datas em milesegundos
      return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // converte milesegundos para dias 
    }

    //metodo para atualizar as datas 
    public void updateDates (Date checkin, Date checkout) {
        
        Date now = new Date();
        if (checkin.before(now) || checkout.before(now) ) {
           throw new Domain_Exception ("Reservation dates for update must be future dates");
        }
        if ( ! checkout.after(checkin) ) {
           throw new Domain_Exception ("Check-out date must be after check-in date");
        }
        this.checkin = checkin;
        this.checkout = checkout;

    } 
    
    //toString
    @Override
    public String toString(){
        return "Room"
                + roomNumber
                + ", Check-in: "
                + sdf.format(checkin)
                + ", Check-out: "
                + sdf.format(checkout)
                + ", "
                + duration()
                + " nights ";
        
    }
    
}
