package com.jokenpo.game.adapter.rest.mapper;

import java.util.List;

public interface MapperAdapter<T, O> {
	
	T mapToModel(O o);
	
	O mapToPortOut(T t);
	
	List<O> mapToPortOutList(List<T> t);

}
