
package main;

import java.time.LocalDate;

/**
 *
 * @author Vinicius Jimenez
 */
public class Installation extends Service implements ServiceOptions{
    public Installation(){
        this.type = "installation";
    }

    @Override
    public String getRequestCode() {
        return "installation" + this.requestCode;
    }

    @Override
    public void postponeDeliveryDate(LocalDate date) {
        this.deliveryDate = date;
    }

    @Override
    public void decreasePrice() {
        this.price = this.price - (this.price * 0.1);
    }

    @Override
    public void cancelService() {
        System.out.println("A instalação foi cancelada com sucesso!");
    }
}
