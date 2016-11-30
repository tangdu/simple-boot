package com.tdu.simple.test.over;

import java.util.List;

import javax.validation.ValidationProviderResolver;
import javax.validation.spi.ValidationProvider;

public class MyValidationProviderResolver implements ValidationProviderResolver{

	@Override
	public List<ValidationProvider<?>> getValidationProviders() {
		return null;
	}

}
