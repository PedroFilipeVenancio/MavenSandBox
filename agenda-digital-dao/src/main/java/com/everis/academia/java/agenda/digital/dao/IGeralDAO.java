package com.everis.academia.java.agenda.digital.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IGeralDAO <T> {
	void delete(T var);

	void update(T var);

	void create(T var);
	
	Collection<T> read();
		
<Optional>	Boolean jaExiste(T var );
}
