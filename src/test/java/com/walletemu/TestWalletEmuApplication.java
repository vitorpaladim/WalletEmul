package com.walletemu;

import org.springframework.boot.SpringApplication;

public class TestWalletEmuApplication {

	public static void main(String[] args) {
		SpringApplication.from(WalletEmuApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
