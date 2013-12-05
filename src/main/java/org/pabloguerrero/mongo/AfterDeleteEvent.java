package org.pabloguerrero.mongo;

import org.springframework.data.mongodb.core.mapping.event.AbstractDeleteEvent;

import com.mongodb.DBObject;

/**
 * Event being thrown after a single or a set of documents has/have been deleted. The {@link DBObject} held in the event
 * will be the query document <em>after</am> it has been mapped onto the domain type handled.
 * 
 * @author Martin Baumgartner
 */
public class AfterDeleteEvent<T> extends AbstractDeleteEvent<T> {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new {@link AfterDeleteEvent} for the given {@link DBObject} and type.
	 * 
	 * @param dbo must not be {@literal null}.
	 * @param type can be {@literal null}.
	 */
	public AfterDeleteEvent(DBObject dbo, Class<T> type) {
		super(dbo, type);
	}
}

