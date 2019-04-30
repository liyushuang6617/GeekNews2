package com.example.geeknews.view;

import com.example.geeknews.bean.Ban;

public interface MyView {


    void onSuccess(Ban ban);

    void onFail(String msg);
}
