-- 8. Find Full Name 

CREATE PROCEDURE usp_get_holders_full_name()
	SELECT CONCAT_WS (' ', first_name, last_name) AS full_name FROM account_holders
    ORDER BY `full_name`, id;
    
-- 9. People with Balance Higher Than

CREATE PROCEDURE usp_get_holders_with_balance_higher_than(balance_bigger_than DECIMAL(19,4))
		SELECT first_name, last_name FROM account_holders AS ah
        JOIN accounts AS a ON ah.id = a.account_holder_id
        GROUP BY a.account_holder_id
        HAVING SUM(a.balance) > balance_bigger_than
        ORDER BY ah.id;
	
-- 10. Future Value Function

CREATE FUNCTION ufn_calculate_future_value(initial_sum DECIMAL(19,4), rate DOUBLE, years INT)
RETURNS DECIMAL(19,4)
	RETURN initial_sum * POW((1 + rate), years);
    
-- 11. Calculating Interest

CREATE PROCEDURE usp_calculate_future_value_for_account(acc_id INT, rate DECIMAL(19,4))
	SELECT a.id AS account_id, ah.first_name, ah.last_name, a.balance AS current_balance, ufn_calculate_future_value(a.balance, rate, 5) AS balance_in_5_years FROM accounts AS a 
    JOIN account_holders AS ah ON a.account_holder_id = ah.id
    WHERE acc_id = a.id;
    
-- 12. Deposit Money 

DELIMITER $$
CREATE PROCEDURE usp_deposit_money(account_id INT , money_amount DECIMAL(19, 4))
BEGIN
	START TRANSACTION;
    UPDATE accounts AS a
    SET a.balance = a.balance + money_amount
    WHERE a.id = account_id;
    IF (money_amount > 0) 
    THEN COMMIT;
    ELSE ROLLBACK;
    END IF;
END$$

-- 13. Withdraw Money

CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL(19, 4))
BEGIN
	START TRANSACTION;
    UPDATE accounts AS a
    SET a.balance = a.balance - money_amount
    WHERE a.id = account_id;
    IF(money_amount <= 0 OR money_amount > (SELECT balance FROM accounts WHERE id = account_id))
    THEN ROLLBACK;
    ELSE COMMIT;
    END IF;
END$$

-- 14. Money Transfer

CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL(19, 4))
BEGIN
	START TRANSACTION;
    UPDATE accounts AS a
    SET balance = balance - amount
    WHERE from_account_id = a.id;
    UPDATE accounts AS a
    SET balance = balance + amount
    WHERE to_account_id = a.id;
    
    IF(from_account_id = to_account_id OR
		amount <= 0 OR
        (SELECT COUNT(id) FROM accounts WHERE id = from_account_id) != 1 OR
        (SELECT COUNT(id) FROM accounts WHERE id = to_account_id) != 1 OR
        (SELECT balance FROM accounts WHERE from_account_id = id) < amount)
        THEN ROLLBACK;
        ELSE COMMIT;
        END IF;
END$$

-- 15. Log Accounts Trigger

CREATE TABLE `logs`(
log_id INT PRIMARY KEY AUTO_INCREMENT,
account_id INT,
old_sum DECIMAL(19, 4),
new_sum DECIMAL(19, 4)
);


CREATE TRIGGER tr_logs
AFTER UPDATE ON accounts
FOR EACH ROW
	BEGIN
		INSERT INTO logs(account_id, old_sum, new_sum)
        VALUES(OLD.id, OLD.balance, NEW.balance);
    END;

-- 16. Emails Trigger

CREATE TABLE notification_emails(
id INT AUTO_INCREMENT PRIMARY KEY,
recipient INT,
`subject` VARCHAR(255),
body VARCHAR(255)
);


CREATE TRIGGER tr_notification_emails
AFTER INSERT ON `logs`
FOR EACH ROW
	BEGIN
		INSERT INTO notification_emails(recipient, subject, body)
        VALUES(
        NEW.account_id,
        CONCAT('Balance change for account:', NEW.account_id),
        CONCAT('On ', CURRENT_DATE, 'at ', CURRENT_TIME, 'your balance was changed from ', NEW.old_sum, 'to ', NEW.new_sum, '.'));
    END;