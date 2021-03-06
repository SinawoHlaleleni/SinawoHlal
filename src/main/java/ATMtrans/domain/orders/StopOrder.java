package ATMtrans.domain.orders;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class StopOrder implements DebitOrders {

    private double amount = 0;

    private StopOrder() {
    }

    private StopOrder(Builder builder) {
        this.amount = builder.amount;
    }

    public double getAmount() {
        return amount;
    }

    public static class Builder {

        private double amount;


        public Builder amount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder copy(StopOrder stopOrder){
            this.amount = stopOrder.amount;
            return this;
        }

        public StopOrder build() {
            return new StopOrder(this);
        }
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "amount=R" + amount +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        if(this ==obj)return true;
        if(obj == null|| getClass() !=obj.getClass()) return false;
        StopOrder stopOrder = (StopOrder) obj;
        return stopOrder.equals(stopOrder.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);        }
}
