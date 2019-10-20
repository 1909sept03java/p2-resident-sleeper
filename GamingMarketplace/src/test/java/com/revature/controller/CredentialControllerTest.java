package com.revature.controller;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.OrmConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = OrmConfiguration.class)
public class CredentialControllerTest {

	private CredentialController credentialController;
	
	@Autowired
	public void setCredentialController(CredentialController credentialController) {
		this.credentialController = credentialController;
	}

	@Test
	public void test() {
		assertThat(credentialController, instanceOf(CredentialController.class));
		//fail("Not yet implemented");
	}

}
