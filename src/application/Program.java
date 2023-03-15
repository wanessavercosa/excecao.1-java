package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entites.Reservation;

public class Program {
	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room Number: ");
		int number = sc.nextInt();
		System.out.print("Check-In date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-Out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next()); 
		/*Têm duas soluções para a exceção 'parse' que deu aqui:
		 * 1 solução: usando o throws ParseException
		 * 2 solução: obj.printStackTrace()*/
		
		//Date tem um método chamada 'after' que testa se uma data está 'depois' da outra
		if(!checkOut.after(checkIn)) {
			System.out.print("Error in reservation: Check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.print("Resevation: " + reservation);
			
			System.out.println();
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-In date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			//Solução muito ruim
			Date now = new Date(); //pega a data de agora
			//Date tem um método chamada 'before' que testa se uma data está 'antes' da outra
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			} else if(!checkOut.after(checkIn)) {
				System.out.print("Error in reservation: Check-out date must be after check-in date");
			} else {
				//Depois que ler as novas datas tem que atualizar
				reservation.updateDates(checkIn, checkOut);
				System.out.print("Resevation: " + reservation);
			}
			
		}
		
		
		sc.close();

	}
}
