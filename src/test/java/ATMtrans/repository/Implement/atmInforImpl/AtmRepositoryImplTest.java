package ATMtrans.repository.Implement.atmInforImpl;

import ATMtrans.domain.atmInfor.Atm;
import ATMtrans.factory.factoryAtmInfor.AtmFactory;
import ATMtrans.repository.repositoryAtmInf.AtmRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AtmRepositoryImplTest {

    private AtmRepository repository;
    private Atm atm;

    private Atm getSaved(){
        Set<Atm> savedAtm=this.repository.getAll();
        return savedAtm.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository= (AtmRepositoryImpl) AtmRepositoryImpl.getRepository();
        this.atm= AtmFactory.getType("ABSAS");
    }

    @Test
    public void d_getAll() {

        Set<Atm> all =this.repository.getAll();
        System.out.println("In getall,all = " + all);
    }

    @Test
    public void create() {
        Atm created = this.repository.create(this.atm);
        System.out.println("the create, done =" + created);
        d_getAll();
        Assert.assertSame(created, this.atm);
    }

    @Test
    public void update() {
        String newAtmName = "Unused Test name";
        Atm atm = new Atm.Builder().copy(getSaved()).Id(newAtmName).build();
        System.out.println("the update, to be done = " + atm );
       Atm update = this.repository.update(atm);
        System.out.println("the update, done = " + update );
        Assert.assertSame(newAtmName,atm.getId());
        d_getAll();
    }

    @Test
    public void delete() {
        Atm saved = getSaved();
        this.repository.delete(saved.getId());
        d_getAll();

    }

    @Test
    public void read() {
        Atm saved = getSaved();
        System.out.println("the read, Atm read = " + saved.getId());
        Atm read = this.repository.read(saved.getId());
        System.out.println("the read, read = " + read);
        d_getAll();
        Assert.assertEquals(saved,read);

    }
}