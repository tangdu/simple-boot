package com.tdu.simple.test.validate;

import java.util.Calendar;
import java.util.Date;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import org.junit.Test;

import com.tdu.simple.test.over.MyValidationProviderResolver;

public class CustValidateTest {

	@Test
	public void 测试验证() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		javax.validation.Validator validator = factory.getValidator();
		SimpleBean simpleBean = new SimpleBean();
		simpleBean.setName("12321");

		long s = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			// Set<ConstraintViolation<SimpleBean>> constraintViolations =
			// validator.validate(simpleBean);
			// StringBuilder builder = new StringBuilder();
			// for (ConstraintViolation<SimpleBean> constraintViolation :
			// constraintViolations) {
			// builder.append(constraintViolation.getMessage());
			// }
			// System.out.println(builder.toString());
			javax.validation.metadata.BeanDescriptor b = validator.getConstraintsForClass(SimpleBean.class);
			validator.validate(simpleBean, Default.class);
		}
		long e = System.currentTimeMillis();
		System.out.println(e - s);
	}

	public class SimpleBean2 {
		@NotNull
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}
	
	@Test
	public void dddd(){
		Calendar a=Calendar.getInstance();
		a.add(Calendar.DATE, 1);
		System.out.println(a.getTime().compareTo(new Date())>0);
	}

}
