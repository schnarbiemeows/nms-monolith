package com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes;

import java.io.Serializable;

public class ServingTypeMinDataDTO implements Serializable {
    // default serial version id, required for serializable classes
    private static final long serialVersionUID = 1L;

    //private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

    /**
     *
     */
    private Integer servTypeId;

    /**
     * "short code for the serving type"
     */
    private String servTypeCde;

    public ServingTypeMinDataDTO() {
    }

    public ServingTypeMinDataDTO(Integer servTypeId, String servTypeCde) {
        this.servTypeId = servTypeId;
        this.servTypeCde = servTypeCde;
    }

    public Integer getServTypeId() {
        return servTypeId;
    }

    public void setServTypeId(Integer servTypeId) {
        this.servTypeId = servTypeId;
    }

    public String getServTypeCde() {
        return servTypeCde;
    }

    public void setServTypeCde(String servTypeCde) {
        this.servTypeCde = servTypeCde;
    }

    @Override
    public String toString() {
        return "ServingTypeMinDataDTO{" +
                "servTypeId=" + servTypeId +
                ", servTypeCde='" + servTypeCde + '\'' +
                '}';
    }
}
