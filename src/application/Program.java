

// METODO BOM = usando tratamento de exceções 
// CRIANDO EXCEÇÕES
// USANDO O METODO = Exception



package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import model.entities.Reservation;
import model.exceptions.Domain_Exception;

public class Program {
    
    public static void main(String[] args)  {
        
    
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        
        try{ 

            System.out.print("Room Number: ");
            int number = sc.nextInt();
            System.out.print("Check-in Date (dd/MM/yyyy): ");
            Date checkin = sdf.parse(sc.next()); //converte o texto pro formato date
            //sdf.parse(sc.next())= pode lançar um exceção no metodo, adicionar o throws ParseException
            System.out.print("Check-out Date (dd/MM/yyyy): ");
            Date checkout = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number, checkin, checkout);
            System.out.println("Reservation: " + reservation);

            System.out.println("\n");

            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in Date (dd/MM/yyyy): ");
            checkin = sdf.parse(sc.next()); 
            System.out.print("Check-out Date (dd/MM/yyyy): ");
            checkout = sdf.parse(sc.next());


            // metodo de atualização de reserva 
            reservation.updateDates(checkin, checkout);

            System.out.println("Reservation" + reservation);

            }
        
            //tratando o ParseException
            catch ( ParseException e ){
                System.out.println("Invalid date format");
            }
            
            //nao deixa o programa "quebrar"
            catch ( Domain_Exception e ){
                System.out.println("Error in Reservation: " + e.getMessage() );
            }
            //herança e upcasting
            catch ( RuntimeException e ) {
                System.out.println("Unexpected error");
            }
              
        sc.close();
    }//fim main
    
}//fim class
