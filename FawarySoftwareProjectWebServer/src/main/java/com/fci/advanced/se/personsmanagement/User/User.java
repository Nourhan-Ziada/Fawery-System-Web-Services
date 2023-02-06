package com.fci.advanced.se.personsmanagement.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
@Getter
@Setter
@AllArgsConstructor
public class User {
    private String name ;
    @Autowired
    private Account account ;
    @Autowired
    private  Wallet wallet ;
    @Autowired
    private  UserHistory userHistory ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	public UserHistory getUserHistory() {
		return userHistory;
	}
	public void setUserHistory(UserHistory userHistory) {
		this.userHistory = userHistory;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
}
