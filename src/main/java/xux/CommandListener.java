package src.main.java.xux.sockets.interfaces;

import org.json.JSONObject;

public interface CommandListener {
    void onResponse(JSONObject response);
}
