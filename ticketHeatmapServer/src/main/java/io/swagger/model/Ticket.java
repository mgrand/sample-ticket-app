package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Geocode;
import io.swagger.model.Status;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Ticket
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-30T19:37:21.031Z")

public class Ticket   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("status")
  private Status status = null;

  @JsonProperty("location")
  private Geocode location = null;

  @JsonProperty("urgency")
  private Integer urgency = null;

  public Ticket id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier for ticket
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Unique identifier for ticket")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Ticket status(Status status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Ticket location(Geocode location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Geocode getLocation() {
    return location;
  }

  public void setLocation(Geocode location) {
    this.location = location;
  }

  public Ticket urgency(Integer urgency) {
    this.urgency = urgency;
    return this;
  }

  /**
   * Get urgency
   * minimum: 1
   * maximum: 100
   * @return urgency
  **/
  @ApiModelProperty(value = "")

@Min(1) @Max(100) 
  public Integer getUrgency() {
    return urgency;
  }

  public void setUrgency(Integer urgency) {
    this.urgency = urgency;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ticket ticket = (Ticket) o;
    return Objects.equals(this.id, ticket.id) &&
        Objects.equals(this.status, ticket.status) &&
        Objects.equals(this.location, ticket.location) &&
        Objects.equals(this.urgency, ticket.urgency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, location, urgency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ticket {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    urgency: ").append(toIndentedString(urgency)).append("\n");
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

