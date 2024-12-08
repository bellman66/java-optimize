package reactor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CallbackSample {

    interface Callback {
        String afterExecute(String name, Callback callback);
    }

    static class Task {
        static String execute(String id, Callback callback1) {
            String name = getName(id);

            return callback1.afterExecute(name, (name2, callback2) ->
                    callback2.afterExecute(name2 + " and ", (name1, callback3) ->
                            name1 + " or "
                    )
            );
        }

        static String getName(String id) {
            return "Task name : " + id;
        }
    }


    @Test
    void callbackSample() {
        // given
        Callback first = (name, nextCallback) ->
                nextCallback.afterExecute(name, (name2, callback2) -> name2 + "end");

        // when
        String res = Task.execute("start", first);

        // then
        Assertions.assertEquals("Task name : start and end", res);
    }

}
