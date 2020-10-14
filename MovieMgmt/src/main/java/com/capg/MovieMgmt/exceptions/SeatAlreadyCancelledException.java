package com.capg.MovieMgmt.exceptions;

public class SeatAlreadyCancelledException extends RuntimeException
{
public SeatAlreadyCancelledException(String message){
super(message);
}
}