package bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class ListCompare Решение задачи Банковские переводы
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 23.05.2018
 */
public class AccountManagement {
    private HashMap<User, List<Account>> account = new HashMap<>();

    /**
     * add new user
     *
     * @param user - for add
     */
    public void addUser(User user) {
        this.account.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * delete user from Map
     *
     * @param user - for delete
     */
    public void deleteUser(User user) {
        this.account.remove(user);
    }

    /**
     * add new account for user
     *
     * @param passport   - identification data for user in String format
     * @param newAccount - for add
     */
    public void addAccountToUser(String passport, Account newAccount) {
        for (HashMap.Entry<User, List<Account>> entry : account.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                entry.getValue().add(newAccount);
            }
        }
    }

    /**
     * delete user's account
     *
     * @param passport      - identification data for user in String format
     * @param deleteAccount - for delete
     */
    public void deleteAccountFromUser(String passport, Account deleteAccount) {
        for (HashMap.Entry<User, List<Account>> entry : account.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                entry.getValue().remove(deleteAccount);
            }
        }
    }

    /**
     * get all accounts for user
     *
     * @param passport - identification data for user in String format
     * @return list with all account user's
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> accounts = new ArrayList<>();
        for (HashMap.Entry<User, List<Account>> entry : account.entrySet()) {
            if (entry != null && entry.getKey().getPassport().equals(passport)) {
                accounts = entry.getValue();
            }
        }
        return accounts;
    }

    /**
     * transfer money between accounts
     *
     * @param srcPassport  source passport data
     * @param srcRequisite source account's requisite data
     * @param destPassport destination user (passport data)
     * @param dstRequisite destination account
     * @param amount       - for transfer
     * @return true or false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite,
                                 double amount) {
        Account srcAccount = getAccount(getUser(srcPassport), srcRequisite);
        Account dstAccount = getAccount(getUser(destPassport), dstRequisite);
        boolean result = srcAccount != null && dstAccount != null && checkValue(srcAccount, amount);
        if (result) {
            srcAccount.setValue(srcAccount.getValue() - amount);
            dstAccount.setValue(dstAccount.getValue() + amount);
        }
        return result;
    }

    /**
     * get user for transfer, search on passport data
     *
     * @param passport - sting format
     * @return - user
     */
    public User getUser(String passport) {
        User userFounded = new User();
        for (HashMap.Entry<User, List<Account>> entry : account.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                userFounded = entry.getKey();
            }
        }
        return userFounded;
    }

    /**
     * get account for transfer
     *
     * @param user      - user (key)
     * @param requisite - for search account
     * @return account
     */
    private Account getAccount(User user, String requisite) {
        List<Account> userAccounts = getUserAccounts(user.getPassport());
        Account accountFounded = new Account();
        for (Account account1 : userAccounts) {
            if (account1.getRequisites().equals(requisite)) {
                accountFounded = account1;
            }
        }
        return accountFounded;
    }

    /**
     * check value for compliance
     *
     * @param account founded account
     * @param amount  - money
     * @return true or false
     */
    private boolean checkValue(Account account, double amount) {
        return account.getValue() - amount >= 0;
    }
}