package com.br.users.apiusers.api.openapi.model;

import java.util.Objects;
import com.br.users.apiusers.api.openapi.model.DadosUsuarioResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Lista com os dados dos usuários.
 */
@ApiModel(description = "Lista com os dados dos usuários.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-04-12T14:56:11.923620-03:00[America/Sao_Paulo]")
public class ListaDadosUsuarios   {
  @JsonProperty("dadosUsuarioResponse")
  @Valid
  private List<DadosUsuarioResponse> dadosUsuarioResponse = null;

  public ListaDadosUsuarios dadosUsuarioResponse(List<DadosUsuarioResponse> dadosUsuarioResponse) {
    this.dadosUsuarioResponse = dadosUsuarioResponse;
    return this;
  }

  public ListaDadosUsuarios addDadosUsuarioResponseItem(DadosUsuarioResponse dadosUsuarioResponseItem) {
    if (this.dadosUsuarioResponse == null) {
      this.dadosUsuarioResponse = new ArrayList<>();
    }
    this.dadosUsuarioResponse.add(dadosUsuarioResponseItem);
    return this;
  }

  /**
   * Get dadosUsuarioResponse
   * @return dadosUsuarioResponse
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<DadosUsuarioResponse> getDadosUsuarioResponse() {
    return dadosUsuarioResponse;
  }

  public void setDadosUsuarioResponse(List<DadosUsuarioResponse> dadosUsuarioResponse) {
    this.dadosUsuarioResponse = dadosUsuarioResponse;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListaDadosUsuarios listaDadosUsuarios = (ListaDadosUsuarios) o;
    return Objects.equals(this.dadosUsuarioResponse, listaDadosUsuarios.dadosUsuarioResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dadosUsuarioResponse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListaDadosUsuarios {\n");
    
    sb.append("    dadosUsuarioResponse: ").append(toIndentedString(dadosUsuarioResponse)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

