package br.com.nlw.events.exceptions;

import br.com.nlw.events.model.Subscription;

public class SubscriptionConflictExecption extends RuntimeException{
    public SubscriptionConflictExecption(String msg){
        super(msg);
    }
}
