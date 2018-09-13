package com.fimc.hello.resource;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class PeopleRequest implements Serializable{
	private String firstName;
	private String lastName;
	private String birthDate;
}
