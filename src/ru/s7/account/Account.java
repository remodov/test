package ru.s7.account;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Класс счета
 */
public class Account {

    /**
     * У каждого счета есть блокировка,
     */
    private Object lock = new Object();

    /**
     * Идентификатор аккаунта
     */
    private Long accountId;

    /**
     * Сумма счета
     */
    private BigDecimal amount;

    public Account(Long accountId, BigDecimal amount) {
        this.accountId = accountId;
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Object getLock() {
        return lock;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountId, account.accountId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(accountId);
    }
}
