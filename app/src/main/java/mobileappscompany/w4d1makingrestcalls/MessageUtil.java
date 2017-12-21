package mobileappscompany.w4d1makingrestcalls;

import android.os.Bundle;
import android.os.Message;

/**
 * Created by fallaye on 12/18/17.
 */

public class MessageUtil {

    public static Message getMessage(String data) {
        Bundle bundle = new Bundle();
        bundle.putString("data", data);

        Message message = new Message();
        message.setData(bundle);
        return message;

    }
}
