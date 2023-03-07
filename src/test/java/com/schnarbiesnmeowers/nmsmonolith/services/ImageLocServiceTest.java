package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ImageLocDTO;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class ImageLocServiceTest {


	/**
	 * get all ImageLoc records
	 * @return
	 * @throws Exception
	 */
	public List<ImageLocDTO> getAllImageLoc() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<ImageLocDTO> imagelocDTO = new ArrayList<ImageLocDTO>();
		return imagelocDTO;
	}

	/**
	 * get ImageLoc by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ImageLocDTO findImageLocById(int id) throws Exception {
		return new ImageLocDTO();
	}

	/**
	 * create a new ImageLoc
	 * @param data
	 * @return
	 */
	public ImageLocDTO createImageLoc(ImageLocDTO data) {
        data.setImageLocId(1);
        return data;
	}

	/**
	 * update a ImageLoc
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public ImageLocDTO updateImageLoc(ImageLocDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a ImageLoc by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteImageLoc(int id) throws Exception {
		return "Successfully Deleted";
	}

}
