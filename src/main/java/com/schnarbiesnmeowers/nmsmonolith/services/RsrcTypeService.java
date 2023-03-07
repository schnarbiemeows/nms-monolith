package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.RsrcTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.RsrcType;
import com.schnarbiesnmeowers.nmsmonolith.repositories.RsrcTypeRepository;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class RsrcTypeService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private RsrcTypeRepository rsrcTypeRepository;

	/**
	 * get all RsrcType records
	 * @return
	 * @throws Exception
	 */
	public List<RsrcTypeDTO> getAllRsrcType() throws Exception {
		Iterable<RsrcType> rsrctype = rsrcTypeRepository.findAll();
		Iterator<RsrcType> rsrctypes = rsrctype.iterator();
		List<RsrcTypeDTO> rsrctypedto = new ArrayList();
		while(rsrctypes.hasNext()) {
			RsrcType item = rsrctypes.next();
			rsrctypedto.add(item.toDTO());
		}
		return rsrctypedto;
	}

	/**
	 * get RsrcType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public RsrcTypeDTO findRsrcTypeById(int id) throws Exception {
		Optional<RsrcType> rsrctypeOptional = rsrcTypeRepository.findById(id);
		if(rsrctypeOptional.isPresent()) {
			RsrcType results = rsrctypeOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new RsrcType
	 * @param data
	 * @return
	 */
	public RsrcTypeDTO createRsrcType(RsrcTypeDTO data) {
		try {
		    RsrcType createdData = data.toEntity();
		    createdData = rsrcTypeRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a RsrcType
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public RsrcTypeDTO updateRsrcType(RsrcTypeDTO data) throws Exception {
		Optional<RsrcType> rsrctypeOptional = rsrcTypeRepository.findById(data.getRsrcTypeId());
		if(rsrctypeOptional.isPresent()) {
		    RsrcType updatedData = data.toEntity();
			updatedData = rsrcTypeRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getRsrcTypeId() + NOT_FOUND);
		}
	}

	/**
	 * delete a RsrcType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteRsrcType(int id) throws Exception {
		Optional<RsrcType> rsrctypeOptional = rsrcTypeRepository.findById(id);
		if(rsrctypeOptional.isPresent()) {
			rsrcTypeRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

}
