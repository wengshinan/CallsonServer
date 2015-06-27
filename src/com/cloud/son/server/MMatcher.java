package com.cloud.son.server;


import com.cloud.son.data.ICreator;
import org.json.JSONObject;

/**
 * Created by wengshinan on 2015/6/26.
 */
public class MMatcher<T> extends Thread{

    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p/>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     * @see #Thread(ThreadGroup, Runnable, String)
     */
    @Override
    public void run() {
        super.run();
    }
}
