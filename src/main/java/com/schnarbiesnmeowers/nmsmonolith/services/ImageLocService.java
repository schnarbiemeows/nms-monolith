package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ImageLocDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.ImageLoc;
import com.schnarbiesnmeowers.nmsmonolith.repositories.ImageLocRepository;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class ImageLocService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private ImageLocRepository imageLocRepository;

	/**
	 * get all ImageLoc records
	 * @return
	 * @throws Exception
	 */
	public List<ImageLocDTO> getAllImageLoc() throws Exception {
		Iterable<ImageLoc> imageloc = imageLocRepository.findAll();
		Iterator<ImageLoc> imagelocs = imageloc.iterator();
		List<ImageLocDTO> imagelocdto = new ArrayList();
		while(imagelocs.hasNext()) {
			ImageLoc item = imagelocs.next();
			imagelocdto.add(item.toDTO());
		}
		return imagelocdto;
	}

	/**
	 * get ImageLoc by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ImageLocDTO findImageLocById(int id) throws Exception {
		Optional<ImageLoc> imagelocOptional = imageLocRepository.findById(id);
		if(imagelocOptional.isPresent()) {
			ImageLoc results = imagelocOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new ImageLoc
	 * @param data
	 * @return
	 */
	public ImageLocDTO createImageLoc(ImageLocDTO data) {
		try {
		    ImageLoc createdData = data.toEntity();
		    createdData = imageLocRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a ImageLoc
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public ImageLocDTO updateImageLoc(ImageLocDTO data) throws Exception {
		Optional<ImageLoc> imagelocOptional = imageLocRepository.findById(data.getImageLocId());
		if(imagelocOptional.isPresent()) {
		    ImageLoc updatedData = data.toEntity();
			updatedData = imageLocRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getImageLocId() + NOT_FOUND);
		}
	}

	/**
	 * delete a ImageLoc by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteImageLoc(int id) throws Exception {
		Optional<ImageLoc> imagelocOptional = imageLocRepository.findById(id);
		if(imagelocOptional.isPresent()) {
			imageLocRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

}
