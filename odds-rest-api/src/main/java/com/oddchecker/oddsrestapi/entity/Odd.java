package com.oddchecker.oddsrestapi.entity;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.oddchecker.oddsrestapi.validations.Odds;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import lombok.Data;

@Entity
@ApiModel(value="Odds", description="ID of user who is offering the odds")
@Table(name="odds")
@Data
public class Odd {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="betid")
	private Long betId;
	
	
	@NotEmpty(message="Please provide an user id")
	
	@Column(name="userid")
	private String userId;
	
	
	@NotEmpty(message="Please provide an odds")
	@Odds
	
	@Column(name="odds")
	private String odds;
	

	
	
	
}
