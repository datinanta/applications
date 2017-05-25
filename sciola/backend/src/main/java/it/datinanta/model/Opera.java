package it.datinanta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Opera
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-23T21:07:05.946Z")

public class Opera   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("author")
  private String author = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("category")
  private String category = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("year")
  private BigDecimal year = null;

  @JsonProperty("material")
  private String material = null;

  @JsonProperty("position")
  private Object position = null;

  @JsonProperty("dimensions")
  private Object dimensions = null;

  @JsonProperty("multimedia")
  private List<Multimedia> multimedia = new ArrayList<Multimedia>();

  public Opera id(String id) {
    this.id = id;
    return this;
  }

   /**
   * opera id
   * @return id
  **/
  @ApiModelProperty(value = "opera id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Opera author(String author) {
    this.author = author;
    return this;
  }

   /**
   * opera author.
   * @return author
  **/
  @ApiModelProperty(value = "opera author.")
  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Opera name(String name) {
    this.name = name;
    return this;
  }

   /**
   * opera name.
   * @return name
  **/
  @ApiModelProperty(value = "opera name.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Opera category(String category) {
    this.category = category;
    return this;
  }

   /**
   * opera type.
   * @return category
  **/
  @ApiModelProperty(value = "opera type.")
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Opera description(String description) {
    this.description = description;
    return this;
  }

   /**
   * opera description
   * @return description
  **/
  @ApiModelProperty(value = "opera description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Opera year(BigDecimal year) {
    this.year = year;
    return this;
  }

   /**
   * year of completion
   * @return year
  **/
  @ApiModelProperty(value = "year of completion")
  public BigDecimal getYear() {
    return year;
  }

  public void setYear(BigDecimal year) {
    this.year = year;
  }

  public Opera material(String material) {
    this.material = material;
    return this;
  }

   /**
   * oepra material.
   * @return material
  **/
  @ApiModelProperty(value = "oepra material.")
  public String getMaterial() {
    return material;
  }

  public void setMaterial(String material) {
    this.material = material;
  }

  public Opera position(Object position) {
    this.position = position;
    return this;
  }

   /**
   * GPS opera position.
   * @return position
  **/
  @ApiModelProperty(value = "GPS opera position.")
  public Object getPosition() {
    return position;
  }

  public void setPosition(Object position) {
    this.position = position;
  }

  public Opera dimensions(Object dimensions) {
    this.dimensions = dimensions;
    return this;
  }

   /**
   * opera dimensions.
   * @return dimensions
  **/
  @ApiModelProperty(value = "opera dimensions.")
  public Object getDimensions() {
    return dimensions;
  }

  public void setDimensions(Object dimensions) {
    this.dimensions = dimensions;
  }

  public Opera multimedia(List<Multimedia> multimedia) {
    this.multimedia = multimedia;
    return this;
  }

  public Opera addMultimediaItem(Multimedia multimediaItem) {
    this.multimedia.add(multimediaItem);
    return this;
  }

   /**
   * multimedia ids.
   * @return multimedia
  **/
  @ApiModelProperty(value = "multimedia ids.")
  public List<Multimedia> getMultimedia() {
    return multimedia;
  }

  public void setMultimedia(List<Multimedia> multimedia) {
    this.multimedia = multimedia;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Opera opera = (Opera) o;
    return Objects.equals(this.id, opera.id) &&
        Objects.equals(this.author, opera.author) &&
        Objects.equals(this.name, opera.name) &&
        Objects.equals(this.category, opera.category) &&
        Objects.equals(this.description, opera.description) &&
        Objects.equals(this.year, opera.year) &&
        Objects.equals(this.material, opera.material) &&
        Objects.equals(this.position, opera.position) &&
        Objects.equals(this.dimensions, opera.dimensions) &&
        Objects.equals(this.multimedia, opera.multimedia);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, author, name, category, description, year, material, position, dimensions, multimedia);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Opera {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("    material: ").append(toIndentedString(material)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
    sb.append("    dimensions: ").append(toIndentedString(dimensions)).append("\n");
    sb.append("    multimedia: ").append(toIndentedString(multimedia)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

