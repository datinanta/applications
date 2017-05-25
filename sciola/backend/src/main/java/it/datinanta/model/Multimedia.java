package it.datinanta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * opera multimedia
 */
@ApiModel(description = "opera multimedia")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-23T21:07:05.946Z")

public class Multimedia   {
  @JsonProperty("id")
  private String id = null;

  /**
   * multimedia type
   */
  public enum TypeEnum {
    AUDIO("audio"),
    
    PHOTO("photo"),
    
    VIDEO("video");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("type")
  private TypeEnum type = null;

  public Multimedia id(String id) {
    this.id = id;
    return this;
  }

   /**
   * multimedia id
   * @return id
  **/
  @ApiModelProperty(value = "multimedia id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Multimedia type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * multimedia type
   * @return type
  **/
  @ApiModelProperty(value = "multimedia type")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Multimedia multimedia = (Multimedia) o;
    return Objects.equals(this.id, multimedia.id) &&
        Objects.equals(this.type, multimedia.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Multimedia {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

