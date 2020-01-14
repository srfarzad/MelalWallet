package com.navin.melalwallet.EventBus;

public class Events {
    public static class FragmenActivityMessage{
        private String message;
        public FragmenActivityMessage(String message){
            this.message=message;

        }
        public String getMessage(){
            return message;
        }
    }
}
