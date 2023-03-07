package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.pojos.PaymentType;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface PaymentTypeRepository extends JpaRepository<PaymentType, Integer> {


	/**
	 * get Iterable<PaymentType> by foreign key : imageLoc
	 * @param imageLoc
	 * @return Iterable<PaymentType>
	*/
	public Iterable<PaymentType> findPaymentTypeByImageLoc(int imageLoc);
}
