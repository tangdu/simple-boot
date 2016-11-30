package com.tdu.simple.test.over;

import java.io.InputStream;

import javax.validation.BootstrapConfiguration;
import javax.validation.Configuration;
import javax.validation.ConstraintValidatorFactory;
import javax.validation.MessageInterpolator;
import javax.validation.ParameterNameProvider;
import javax.validation.TraversableResolver;
import javax.validation.ValidatorFactory;

public class MyConfiguration implements Configuration {

	@Override
	public Configuration ignoreXmlConfiguration() {
		return null;
	}

	@Override
	public Configuration messageInterpolator(MessageInterpolator interpolator) {
		return null;
	}

	@Override
	public Configuration traversableResolver(TraversableResolver resolver) {
		return null;
	}

	@Override
	public Configuration constraintValidatorFactory(ConstraintValidatorFactory constraintValidatorFactory) {
		return null;
	}

	@Override
	public Configuration parameterNameProvider(ParameterNameProvider parameterNameProvider) {
		return null;
	}

	@Override
	public Configuration addMapping(InputStream stream) {
		return null;
	}

	@Override
	public Configuration addProperty(String name, String value) {
		return null;
	}

	@Override
	public MessageInterpolator getDefaultMessageInterpolator() {
		return null;
	}

	@Override
	public TraversableResolver getDefaultTraversableResolver() {
		return null;
	}

	@Override
	public ConstraintValidatorFactory getDefaultConstraintValidatorFactory() {
		return null;
	}

	@Override
	public ParameterNameProvider getDefaultParameterNameProvider() {
		return null;
	}

	@Override
	public BootstrapConfiguration getBootstrapConfiguration() {
		return null;
	}

	@Override
	public ValidatorFactory buildValidatorFactory() {
		return null;
	}

}
