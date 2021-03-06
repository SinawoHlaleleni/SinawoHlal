package ATMtrans.repository.Implement.atmInforImpl;

import ATMtrans.domain.account.Account;
import ATMtrans.domain.atmInfor.Atm;
import ATMtrans.repository.repositoryAtmInf.AtmRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AtmRepositoryImpl implements AtmRepository {

    public static AtmRepositoryImpl repository = null;
    private Map<String, Atm> AtmTable;

    private AtmRepositoryImpl() {
        AtmTable = new HashMap<>();
    }

    public static AtmRepository getRepository(){
        if (repository == null) repository = new AtmRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Atm> getAll() {
        return this.getAll();
    }

    @Override
    public Atm create(Atm atm) {
        AtmTable.put(Atm.getType(),atm);
        Atm atm1 = AtmTable.get(Atm.getType());
        return atm1;
    }

    @Override
    public Atm update(Atm atm) {
        AtmTable.put(Atm.getType(),atm);
        Atm atm1 = AtmTable.get(Atm.getType());
        return atm1;
    }

    @Override
    public Account delete(String s) {
        //AtmTable.remove(s);

        return this.delete(s);
    }

    @Override
    public Atm read(String s) {
        Atm atm = AtmTable.get(s);
        return atm;
    }
}
