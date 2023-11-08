package com.fullstack.examen.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArtworkDescriptionValid implements ConstraintValidator<ArtworkDescriptionValidator, String> {

	@Override
	public void initialize(ArtworkDescriptionValidator constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if (value == null || value.trim().isEmpty()) {
			return false;
		}
		String[] palabras = value.trim().split("\\s+");
		return palabras.length >= 5;
	}

}