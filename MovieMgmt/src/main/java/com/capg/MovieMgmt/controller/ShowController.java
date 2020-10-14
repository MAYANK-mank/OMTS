package com.capg.MovieMgmt.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.MovieMgmt.dto.ShowDetailsDto;
import com.capg.MovieMgmt.dto.ShowRequestDto;
import com.capg.MovieMgmt.entities.Show;
import com.capg.MovieMgmt.service.IShowService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/shows")
public class ShowController {
	
	@Autowired
	private IShowService showService ;
	
	@PostMapping("/add/{id}")
	public ResponseEntity<ShowDetailsDto> addShow(@RequestBody ShowRequestDto showDto){
		Show show = convertShow(showDto) ;
		showService.save(show);
		ShowDetailsDto detailsDto = new ShowDetailsDto();
		detailsDto = convertDetails(show);
		ResponseEntity<ShowDetailsDto> response = new ResponseEntity<ShowDetailsDto>(detailsDto, HttpStatus.OK);
		return response;
	}

	private ShowDetailsDto convertDetails(Show show) {
		ShowDetailsDto detailsDto = new ShowDetailsDto();
		detailsDto.setMovieName(show.getMovieName());
		detailsDto.setShowStartTime(show.getShowStartTime());
		detailsDto.setShowEndTime(show.getShowEndTime());
		detailsDto.setSeatsId(show.getSeatsId());
		detailsDto.setShowId(show.getShowId());
		detailsDto.setShowName(show.getShowName());
		//detailsDto.setSeatsId(addSeats());
		return detailsDto;
	}

	private Show convertShow(ShowRequestDto showDto) {
		Show show = new Show();
		show.setMovieName(showDto.getMovieName());
		show.setShowName(showDto.getShowName());
//		show.setSeatsId(addSeats());
		show.setShowStartTime(showDto.getShowStartTime());
		show.setShowEndTime(showDto.getShowEndTime());
		return show;
	}
	
//	private List<Seat> addSeats()
//	{
//		List<Seat> seatsId = new ArrayList<>();
//		seatsId.add(101);
//		seatsId.add(102);
//		return seatsId;
//	}
	
	@GetMapping("/all")
	ResponseEntity<List<Show>> fetchAll(){
		List<Show> showList = showService.fetchAll();
		ResponseEntity<List<Show>> response = new ResponseEntity<List<Show>>(showList, HttpStatus.OK);
		return response;
	}
}
