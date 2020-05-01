package me.chillgu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import me.chillgu.demo.account.Account;
import me.chillgu.demo.account.AccountRepository;
import me.chillgu.demo.account.AccountService;

@Component
public class AccountRunner implements ApplicationRunner {
	
	@Autowired
	private AccountService accountService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Account account = accountService.createAccount("donggu", "1234");
		
		System.out.println("username : " + account.getUsername() + " password : " + account.getPassword());
	}
}
