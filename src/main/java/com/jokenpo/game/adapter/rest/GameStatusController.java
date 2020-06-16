package com.jokenpo.game.adapter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jokenpo.game.adapter.rest.dto.GameResultDto;
import com.jokenpo.game.adapter.rest.mapper.GameMapper;
import com.jokenpo.game.service.GetResultCommand;

@RestController
@RequestMapping("/status")
@ResponseBody
public class GameStatusController {
	
	@Autowired
	GetResultCommand res;
	
	@Autowired
	GameMapper map;

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping
	public GameResultDto getActualStatus() {
		return map.mapToPortOut(res.getResult());
		
	}

}
