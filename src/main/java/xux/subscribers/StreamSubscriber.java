package src.main.java.xux.subscribers;

import org.json.JSONObject;



public interface StreamSubscriber {
    void onSubscription(StreamSubscriptionEnum subscription, JSONObject message);
}
