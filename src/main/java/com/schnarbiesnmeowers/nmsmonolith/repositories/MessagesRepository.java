package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.Messages;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface MessagesRepository extends JpaRepository<Messages, Integer> {


	/**
	 * get Iterable<Messages> by foreign key : eventId
	 * @param eventId
	 * @return Iterable<Messages>
	*/
	public Iterable<Messages> findMessagesByEventId(int eventId);
	/**
	 * get Iterable<Messages> by foreign key : messageTypeId
	 * @param messageTypeId
	 * @return Iterable<Messages>
	*/
	public Iterable<Messages> findMessagesByMessageTypeId(int messageTypeId);
	/**
	 * get Iterable<Messages> by all foreign keys
	 * @return Iterable<Messages>
	*/
	public Iterable<Messages> findMessagesByEventIdAndMessageTypeId(int eventId,int messageTypeId);
}
