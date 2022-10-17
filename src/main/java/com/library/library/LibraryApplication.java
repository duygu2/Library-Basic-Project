package com.library.library;

import com.library.library.model.Account;
import com.library.library.model.Book;
import com.library.library.model.Category;
import com.library.library.repository.AccountRepository;
import com.library.library.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {
	private final AccountRepository accountRepository;
	private final BookRepository bookRepository;

	public LibraryApplication(AccountRepository accountRepository, BookRepository bookRepository) {
		this.accountRepository = accountRepository;
		this.bookRepository = bookRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Account a1=Account.builder()
				.id("123")
				.name("Duygu Orhan")
				.address("Kocaeli-cayırova")
				.telephone("555555555")
				.dateOfBirth(2001)
				.build();
		Account a2=Account.builder()
				.id("1234")
				.name("Ali Isik")
				.address("İstanbul-kartal")
				.telephone("444444444")
				.dateOfBirth(1998)
				.build();
		Account a3=Account.builder()
				.id("12345")
				.name("Nezih Han")
				.address("Kayseri-merkez")
				.telephone("333333333")
				.dateOfBirth(1979)
				.build();

		accountRepository.saveAll(Arrays.asList(a1,a2,a3));

		Book b1=Book.builder()
				.id("1")
				.accountId("12345")
				.name("Aşk ve Gurur")
				.category(Category.LOVE)
				.writer("Jane Austen")
				.page(354)
				.build();
		Book b2=Book.builder()
				.id("2")
				.accountId("1234")
				.name("Mutlu Olma Sanatı")
				.category(Category.ROMAN)
				.writer("Bertand Russel")
				.page(200)
				.build();

		Book b3=Book.builder()
				.id("3")
				.accountId("123")
				.name("Suç ve Ceza")
				.category(Category.DRAMA)
				.writer("Dostyoveski")
				.page(850)
				.build();

		Book b4=Book.builder()
				.id("4")
				.accountId("12345")
				.name("Aşk")
				.category(Category.LOVE)
				.writer("Elif Şafak")
				.page(246)
				.build();

		bookRepository.saveAll(Arrays.asList(b1,b2,b3,b4));

	}
}
