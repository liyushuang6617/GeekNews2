package com.example.geeknews.prenster;

import com.example.geeknews.bean.Ban;
import com.example.geeknews.callback.CallBack;
import com.example.geeknews.model.MyModel;
import com.example.geeknews.view.MyView;

public class MyPrensterImple implements MyPrenster, CallBack {

    private MyModel myModel;
    private MyView myView;

    public MyPrensterImple(MyModel myModel, MyView myView) {
        this.myModel = myModel;
        this.myView = myView;
    }

    @Override
    public void getData() {
        if (myModel != null) {
            myModel.getData(this);
        }
    }

    @Override
    public void onSuccess(Ban ban) {
        myView.onSuccess(ban);
    }

    @Override
    public void onFail(String msg) {
        myView.onFail(msg);
    }
}
