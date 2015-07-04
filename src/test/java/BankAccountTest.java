import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.xiaoqiaotq.Application;
import org.xiaoqiaotq.domain.Address;
import org.xiaoqiaotq.domain.BankAccount;
import org.xiaoqiaotq.domain.User;
import org.xiaoqiaotq.repository.BankAccountRepository;
import org.xiaoqiaotq.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author: xiaoqiaotq@gmail.com
 * date  : 2015/5/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@TransactionConfiguration(defaultRollback=false)
public class BankAccountTest {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Test
    public void save() {
        String username="zhsan";
        int money=0;
        BankAccount     bankAccount=new BankAccount(username,money);
        bankAccountRepository.save(bankAccount);
    }
    @Test
    @Transactional
    public void test1() {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
//        for (int i = 0; i < 100; i++) {
//            executorService.submit(()->{
//            String username = "zhsan";
//            int money = 0;
//            BankAccount bankAccount = null;
//            if ((bankAccount = bankAccountRepository.findByUsername(username)) != null) {
//                bankAccountRepository.incrementMoney(bankAccount.getId());
//            } else {
//                bankAccount = new BankAccount(username, money);
//                bankAccountRepository.save(bankAccount);
//            }
//            });
//        }

    }
}
