package com.jokenpo.game.adapter.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jokenpo.game.adapter.rest.dto.PlayerDto;
import com.jokenpo.game.adapter.rest.mapper.PlayerMapper;
import com.jokenpo.game.domain.Player;
import com.jokenpo.game.service.PlayerCommand;

@RestController
@RequestMapping("/player")
@ResponseBody
public class PlayerController {

	@Autowired
	PlayerCommand command;

	@Autowired
	PlayerMapper mapper;

	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping
	public PlayerDto add(@Validated @RequestBody PlayerDto incoming) {
		Player add = command.add(mapper.mapToModel(incoming));

		return mapper.mapToPortOut(add);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping
	public void remove(@Validated @NonNull @RequestParam(name = "id") String id) {
		command.remove(id);
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping
	public List<PlayerDto> list() {
		return mapper.mapToPortOutList(command.getAll());
	}

}
