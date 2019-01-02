package com.hcl.example.ticketHeatMap.server.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Ticket
 */
@SuppressWarnings("unused")
@Validated
public class Ticket   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("region")
  private String region = null;

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
  @ApiModelProperty(required = true)
  @NotNull

  @Valid

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }


  public Ticket region(String region) {
    this.region = region;
    return this;
  }

  @ApiModelProperty(required = true)
  @NotNull
  @Valid
  public String getRegion() {return region;}

  public void setRegion(String region) {this.region = region;}


  public Ticket location(Geocode location) {
    this.location = location;
    return this;
  }


  /**
   * Get location
   * @return location
  **/
  @ApiModelProperty(required = true)
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
  @ApiModelProperty()

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
    return "class Ticket {\n" +
            "    id: " + toIndentedString(id) + "\n" +
            "    status: " + toIndentedString(status) + "\n" +
            "    location: " + toIndentedString(location) + "\n" +
            "    urgency: " + toIndentedString(urgency) + "\n" +
            "}";
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

