package com.capg.MovieMgmt.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.MovieMgmt.dao.ISeatDao;
import com.capg.MovieMgmt.entities.BookingState;
import com.capg.MovieMgmt.entities.Seat;
import com.capg.MovieMgmt.exceptions.SeatAlreadyBlockedException;
import com.capg.MovieMgmt.exceptions.SeatAlreadyBookedException;
import com.capg.MovieMgmt.exceptions.SeatAlreadyCancelledException;
import com.capg.MovieMgmt.exceptions.SeatNotFoundException;

@Service
@Transactional
public class SeatServiceImpl implements ISeatService {

private ISeatDao seatDao;

public ISeatDao getSeatDao() {
return seatDao;
}

@Autowired
public void setSeatDao(ISeatDao seatDao) {
this.seatDao = seatDao;
}

/*** add new seat ***/
@Override
public Seat saveSeat(Seat seat) {
seat = seatDao.save(seat);
return seat;
}

/* get all seat details */
@Override
public List<Seat> getAllSeats() {
List<Seat> list = seatDao.findAll();
return list;
}

/* block seat using seatId */
@Override
public Boolean blockSeats(int seatId) {
Seat seat = getSeat(seatId);
if (seat.getSeatStatus().equals(BookingState.Blocked)) {
throw new SeatAlreadyBlockedException("Seat already blocked for id=" + seatId);
}
seat.setSeatStatus(BookingState.Blocked);
seatDao.save(seat);
return true;

}

/* book seat using seatId */
@Override
public Boolean bookSeats(int seatId) {
Seat seat = getSeat(seatId);
if (seat.getSeatStatus().equals(BookingState.Booked)) {
throw new SeatAlreadyBookedException("Seat already booked for id=" + seatId);
}
seat.setSeatStatus(BookingState.Booked);
seatDao.save(seat);
return true;
}

/* cancel seat using seatId */
@Override
public Boolean cancelSeatBooking(int seatId) {
Seat seat = getSeat(seatId);
if (seat.getSeatStatus().equals(BookingState.Available)) {
throw new SeatAlreadyCancelledException("Seat already cancelled for id=" + seatId);
}
seat.setSeatStatus(BookingState.Available);
seatDao.save(seat);
return true;
}

/* get seatdetails using seatId */
@Override
public Seat getSeat(int seatId) {
Optional<Seat> optional = seatDao.findById(seatId);
if (optional.isPresent()) {
return optional.get();
}
throw new SeatNotFoundException("Seat not found for id=" + seatId);
}

}