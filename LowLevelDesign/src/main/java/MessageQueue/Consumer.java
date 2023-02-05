package MessageQueue;

import java.util.List;

public interface Consumer {

    void register();

    void deregister();

    String getRegex();

}
