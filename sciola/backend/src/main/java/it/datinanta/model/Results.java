package it.datinanta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Results
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-23T21:07:05.946Z")

public class Results   {
  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("errors")
  private List<Errors> errors = new ArrayList<Errors>();

  public Results status(Integer status) {
    this.status = status;
    return this;
  }

   /**
   * http status.
   * @return status
  **/
  @ApiModelProperty(value = "http status.")
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Results errors(List<Errors> errors) {
    this.errors = errors;
    return this;
  }

  public Results addErrorsItem(Errors errorsItem) {
    this.errors.add(errorsItem);
    return this;
  }

   /**
   * errors list.
   * @return errors
  **/
  @ApiModelProperty(value = "errors list.")
  public List<Errors> getErrors() {
    return errors;
  }

  public void setErrors(List<Errors> errors) {
    this.errors = errors;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Results results = (Results) o;
    return Objects.equals(this.status, results.status) &&
        Objects.equals(this.errors, results.errors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, errors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Results {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
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

