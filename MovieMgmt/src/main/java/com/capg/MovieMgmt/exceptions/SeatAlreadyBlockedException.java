package com.capg.MovieMgmt.exceptions;

public class SeatAlreadyBlockedException extends RuntimeException {

public SeatAlreadyBlockedException(String message) {
super(message);
}

}