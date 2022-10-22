package .PaymentManager.interfaces;


import java.util.EnumSet;
import java.util.Map;

public interface SocketManager {
    void subscribe(EnumSet<StreamSubscriptionEnum> streams,
                   Map<String, Object> parameters,
                   StreamSubscriber subscriber,
                   boolean isReal) throws InvalidStateException;
    void subscribe(EnumSet<StreamSubscriptionEnum> streams,
                   StreamSubscriber subscriber,
                   boolean isReal) throws InvalidStateException;
    void unsubscribe(EnumSet<StreamSubscriptionEnum> streams, boolean isReal) throws InvalidStateException;
    void closeWhenComplete(boolean isReal);

    String sendCommand(String command,
                       Map<String, Object> parameters,
                       CommandListener listener,
                       boolean isReal) throws InvalidStateException;
    String sendCommand(String command,
                       CommandListener listener,
                       boolean isReal) throws InvalidStateException;

    EnumSet<StreamSubscriptionEnum> getActiveSubscriptions(boolean isReal);
}
