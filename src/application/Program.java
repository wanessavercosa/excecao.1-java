package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entites.Reservation;
import model.exceptions.DomainException;

public class Program {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room Number: ");
			int number = sc.nextInt();
			System.out.print("Check-In date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next()); 
			/*Têm duas soluções para a exceção 'parse' que deu aqui:
			 * 1 solução: usando o throws ParseException
			 * 2 solução: obj.printStackTrace()*/
	
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.print("Resevation: " + reservation);
		
			System.out.println();
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-In date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
		
			//Depois que ler as novas datas tem que atualizar
			reservation.updateDates(checkIn, checkOut);
			System.out.print("Resevation: " + reservation);	
		}
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
			//e(obj).getMessage() - para pegar a mensagem que está no IllegalArgumentException 
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		sc.close();

	}
}
