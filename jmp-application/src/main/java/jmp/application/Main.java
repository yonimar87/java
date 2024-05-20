package jmp.application;

import org.example.bank.api.Bank;
import org.example.dto.BankCard;
import org.example.dto.User;
import org.example.service.api.Service;
import org.example.cloud.bank.impl.BankImpl;
import org.example.cloud.service.impl.ServiceImpl;

import java.time.LocalDate;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        // Create instances of BankImpl and ServiceImpl
        Bank bank = new BankImpl();
        Service service = new ServiceImpl();

        // Create a User
        User user = new User("Alice", "Smith", LocalDate.of(1985, 10, 25));

        // Create a BankCard for the user
        BankCard bankCard = new BankCard("1234 5678 9012 3456", user);

        // Demonstrate subscription functionality
        service.subscribe(bankCard);

        // Get a subscription by BankCard number
        Optional<Subscription> subscription = service.getSubscriptionByBankCardNumber(bankCard.getNumber());
        subscription.ifPresent(sub -> System.out.println("Subscription found: " + sub));

        // Get all users
        System.out.println("All Users:");
        service.getAllUsers().forEach(u -> System.out.println(u.getName() + " " + u.getSurname()));
    }
}