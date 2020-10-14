package com.capg.MovieMgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.MovieMgmt.dto.SeatRequestDto;
import com.capg.MovieMgmt.entities.Seat;
import com.capg.MovieMgmt.exceptions.SeatAlreadyBlockedException;
import com.capg.MovieMgmt.exceptions.SeatAlreadyBookedException;
import com.capg.MovieMgmt.exceptions.SeatAlreadyCancelledException;
import com.capg.MovieMgmt.exceptions.SeatNotFoundException;
import com.capg.MovieMgmt.service.ISeatService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/seats")
public class SeatController {

@Autowired
private ISeatService seatService;

/* add new seat */
@PostMapping("/add")
public ResponseEntity<Seat> addSeat(@RequestBody SeatRequestDto seatDto) {
Seat seat = convertFromDtoToSeat(seatDto);
seat = seatService.saveSeat(seat);
ResponseEntity<Seat> reponse = new ResponseEntity<Seat>(seat, HttpStatus.OK);
return reponse;
}

/* convert dto details into seat */
public Seat convertFromDtoToSeat(SeatRequestDto requestData) {
Seat seat = new Seat();
seat.setSeatPrice(requestData.getSeatPrice());
seat.setSeatStatus(requestData.getSeatStatus());
return seat;
}

/* get seat details using seatid */
@GetMapping("/getbyid/{id}")
public ResponseEntity<Seat> fetchSeatById(@PathVariable("id") int seatId) {
Seat seat = seatService.getSeat(seatId);
ResponseEntity<Seat> reponse = new ResponseEntity<Seat>(seat, HttpStatus.OK);
return reponse;
}

/* get all seat details */
@GetMapping("/getall")
public ResponseEntity<List<Seat>> fetchAllSeats() {
List<Seat> list = seatService.getAllSeats();
ResponseEntity<List<Seat>> reponse = new ResponseEntity<List<Seat>>(list, HttpStatus.OK);
return reponse;
}

/* block seat using seatid */
@GetMapping("/blockseat/{id}")
public ResponseEntity<Boolean> blockSeat(@PathVariable("id") int seatId) {
Boolean result = seatService.blockSeats(seatId);
ResponseEntity<Boolean> reponse = new ResponseEntity<Boolean>(result, HttpStatus.OK);
return reponse;
}

/* book seat using seatid */
@GetMapping("/bookseat/{id}")
public ResponseEntity<Boolean> bookSeat(@PathVariable("id") int seatId) {
Boolean result = seatService.bookSeats(seatId);
ResponseEntity<Boolean> reponse = new ResponseEntity<Boolean>(result, HttpStatus.OK);
return reponse;
}

/* cancel seat using seatid */
@GetMapping("/cancelseat/{id}")
public ResponseEntity<Boolean> cancelSeat(@PathVariable("id") int seatId) {
Boolean result = seatService.cancelSeatBooking(seatId);
ResponseEntity<Boolean> reponse = new ResponseEntity<Boolean>(result, HttpStatus.OK);
return reponse;
}

@ExceptionHandler(SeatNotFoundException.class)
public ResponseEntity<String> handleSeatNotFound(SeatNotFoundException exception) {
String message = exception.getMessage();
ResponseEntity<String> response = new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
return response;
}

@ExceptionHandler(SeatAlreadyBlockedException.class)
public ResponseEntity<String> handleSeatAlreadyBlocked(SeatAlreadyBlockedException exception) {
String message = exception.getMessage();
ResponseEntity<String> response = new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
return response;
}

@ExceptionHandler(SeatAlreadyBookedException.class)
public ResponseEntity<String> handleSeatAlreadyBooked(SeatAlreadyBookedException exception) {
String message = exception.getMessage();
ResponseEntity<String> response = new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
return response;
}

@ExceptionHandler(SeatAlreadyCancelledException.class)
public ResponseEntity<String> handleSeatAlreadyCancelled(SeatAlreadyCancelledException exception) {
String message = exception.getMessage();
ResponseEntity<String> response = new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
return response;
}

}