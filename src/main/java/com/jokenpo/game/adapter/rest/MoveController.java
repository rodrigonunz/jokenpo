package com.jokenpo.game.adapter.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.jokenpo.game.adapter.rest.dto.MoveDto;
import com.jokenpo.game.adapter.rest.mapper.MoveMapper;
import com.jokenpo.game.domain.Move;
import com.jokenpo.game.exception.EntityValidatorException;
import com.jokenpo.game.service.MoveCommand;

@RestController
@RequestMapping("/move")
@ResponseBody
public class MoveController {
	
	@Autowired
	MoveCommand command;

	@Autowired
	MoveMapper mapper;
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping
	public ResponseEntity add(@RequestBody MoveDto incoming) {

		Move add;
		try {
			add = command.add(mapper.mapToModel(incoming));
			return ResponseEntity.ok(mapper.mapToPortOut(add));
		} catch (EntityValidatorException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		}
	}

	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping
	public void remove(@Validated @RequestParam(name = "id") String id) {
		command.remove(id);
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping
	public List<MoveDto> list() {
		return mapper.mapToPortOutList(command.getAll());
	}
	
}
