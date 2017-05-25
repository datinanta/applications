package it.datinanta.model;

import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * MultimediaStream
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-23T21:07:05.946Z")

public class MultimediaStream   {

  @JsonProperty("id")
  private String id= UUID.randomUUID().toString();

  @JsonProperty("stream")
  private byte[] stream = null;

  @JsonProperty("item")
  private Multimedia item = null;

  public MultimediaStream stream(byte[] stream) {
    this.stream = stream;
    return this;
  }

   /**
   * base64 multimedia file stream
   * @return stream
  **/
  @ApiModelProperty(value = "base64 multimedia file stream")
  public byte[] getStream() {
    return stream;
  }

  public void setStream(byte[] stream) {
    this.stream = stream;
  }

  public MultimediaStream item(Multimedia item) {
    this.item = item;
    return this;
  }

   /**
   * Get item
   * @return item
  **/
  @ApiModelProperty(value = "")
  public Multimedia getItem() {
    return item;
  }

  public void setItem(Multimedia item) {
    this.item = item;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MultimediaStream multimediaStream = (MultimediaStream) o;
    return Objects.equals(this.stream, multimediaStream.stream) &&
        Objects.equals(this.item, multimediaStream.item);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stream, item);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MultimediaStream {\n");
    
    sb.append("    stream: ").append(toIndentedString(stream)).append("\n");
    sb.append("    item: ").append(toIndentedString(item)).append("\n");
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

