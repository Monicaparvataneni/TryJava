package com.monica.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	// basic way is by diffrent urls
	@GetMapping("V1/person")
	public PersonV1 personV1() {
		return new PersonV1("monica Parvataneni");
	}

	@GetMapping("V2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Balu", "Tadikonda"));
	}

	// next way is via param in url
	@GetMapping(value = "/person/param", params = "version=1")
	public PersonV1 paramV1() {
		return new PersonV1("parammonica Parvataneni");
	}

	@GetMapping(value = "/person/param", params = "version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("paramBalu", "Tadikonda"));
	}
	// next way by passing header params in request

	@GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("hmonica Parvataneni");
	}

	@GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("hBalu", "Tadikonda"));

	}
	//last way is using produces called mime type verisoning/mediatype verisoning/content negocication

	@GetMapping(value = "/person/produce", produces = "application/v1+json")
	public PersonV1 produceV1() {
		return new PersonV1("pmonica Parvataneni");
	}

	@GetMapping(value = "/person/produce", produces = "application/v2+json")
	public PersonV2 produceV2() {
		return new PersonV2(new Name("pBalu", "Tadikonda"));

	}
	

}
