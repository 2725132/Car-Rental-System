package com.mainsystem.identity.aggregate;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @Embeddable @NoArgsConstructor
public class Adress {
	String city;
	String street;
	int number;
}
