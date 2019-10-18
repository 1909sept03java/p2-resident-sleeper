package com.revature.service;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.OrmConfiguration;
import com.revature.model.Credential;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = OrmConfiguration.class)
public class CredentialServiceTest {

	private Credential cred;
	
	@Autowired
	public void setCredential(Credential cred) {
		this.cred = cred;
	}
	

	@Test
	public void test() {
		System.out.println(cred);
		//fail("Not yet implemented");
	}

}
