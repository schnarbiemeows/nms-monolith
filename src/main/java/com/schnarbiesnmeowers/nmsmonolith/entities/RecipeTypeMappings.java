package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.RecipeTypeMappingsDTO;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;

import static com.schnarbiesnmeowers.nmsmonolith.utilities.NumberUtility.toIntArr;

@Entity
@Immutable
@Table(name = "recipe_type_mappings")
public class RecipeTypeMappings implements Serializable {
    // default serial version id, required for serializable classes
    private static final long serialVersionUID = 1L;

    @Column(name = "id")
    private Integer id;

    /**
     *
     */
    @Id()
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

    public RecipeTypeMappings() {
    }

    public RecipeTypeMappings(Integer id, Integer parentId, String parentDesc, String childId) {
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
        return "RecipeMappings{" +
                "parentId=" + parentId +
                ", recipeTypeDesc='" + parentDesc + '\'' +
                ", childId='" + childId + '\'' +
                '}';
    }


    public RecipeTypeMappingsDTO toDTO() {
        return new RecipeTypeMappingsDTO(this.parentId == 0 ? null :
                this.parentId,this.parentDesc,
                this.childId == null ? null : toIntArr(this.childId
                        .replaceAll("'","").split(",")));
    }
}
