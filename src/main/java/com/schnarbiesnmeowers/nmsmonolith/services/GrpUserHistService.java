package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GrpUserHistDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.GrpUserHist;
import com.schnarbiesnmeowers.nmsmonolith.repositories.GrpUserHistRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class GrpUserHistService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private GrpUserHistRepository grpUserHistRepository;

	/**
	 * get all GrpUserHist records
	 * @return
	 * @throws Exception
	 */
	public List<GrpUserHistDTO> getAllGrpUserHist() throws Exception {
		Iterable<GrpUserHist> grpuserhist = grpUserHistRepository.findAll();
		Iterator<GrpUserHist> grpuserhists = grpuserhist.iterator();
		List<GrpUserHistDTO> grpuserhistdto = new ArrayList();
		while(grpuserhists.hasNext()) {
			GrpUserHist item = grpuserhists.next();
			grpuserhistdto.add(item.toDTO());
		}
		return grpuserhistdto;
	}

	/**
	 * get GrpUserHist by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public GrpUserHistDTO findGrpUserHistById(int id) throws Exception {
		Optional<GrpUserHist> grpuserhistOptional = grpUserHistRepository.findById(id);
		if(grpuserhistOptional.isPresent()) {
			GrpUserHist results = grpuserhistOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new GrpUserHist
	 * @param data
	 * @return
	 */
	public GrpUserHistDTO createGrpUserHist(GrpUserHistDTO data) {
		try {
		    GrpUserHist createdData = data.toEntity();
		    createdData = grpUserHistRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a GrpUserHist
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public GrpUserHistDTO updateGrpUserHist(GrpUserHistDTO data) throws Exception {
		Optional<GrpUserHist> grpuserhistOptional = grpUserHistRepository.findById(data.getGrpUserHistId());
		if(grpuserhistOptional.isPresent()) {
		    GrpUserHist updatedData = data.toEntity();
			updatedData = grpUserHistRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getGrpUserHistId() + NOT_FOUND);
		}
	}

	/**
	 * delete a GrpUserHist by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteGrpUserHist(int id) throws Exception {
		Optional<GrpUserHist> grpuserhistOptional = grpUserHistRepository.findById(id);
		if(grpuserhistOptional.isPresent()) {
			grpUserHistRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<GrpUserHistDTO> by foreign key : grpUserId
	 * @param grpUserId
	 * @return List<GrpUserHist>
	 * @throws Exception
	*/
	public List<GrpUserHistDTO> findGrpUserHistByGrpUserId(int id) throws Exception {
		Iterable<GrpUserHist> results = grpUserHistRepository.findGrpUserHistByGrpUserId(id);
		Iterator<GrpUserHist> iter = results.iterator();
		List<GrpUserHistDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			GrpUserHist item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<GrpUserHistDTO> by foreign key : grpId
	 * @param grpId
	 * @return List<GrpUserHist>
	 * @throws Exception
	*/
	public List<GrpUserHistDTO> findGrpUserHistByGrpId(int id) throws Exception {
		Iterable<GrpUserHist> results = grpUserHistRepository.findGrpUserHistByGrpId(id);
		Iterator<GrpUserHist> iter = results.iterator();
		List<GrpUserHistDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			GrpUserHist item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<GrpUserHistDTO> by foreign key : userId
	 * @param userId
	 * @return List<GrpUserHist>
	 * @throws Exception
	*/
	public List<GrpUserHistDTO> findGrpUserHistByUserId(int id) throws Exception {
		Iterable<GrpUserHist> results = grpUserHistRepository.findGrpUserHistByUserId(id);
		Iterator<GrpUserHist> iter = results.iterator();
		List<GrpUserHistDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			GrpUserHist item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<GrpUserHistDTO> by foreign key : actionTypeId
	 * @param actionTypeId
	 * @return List<GrpUserHist>
	 * @throws Exception
	*/
	public List<GrpUserHistDTO> findGrpUserHistByActionTypeId(int id) throws Exception {
		Iterable<GrpUserHist> results = grpUserHistRepository.findGrpUserHistByActionTypeId(id);
		Iterator<GrpUserHist> iter = results.iterator();
		List<GrpUserHistDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			GrpUserHist item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<GrpUserHistDTO> by foreign key : evntOperId
	 * @param evntOperId
	 * @return List<GrpUserHist>
	 * @throws Exception
	*/
	public List<GrpUserHistDTO> findGrpUserHistByEvntOperId(int id) throws Exception {
		Iterable<GrpUserHist> results = grpUserHistRepository.findGrpUserHistByEvntOperId(id);
		Iterator<GrpUserHist> iter = results.iterator();
		List<GrpUserHistDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			GrpUserHist item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<GrpUserHistDTO> by foreign key : GrpUserIdAndGrpIdAndUserIdAndActionTypeIdAndEvntOperId
	 * @param GrpUserIdAndGrpIdAndUserIdAndActionTypeIdAndEvntOperId
	 * @return List<GrpUserHist>
	 * @throws Exception
	*/
	public List<GrpUserHistDTO> findGrpUserHistByGrpUserIdAndGrpIdAndUserIdAndActionTypeIdAndEvntOperId(@PathVariable int id0,@PathVariable int id1,@PathVariable int id2,@PathVariable int id3,@PathVariable int id4) throws Exception {
		Iterable<GrpUserHist> results = grpUserHistRepository.findGrpUserHistByGrpUserIdAndGrpIdAndUserIdAndActionTypeIdAndEvntOperId(id0, id1, id2, id3, id4);
		Iterator<GrpUserHist> iter = results.iterator();
		List<GrpUserHistDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			GrpUserHist item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
