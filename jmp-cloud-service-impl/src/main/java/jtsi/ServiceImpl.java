package jtsi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServiceImpl implements Service {
    private List<User> users = new ArrayList<>();
    private List<Subscription> subscriptions = new ArrayList<>();

    public void subscribe(BankCard bankCard) {
        // Create a new subscription with the provided BankCard and current date
        Subscription newSubscription = new Subscription(bankCard.getNumber(), LocalDate.now());

        // Add the new subscription to the list of subscriptions
        subscriptions.add(newSubscription);

        // Update the user associated with the BankCard if present
        Optional<User> userOptional = users.stream()
                .filter(user -> user.equals(bankCard.getUser()))
                .findFirst();

        userOptional.ifPresent(user -> {
            user.addSubscription(newSubscription);
            System.out.println("Subscription successful for user: " + user.getName() + " " + user.getSurname());
        });
    }

    public Optional<Subscription> getSubscriptionByBankCardNumber(String bankCardNumber) {
        return subscriptions.stream()
                .filter(subscription -> subscription.getBankcard().equals(bankCardNumber))
                .findFirst();
    }

    public List<User> getAllUsers() {
        return users;
    }
}