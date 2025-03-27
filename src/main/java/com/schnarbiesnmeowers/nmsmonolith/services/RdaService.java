package com.schnarbiesnmeowers.nmsmonolith.services;

import com.schnarbiesnmeowers.nmsmonolith.dtos.RdaDTO;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.entities.Rda;
import com.schnarbiesnmeowers.nmsmonolith.repositories.RdaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class RdaService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private RdaRepository rdaRepository;

	/**
	 * get all Rda records
	 * @return
	 * @throws Exception
	 */
	public List<RdaDTO> getAllRda() throws Exception {
		Iterable<Rda> rda = rdaRepository.findAll();
		Iterator<Rda> rdas = rda.iterator();
		List<RdaDTO> rdadto = new ArrayList();
		while(rdas.hasNext()) {
			Rda item = rdas.next();
			rdadto.add(item.toDTO());
		}
		return rdadto;
	}

	/**
	 * get Rda by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public RdaDTO findRdaById(int id) throws Exception {
		Optional<Rda> rdaOptional = rdaRepository.findById(id);
		if(rdaOptional.isPresent()) {
			Rda results = rdaOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	public List<RdaDTO> findDefaults() throws Exception {
		Iterable<Rda> rda = rdaRepository.findDefaults();
		Iterator<Rda> rdas = rda.iterator();
		List<RdaDTO> rdadto = new ArrayList();
		while(rdas.hasNext()) {
			Rda item = rdas.next();
			rdadto.add(item.toDTO());
		}
		return rdadto;
	}

	public Map<String, BigDecimal> findRdasForAGivenUserId(int userId) throws Exception {
		Map<String, BigDecimal> defaults = mapRdas(findDefaults());
		Iterable<Rda> rda = rdaRepository.findActiveRdasByUserId(userId);
		Iterator<Rda> rdas = rda.iterator();
		List<RdaDTO> userRdaList = new ArrayList();
		while(rdas.hasNext()) {
			Rda item = rdas.next();
			userRdaList.add(item.toDTO());
		}
		Map<String, BigDecimal> userRDAs = mapRdas(userRdaList);
		Map<String, BigDecimal> output = new HashMap();
		for(String key : defaults.keySet()) {
			if(userRDAs.containsKey(key)) {
				output.put(key,userRDAs.get(key));
			} else {
				output.put(key,defaults.get(key));
			}
		}
		return output;
	}

	private Map<String, BigDecimal> mapRdas(List<RdaDTO> input) {
		Map<String, BigDecimal> output = new HashMap();
		for(RdaDTO dto : input) {
			output.put(dto.getRdaName(),dto.getRdaValue());
		}
		return output;
	}
	/**
	 * create a new Rda
	 * @param data
	 * @return
	 */
	public RdaDTO createRda(RdaDTO data) {
		try {
		    Rda createdData = data.toEntity();
		    createdData = rdaRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Rda
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public RdaDTO updateRda(RdaDTO data) throws Exception {
		Optional<Rda> rdaOptional = rdaRepository.findById(data.getRdaId());
		if(rdaOptional.isPresent()) {
		    Rda updatedData = data.toEntity();
			updatedData = rdaRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getRdaId() + NOT_FOUND);
		}
	}

	/**
	 * delete a Rda by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteRda(int id) throws Exception {
		Optional<Rda> rdaOptional = rdaRepository.findById(id);
		if(rdaOptional.isPresent()) {
			rdaRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<RdaDTO> by foreign key : userId
	 * @param id
	 * @return List<Rda>
	 * @throws Exception
	*/
	public List<RdaDTO> findRdaByUserId(int id) throws Exception {
		Iterable<Rda> results = rdaRepository.findRdaByUserId(id);
		Iterator<Rda> iter = results.iterator();
		List<RdaDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Rda item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
