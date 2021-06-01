package br.com.alura.ecommerce;


import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain{

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //quem envia a mensagem
       try(var dispatcher = new KafkaDispatcher()){
            for (var i = 0; i < 10; i++) {
                var key = UUID.randomUUID().toString();
                var value = key + "442,4321,1324";
                dispatcher.send("ECOMMERCE_NEW_ORDER", key, value);
                var email = "Obrigada. Estamos processando sua compra.";
                dispatcher.send("ECOMMERCE_SEND_EMAIL", key, email);
            }
       }
    }
}
