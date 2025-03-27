package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.BldstTableDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.BldstTable;
import com.schnarbiesnmeowers.nmsmonolith.repositories.BldstTableRepository;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class BldstTableService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private BldstTableRepository bldstTableRepository;

	/**
	 * get all BldstTable records
	 * @return
	 * @throws Exception
	 */
	public List<BldstTableDTO> getAllBldstTable() throws Exception {
		Iterable<BldstTable> bldsttable = bldstTableRepository.getAllActiveBDLST();
		Iterator<BldstTable> bldsttables = bldsttable.iterator();
		List<BldstTableDTO> bldsttabledto = new ArrayList();
		while(bldsttables.hasNext()) {
			BldstTable item = bldsttables.next();
			bldsttabledto.add(item.toDTO());
		}
		return bldsttabledto;
	}

	public List<BldstTableDTO> getAllBldstTableForUser() throws Exception {
		Iterable<BldstTable> bldsttable = bldstTableRepository.getAllActiveBDLST();
		Iterator<BldstTable> bldsttables = bldsttable.iterator();
		List<BldstTableDTO> bldsttabledto = new ArrayList();
		while(bldsttables.hasNext()) {
			BldstTable item = bldsttables.next();
			bldsttabledto.add(item.toDTO());
		}
		return bldsttabledto.stream().filter(rec -> !rec.getBldstCde().equals("T")).collect(Collectors.toList());
	}

	/**
	 * get BldstTable by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public BldstTableDTO findBldstTableById(int id) throws Exception {
		Optional<BldstTable> bldsttableOptional = bldstTableRepository.findById(id);
		if(bldsttableOptional.isPresent()) {
			BldstTable results = bldsttableOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new BldstTable
	 * @param data
	 * @return
	 */
	public BldstTableDTO createBldstTable(BldstTableDTO data) {
		try {
		    BldstTable createdData = data.toEntity();
		    createdData = bldstTableRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a BldstTable
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public BldstTableDTO updateBldstTable(BldstTableDTO data) throws Exception {
		Optional<BldstTable> bldsttableOptional = bldstTableRepository.findById(data.getBldstTableId());
		if(bldsttableOptional.isPresent()) {
		    BldstTable updatedData = data.toEntity();
			updatedData = bldstTableRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getBldstTableId() + NOT_FOUND);
		}
	}

	/**
	 * delete a BldstTable by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteBldstTable(int id) throws Exception {
		Optional<BldstTable> bldsttableOptional = bldstTableRepository.findById(id);
		if(bldsttableOptional.isPresent()) {
			bldstTableRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

}
