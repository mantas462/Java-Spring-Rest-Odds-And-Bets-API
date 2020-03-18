package com.oddchecker.oddsrestapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oddchecker.oddsrestapi.dao.OddRepository;
import com.oddchecker.oddsrestapi.entity.Odd;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;

@RestController
@RequestMapping("/api")
@Api(tags="odds", description="Offer and return Odds")
public class OddController {

	@Autowired
	OddRepository oddRepository;

	
	

	@ApiOperation(value = "Find Odds by Bet ID", produces="application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Odds are returned for the bet ID"),
			@ApiResponse(code = 400, message = "Invalid Bet ID supplied"),
			@ApiResponse(code = 404, message = "Bet not found for given ID")})
	@ApiImplicitParams({
		@ApiImplicitParam(name = "betId", value = "ID of bet to return", paramType = "path", dataType = "Bet", required=true, type = "integer", format ="int64") })
	
	@GetMapping("/odds/{betId}")
	public Optional<Odd> getOdd(@PathVariable long betId) {

		Optional<Odd> odd = oddRepository.findById(betId);

		return odd;
	}
	
	@ApiOperation(value = "Offer odds for a bet", produces="application/json")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Odds have been created for bet"),
			@ApiResponse(code = 400, message = "Invalid format of Odds") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "body", value = "Odds that should be offered for a bet", paramType = "body", dataType = "Odds", required=true) })
	
	@PostMapping("/odds")
	public Odd addOdd(@Valid @RequestBody Odd odd) {
		odd.setBetId((long) 0);
		oddRepository.save(odd);
		return odd;
	}



}
