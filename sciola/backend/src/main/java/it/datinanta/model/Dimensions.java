package it.datinanta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * Dimensions
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-23T21:07:05.946Z")

public class Dimensions   {
  @JsonProperty("height")
  private Double height = null;

  @JsonProperty("width")
  private Double width = null;

  @JsonProperty("depth")
  private Double depth = null;

  @JsonProperty("weight")
  private Double weight = null;

  public Dimensions height(Double height) {
    this.height = height;
    return this;
  }

   /**
   * max opera height in cm
   * @return height
  **/
  @ApiModelProperty(value = "max opera height in cm")
  public Double getHeight() {
    return height;
  }

  public void setHeight(Double height) {
    this.height = height;
  }

  public Dimensions width(Double width) {
    this.width = width;
    return this;
  }

   /**
   * max opera width in cm
   * @return width
  **/
  @ApiModelProperty(value = "max opera width in cm")
  public Double getWidth() {
    return width;
  }

  public void setWidth(Double width) {
    this.width = width;
  }

  public Dimensions depth(Double depth) {
    this.depth = depth;
    return this;
  }

   /**
   * max opera depth in cm
   * @return depth
  **/
  @ApiModelProperty(value = "max opera depth in cm")
  public Double getDepth() {
    return depth;
  }

  public void setDepth(Double depth) {
    this.depth = depth;
  }

  public Dimensions weight(Double weight) {
    this.weight = weight;
    return this;
  }

   /**
   * opera weight in kg's
   * @return weight
  **/
  @ApiModelProperty(value = "opera weight in kg's")
  public Double getWeight() {
    return weight;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Dimensions dimensions = (Dimensions) o;
    return Objects.equals(this.height, dimensions.height) &&
        Objects.equals(this.width, dimensions.width) &&
        Objects.equals(this.depth, dimensions.depth) &&
        Objects.equals(this.weight, dimensions.weight);
  }

  @Override
  public int hashCode() {
    return Objects.hash(height, width, depth, weight);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Dimensions {\n");
    
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    width: ").append(toIndentedString(width)).append("\n");
    sb.append("    depth: ").append(toIndentedString(depth)).append("\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
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

