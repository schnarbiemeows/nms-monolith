package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.Payment;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface PaymentRepository extends JpaRepository<Payment, Integer> {


	/**
	 * get Iterable<Payment> by foreign key : userId
	 * @param userId
	 * @return Iterable<Payment>
	*/
	public Iterable<Payment> findPaymentByUserId(int userId);
	/**
	 * get Iterable<Payment> by foreign key : paymentTypeId
	 * @param paymentTypeId
	 * @return Iterable<Payment>
	*/
	public Iterable<Payment> findPaymentByPaymentTypeId(int paymentTypeId);
	/**
	 * get Iterable<Payment> by all foreign keys
	 * @return Iterable<Payment>
	*/
	public Iterable<Payment> findPaymentByUserIdAndPaymentTypeId(int userId,int paymentTypeId);
}
