package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.IngredientTypeMappingsDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.RecipeTypeMappingsDTO;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import static com.schnarbiesnmeowers.nmsmonolith.utilities.NumberUtility.toIntArr;

@Entity
@Immutable
@Table(name = "ingredient_type_mappings")
public class IngredientTypeMappings implements Serializable {
    // default serial version id, required for serializable classes
    private static final long serialVersionUID = 1L;

    @Column(name = "id")
    @Id()
    private Integer id;

    /**
     *
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     *
     */
    @Column(name = "parent_desc")
    private String parentDesc;

    /**
     * this is a list of integers
     */
    @Column(name = "child_id")
    private String childId;

    public IngredientTypeMappings() {
    }

    public IngredientTypeMappings(Integer id, Integer parentId, String parentDesc, String childId) {
        this.id = id;
        this.parentId = parentId;
        this.parentDesc = parentDesc;
        this.childId = childId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public String getParentDesc() {
        return parentDesc;
    }

    public String getChildId() {
        return childId;
    }

    @Override
    public String toString() {
        return "IngredientTypeMappings{" +
                "parentId=" + parentId +
                ", parentDesc='" + parentDesc + '\'' +
                ", childId='" + childId + '\'' +
                '}';
    }

    public IngredientTypeMappingsDTO toDTO() {
        return new IngredientTypeMappingsDTO(this.parentId,this.parentDesc,
                this.childId == null ? null : toIntArr(this.childId
                .replaceAll("'","").split(",")));
    }

}
