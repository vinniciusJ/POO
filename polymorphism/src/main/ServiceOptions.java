package main;

import java.time.LocalDate;

/**
 *
 * @author Vinicius Jimenez
 */
public interface ServiceOptions{
    public void postponeDeliveryDate(LocalDate date);
    public void decreasePrice();
    public void cancelService();
}
