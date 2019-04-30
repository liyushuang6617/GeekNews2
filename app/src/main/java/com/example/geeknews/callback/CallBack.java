package com.example.geeknews.callback;

import com.example.geeknews.bean.Ban;

public interface CallBack {

    void onSuccess(Ban ban);

    void onFail(String msg);
}
