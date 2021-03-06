package ATMtrans.repository.Implement.bankInforImpl;

import ATMtrans.domain.bankInfor.Bank;
import ATMtrans.factory.factoryBankInfor.BankFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BankRepositoryImplTest {

    private BankRepositoryImpl repository;
    private Bank bank;

    private Bank getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.bank= BankFactory.getName("ABSAS");
    }

    @Test
    public void d_getAll() {
        Set<Bank> all =this.repository.getAll();
        System.out.println("In getall,all = " + all);
    }

    @Test
    public void create() {
        Bank created = this.repository.create(this.bank);
        System.out.println("the create, done =" + created);
        d_getAll();
        Assert.assertSame(created, this.bank);
    }

    @Test
    public void update() {

        String newBankName = "Unused bank name";
        Bank bank = new Bank.Builder().copy(getSaved()).Id(newBankName).build();
        System.out.println("the update,to be done = " + bank );
        Bank updated = this.repository.update(bank);
        System.out.println("the updates, done = " + updated );
        Assert.assertSame(newBankName,updated.getId());
        d_getAll();
    }

    @Test
    public void delete() {

        Bank saved = getSaved();
        this.repository.delete(saved.getId());
        d_getAll();
    }

    @Test
    public void read() {

        Bank saved = getSaved();
        Bank read = this.repository.read(saved.getId());
        System.out.println("the read, read = " + read);
        Assert.assertSame(read,saved);
    }
}