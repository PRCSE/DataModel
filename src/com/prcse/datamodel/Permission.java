package com.prcse.datamodel;

import java.util.ArrayList;

/*
 * TODO: write class description
 */
public class Permission extends PersistantObject {

	
	// ======== Class Variables ======================================================== //
	
	private static final long serialVersionUID = -3700183972858884680L;
	private ArrayList<Account> accounts;
	private String name;
	
	
	// ======== Class Constructor ====================================================== //
	
	public Permission(String name)
	{
		this.accounts = new ArrayList<Account>();
		this.name = name;
	}

	
	// ======== Class Getters/Setters =================================================== //
	
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	
	public void addAccount(Account account)
	{
		accounts.add(account);
	}
	
	public void removeAccount(Account account)
	{
		accounts.remove(account);
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Permission [accounts=" + accounts + ", name=" + name + "]";
	}
}
