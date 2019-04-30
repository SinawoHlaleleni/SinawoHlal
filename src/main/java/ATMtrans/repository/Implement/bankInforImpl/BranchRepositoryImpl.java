package ATMtrans.repository.Implement.bankInforImpl;

import ATMtrans.domain.account.Account;
import ATMtrans.domain.bankInfor.Branch;
import ATMtrans.repository.repositoryBankInfor.BranchRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BranchRepositoryImpl implements BranchRepository {
    public static BranchRepositoryImpl repository = null;
    private Map<String, Branch> BranchTable;

    private BranchRepositoryImpl() {
        BranchTable = new HashMap<String, Branch>();
    }

    public static BranchRepository getRepository(){
        if (repository == null) repository = new BranchRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Branch> getAll() {
        return null;
    }

    @Override
    public Branch create(Branch branch) {
        BranchTable.put(branch.getName(),branch);
        Branch branch1 = BranchTable.get(branch.getName());
        return branch1;

    }

    @Override
    public Branch update(Branch branch) {
        BranchTable.put(branch.getName(),branch);
        Branch branch1 = BranchTable.get(branch.getName());
        return branch1;

    }

    @Override
    public Account delete(String s) {
        BranchTable.remove(s);
        return null;
    }
    @Override
    public Branch read(String s)
    {
        Branch branch = BranchTable.get(s);
        return branch;
    }
}