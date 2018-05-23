package ru.job4j.bank;

import bank.Account;
import bank.AccountManagement;
import bank.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ListCompare Решение задачи Банковские переводы
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 23.05.2018
 */
public class AccountManagementTest {
    /**
     * test add user
     */
    @Test
    public void whenAddUserThenMapContainUser() {
        User user = new User("Sergey", "123");
        AccountManagement am = new AccountManagement();
        am.addUser(user);
        assertThat(am.getUser("123"), is(user));
    }

    /**
     * test delete user
     */
    @Test
    public void whenDeleteUserThenMapNotContainUser() {
        User user = new User("Sergey", "123");
        AccountManagement am = new AccountManagement();
        am.addUser(user);
        assertThat(am.getUser("123"), is(user));
        am.deleteUser(user);
        assertThat(am.getUser("123").equals(user), is(false));
    }

    /**
     * test add user and accounts
     */
    @Test
    public void whenAddUserAndAccountsThenMapContainUserAndAccounts() {
        User user = new User("Sergey", "123");
        Account accountUser = new Account(2353D, "00123");
        Account accountUser2 = new Account(235D, "001234");
        List<Account> accounts = new ArrayList<>();
        accounts.add(accountUser);
        accounts.add(accountUser2);
        AccountManagement am = new AccountManagement();
        am.addUser(user);
        am.addAccountToUser(user.getPassport(), accountUser);
        am.addAccountToUser(user.getPassport(), accountUser2);
        assertThat(am.getUser("123"), is(user));
        assertThat(am.getUserAccounts("123"), is(accounts));
    }

    /**
     * test delete account
     */
    @Test
    public void whenDeleteAccountThenMapContainUserWithoutAccount() {
        User user = new User("Sergey", "123");
        Account accountUser = new Account(2353D, "00123");
        Account accountUser2 = new Account(235D, "001234");
        List<Account> accounts = new ArrayList<>();
        accounts.add(accountUser);
        accounts.add(accountUser2);
        AccountManagement am = new AccountManagement();
        am.addUser(user);
        am.addAccountToUser(user.getPassport(), accountUser);
        am.addAccountToUser(user.getPassport(), accountUser2);
        assertThat(am.getUser("123"), is(user));
        assertThat(am.getUserAccounts("123"), is(accounts));
        am.deleteAccountFromUser("123", accountUser2);
        accounts.remove(accountUser2);
        assertThat(am.getUserAccounts("123"), is(accounts));
    }

    /**
     * test transfer money between user's accounts
     */
    @Test
    public void whenTransferThenNewValueFor1User() {
        User user = new User("Sergey", "123");
        Account accountUser = new Account(2353D, "00123");
        Account accountUser2 = new Account(235D, "001234");
        AccountManagement am = new AccountManagement();
        am.addUser(user);
        am.addAccountToUser(user.getPassport(), accountUser);
        am.addAccountToUser(user.getPassport(), accountUser2);
        am.transferMoney("123", "00123", "123", "001234", 700D);
        assertThat(am.getUserAccounts("123").get(0).getValue(), is(1653D));
        assertThat(am.getUserAccounts("123").get(1).getValue(), is(935D));
    }

    /**
     * test transfer money between users
     */
    @Test
    public void whenTransferThenNewValueFor2Users() {
        User user = new User("Sergey", "123");
        Account accountUser = new Account(235D, "001234");
        User user2 = new User("Max", "987");
        Account accountUser2 = new Account(2005D, "94282");
        AccountManagement am = new AccountManagement();
        am.addUser(user);
        am.addUser(user2);
        am.addAccountToUser(user.getPassport(), accountUser);
        am.addAccountToUser(user2.getPassport(), accountUser2);
        am.transferMoney("987", "94282", "123",
                "001234", 700D);
        assertThat(am.getUserAccounts("987").get(0).getValue(), is(1305D));
        assertThat(am.getUserAccounts("123").get(0).getValue(), is(935D));
        assertThat(am.transferMoney("987", "94282", "123",
                "001234", 700D), is(true));
        assertThat(am.transferMoney("987", "94282", "123",
                "001234", 700D), is(false));
    }
}