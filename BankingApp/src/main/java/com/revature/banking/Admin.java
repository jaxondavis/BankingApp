package com.revature.banking;

import java.io.Serializable;

public class Admin extends Employee implements Serializable
{
	private static final long serialVersionUID = 8117653648675318681L;
	
	@Override
	public String toString() {
		return "Admin [personName=" + personName + ", userName=" + userName
				+ ", password=" + password + "]";
	}
}
