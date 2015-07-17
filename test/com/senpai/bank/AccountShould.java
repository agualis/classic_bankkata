package com.senpai.bank;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountShould {

    private Account account;
    @Mock Console console;

    @Before
    public void init(){
        account = new Account(console);
    }

    @Test public void
    have_zero_initial_balance() {
        assertThat(account.balance() , is(0));
    }

    @Test public void
    increase_balance_after_deposit() {
        account.deposit(1000);

        assertThat(account.balance(), is(1000));
    }

    @Test public void
    decrease_balance_after_withdrawal() {
        account.withdraw(1000);

        assertThat(account.balance(), is(-1000));
    }

    @Test public void
    print_header_when_printing() {

        account.printStatement();

        verify(console).printLine("TRANSACTION | AMOUNT | BALANCE");
    }

    @Test public void
    save_transaction_when_depositing() {
        account.deposit(1000);

        assertThat(account.transaction().date(), is("2015/07/17"));
        assertThat(account.transaction().amount(), is(1000));
    }

    @Test public void
    save_transaction_when_withdrawing() {
        account.withdraw(500);

        assertThat(account.transaction().date(), is("2015/07/17"));
        assertThat(account.transaction().amount(), is(-500));
    }

    @Test public void
    save_several_transactions_when_performing_several_transactions() {
        account.deposit(100);
        account.withdraw(200);
        account.deposit(500);

        assertThat(account.transactions(), contains(transaction(100, "2015/07/17"),
                                                    transaction(-200, "2015/07/17"),
                                                    transaction(500, "2015/07/17")));
    }

    private Transaction transaction(int amount, String date) {
        return new Transaction(amount, date);
    }


}