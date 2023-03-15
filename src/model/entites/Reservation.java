package model.entites;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer roomNumber;
	private Date chekcIn;
	private Date checkOut;
	
	public Reservation(Integer roomNumber, Date chekcIn, Date checkOut){
		if(!checkOut.after(chekcIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.chekcIn = chekcIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getChekcIn() {
		return chekcIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		//como calcular a diferença das duas datas pelo milíssegundos
		//o getTime() devolve a quantidade de milíssegundos data
		long diff = checkOut.getTime() - chekcIn.getTime();
		//TimeUnit - Tipo enumerado complexo que tem algumas operações 
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); //converte o milíssegundos para dias
	}
	
	public void updateDates(Date checkIn, Date checkOut){
		Date now = new Date(); //pega a data de agora
		//Date tem um método chamada 'before' que testa se uma data está 'antes' da outra
		if(checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Reservation dates for update must be future dates");
		} 
		if(!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		/*Se passar pelo if e não encontrar nenhum erro, daí executa a 
		 * logica para atualizar o checkin e checkout*/
		this.checkOut = checkOut;
		this.chekcIn = checkIn;
	}

	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+", check-in: "
				+ sdf.format(chekcIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nigths";
	}
	
	

}
