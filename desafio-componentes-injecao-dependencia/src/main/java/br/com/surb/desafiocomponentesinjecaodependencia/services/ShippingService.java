package br.com.surb.desafiocomponentesinjecaodependencia.services;

import br.com.surb.desafiocomponentesinjecaodependencia.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    public double shipiment(Order order){
        double shipiment = 0.0;
        if(order.getBasic() <= 100){
            shipiment = 20.00;
        }else if(order.getBasic() >= 100 && order.getBasic() <= 200 ){
            shipiment = 12.00;
        }
        return shipiment;
    }
}
