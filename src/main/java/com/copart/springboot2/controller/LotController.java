/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.copart.springboot2.controller;


import com.copart.springboot2.model.Lot;
import com.copart.springboot2.repository.LotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController(value = "/lots")
public class LotController {

	@Autowired
	LotRepository repository;

	@GetMapping
	public Flux<Lot> getLots() {
		return this.repository.findAll().log();
	}

	@GetMapping(path = "/stream", produces = "application/stream+json")
	public Flux<Lot> getCarStream() {
		return this.repository.findLotsBy().log();
	}


}
