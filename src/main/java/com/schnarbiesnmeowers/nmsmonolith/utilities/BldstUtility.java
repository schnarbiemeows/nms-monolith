package com.schnarbiesnmeowers.nmsmonolith.utilities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.BldstTableDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.BldstTable;
import com.schnarbiesnmeowers.nmsmonolith.repositories.BldstTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BldstUtility {
    public static List<BldstTableDTO> bldstRecords = null;
    public static Map<String,Integer> bldstCodes = null;
    public static final String BLDST_BREAKFAST = "B";
    public static final String BLDST_LUNCH = "L";
    public static final String BLDST_DINNER = "D";
    public static final String BLDST_MID_MORNING_SNACK = "S";

    public static final String BLDST_MID_AFTERNOON_SNACK = "M1";
    public static final String BLDST_LATE_AFTERNOON_SNACK = "M2";
    public static final String BLDST_LATE_NIGHT_SNACK = "M3";
    public static final String BLDST_TOTAL = "T";
    public static final String BLDST_COFFEE = "C";

    public static final String BLDST_PRE_WORKOUT = "PRE";

    public static final String BLDST_POST_WORKOUT = "PST";

    @Autowired
    private BldstTableRepository bldstTableRepository;

    private void initialize() {
        bldstRecords = new ArrayList();
        bldstCodes = new HashMap();
        System.out.println("************************** populating bldstRecords **************************");
        Iterable<BldstTable> bldsttable = bldstTableRepository.getAllActiveBDLST();
        Iterator<BldstTable> bldsttables = bldsttable.iterator();
        while(bldsttables.hasNext()) {
            BldstTable item = bldsttables.next();
            bldstRecords.add(item.toDTO());
            bldstCodes.put(item.getBldstCde(),item.getBldstTableId());
        }

        System.out.println("************************** populating bldstRecords **************************");
    }

    public List<BldstTableDTO> getBldstRecords() {
        if(bldstRecords==null) {
            initialize();
        }
        return bldstRecords;
    }

    public Map<String,Integer> getBldstMap() {
        if(bldstRecords==null) {
            initialize();
        }
        return bldstCodes;
    }
}
