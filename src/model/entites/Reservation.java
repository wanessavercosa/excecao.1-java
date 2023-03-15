package model.entites;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer roomNumber;
	private Date chekcIn;
	private Date checkOut;
	
	public Reservation() {
	
	}

	public Reservation(Integer roomNumber, Date chekcIn, Date checkOut) {
		super();
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
	
	public void updateDates(Date checkIn, Date checkOut) {
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
